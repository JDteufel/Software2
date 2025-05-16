package co.edu.poli.ejemplo1.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String numero;
    private String cliente;
    private List<Producto> producto;
    private EstadoPedido estado;

    public Pedido() {
        producto = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProductos(List<Producto> productos) {
        this.producto = producto;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
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

    @Override
    public String toString() {
        return "Pedido [numero=" + numero + ", cliente=" + cliente + ", productos=" + producto + "]";
    }
}
