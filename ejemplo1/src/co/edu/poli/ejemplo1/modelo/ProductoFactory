package co.edu.poli.ejemplo1.modelo.Producto;

public abstract class ProductoFactory {
    
    // Método abstracto que cada fábrica debe implementar
    public abstract Producto crearProducto(String idProducto, String descripcion);
    
    // Método concreto compartido por todas las fábricas
    public void registrarProducto(Producto producto) {
        System.out.println("Producto registrado: " + producto.getDescripcion());
    }
}
