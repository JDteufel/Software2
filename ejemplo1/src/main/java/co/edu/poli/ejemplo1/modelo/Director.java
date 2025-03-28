package co.edu.poli.ejemplo1.modelo;

public class Director {
	public void constructProveedor(Proveedor.Builder builder, String evaluacion, String Certificacion, String PoliticaEntrega) {
        builder.reset()
               .setEvaluacion(evaluacion)
               .setCertificacion(Certificacion)
               .setPoliticaEntrega(PoliticaEntrega);
    }
}