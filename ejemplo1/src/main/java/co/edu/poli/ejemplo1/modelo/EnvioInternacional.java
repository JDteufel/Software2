package co.edu.poli.ejemplo1.modelo;

public class EnvioInternacional implements Envio {
    @Override
    public void procesarEnvio(String tipoMercancia) {
        System.out.println("Envío internacional procesado para: " + tipoMercancia);
    }
}