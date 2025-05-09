package co.edu.poli.ejemplo1.modelo;

public class Contexto {
    private Cliente cliente;
    private Strategy strategy;

    public Contexto(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double procesarPago() {
        if (strategy == null) {
            throw new IllegalStateException("No se ha definido una estrategia de descuento.");
        }
        return strategy.calcularDescuento();
    }
}