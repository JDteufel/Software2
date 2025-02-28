package co.edu.poli.ejemplo1.servicios;

import java.sql.*;
import java.util.*;
import co.edu.poli.ejemplo1.modelo.Producto;

public class DAOimplementProducto implements DAO <Producto , String>{

	private Connection conn;
	public DAOimplementProducto() {
		this.conn = Singleton.getInstance().conexionActiva();
	}

	@Override
	public void create(Producto producto) {
		String query = "INSERT INTO productos (idProducto, tipo, descripcion) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, producto.getIdProducto());
			stmt.setString(2, producto.getTipo());
			stmt.setString(3, producto.getDescripcion());
			stmt.executeUpdate();
			
			if (producto instanceof ProductoElectrico) {
				String queryElec = "INSERT INTO ProdElectricos (id_producto, tipo, voltaje) VALUES (?, ?, ?)";
	                try (PreparedStatement stmtElec = conn.prepareStatement(query)) {
	                    stmtElec.setString(1, producto.getIdProducto());
	                    stmtElec.setString(2, ((ProductoElectrico)producto).getVoltajeEntrada());
	                    stmtElec.executeUpdate();
	                }
	            } else if (producto instanceof ProductoAlimenticio) {
	                String queryAlim = "INSERT INTO Alimenticios (id_producto, calorias) VALUES (?, ?)";
	                try (PreparedStatement stmtAlimen = conn.prepareStatement(queryAlim)) {
	                    stmtAlimen.setString(1, producto.getIdProducto());
	                    stmtAlimen.setString(2, ((ProductoAlimenticio)producto).getAporteCalorico());
	                    stmtAlimen.executeUpdate();
	                }
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Producto read(String idProducto) {
		String query = "SELECT * FROM productos WHERE idProducto = ?";
		try ( PreparedStatement stmt = conn.prepareStatement(query)) {
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
	public List<Producto> readAll() {
		List<Producto> productos = new ArrayList<>();
		String query = "SELECT * FROM productos";
		try (Statement stmt = conn.createStatement();
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
	public void update(Producto producto) {
		String query = "UPDATE productos SET descripcion = ? WHERE idProducto = ?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {

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
	public void delete(String idProducto) {
		String query = "DELETE FROM productos WHERE idProducto = ?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {

			stmt.setString(1, idProducto);
			stmt.executeUpdate();
			System.out.println("Producto eliminado con id: " + idProducto);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al eliminar el producto.");
		}
	}
}
