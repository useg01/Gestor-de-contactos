package businessentity;
import java.util.List;

public interface IBaseDAO<T> {
    void insertar(T obj) throws Exception;
    void actualizar(T obj) throws Exception;
    void eliminar(int id) throws Exception;
    T obtenerPorId(int id) throws Exception;
    List<T> listar() throws Exception;
}