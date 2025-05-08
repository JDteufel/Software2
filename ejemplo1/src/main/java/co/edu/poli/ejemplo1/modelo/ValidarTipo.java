package co.edu.poli.ejemplo1.modelo;

public class ValidarTipo extends ManejadorProducto {
    @Override
    protected boolean puedeProcesar(Producto producto) {
        String tipo = producto.getTipo();

        if ("Alimenticio".equalsIgnoreCase(tipo)) {
            if (producto instanceof ProductoAlimenticio) {
                ProductoAlimenticio p = (ProductoAlimenticio) producto;
                if (p.getAporteCalorico() == null || p.getAporteCalorico().isBlank()) {
                    System.out.println("Error: El aporte calórico no puede estar vacío.");
                    return false;
                }
            } else {
                System.out.println("Error: El producto debe ser una instancia de ProductoAlimenticio.");
                return false;
            }

        } else if ("Electrico".equalsIgnoreCase(tipo)) {
            if (producto instanceof ProductoElectrico) {
                ProductoElectrico p = (ProductoElectrico) producto;
                if (p.getVoltajeEntrada() == null || p.getVoltajeEntrada().isBlank()) {
                    System.out.println("Error: El voltaje no puede estar vacío.");
                    return false;
                }
            } else {
                System.out.println("Error: El producto debe ser una instancia de ProductoElectrico.");
                return false;
            }
        }

        return true;
    }
}
