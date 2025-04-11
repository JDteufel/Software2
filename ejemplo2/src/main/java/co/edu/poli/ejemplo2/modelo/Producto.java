package co.edu.poli.ejemplo2.modelo;

public abstract class Producto {
    private String idProducto;
    private String descripcion;
    private Proveedor proveedor;

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

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + idProducto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", proveedor=" + (proveedor != null ? proveedor.toString() : "N/A") +
                '}';
    }
}
