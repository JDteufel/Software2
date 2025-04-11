package co.edu.poli.ejemplo2.modelo;

import java.util.ArrayList;
import java.util.List;

public class ProductoSimple extends Producto {
    public ProductoSimple(String idProducto, String descripcion) {
        super(idProducto, descripcion);
    }

    @Override
    public String getIdProducto() {
        return super.getIdProducto();
    }

    @Override
    public void setIdProducto(String idProducto) {
        super.setIdProducto(idProducto);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion();
    }

    @Override
    public void setDescripcion(String descripcion) {
        super.setDescripcion(descripcion);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static List<ProductoSimple> crearListaProductos() {
        List<ProductoSimple> lista = new ArrayList<>();
        lista.add(new ProductoSimple("001", "Laptop"));
        lista.add(new ProductoSimple("002", "Mouse"));
        lista.add(new ProductoSimple("003", "Impresora"));
        lista.add(new ProductoSimple("004", "Teclado"));
        lista.add(new ProductoSimple("005", "Monitor"));
        return lista;
    }
}
