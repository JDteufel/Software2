package co.edu.poli.ejemplo2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Gestor {
    private List<Cliente> clientes = new ArrayList<>();

    public void addCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
    }

    public void removeCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public List<String> notifyClientes(String message) {
        List<String> notificaciones = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.isSuscripcion()) {
                notificaciones.add("Cliente " + cliente.getNombre() + " recibió notificación: " + message);
            }
        }
        return notificaciones;
    }
}
