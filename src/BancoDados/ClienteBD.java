package BancoDados;

import BancoDados.ConexaoPostgre; //No package Banco de dados eu vou usar a class Postgree
import BancoDados.ModeloCliente.Cliente;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.UUID;
import java.sql.Types;

public class ClienteBD {
    //Chamar o "ponteiro"
    //Não sei se é necessário essa chamada aqui
    private Connection conexao;
    
    public ClienteBD() {
        
        try{
            this.conexao = new ConexaoPostgre().getConnection();
            if (this.conexao != null) {
            System.out.println("A conexão foi feita com sucesso");
            } else {
                System.out.println("A conexão retornou nula, verifique se o banco no Supabase está ligado");
            }
            System.out.println("A conexão foi feita com sucesso");
        }catch (SQLException e){
            System.out.println("Houve um erro de conexão com o BD: " + e);
        } 
    }
    
    public void addCliente(Cliente novocliente){ //void significa que essa função não irá retornar nenhum valor
        //INSERT INTO é para adicionar valores na tabela
        String s = "INSERT INTO clientes (uuid_cliente ,nome, celular, senha, cpf, email, data)" +
                "VALUES (?,?,?,?,?,?,?)";
        
        String sqlinserirextrato = "INSERT INTO extrato (uuid_cliente, nome_cliente) VALUES (?, ?)";

        UUID id_cliente = novocliente.getId();
        Double saldo = 0.00;
        
        //Uso do Try para caso dê erro.
        try{
            
            try (PreparedStatement psAtualizaSaldo = conexao.prepareStatement(sqlinserirextrato)) {
                psAtualizaSaldo.setObject(1, id_cliente,Types.OTHER);
                psAtualizaSaldo.setString(2, novocliente.getNome());
                psAtualizaSaldo.executeUpdate();
            }catch(SQLException e){
                System.out.println("Erro ao tentar adicionar o novo clinte. Erro: " + e);
                throw new RuntimeException(e);
            }
            
            PreparedStatement ps = conexao.prepareStatement(s);
                        
            // Usa o Type para poder dizer ao Postgres que é um UUID
            ps.setObject(1, id_cliente,Types.OTHER);//Setar Object pois o UUID é um objeto complexo            
            ps.setString(2, novocliente.getNome());
            ps.setString(3, novocliente.getCelular());
            ps.setString(4, novocliente.getSenha());
            ps.setString(5, novocliente.getCpf());
            ps.setString(6, novocliente.getEmail()); 
            ps.setString(7, novocliente.getDtnascimento()); // Coluna 'data'
            
            ps.execute();
            ps.close();

        }catch (SQLException e){
            System.out.println("Erro ao tentar cadastrar o novo clinte. Erro: " + e);
            throw new RuntimeException(e);
        }       
    }
    
    public boolean loginCliente(String usuario, String senha) {
        //O * significa "todas as colunas"
        //Nome e senha estão com o placeholder ? porque o JAVA que vai preencher
        String sql = "SELECT * FROM clientes WHERE (email = ? OR celular = ?) AND senha = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);

            if (usuario.contains("@")) {
                ps.setString(1, usuario); 
                ps.setString(2, "");      
            } else {
                ps.setString(1, "");     
                ps.setString(2, usuario); 
            }

            ps.setString(3, senha);
            ResultSet rs = ps.executeQuery();
            return rs.next(); 

        } catch (SQLException e) {
            System.out.println("Erro ao fazer login: " + e.getMessage());
            return false;
        }
    }
    
    public void transferenciaPix(UUID id_cliente_remetente, double valor, String email, String celular, Connection conexao) {

        String sqlbuscarecebedor = "SELECT id_cliente, nome_cliente, saldo_atual FROM cliente WHERE email = ? OR celular = ?";

        String sqlinserirextrato = "INSERT INTO extrato (id_cliente, nome_cliente, valor, saldo_atual, pagamento, id_transfer, movimentacao) VALUES (?, ?, ?, ?, ?, ?, ?)";

        String sqlatualizasaldorecebedor = "UPDATE cliente SET saldo_atual = saldo_atual + ? WHERE id_cliente = ?";

        try {
            conexao.setAutoCommit(false);

            UUID idclienterecebedor = null;
            String nomeclienterecebedor = null;
            double saldoatualrecebedor = 0.0;//Valor vazio caso não tenha nada no banco

            try (PreparedStatement psBusca = conexao.prepareStatement(sqlbuscarecebedor)) {
                psBusca.setString(1, email);
                psBusca.setString(2, celular);

                try (ResultSet rs = psBusca.executeQuery()) {
                    if (rs.next()) {
                        // Se achou, pega os dados do recebedor
                        idclienterecebedor = UUID.fromString(rs.getString("id_cliente"));
                        nomeclienterecebedor = rs.getString("nome_cliente");
                        saldoatualrecebedor = rs.getDouble("saldo_atual");
                    } else {
                        System.out.println("Chave pix (email e celular) não encontradas.");
                        return; 
                    }
                }
            }

            double novoSaldoRecebedor = saldoatualrecebedor + valor;
            try (PreparedStatement psAtualizaSaldo = conexao.prepareStatement(sqlatualizasaldorecebedor)) {
                psAtualizaSaldo.setDouble(1, valor);
                psAtualizaSaldo.setObject(2, idclienterecebedor);
                psAtualizaSaldo.executeUpdate();
            }

            try (PreparedStatement psExtrato = conexao.prepareStatement(sqlinserirextrato)) {
                UUID idTransferencia = UUID.randomUUID(); 

                psExtrato.setObject(1, idclienterecebedor);         
                psExtrato.setString(2, nomeclienterecebedor);        
                psExtrato.setDouble(3, valor);                      
                psExtrato.setDouble(4, novoSaldoRecebedor);          
                psExtrato.setString(5, "PIX RECEBIDO");              
                psExtrato.setObject(6, idTransferencia);             
                psExtrato.setString(7, "ENTRADA");                  

                psExtrato.executeUpdate();
            }

            conexao.commit();
            System.out.println("Pix realizado com sucesso");

            //teste
        } catch (SQLException e) {
            try {
                conexao.rollback();// rollback significa que tudo será refeito para o padrão (inicio)
                System.err.println("Erro na transação.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conexao.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.print("Erro ao restaurar conexão padrão: " + e);
            }
        }
    }
    
    
}
