package co.edu.poli.ejemplo1.servicios;

import java.sql.*;
import java.util.*;
import co.edu.poli.ejemplo1.modelo.Producto;
import co.edu.poli.ejemplo1.modelo.ProductoAlimenticio;
import co.edu.poli.ejemplo1.modelo.ProductoElectrico;

public class DAOimplementProducto implements ConsultaEsp<Producto , String>{

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
	                try (PreparedStatement stmtElec = conn.prepareStatement(queryElec)) {
	                    stmtElec.setString(1, producto.getIdProducto());
	                    stmtElec.setString(2, String.valueOf(((ProductoElectrico)producto).getVoltajeEntrada()));
	                    stmtElec.executeUpdate();
	                }
	            } else if (producto instanceof ProductoAlimenticio) {
	                String queryAlim = "INSERT INTO Alimenticios (id_producto, calorias) VALUES (?, ?)";
	                try (PreparedStatement stmtAlim = conn.prepareStatement(queryAlim)) {
	                    stmtAlim.setString(1, producto.getIdProducto());
	                    stmtAlim.setString(2, ((ProductoAlimenticio)producto).getAporteCalorico());
	                    stmtAlim.executeUpdate();
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
				String tipo = rs.getString("tipo");
                String descripcion = rs.getString("descripcion");
                
                if("Eléctrico".equals(tipo)) {
                	String queryElec = "SELECT * FROM ProdElectricos WHERE id_producto = ?";
                	try (PreparedStatement stmtElec = conn.prepareStatement(queryElec)) {
                        stmtElec.setString(1, idProducto);
                        ResultSet rsElec = stmtElec.executeQuery();
                        if (rsElec.next()) {
                            String voltajeEntrada = rsElec.getString("voltajeEntrada");
                            return new ProductoElectrico(idProducto, tipo, descripcion, voltajeEntrada);
                        }
                    }
                }else if ("Alimenticio".equals(tipo)) {
                    String sqlAlim = "SELECT * FROM ProdAlimenticios WHERE id_producto = ?";
                    try (PreparedStatement stmtAlim = conn.prepareStatement(sqlAlim)) {
                        stmtAlim.setString(1, idProducto);
                        ResultSet rsAlim = stmtAlim.executeQuery();
                        if (rsAlim.next()) {
                            String aporteCalorico = rsAlim.getString("aporteCalorico");
                            return new ProductoAlimenticio(idProducto, tipo, descripcion, aporteCalorico);
                        }
                    }
                }
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
				String id = rs.getString("id");
                String tipo = rs.getString("tipo");
                String descripcion = rs.getString("descripcion");

                if ("Electrico".equals(tipo)) {
                    String sqlElec = "SELECT * FROM Electricos WHERE id_producto = ?";
                    try (PreparedStatement stmtElec = conn.prepareStatement(sqlElec)) {
                        stmtElec.setString(1, id);
                        ResultSet rsElec = stmtElec.executeQuery();
                        if (rsElec.next()) {
                            String voltajeEntrada = rsElec.getString("voltajeEntrada");
                            productos.add(new ProductoElectrico(id, tipo, descripcion, voltajeEntrada));
                        }
                    }
                }else if ("Alimenticio".equals(tipo)) {
                    String sqlAlim = "SELECT * FROM Alimenticios WHERE id_producto = ?";
                    try (PreparedStatement stmtAlim = conn.prepareStatement(sqlAlim)) {
                        stmtAlim.setString(1, id);
                        ResultSet rsAlim = stmtAlim.executeQuery();
                        if (rsAlim.next()) {
                            String calorias = rsAlim.getString("calorias");
                            productos.add(new ProductoAlimenticio(id, tipo, descripcion, calorias));
                        }
                    } 
                }
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
			
			if (producto instanceof ProductoElectrico) {
                String sqlElec = "UPDATE Electricos SET voltaje = ? WHERE id_producto = ?";
                try (PreparedStatement stmtElec = conn.prepareStatement(sqlElec)) {
                    stmtElec.setString(1, ((ProductoElectrico) producto).getVoltajeEntrada());
                    stmtElec.setString(2, producto.getIdProducto());
                    stmtElec.executeUpdate();
                }
            } else if (producto instanceof ProductoAlimenticio) {
                String sqlAlim = "UPDATE Alimenticios SET calorias = ? WHERE id_producto = ?";
                try (PreparedStatement stmtAlim = conn.prepareStatement(sqlAlim)) {
                    stmtAlim.setString(1, ((ProductoAlimenticio) producto).getAporteCalorico());
                    stmtAlim.setString(2, producto.getIdProducto());
                    stmtAlim.executeUpdate();
                }
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String idProducto) {
		String query = "DELETE FROM productos WHERE idProducto = ?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, idProducto);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}