package co.edu.poli.ejemplo1.modelo;

public class EstadoNuevo implements EstadoPedido {
    private Pedido pedido;

    public EstadoNuevo(Pedido pedido) {
        this.pedido = pedido;
    }

    public void pagar() {
        System.out.println("Pedido pagado.");
        pedido.cambiarEstado(new EstadoPagado(pedido));
    }

    public void enviar() {
        System.out.println("No se puede enviar un pedido no pagado.");
    }

    public void entregar() {
        System.out.println("No se puede entregar un pedido no enviado.");
    }

    public void cancelar() {
        System.out.println("Pedido cancelado.");
        pedido.cambiarEstado(new EstadoCancelado(pedido));
    }
}
