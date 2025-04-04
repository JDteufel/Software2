package co.edu.poli.ejemplo1.modelo;

public class AlimenticioFactory implements ProductoFactory {
    @Override
    public Producto crearProducto(String idProducto, String descripcion, double precio, String extra) {
        return new ProductoAlimenticio(idProducto, "Alimenticio", descripcion, precio, extra);
    }
}
