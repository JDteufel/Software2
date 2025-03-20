package co.edu.poli.ejemplo1.modelo;

public abstract class Builder {
    protected Producto producto;

    public Builder() {
        this.reset();
    }

    public void reset() {
        this.producto = new Producto();
    }

    public void setIdProducto(String idProducto) {
        this.producto.setIdProducto(idProducto);
    }

    public void setNombre(String descripcion) {
        this.producto.setDescripcion(descripcion);
    }

    public void setTipo(String tipo) {
        this.producto.setTipo(tipo);
    }

    public abstract void setCalorias(String aporteCalorico);
    public abstract void setVoltaje(String voltajeEntrada);

    public Producto build() {
        Producto resultado = this.producto;
        this.reset(); // Reiniciar builder para siguiente producto
        return resultado;
    }
}
