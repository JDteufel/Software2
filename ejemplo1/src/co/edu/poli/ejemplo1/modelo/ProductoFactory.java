package co.edu.poli.ejemplo1.modelo;

public interface ProductoFactory {
    
    // Método abstracto que cada fábrica debe implementar
    public Producto crearProducto(String idProducto, String descripcion);
    
    }
}
