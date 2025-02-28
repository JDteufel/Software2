package co.edu.poli.ejemplo1.modelo; 

public class ProductoAlimenticioFactory implements ProductoFactory {

    private String fechaExpiracion;

    public ProductoAlimenticioFactory(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    @Override
    public Producto crearProducto(String idProducto, String descripcion) {
        Producto p = new ProductoAlimenticio(idProducto, descripcion, fechaExpiracion);
        return p;
    }
}
