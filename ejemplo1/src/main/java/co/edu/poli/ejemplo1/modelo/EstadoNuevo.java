package co.edu.poli.ejemplo1.modelo;

public class EstadoNuevo implements EstadoPedido {
    private Pedido pedido;

    public EstadoNuevo(Pedido pedido) {
        this.pedido = pedido;
    }

    public void pagar() {
        pedido.cambiarEstado(new EstadoPagado(pedido));
    }

    public void enviar() {
    }

    public void entregar() {
    }

    public void cancelar() {
        pedido.cambiarEstado(new EstadoCancelado(pedido));
    }
}
