package co.edu.poli.ejemplo1.modelo;

public class Cliente {

    private String idCliente;
    private String nombre;
    private Mediator mediator;

    public Cliente(String idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }

    public Cliente(String idCliente, String nombre, Mediator mediator) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.mediator = mediator;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + idCliente + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}