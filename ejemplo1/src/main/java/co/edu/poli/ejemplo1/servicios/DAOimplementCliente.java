package co.edu.poli.ejemplo1.servicios;

import java.sql.*;
import java.util.*;
import co.edu.poli.ejemplo1.modelo.Cliente;

public class DAOimplementCliente implements DAO<Cliente, String> {

	private Connection conn;

	public DAOimplementCliente() {
		try {
			this.conn = Singleton.getInstance().conexionActiva();
		} catch (SQLException e) {
			throw new RuntimeException("Error al obtener la conexión activa: " + e.getMessage(), e);
		}
	}

	@Override
	public void create(Cliente cliente) {
		String query = "INSERT INTO clientes (idCliente, nombre) VALUES (?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, cliente.getIdCliente());
			stmt.setString(2, cliente.getNombre());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cliente read(String idCliente) {
		String query = "SELECT * FROM clientes WHERE idCliente = ?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, idCliente);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Cliente(rs.getString("idCliente"), rs.getString("nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cliente> readAll() {
		List<Cliente> clientes = new ArrayList<>();
		String query = "SELECT * FROM clientes";
		try (Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(query)) {
			 while (rs.next()) {
				clientes.add(new Cliente(rs.getString("idCliente"), rs.getString("nombre")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public void update(Cliente cliente) {
		String query = "UPDATE clientes SET nombre = ? WHERE idCliente = ?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, cliente.getNombre());
			stmt.setString(2, cliente.getIdCliente());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String idCliente) {
		String query = "DELETE FROM clientes WHERE idCliente = ?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, idCliente);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}