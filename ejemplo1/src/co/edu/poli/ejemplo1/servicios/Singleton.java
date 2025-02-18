package co.edu.poli.ejemplo1.servicios;

import java.sql.*;

public class Singleton {

    private static Connection conexion;
    
    private static Singleton instancia;
    
    private Singleton() {
    }
    
    private static final String URL = "jdbc:mysql://localhost:3306/ejemplo1DB";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "Jbelmgzic#009";
    
    public static Connection conexionBD() {
    	 if (conexion == null || !conexionActiva()) {
             try {
                 conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
                 System.out.println("Conexión exitosa.");
             } catch (SQLException e) {
                 e.printStackTrace();
                 System.out.println("Error al conectar a la base de datos.");
             }
         }
         return conexion;
    }
    
    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null;
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }    

    public static Singleton getInstance() {
    	if(instancia == null) {
    		instancia = new Singleton();
    	}
    	return instancia;
    }
    
    private static boolean conexionActiva() {
        try {
            return conexion != null && !conexion.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}