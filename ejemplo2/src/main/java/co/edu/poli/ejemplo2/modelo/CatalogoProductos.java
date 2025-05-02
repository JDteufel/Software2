package co.edu.poli.ejemplo2.modelo;

import java.util.HashMap;
import java.util.Map;

public class CatalogoProductos {
    private static Map<String, Producto> productos = new HashMap<>();

    public static void agregarProducto(Producto producto) {
        productos.put(producto.getIdProducto(), producto);
    }

    public static Producto getProducto(String id) {
        return productos.get(id);
    }

    public static Map<String, Producto> getTodos() {
        return productos;
    }
}
