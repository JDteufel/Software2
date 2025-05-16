package co.edu.poli.ejemplo1.modelo;

public class EstadoCancelado implements EstadoPedido {
    private Pedido pedido;

    public EstadoCancelado(Pedido pedido) {
        this.pedido = pedido;
    }

    public void pagar() {
       
    }

    public void enviar() {
        
    }

    public void entregar() {
        
    }

    public void cancelar() {
        
    }
}