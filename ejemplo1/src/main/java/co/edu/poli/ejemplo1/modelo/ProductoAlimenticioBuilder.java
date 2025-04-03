package co.edu.poli.ejemplo1.modelo;

public class ProductoAlimenticioBuilder implements Builder {

private ProductoAlimenticio producto;
    
    public ProductoAlimenticioBuilder() {
        this.reset();
    }
    
    @Override
    public void reset() {
        this.producto = new ProductoAlimenticio("", "", "", "");
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
    
    public void setAporteCalorico(String aporteCalorico) {
        producto.setAporteCalorico(aporteCalorico);
    }
    
    public ProductoAlimenticio getProduct() {
        ProductoAlimenticio result = this.producto;
        this.reset();
        return result;
    }
}
