package businessentity;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             Connection conexion = ConexionDB.obtenerConexion()) {

            ContactoDAO contactoDAO = new ContactoDAO(conexion);
            int opcion;

            do {
                System.out.println("\n=== Menu de Gestion de Contactos ===");
                System.out.println("1. Anadir nuevo contacto");
                System.out.println("2. Listar todos los contactos");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opcion: ");
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Telefono: ");
                        String telefono = scanner.nextLine();

                        System.out.print("Correo: ");
                        String correo = scanner.nextLine();

                        Contacto nuevoContacto = new Contacto(nombre, telefono, correo);
                        contactoDAO.insertar(nuevoContacto);
                        System.out.println("Contacto anadido exitosamente.");
                        break;

                    case 2:
                        List<Contacto> contactos = contactoDAO.listar();
                        if (contactos.isEmpty()) {
                            System.out.println("No hay contactos registrados.");
                        } else {
                            System.out.println("\n=== Lista de Contactos ===");
                            for (Contacto c : contactos) {
                                System.out.println(c);
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opcion no valida. Intente nuevamente.");
                        break;
                }
            } while (opcion != 3);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}