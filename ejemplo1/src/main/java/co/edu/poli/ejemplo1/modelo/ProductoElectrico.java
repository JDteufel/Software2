package co.edu.poli.ejemplo1.modelo;

public class ProductoElectrico extends Producto implements Prototype{
	private String voltajeEntrada;

	public ProductoElectrico(String idProducto, String tipo, String descripcion, String voltajeEntrada) {
		super(idProducto, tipo, descripcion);
		this.voltajeEntrada = voltajeEntrada;
	}
	
	private ProductoElectrico(ProductoElectrico otro) {
        super(otro);
        this.voltajeEntrada = otro.getVoltajeEntrada();	
    }

	public String getVoltajeEntrada() {
		return voltajeEntrada;
	}

	public void setVoltajeEntrada(String voltajeEntrada) {
		this.voltajeEntrada = voltajeEntrada;
	}

	@Override
    public String toString() {
        return super.toString();
    }
	
	/*
	public ProductoElectrico Clone() {
		return new ProductoElectrico(this);
	}
	*/
	
	@Override
	public Prototype Clone() {
		return new ProductoElectrico(this);
	}
}
