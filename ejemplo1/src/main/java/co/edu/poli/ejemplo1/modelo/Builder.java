package co.edu.poli.ejemplo1.modelo;

public interface Builder {
	public void reset();
    public void setIdProducto(String idProducto);
    public void setTipo(String tipo);
    public void setDescripcion(String descripcion);
}