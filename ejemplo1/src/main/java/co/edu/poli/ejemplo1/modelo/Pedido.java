package co.edu.poli.ejemplo1.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String numero;
    private String cliente;
    private List<Producto> producto;
    private EstadoPedido estado;
    private Mediator mediator;

    public Pedido() {
        producto = new ArrayList<>();
    }

    public Pedido(String numero, String cliente, List<Producto> producto, Mediator mediator) {
        this.numero = numero;
        this.cliente = cliente;
        this.producto = producto;
        this.mediator = mediator;
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

    public void setProductos(List<Producto> producto) {
        this.producto = producto;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
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
