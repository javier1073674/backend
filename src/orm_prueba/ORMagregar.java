package orm_prueba;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ORMagregar {

    public static void main(String[] args) {

        // Crear SessionFactory
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Producto.class)
                .buildSessionFactory()) {
            // Iniciar sesión            
            try (Session session = factory.openSession()) {

                session.beginTransaction();//Se da comienzo a la transacción
                // Crear objeto Artista
                Producto producto = new Producto("Conductor", 
                "con base en aluminio reforsado y 5 puntos de reclinacion", 
                650000, 
                "imagen/sillas/silla3");

                // Guardar en la base de datos
                session.save(producto);

                // Confirmar transacción
                session.getTransaction().commit();

                System.out.println("El registro fue almacenado correctamente");
            } catch (Exception e) {
                System.err.println("Error en la transacción: " + e.getMessage());
                e.printStackTrace();
            } finally {
                factory.close();
            }

        } catch (Exception e) {
            System.err.println("Error al inicializar Hibernate: " + e.getMessage());
            e.printStackTrace();
        }

    }

}