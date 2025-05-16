package co.edu.poli.ejemplo1.modelo;

public class AgregarProductoComando implements Comando {
    private Pedido pedido;
    private Producto producto;

    public AgregarProductoComando(Pedido pedido, Producto producto) {
        this.pedido = pedido;
        this.producto = producto;
    }

    @Override
    public void ejecutar() {
        pedido.getProducto().add(producto);
        System.out.println("Producto agregado: " + producto);
    }
}