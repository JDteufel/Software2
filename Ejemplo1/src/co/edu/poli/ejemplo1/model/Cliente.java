package co.edu.poli.ejemplo1.model;

public class Cliente {
    // Atributos privados
    private String ID;
    private String nombre;

    // Constructor público
    public Cliente(String ID, String nombre){
    }

    // Métodos Getters y Setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return "Cliente{ID='" + ID + "', nombre='" + nombre + "'}";
    }

}
