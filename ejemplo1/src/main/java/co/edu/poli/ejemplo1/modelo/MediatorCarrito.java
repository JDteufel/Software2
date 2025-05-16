package co.edu.poli.ejemplo1.modelo;

import javafx.scene.control.Alert;

public class MediatorCarrito implements Mediator {
    private Cliente cliente;
    private Pedido pedido;
    private Mediator mediator;

    public MediatorCarrito(Cliente cliente, Pedido pedido, Mediator mediator) {
        this.cliente = cliente;
        this.pedido = pedido;
        this.mediator = mediator;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void registrarEnCarrito() {
        // Pedido notifies Cliente that it is available (mediator pattern)
        if (pedido != null && cliente != null) {
            String msg = "Pedido '" + pedido.getNumero() + "' notifica a Cliente '" + cliente.getNombre() + "': Estoy disponible.";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notificación de Pedido");
            alert.setHeaderText(null);
            alert.setContentText(msg);
            alert.showAndWait();
        }
    }

    @Override
    public void notificarCliente() {
        // Cliente notifies Pedido that it is searching for it (mediator pattern)
        if (cliente != null && pedido != null) {
            String msg = "Cliente '" + cliente.getNombre() + "' notifica a Pedido '" + pedido.getNumero() + "': Te estoy buscando.";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notificación de Cliente");
            alert.setHeaderText(null);
            alert.setContentText(msg);
            alert.showAndWait();
        }
    }
}
