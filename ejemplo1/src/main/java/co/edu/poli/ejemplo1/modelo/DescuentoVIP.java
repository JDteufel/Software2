package co.edu.poli.ejemplo1.modelo;

public class DescuentoVIP implements Strategy {
    @Override
    public double calcularDescuento() {
        return 0.25;
    }
}
