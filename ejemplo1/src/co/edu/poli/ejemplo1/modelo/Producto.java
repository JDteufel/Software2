package co.edu.poli.ejemplo1.modelo;

public class Producto {

    public Producto(String idProducto, String descripcion) {
    	this.idProducto = idProducto;
    	this.descripcion = descripcion;
    }

    private String idProducto;
    private String descripcion;

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
    	this.descripcion = descripcion;
    }
}