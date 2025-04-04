package co.edu.poli.ejemplo1.modelo;

public class ElectricoFactory implements ProductoFactory {
    @Override
    public Producto crearProducto(String idProducto, String descripcion, double precio, String extra) {
        return new ProductoElectrico(idProducto, "Electrico", descripcion, precio, extra);
    }
}
