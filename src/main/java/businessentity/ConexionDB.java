package businessentity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    public static Connection obtenerConexion() throws SQLException {
  

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Registrar el driver
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se pudo cargar el driver MySQL", e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String pass = "01234567";

        return DriverManager.getConnection(url, user, pass);
    }
}


