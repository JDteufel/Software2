package co.edu.poli.ejemplo2.modelo;

public class ProductoSimple extends Producto {
    public ProductoSimple(String idProducto, String descripcion) {
        super(idProducto, descripcion);
    }

    @Override
    public String getIdProducto() {
        return super.getIdProducto();
    }

    @Override
    public void setIdProducto(String idProducto) {
        super.setIdProducto(idProducto);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion();
    }

    @Override
    public void setDescripcion(String descripcion) {
        super.setDescripcion(descripcion);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
