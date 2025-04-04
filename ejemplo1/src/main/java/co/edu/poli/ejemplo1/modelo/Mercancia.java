package co.edu.poli.ejemplo1.modelo;

public abstract class Mercancia {
    protected Envio envio;

    public Mercancia(Envio envio) {
        this.envio = envio;
    }

    protected void procesarEnvio(String tipoMercancia) {
        envio.procesarEnvio(tipoMercancia);
    }

}