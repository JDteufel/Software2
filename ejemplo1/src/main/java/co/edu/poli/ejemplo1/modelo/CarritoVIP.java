package co.edu.poli.ejemplo1.modelo;

public class CarritoVIP extends Agregaciones {
    private String nombreUsuario;

    public CarritoVIP(Carrito carrito, String nombreUsuario) {
        super(carrito);
        this.nombreUsuario = nombreUsuario;
    }

    public boolean esUsuarioVIP() {
        return nombreUsuario.equalsIgnoreCase("Juan David Gómez") ||
               nombreUsuario.equalsIgnoreCase("Deivid Rodríguez") ||
               nombreUsuario.equalsIgnoreCase("Hillary Rodríguez");
    }

    @Override
    public double FinalizarCompra() {
        return super.FinalizarCompra();
    }
}
