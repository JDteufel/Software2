package co.edu.poli.ejemplo1.modelo;

public class Descuento extends Agregaciones {
    private double descuento;

    public Descuento(Carrito carrito, double descuento) {
        super(carrito);
        this.descuento = descuento / 100; // Convert percentage to decimal
    }

    @Override
    public double FinalizarCompra() {
        double total = super.FinalizarCompra();
        return Math.max(0, total - (total * descuento)); // Asegurar que el total no sea negativo
    }
}
    