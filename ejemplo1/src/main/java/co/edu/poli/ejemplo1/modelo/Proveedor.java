package co.edu.poli.ejemplo1.modelo;

public class Proveedor {
	
    private String evaluacion;
    private String certificacion;
    private String politicaEntrega;

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }
    
    public void setCertificacion(String certificacion) {
        this.certificacion = certificacion;
    }
    
    public void setPoliticaEntrega(String politicaEntrega) {
        this.politicaEntrega = politicaEntrega;
    }
    
    @Override
    public String toString() {
        return "Proveedor {evaluacion = " + evaluacion + ",\ncertificacion = " + certificacion + ", \npoliticaEntrega = " + politicaEntrega + "}";
    }
    
    public static class Builder {
    	private Proveedor proveedor;

        public Builder() {
            this.reset();
        }

        public Builder reset() {
            this.proveedor = new Proveedor();
            return this;
        }

        public Builder setEvaluacion(String evaluacion) {
            this.proveedor.setEvaluacion(evaluacion);
            return this;
        }

        public Builder setCertificacion(String certificacion) {
            this.proveedor.setCertificacion(certificacion);
            return this;
        }

        public Builder setPoliticaEntrega(String politicaEntrega) {
            this.proveedor.setPoliticaEntrega(politicaEntrega);
            return this;
        }

        public Proveedor getProduct() {
            Proveedor product = this.proveedor;
            this.reset();
            return product;
        }
    }
    
}