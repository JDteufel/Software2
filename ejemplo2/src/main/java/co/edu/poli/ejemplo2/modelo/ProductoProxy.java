package co.edu.poli.ejemplo2.modelo;

import java.util.List;

public class ProductoProxy extends Producto {

    private String usuario;
    private List<ProductoSimple> productos;

    public ProductoProxy(String id, String descripcion, String usuario, List<ProductoSimple> productos) {
        super(id, descripcion);
        this.productos = productos;
        this.usuario = usuario;
    }

    public List<ProductoSimple> getProductos() {
        return productos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String mostrarProductosSiUsuarioValido() {
        if ("Juan David Gómez Cárdenas".equals(usuario) || 
            "Deivid Rodríguez Cruz".equals(usuario) || 
            "Hillary Liv Rodríguez Sagbini".equals(usuario)) {
            StringBuilder mensaje = new StringBuilder("Lista de productos:\n");
            for (ProductoSimple producto : productos) {
                mensaje.append(producto.toString()).append("\n");
            }
            return mensaje.toString();
        } else {
            return "Acceso denegado. Usuario no autorizado.";
        }
    }
}