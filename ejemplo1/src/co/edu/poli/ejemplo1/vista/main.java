package co.edu.poli.ejemplo1.vista;

import java.util.*;
import co.edu.poli.ejemplo1.modelo.*;
import co.edu.poli.ejemplo1.servicios.*;

public class main {

    public static void main(String[] args) {
        DAOcliente clienteDAO = new DAOimplementCliente();

        Cliente cliente1 = new Cliente("C001", "Juan Pérez");
        Cliente cliente2 = new Cliente("C002", "Ana García");

        clienteDAO.createCliente(cliente1);
        clienteDAO.createCliente(cliente2);

        Cliente clienteObtenido = clienteDAO.readCliente("C001");
        if (clienteObtenido != null) {
            System.out.println("Cliente obtenido: " + clienteObtenido.getNombre());
        } else {
            System.out.println("Cliente no encontrado");
        }

        cliente1.setNombre("Juan Pérez Actualizado");
        clienteDAO.updateCliente(cliente1);

        clienteDAO.deleteCliente("C002");

        List<Cliente> clientes = clienteDAO.readAllCliente();
        System.out.println("Clientes restantes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombre());
        }
        
        Singleton.cerrarConexion();
    }
}