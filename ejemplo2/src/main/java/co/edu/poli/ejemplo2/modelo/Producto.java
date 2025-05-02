package co.edu.poli.ejemplo2.modelo;

public class Producto {
    private String idProducto;
    private String descripcion;
    private double precio;

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
        MementoPrecio.guardarEstado(this, precio); // Save state before updating price
        this.precio = nuevoPrecio;
    }

    public double getPrecio() {
        return precio;
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
