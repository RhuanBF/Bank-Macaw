
package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class TesteConexaoBD {
        
    //Variavel privada para conectar com a base de dados
    
    //A string do Supabase é essa: postgresql://postgres:[YOUR-PASSWORD]@db.xzanampruuaorjtxzvyz.supabase.co:5432/postgres
    private static final String URL = "jdbc:postgresql://db.xzanampruuaorjtxzvyz.supabase.co:5432/postgres";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "m@caw20bank26";
    
    //Precisa estar em Connection porque é da biblioteca SQL 
    public Connection getConnection() throws SQLException {
        //Try para poder proteger a execução
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            //
            throw new SQLException("Driver JDBC não encontrado: " +
                    e.getMessage());
        }    
    }
    
    public void VerificarValoresDaTabela(Connection conexao){
        //Aprendizad: Nunca colocar o nome de uma tabela com letra maiuscula. 
        //Quando vai fazer um Result, ele não acha a tabela kkkk
        String s = "SELECT * FROM clientes";
        
        try{
            PreparedStatement ps = conexao.prepareStatement(s);
            ResultSet rs = ps.executeQuery();
            
            //Aqui usa o while para percorrer todas as linhas da tabela
            //Já que tem poucas então é tranquilo
            while(rs.next()){

                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Email: " + rs.getString("email"));

                System.out.println("----------------");
            }
            
        }catch(SQLException e){
            System.out.println("Erro na conexao: " + e);
        }
        
    }
    
    
    public static void main(String[] args) {

        TesteConexaoBD conexaoBD = new TesteConexaoBD();

        try {

            Connection conexao = conexaoBD.getConnection();
            
            if (conexao != null) {

                System.out.println("Conexão realizada com sucesso!");

                conexaoBD.VerificarValoresDaTabela(conexao);
                
                conexao.close();

            }

        } catch (SQLException e) {

            System.out.println("Erro ao conectar:");
            System.out.println(e.getMessage());
        } 
    }
}
