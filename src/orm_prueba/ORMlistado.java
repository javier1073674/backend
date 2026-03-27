package orm_prueba;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ORMlistado {

    public static void main(String[] args) {
        // Crear SessionFactory
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Cargar configuración de Hibernate
                .addAnnotatedClass(Producto.class) // Registrar la entidad
                .buildSessionFactory()) {

            // Iniciar sesión
            try (Session session = factory.openSession()) {
                session.beginTransaction(); // Iniciar transacción

                // Obtener la lista completa de artistas
                List<Producto> productos = session.createQuery("from Producto", Producto.class).getResultList();

                // Mostrar los resultados
                if (!productos.isEmpty()) {
                    System.out.println("Lista de Artistas:");
                    for (Producto producto : productos) {
                        System.out.println(producto);
                    }
                } else {
                    System.out.println("No hay productos registrados en la base de datos.");
                }

                session.getTransaction().commit(); // Confirmar transacción
                System.out.println("Listado finalizado correctamente");

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