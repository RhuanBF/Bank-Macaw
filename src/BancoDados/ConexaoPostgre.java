package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgre {
    
    //Variavel privada para conectar com a base de dados
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
}
    

