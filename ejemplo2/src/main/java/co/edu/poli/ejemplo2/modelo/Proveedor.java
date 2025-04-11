package co.edu.poli.ejemplo2.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Proveedor {
    private String nombre;
    private String contacto;
    private String direccion;

    private static final List<Proveedor> listaProveedores = new ArrayList<>();

    public Proveedor(String nombre, String contacto, String direccion) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
        listaProveedores.add(this);
    }

    public static List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

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

    @Override
    public String toString() {
        return "Proveedor{" +
               "nombre='" + nombre + '\'' +
               ", contacto='" + contacto + '\'' +
               ", direccion='" + direccion + '\'' +
               '}';
    }
}