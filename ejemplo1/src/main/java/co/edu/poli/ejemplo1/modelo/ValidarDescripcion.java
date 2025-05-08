package co.edu.poli.ejemplo1.modelo;

public class ValidarDescripcion extends ManejadorProducto {
    @Override
    public boolean puedeProcesar(Producto producto) {
        if (producto.getDescripcion() == null || producto.getDescripcion().isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return false;
        }
        return true;
    }
}