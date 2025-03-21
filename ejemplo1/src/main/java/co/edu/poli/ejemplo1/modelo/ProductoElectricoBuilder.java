package co.edu.poli.ejemplo1.modelo;

public class ProductoElectricoBuilder implements Builder{
private ProductoElectrico producto;
    
    public ProductoElectricoBuilder() {
        this.reset();
    }
    
    @Override
    public void reset() {
        this.producto = new ProductoElectrico("", "", "", "");
    }
    
    @Override
    public void setIdProducto(String idProducto) {
        producto.setIdProducto(idProducto);
    }
    
    @Override
    public void setTipo(String tipo) {
        producto.setTipo(tipo);
    }
    
    @Override
    public void setDescripcion(String descripcion) {
        producto.setDescripcion(descripcion);
    }
    
    public void setVoltajeEntrada(String voltajeEntrada) {
        producto.setVoltajeEntrada(voltajeEntrada);
    }
    
    public ProductoElectrico getProduct() {
        ProductoElectrico result = this.producto;
        this.reset();
        return result;
    }
}