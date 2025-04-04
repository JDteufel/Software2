package co.edu.poli.ejemplo1.modelo;

public class EnvioGratis extends Agregaciones {
    private int valorEnvio;

    public EnvioGratis(Carrito carrito, int valorEnvio) {
        super(carrito);
        this.valorEnvio = valorEnvio;
    }

    public void setValorEnvio(int valorEnvio) {
        this.valorEnvio = valorEnvio;
    }
    
    @Override
    public double FinalizarCompra() {
        double total = super.FinalizarCompra();
        return total + valorEnvio;
    }
}
