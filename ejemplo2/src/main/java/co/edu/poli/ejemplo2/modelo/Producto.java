package co.edu.poli.ejemplo2.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Producto {
    private String idProducto;
    private String descripcion;
    private Proveedor proveedor;
    private double precio;
    private List<MementoPrecio> historialPrecios = new ArrayList<>();

    public Producto(String idProducto, String descripcion) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
    }

    protected Producto(Producto otro) {
        this.idProducto = otro.getIdProducto();
        this.descripcion = otro.getDescripcion();
    }

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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setPrecio(double nuevoPrecio) {
        guardarEstado(); // antes de cambiarlo
        this.precio = nuevoPrecio;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void guardarEstado() {
        historialPrecios.add(new MementoPrecio(precio));
    }
    
    public boolean deshacerCambioPrecio() {
        if (!historialPrecios.isEmpty()) {
            MementoPrecio memento = historialPrecios.remove(historialPrecios.size() - 1);
            this.precio = memento.getPrecioGuardado();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", proveedor=" + proveedor
       + ", precio=" + precio + "]";

    }

    
}
