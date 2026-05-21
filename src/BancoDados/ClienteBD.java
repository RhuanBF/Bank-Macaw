package BancoDados;

import BancoDados.ConexaoPostgre; //No package Banco de dados eu vou usar a class Postgree
import BancoDados.ModeloCliente.Cliente;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

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
        String s = "INSERT INTO clientes (nome),(celular),(senha),(cpf),(email)" +
                "VALUES (?,?,?,?,?)";
        
        //Uso do Try para caso dê erro.
        try{
            PreparedStatement ps = conexao.prepareStatement(s);
            
            //Agora vamos preencher os valores das colunas com o que o usuário preencheu no frontend
            ps.setString(1,novocliente.getNome());
            ps.setString(2, novocliente.getCelular());
            ps.setString(3,novocliente.getSenha());
            ps.setInt(4,novocliente.getCpf());
            ps.setString(5,novocliente.getEmail()); 
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
        String sql = "SELECT * FROM Clientes WHERE nome = ? AND senha = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Cliente já existente no BD");
                return true;
            }
            else {
                System.out.println("Cliente não existente no BD");
                return false;
            }
        }
        catch (SQLException e) {
            System.out.println("Erro ao procurar cliente no BD. Erro: " + e);
            throw new RuntimeException(e);
        }
    }
    
    
}
