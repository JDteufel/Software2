package co.edu.poli.ejemplo2.modelo;

public class InformacionCliente {
    private Cliente cliente;

    public InformacionCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void actualizarNombre(String nuevoNombre) {
        cliente.setNombre(nuevoNombre);
    }

    public String mostrarInformacion() {
        return cliente.toString();
    }
}
