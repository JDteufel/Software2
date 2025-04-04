package co.edu.poli.ejemplo1.modelo;

public class Puntos extends Agregaciones {
    private int puntosAcumulados = 0;

    public Puntos(Carrito carrito) {
        super(carrito);
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(int puntos) {
        this.puntosAcumulados += puntos;
    }
    
    @Override
    public double FinalizarCompra() {
        double total = super.FinalizarCompra();
        puntosAcumulados += total / 10;
        return total;
    }
}
