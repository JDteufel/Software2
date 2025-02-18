package co.edu.poli.ejemplo1.servicios;

import java.sql.*;
import java.util.*;
import co.edu.poli.ejemplo1.modelo.Cliente;

public class DAOimplementCliente implements DAOcliente{

    public DAOimplementCliente() {
    }
    
    @Override
    public void createCliente(Cliente cliente) {
    	String query = "INSERT INTO clientes (idCliente, nombre) VALUES (?, ?)";
        try (Connection conn = Singleton.conexionBD();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, cliente.getIdCliente());
            stmt.setString(2, cliente.getNombre());
            stmt.executeUpdate();
            System.out.println("Cliente insertado: " + cliente.getNombre());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al insertar el cliente.");
        }
    }
    
    @Override
    public Cliente readCliente(String idCliente) {
    	String query = "SELECT * FROM clientes WHERE idCliente = ?";
        try (Connection conn = Singleton.conexionBD();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(rs.getString("idCliente"), rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener el cliente.");
        }
        return null;
    }
    
    @Override
    public List<Cliente> readAllCliente(){
    	List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM clientes";
        try (Connection conn = Singleton.conexionBD();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getString("idCliente"), rs.getString("nombre"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener todos los clientes.");
        }
        return clientes;
    }
    
    @Override
    public void updateCliente(Cliente cliente) {
    	String query = "UPDATE clientes SET nombre = ? WHERE idCliente = ?";
        try (Connection conn = Singleton.conexionBD();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getIdCliente());
            stmt.executeUpdate();
            System.out.println("Cliente actualizado: " + cliente.getNombre());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar el cliente.");
        }
    }
    
    @Override
    public void deleteCliente(String idCliente) {
    	String query = "DELETE FROM clientes WHERE idCliente = ?";
        try (Connection conn = Singleton.conexionBD();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, idCliente);
            stmt.executeUpdate();
            System.out.println("Cliente eliminado con id: " + idCliente);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar el cliente.");
        }
    }
}