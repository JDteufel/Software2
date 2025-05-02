package co.edu.poli.ejemplo2.modelo;

public class Cliente implements Observador{
    private String nombre;
    private boolean suscripcion;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(boolean suscripcion) {
        this.suscripcion = suscripcion;
    }

    @Override
    public void update(String message) {
        System.out.println("Cliente " + nombre + " recibió notificación: " + message);
    }
}
