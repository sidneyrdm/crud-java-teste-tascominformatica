import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBanco {

    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost/tascomCrud";

        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection(url, "root", "");
            System.out.println("Conexão realizada com sucesso!");
        }catch (SQLException e){
            System.out.println("Falha ao tentar se conectar");
            e.printStackTrace();
        }
        return conexao;
    }
}
