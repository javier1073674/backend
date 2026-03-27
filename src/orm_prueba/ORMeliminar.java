package orm_prueba;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ORMeliminar {

    public static void main(String[] args) {

        // Crear SessionFactory
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Producto.class)
                .buildSessionFactory()) {

            // Iniciar sesión
            try (Session session = factory.openSession()) {
                session.beginTransaction(); // Iniciar transacción

                //ID del producto que quieres eliminar
                int idProducto = 4;

                //Buscar el producto
                Producto producto = session.get(Producto.class, idProducto);

                if (producto != null) {

                    //  ELIMINAR
                    session.delete(producto);

                    // Confirmar cambios
                    session.getTransaction().commit();

                    System.out.println("Producto eliminado correctamente");

                } else {
                    System.out.println("No se encontró el producto con ID: " + idProducto);
                }

            } catch (Exception e) {
                System.err.println("Error al eliminar: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.err.println("Error al inicializar Hibernate: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
