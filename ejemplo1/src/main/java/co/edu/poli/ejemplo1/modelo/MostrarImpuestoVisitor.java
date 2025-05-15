package co.edu.poli.ejemplo1.modelo;

public class MostrarImpuestoVisitor implements Visitor {

    private String resultado;

    public String getResultado() {
        return resultado;
    }

    @Override
    public void visit(ProductoAlimenticio producto) {
        double precio = producto.getPrecio();
        double precioConImpuesto = precio * 1.08;
        resultado = "Producto: " + producto.getDescripcion() + "\n"
                  + "Precio sin impuesto: $" + precio + "\n"
                  + "Precio con impuesto (8%): $" + String.format("%.2f", precioConImpuesto);
    }

    @Override
    public void visit(ProductoElectrico producto) {
        double precio = producto.getPrecio();
        double precioConImpuesto = precio * 1.15;
        resultado = "Producto: " + producto.getDescripcion() + "\n"
                  + "Precio sin impuesto: $" + precio + "\n"
                  + "Precio con impuesto (15%): $" + String.format("%.2f", precioConImpuesto);
    }
}

