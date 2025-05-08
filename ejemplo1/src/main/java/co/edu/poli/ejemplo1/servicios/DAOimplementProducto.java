package co.edu.poli.ejemplo1.servicios;

import java.sql.*;
import java.util.*;
import co.edu.poli.ejemplo1.modelo.Producto;
import co.edu.poli.ejemplo1.modelo.ProductoAlimenticio;
import co.edu.poli.ejemplo1.modelo.ProductoElectrico;

public class DAOimplementProducto implements DAO<Producto, String> {

    private Connection conn;

    public DAOimplementProducto() {
        try {
            this.conn = Singleton.getInstance().conexionActiva();
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión activa: " + e.getMessage(), e);
        }
    }

    @Override
    public void create(Producto producto) {
        String query = "INSERT INTO productos (idProducto, tipo, descripcion, precio) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, producto.getIdProducto());
            stmt.setString(2, producto.getTipo());
            stmt.setString(3, producto.getDescripcion());
            stmt.setDouble(4, producto.getPrecio());
            stmt.executeUpdate();

            if (producto instanceof ProductoElectrico) {
                String queryElec = "INSERT INTO ProdElectricos (id_producto, voltajeEntrada) VALUES (?, ?)";
                try (PreparedStatement stmtElec = conn.prepareStatement(queryElec)) {
                    stmtElec.setString(1, producto.getIdProducto());
                    stmtElec.setString(2, ((ProductoElectrico) producto).getVoltajeEntrada());
                    stmtElec.executeUpdate();
                }
            } else if (producto instanceof ProductoAlimenticio) {
                String queryAlim = "INSERT INTO Alimenticios (id_producto, aporteCalorico) VALUES (?, ?)";
                try (PreparedStatement stmtAlim = conn.prepareStatement(queryAlim)) {
                    stmtAlim.setString(1, producto.getIdProducto());
                    stmtAlim.setString(2, ((ProductoAlimenticio) producto).getAporteCalorico());
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
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, idProducto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String tipo = rs.getString("tipo");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");

                if ("Electrico".equalsIgnoreCase(tipo)) {
                    String queryElec = "SELECT voltajeEntrada FROM ProdElectricos WHERE id_producto = ?";
                    try (PreparedStatement stmtElec = conn.prepareStatement(queryElec)) {
                        stmtElec.setString(1, idProducto);
                        ResultSet rsElec = stmtElec.executeQuery();
                        if (rsElec.next()) {
                            String voltajeEntrada = rsElec.getString("voltajeEntrada");
                            return new ProductoElectrico(idProducto, tipo, descripcion, precio, voltajeEntrada);
                        }
                    }
                } else if ("Alimenticio".equalsIgnoreCase(tipo)) {
                    String queryAlim = "SELECT aporteCalorico FROM Alimenticios WHERE id_producto = ?";
                    try (PreparedStatement stmtAlim = conn.prepareStatement(queryAlim)) {
                        stmtAlim.setString(1, idProducto);
                        ResultSet rsAlim = stmtAlim.executeQuery();
                        if (rsAlim.next()) {
                            String aporteCalorico = rsAlim.getString("aporteCalorico");
                            return new ProductoAlimenticio(idProducto, tipo, descripcion, precio, aporteCalorico);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no product is found
    }

    @Override
    public List<Producto> readAll() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM productos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String id = rs.getString("idProducto");
                String tipo = rs.getString("tipo");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");

                if ("Electrico".equals(tipo)) {
                    String queryElec = "SELECT voltajeEntrada FROM ProdElectricos WHERE id_producto = ?";
                    try (PreparedStatement stmtElec = conn.prepareStatement(queryElec)) {
                        stmtElec.setString(1, id);
                        ResultSet rsElec = stmtElec.executeQuery();
                        if (rsElec.next()) {
                            String voltajeEntrada = rsElec.getString("voltajeEntrada");
                            productos.add(new ProductoElectrico(id, tipo, descripcion, precio, voltajeEntrada));
                        }
                    }
                } else if ("Alimenticio".equals(tipo)) {
                    String queryAlim = "SELECT aporteCalorico FROM Alimenticios WHERE id_producto = ?";
                    try (PreparedStatement stmtAlim = conn.prepareStatement(queryAlim)) {
                        stmtAlim.setString(1, id);
                        ResultSet rsAlim = stmtAlim.executeQuery();
                        if (rsAlim.next()) {
                            String aporteCalorico = rsAlim.getString("aporteCalorico");
                            productos.add(new ProductoAlimenticio(id, tipo, descripcion, precio, aporteCalorico));
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
        String query = "UPDATE productos SET descripcion = ?, precio = ? WHERE idProducto = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, producto.getDescripcion());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setString(3, producto.getIdProducto());
            stmt.executeUpdate();

            if (producto instanceof ProductoElectrico) {
                String queryElec = "UPDATE ProdElectricos SET voltajeEntrada = ? WHERE id_producto = ?";
                try (PreparedStatement stmtElec = conn.prepareStatement(queryElec)) {
                    stmtElec.setString(1, ((ProductoElectrico) producto).getVoltajeEntrada());
                    stmtElec.setString(2, producto.getIdProducto());
                    stmtElec.executeUpdate();
                }
            } else if (producto instanceof ProductoAlimenticio) {
                String queryAlim = "UPDATE Alimenticios SET aporteCalorico = ? WHERE id_producto = ?";
                try (PreparedStatement stmtAlim = conn.prepareStatement(queryAlim)) {
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