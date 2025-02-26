package co.edu.poli.ejemplo1.modelo;

public abstract class Producto {
    private String idProducto;
    private String descripcion;

    public Producto(String idProducto, String descripcion) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public abstract void mostrarDetalles();
}
