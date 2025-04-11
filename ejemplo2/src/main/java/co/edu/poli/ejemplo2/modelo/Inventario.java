package co.edu.poli.ejemplo2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(String idProducto, String descripcion, String nombre, String contacto, String direccion) {
        Proveedor proveedor = ProveedorFactory.getProveedor(nombre, contacto, direccion);
        ProductoSimple producto = new ProductoSimple(idProducto, descripcion);
        producto.setProveedor(proveedor);
        productos.add(producto);
    }

    public void importarProductos(List<ProductoSimple> listaProductos) {
        productos.addAll(listaProductos);
    }

    public void mostrarInventario() {
        for (Producto p : productos) {
            System.out.println(p.toString());
        }
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public static Inventario inventarioBase() {
        Inventario inv = new Inventario();

        Proveedor proveedor1 = ProveedorFactory.getProveedor("Proveedor A", "123456789", "Calle 1");
        Proveedor proveedor2 = ProveedorFactory.getProveedor("Proveedor B", "987654321", "Calle 2");

        ProductoSimple producto1 = new ProductoSimple("001", "Laptop");
        producto1.setProveedor(proveedor1);

        ProductoSimple producto2 = new ProductoSimple("002", "Mouse");
        producto2.setProveedor(proveedor1);

        ProductoSimple producto3 = new ProductoSimple("003", "Impresora");
        producto3.setProveedor(proveedor2);

        ProductoSimple producto4 = new ProductoSimple("004", "Teclado");
        producto4.setProveedor(proveedor2);

        ProductoSimple producto5 = new ProductoSimple("005", "Monitor");
        producto5.setProveedor(proveedor1);

        inv.getProductos().add(producto1);
        inv.getProductos().add(producto2);
        inv.getProductos().add(producto3);
        inv.getProductos().add(producto4);
        inv.getProductos().add(producto5);

        return inv;
    }
}