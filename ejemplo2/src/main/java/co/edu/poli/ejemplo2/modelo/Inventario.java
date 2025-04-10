package co.edu.poli.ejemplo2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(String idProducto, String descripcion, String Nombre, String contacto, String direccion) {
        Proveedor proveedor = ProveedorFactory.getProveedor(Nombre, contacto, direccion);
        Producto producto = new Producto(idProducto, descripcion);
        productos.add(producto);
    }

    public void mostrarInventario() {
        for (Producto p : productos) {
            p.toString();
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }
}