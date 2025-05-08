package co.edu.poli.ejemplo1.modelo;

public class EliminarProductoComando implements Comando {
    private Pedido pedido;
    private Producto producto;

    public EliminarProductoComando(Pedido pedido, Producto producto) {
        this.pedido = pedido;
        this.producto = producto;
    }

    @Override
    public void ejecutar() {
        pedido.getProducto().remove(producto);
        System.out.println("Producto eliminado: " + producto);
    }
}

