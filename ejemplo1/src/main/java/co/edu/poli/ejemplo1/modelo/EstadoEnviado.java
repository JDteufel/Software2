package co.edu.poli.ejemplo1.modelo;

public class EstadoEnviado implements EstadoPedido {
    private Pedido pedido;

    public EstadoEnviado(Pedido pedido) {
        this.pedido = pedido;
    }

    public void pagar() {
        
    }

    public void enviar() {
       
    }

    public void entregar() {
        pedido.cambiarEstado(new EstadoEntregado(pedido));
    }

    public void cancelar() {
       
    }
}
