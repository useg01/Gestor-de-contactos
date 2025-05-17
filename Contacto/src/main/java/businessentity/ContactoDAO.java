package businessentity;
import businessentity.Contacto; // ajusta el paquete
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ContactoDAO implements IBaseDAO <Contacto> {
private Connection conexion;

    public ContactoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(Contacto obj) throws Exception {
        String sql = "INSERT INTO contactos (nombre, telefono, correo) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getTelefono());
            ps.setString(3, obj.getCorreo());
            ps.executeUpdate();
        }
    }

    @Override
    public void actualizar(Contacto obj) throws Exception {
        String sql = "UPDATE contactos SET nombre=?, telefono=?, correo=? WHERE id=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getTelefono());
            ps.setString(3, obj.getCorreo());
            ps.setInt(4, obj.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM contactos WHERE id=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public Contacto obtenerPorId(int id) throws Exception {
        String sql = "SELECT * FROM contactos WHERE id=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Contacto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("correo")
                    );
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public List<Contacto> listar() throws Exception {
        List<Contacto> lista = new ArrayList<>();
        String sql = "SELECT * FROM contactos";
        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Contacto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("telefono"),
                    rs.getString("correo")
                ));
            }
        }
        return lista;
    }
}
