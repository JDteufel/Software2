package co.edu.poli.ejemplo1.modelo;

public class DescuentoNulo implements Strategy {
    @Override
    public double calcularDescuento() {
        return 0.0;
    }
}
