package co.edu.poli.ejemplo2.modelo;

import java.util.Objects;

public class Proveedor {
    private String nombre;
    private String contacto;
    private String direccion;

    public Proveedor(String nombre, String contacto, String direccion) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
    }

    // Para poder comparar correctamente en el mapa
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Proveedor)) return false;
        Proveedor p = (Proveedor) obj;
        return nombre.equals(p.nombre) && contacto.equals(p.contacto) && direccion.equals(p.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, contacto, direccion);
    }
}