package co.edu.poli.ejemplo1.modelo;

public class Puntos extends Agregaciones {
    private int puntosAcumulados = 0; // Puntos acumulados por el cliente

    public Puntos(Carrito carrito) {
        super(carrito);
    }

    @Override
    public double FinalizarCompra() {
        double total = super.FinalizarCompra();
        puntosAcumulados += total / 10; // Acumular puntos
        return total;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(int puntos) {
        this.puntosAcumulados += puntos; // Acumular puntos adicionales
    }
}
