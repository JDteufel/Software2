package co.edu.poli.ejemplo1.modelo;

public class Descuento1raCompra implements Strategy {
    @Override
    public double calcularDescuento() {
        return 0.10;
    }
}
