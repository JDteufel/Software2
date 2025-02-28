package co.edu.poli.ejemplo1.modelo;

public class ProductoElectrico extends Producto {
	private int voltajeEntrada;

	public ProductoElectrico(String idProducto, String tipo, String descripcion, int voltajeEntrada) {
		super(idProducto, tipo, descripcion);
		this.voltajeEntrada = voltajeEntrada;
	}

	public int getVoltajeEntrada() {
		return voltajeEntrada;
	}

	public void setVoltajeEntrada(int voltajeEntrada) {
		this.voltajeEntrada = voltajeEntrada;
	}

	@Override
    public String toString() {
        return super.toString();
    }
}
