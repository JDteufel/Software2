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

    public static Inventario inventarioBase() {
        Inventario inv = new Inventario();
        inv.agregarProducto("001", "Laptop", "TechCorp", "123456", "Calle 1");
        inv.agregarProducto("002", "Mouse", "TechCorp", "123456", "Calle 1");
        inv.agregarProducto("003", "Impresora", "PrintWorld", "789101", "Avenida 5");
        return inv;
    }
}