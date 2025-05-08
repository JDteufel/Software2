package co.edu.poli.ejemplo1.modelo;

public class Producto {
    private String idProducto;
    private String tipo;
    private String descripcion;
    private double precio;

    public Producto(String idProducto, String tipo, String descripcion, double precio) {
        this.idProducto = idProducto;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    protected Producto(Producto otro) {
        this.idProducto = otro.getIdProducto();
        this.tipo = otro.getTipo();
        this.descripcion = otro.getDescripcion();
        this.precio = otro.getPrecio();
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "Producto{" +
                "id='" + idProducto + '\n' +
                ", tipo='" + tipo + '\n' +
                ", descripcion='" + descripcion + '\n' +
                ", precio=" + precio +
                '}';
    }
}