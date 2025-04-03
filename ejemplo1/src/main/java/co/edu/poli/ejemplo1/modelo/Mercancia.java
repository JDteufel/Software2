package co.edu.poli.ejemplo1.modelo;

public abstract class Mercancia {
    private Envio envio;

    public Mercancia(Envio envio) {
        this.envio = envio;
    }

    private void procesarEnvio(String tipoMercancia) {
        envio.procesarEnvio(tipoMercancia);
    }

    public void enviar() {
        procesarEnvio(this.getClass().getSimpleName());
    }
}