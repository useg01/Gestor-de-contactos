package businessentity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
public static Connection obtenerConexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/tu_base_de_datos";
        String user = "tu_usuario";
        String pass = "tu_contraseña";
        return DriverManager.getConnection(url, user, pass);
        
    }
}
