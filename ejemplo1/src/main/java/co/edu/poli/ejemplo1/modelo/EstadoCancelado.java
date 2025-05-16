package co.edu.poli.ejemplo1.modelo;

public class EstadoCancelado implements EstadoPedido {
    private Pedido pedido;

    public EstadoCancelado(Pedido pedido) {
        this.pedido = pedido;
    }

    public void pagar() {
        System.out.println("El pedido está cancelado. No se puede pagar.");
    }

    public void enviar() {
        System.out.println("El pedido está cancelado. No se puede enviar.");
    }

    public void entregar() {
        System.out.println("El pedido está cancelado. No se puede entregar.");
    }

    public void cancelar() {
        System.out.println("El pedido ya está cancelado.");
    }
}