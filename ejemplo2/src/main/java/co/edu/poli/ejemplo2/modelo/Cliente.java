package co.edu.poli.ejemplo2.modelo;

public class Cliente {

    public Cliente(String idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }

    private String idCliente;
    private String nombre;

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
    
    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + idCliente + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
        
    }
}