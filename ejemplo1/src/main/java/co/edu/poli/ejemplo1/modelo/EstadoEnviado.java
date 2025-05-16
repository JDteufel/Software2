package co.edu.poli.ejemplo1.modelo;

public class EstadoEnviado implements EstadoPedido {
    private Pedido pedido;

    public EstadoEnviado(Pedido pedido) {
        this.pedido = pedido;
    }

    public void pagar() {
        System.out.println("El pedido ya fue pagado.");
    }

    public void enviar() {
        System.out.println("El pedido ya fue enviado.");
    }

    public void entregar() {
        System.out.println("Pedido entregado.");
        pedido.cambiarEstado(new EstadoEntregado(pedido));
    }

    public void cancelar() {
        System.out.println("No se puede cancelar un pedido enviado.");
    }
}
