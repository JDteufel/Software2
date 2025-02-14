package co.edu.poli.ejemplo1.model;

public class Producto {

    // Atributos privados
    private String id;
    private String descripcion;

    // Constructor vacío
    public Producto() {
    }

    // Constructor con parámetros (opcional)
    public Producto(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    // Métodos Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "Producto{id='" + id + "', descripcion='" + descripcion + "'}";
    }

}
