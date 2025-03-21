package co.edu.poli.ejemplo1.modelo;

public class Director {

    public void constructProductoAlimenticio(ProductoAlimenticioBuilder builder) {
    	builder.reset();
    }
    
    public void constructProductoElectrico(ProductoElectricoBuilder builder) {
    	builder.reset();	 
    }
}