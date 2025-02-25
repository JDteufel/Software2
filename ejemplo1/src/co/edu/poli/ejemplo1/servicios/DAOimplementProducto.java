package co.edu.poli.ejemplo1.servicios;

import java.sql.*;
import java.util.*;
import co.edu.poli.ejemplo1.modelo.Producto;

public class DAOimplementProducto implements DAOproducto {

	public DAOimplementProducto() {
	}

	@Override
	public void createProducto(Producto producto) {
		String query = "INSERT INTO productos (idProducto, descripcion) VALUES (?, ?)";
		try (Connection conn = Singleton.conexionBD(); PreparedStatement stmt = conn.prepareStatement(query)) {

			stmt.setString(1, producto.getIdProducto());
			stmt.setString(2, producto.getDescripcion());
			stmt.executeUpdate();
			System.out.println("Producto insertado: " + producto.getDescripcion());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al insertar el producto.");
		}
	}

	@Override
	public Producto readProducto(String idProducto) {
		String query = "SELECT * FROM productos WHERE idProducto = ?";
		try (Connection conn = Singleton.conexionBD(); PreparedStatement stmt = conn.prepareStatement(query)) {

			stmt.setString(1, idProducto);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Producto(rs.getString("idProducto"), rs.getString("descripcion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al obtener el producto.");
		}
		return null;
	}

	@Override
	public List<Producto> readAllProducto() {
		List<Producto> productos = new ArrayList<>();
		String query = "SELECT * FROM productos";
		try (Connection conn = Singleton.conexionBD();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			while (rs.next()) {
				Producto producto = new Producto(rs.getString("idProducto"), rs.getString("descripcion"));
				productos.add(producto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al obtener todos los productos.");
		}
		return productos;
	}

	@Override
	public void updateProducto(Producto producto) {
		String query = "UPDATE productos SET descripcion = ? WHERE idProducto = ?";
		try (Connection conn = Singleton.conexionBD(); PreparedStatement stmt = conn.prepareStatement(query)) {

			stmt.setString(1, producto.getDescripcion());
			stmt.setString(2, producto.getIdProducto());
			stmt.executeUpdate();
			System.out.println("Producto actualizado: " + producto.getDescripcion());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al actualizar el producto.");
		}
	}

	@Override
	public void deleteProducto(String idProducto) {
		String query = "DELETE FROM productos WHERE idProducto = ?";
		try (Connection conn = Singleton.conexionBD(); PreparedStatement stmt = conn.prepareStatement(query)) {

			stmt.setString(1, idProducto);
			stmt.executeUpdate();
			System.out.println("Producto eliminado con id: " + idProducto);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al eliminar el producto.");
		}
	}
}
