package co.edu.poli.ejemplo1.modelo;

import java.util.ArrayList;
import java.util.List;

public class Empleado implements ComponenteDepartamento {
    private String id;
    private String nombre;
    private List<Departamento> departamentos; // Un empleado puede pertenecer a varios departamentos

    public Empleado(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.departamentos = new ArrayList<>();
    }

    public void agregarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }

    public void eliminarDepartamento(Departamento departamento) {
        departamentos.remove(departamento);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Empleado: " + nombre + " (ID: " + id + ")");
        System.out.println("Departamentos:");
        for (Departamento dep : departamentos) {
            System.out.println("  - " + dep.getNombre());
        }
    }

    @Override
    public List<Empleado> obtenerEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        lista.add(this);
        return lista;
    }
}