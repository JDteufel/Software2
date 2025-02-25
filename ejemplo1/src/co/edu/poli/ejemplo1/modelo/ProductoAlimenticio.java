package co.edu.poli.ejemplo1.modelo;

public class ProductoAlimenticio extends Producto {
	private String aporteCalorico;

	public ProductoAlimenticio(String idProducto, String descripcion, String aporteCalorico) {
		super(idProducto, descripcion);
		this.aporteCalorico = aporteCalorico;
	}

	public String getAporteCalorico() {
		return aporteCalorico;
	}

	public void setAporteCalorico(String aporteCalorico) {
		this.aporteCalorico = aporteCalorico;
	}
}
