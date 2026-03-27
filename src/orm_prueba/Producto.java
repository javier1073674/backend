package orm_prueba;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Solo este es el ID correcto
    @Column(name = "id_producto")
    private int IdProducto;

    @Column(name = "Nombre")    
    private String nombre;

    @Column(name = "descripcion")    
    private String descripcion;
    
    @Column(name = "precio")
    private double precio;
    
    @Column(name = "imagen")
    private String imagen;
    
    //Creacion de constructores 

    public Producto() {}

    public Producto(String nombre, String descripcion, double precio, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }
//Getters y Setters
    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Producto{" + "IdProducto=" + IdProducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", imagen=" + imagen + '}';
    }


}