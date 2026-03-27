package orm_prueba;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ORMactualizar {

    public static void main(String[] args) {
        // Crear SessionFactory
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Cargar configuración de Hibernate
                .addAnnotatedClass(Producto.class) // Registrar la entidad
                .buildSessionFactory()) {

            // Iniciar sesión
            try (Session session = factory.openSession()) {
                session.beginTransaction(); // Iniciar transacción

                //ID del artista que queremos actualizar
                int IdProducto = 4; // Cambiar según la BD

                //Buscar el artista en la base de datos
                Producto producto = session.get(Producto.class, IdProducto);

                if (producto != null) {
                    //Actualizar los valores
                    producto.setNombre("Polaris");
                    producto.setDescripcion("Diseño perosanalizable con base en acero y 4 puntos de reclinacion ");
                    producto.setPrecio(390000);
                    producto.setImagen("imagenes/sillas/silla4");

                    //Guardar cambios
                    session.getTransaction().commit();
                    System.out.println("Producto actualizado: " + producto);
                } else {
                    System.out.println("No se encontró el producto con ID: " + IdProducto);
                }

            } catch (Exception e) {
                System.err.println("Error en la actualización: " + e.getMessage());
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

