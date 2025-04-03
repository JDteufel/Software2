package co.edu.poli.ejemplo1.modelo;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements ComponenteDepartamento {
    private String nombre;
    private List<ComponenteDepartamento> componentes;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

    public void agregarComponente(ComponenteDepartamento componente) {
        componentes.add(componente);
    }

    public void eliminarComponente(ComponenteDepartamento componente) {
        componentes.remove(componente);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Departamento: " + nombre);
        for (ComponenteDepartamento componente : componentes) {
            componente.mostrarInformacion();
        }
    }

    @Override
    public List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        for (ComponenteDepartamento componente : componentes) {
            empleados.addAll(componente.obtenerEmpleados());
        }
        return empleados;
    }
}