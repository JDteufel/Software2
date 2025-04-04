package co.edu.poli.ejemplo1.modelo;

public abstract class Agregaciones implements Carrito {
    protected Carrito carrito;

    public Agregaciones(Carrito carrito) {
        this.carrito = carrito;
    }

    @Override
    public double FinalizarCompra() {
        return carrito.FinalizarCompra();
    }
}
