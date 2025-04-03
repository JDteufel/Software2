package co.edu.poli.ejemplo1.controlador;

import co.edu.poli.ejemplo1.servicios.Singleton;
import java.sql.SQLException;

public class ControladorBD {
    
    public String conexionBD() {
        try {
            Singleton.conexionBD();
            return "Conexión exitosa.";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    public String cerrarConexion() {
        try {
            Singleton.cerrarConexion();
            return "Conexión cerrada exitosamente.";
        } catch (SQLException e) {
            return "Error al cerrar la conexión: " + e.getMessage();
        }
    }
}