package co.edu.poli.ejemplo1.modelo;

public class ProductoAlimenticio extends Producto{
    private String aporteCalorico;

    public ProductoAlimenticio(String idProducto, String tipo, String descripcion, double precio, String aporteCalorico) {
        super(idProducto, tipo, descripcion, precio);
        this.aporteCalorico = aporteCalorico;
    }

    private ProductoAlimenticio(ProductoAlimenticio otro) {
        super(otro);
        this.aporteCalorico = otro.getAporteCalorico();
    }

    public String getAporteCalorico() {
        return aporteCalorico;
    }

    public void setAporteCalorico(String aporteCalorico) {
        this.aporteCalorico = aporteCalorico;
    }

    @Override
    public String toString() {
        return super.toString() + ", aporteCalorico='" + aporteCalorico ;
    }
}