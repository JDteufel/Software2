package co.edu.poli.ejemplo1.modelo;

public class EstadoPagado implements EstadoPedido {
    private Pedido pedido;

    public EstadoPagado(Pedido pedido) {
        this.pedido = pedido;
    }

    public void pagar() {
        System.out.println("El pedido ya está pagado.");
    }

    public void enviar() {
        System.out.println("Pedido enviado.");
        pedido.cambiarEstado(new EstadoEnviado(pedido));
    }

    public void entregar() {
        System.out.println("No se puede entregar antes de enviar.");
    }

    public void cancelar() {
        System.out.println("Pedido cancelado.");
        pedido.cambiarEstado(new EstadoCancelado(pedido));
    }
}
