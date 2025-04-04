package co.edu.poli.ejemplo1.modelo;

public interface ProductoFactory {
    Producto crearProducto(String idProducto, String descripcion, double precio, String extra);
}
