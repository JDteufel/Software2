package co.edu.poli.ejemplo1.modelo;

public class ValidarPrecio extends ManejadorProducto {
    @Override
    protected boolean puedeProcesar(Producto producto) {
        if (producto.getPrecio() <= 0) {
            System.out.println("Error: El precio debe ser mayor a 0.");
            return false;
        }
        return true;
    }
}
