package co.edu.poli.ejemplo1.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private String numero;
	private Cliente cliente;
	private List<Producto> producto;
	private EstadoPedido estado;

	public Pedido() {
		producto = new ArrayList<>();
		this.estado = new EstadoNuevo(this);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public void pagar() {
        estado.pagar();
    }

    public void enviar() {
        estado.enviar();
    }

    public void entregar() {
        estado.entregar();
    }

    public void cancelar() {
        estado.cancelar();
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
    }

	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", cliente=" + cliente + ", producto=" + producto
				+ "]";
	}
}
