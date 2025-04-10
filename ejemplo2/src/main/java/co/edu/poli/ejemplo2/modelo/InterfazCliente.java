package co.edu.poli.ejemplo2.modelo;

public class InterfazCliente {
    private InformacionCliente infoCliente;
    private HistorialPedidos historial;
    private FormaDePago pagos;

    public InterfazCliente(Cliente cliente) {
        this.infoCliente = new InformacionCliente(cliente);
        this.historial = new HistorialPedidos();
        this.pagos = new FormaDePago();
    }

    public InformacionCliente getInfoCliente() {
        return infoCliente;
    }

    public HistorialPedidos getHistorial() {
        return historial;
    }

    public FormaDePago getPagos() {
        return pagos;
    }
}
