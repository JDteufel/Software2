package co.edu.poli.ejemplo1.modelo;

public class EstadoPagado implements EstadoPedido {
    private Pedido pedido;

    public EstadoPagado(Pedido pedido) {
        this.pedido = pedido;
    }

    public void pagar() {
        
    }

    public void enviar() {
        pedido.cambiarEstado(new EstadoEnviado(pedido));
    }

    public void entregar() {
        
    }

    public void cancelar() {
        pedido.cambiarEstado(new EstadoCancelado(pedido));
    }
}
