package co.edu.poli.ejemplo1.modelo;

public abstract class ManejadorProducto {
    protected ManejadorProducto siguiente;

    public void setSiguiente(ManejadorProducto siguiente) {
        this.siguiente = siguiente;
    }

    public void procesar(Producto producto) {
        if (puedeProcesar(producto) && siguiente != null) {
            siguiente.procesar(producto);
        }
    }

    protected abstract boolean puedeProcesar(Producto producto);
}
