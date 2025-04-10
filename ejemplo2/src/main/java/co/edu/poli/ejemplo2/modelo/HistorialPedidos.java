package co.edu.poli.ejemplo2.modelo;
import java.util.ArrayList;
import java.util.List;

public class HistorialPedidos {
    private List<Producto> pedidos = new ArrayList<>();

    public void realizarPedido(Producto producto) {
        pedidos.add(producto);
    }

    public List<Producto> verHistorial() {
        return pedidos;
    }
}