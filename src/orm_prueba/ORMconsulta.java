package orm_prueba;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ORMconsulta {

    public static void main(String[] args) {
        // Crear SessionFactory
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Cargar configuración
                .addAnnotatedClass(Producto.class) // Registrar la entidad
                .buildSessionFactory()) {

            // Iniciar sesión
            try (Session session = factory.openSession()) {
                session.beginTransaction(); // Iniciar transacción

                // 🔹 ID del artista a consultar (DEBE SER UN ENTERO)
                int IdProducto = 2; // Cambiar según la BD

                // 🔹 Obtener el artista desde la BD
                Producto producto = session.get(Producto.class, IdProducto);

                // 🔹 Mostrar el resultado
                if (producto != null) {
                    System.out.println("Registro obtenido: " + producto);
                } else {
                    System.out.println("No se encontró el producto con ID: " + IdProducto);
                }

                session.getTransaction().commit(); // Confirmar transacción
                System.out.println("Consulta finalizada correctamente");

            } catch (Exception e) {
                System.err.println("Error en la consulta: " + e.getMessage());
                e.printStackTrace();
            } finally {
                factory.close(); // Cerrar la fábrica de sesiones
            }

        } catch (Exception e) {
            System.err.println("Error al inicializar Hibernate: " + e.getMessage());
            e.printStackTrace();
        }
    }
}