package co.edu.poli.ejemplo1.modelo;

public class ProductoElectricoFactory implements ProductoFactory {

    private int voltaje;

    public ProductoElectricoFactory(int voltaje) {
        this.voltaje = voltaje;
    }

    @Override
    public Producto crearProducto(String idProducto, String descripcion) {
        Producto p = new ProductoElectrico(idProducto, descripcion, voltaje);
        return p;
    }
}
