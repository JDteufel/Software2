package co.edu.poli.ejemplo2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Producto{
    private String idProducto;
    private String descripcion;
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

    public void setPrecio(double nuevoPrecio) {
        guardarEstado();
        this.precio = nuevoPrecio;
    }

    public double getPrecio() {
        return precio;
    }

    public List<Double> getHistorialPrecios() {
        List<Double> historial = new ArrayList<>();
        for (MementoPrecio m : historialPrecios) {
            historial.add(m.getPrecioGuardado());
        }
        return historial;
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

    public void aplicarDescuento(double descuento) {
        double nuevoPrecio = this.precio - (this.precio * descuento / 100);
        setPrecio(nuevoPrecio);
    }

    @Override
    public String toString() {
        return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", precio=" + precio + "]";
    }
}
