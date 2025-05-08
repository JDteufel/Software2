package co.edu.poli.ejemplo1.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private String numero;
	private String fecha;
	private Cliente cliente;
	private List<Producto> producto;

	public Pedido() {
		producto = new ArrayList<>();
	}

	public List<Producto> getProducto() {
		return producto;
	}
}
