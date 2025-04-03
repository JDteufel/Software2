package co.edu.poli.ejemplo1.modelo;

public class EnvioNacional implements Envio {
    @Override
    public void procesarEnvio(String tipoMercancia) {
        System.out.println("Envío nacional procesado para: " + tipoMercancia);
    }
}