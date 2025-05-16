package co.edu.poli.ejemplo1.modelo;

public class EstadoEntregado implements EstadoPedido {
    private Pedido pedido;

    public EstadoEntregado(Pedido pedido) {
        this.pedido = pedido;
    }

    public void pagar() {
        System.out.println("El pedido ya fue pagado y entregado.");
    }

    public void enviar() {
        System.out.println("El pedido ya fue enviado y entregado.");
    }

    public void entregar() {
        System.out.println("El pedido ya fue entregado.");
    }

    public void cancelar() {
        System.out.println("No se puede cancelar un pedido entregado.");
    }
}
