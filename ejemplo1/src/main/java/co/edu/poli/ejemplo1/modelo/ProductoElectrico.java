package co.edu.poli.ejemplo1.modelo;

public class ProductoElectrico extends Producto{
    private String voltajeEntrada;

    public ProductoElectrico(String idProducto, String tipo, String descripcion, double precio, String voltajeEntrada) {
        super(idProducto, tipo, descripcion, precio);
        this.voltajeEntrada = voltajeEntrada;
    }
    
    private ProductoElectrico(ProductoElectrico otro) {
        super(otro);
        this.voltajeEntrada = otro.getVoltajeEntrada();
    }

    public String getVoltajeEntrada() {
        return voltajeEntrada;
    }

    public void setVoltajeEntrada(String voltajeEntrada) {
        this.voltajeEntrada = voltajeEntrada;
    }

    @Override
    public String toString() {
        return super.toString() + ", voltajeEntrada='" + voltajeEntrada + '\'';
    }
}
