package co.edu.poli.ejemplo1.modelo;

public abstract class Producto {
    private String idProducto;
    private String tipo;
    private String descripcion;

    public Producto(String idProducto, String tipo , String descripcion) {
        this.idProducto = idProducto;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
    
    protected Producto(Producto otro) {
        this.idProducto = otro.getIdProducto();
        this.tipo = otro.getTipo();
        this.descripcion = otro.getDescripcion();
    }

    public String getIdProducto() {
        return idProducto;
    }
    
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
    	this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "Producto{" +
                "id='" + idProducto + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}