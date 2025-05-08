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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	public List<Producto> getProducto() {
		return producto;
	}

	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", fecha=" + fecha + ", cliente=" + cliente + ", producto=" + producto
				+ "]";
	}
}
