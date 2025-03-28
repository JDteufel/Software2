package co.edu.poli.ejemplo1.modelo;

import java.util.List;

public interface ComponenteDepartamento {
    String getNombre();
    void mostrarInformacion();
    List<Empleado> obtenerEmpleados();
}