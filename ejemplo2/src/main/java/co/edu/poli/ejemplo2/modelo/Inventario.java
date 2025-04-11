package co.edu.poli.ejemplo2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(String idProducto, String descripcion, String Nombre, String contacto, String direccion) {
        Proveedor proveedor = ProveedorFactory.getProveedor(Nombre, contacto, direccion);
        ProductoSimple producto = new ProductoSimple(idProducto, descripcion);
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
        inv.importarProductos(ProductoSimple.crearListaProductos());
        return inv;
    }
}