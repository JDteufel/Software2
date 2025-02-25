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

	static {
        ResourceBundle config = ResourceBundle.getBundle("config");
        URL = config.getString("URL");
        USUARIO = config.getString("USUARIO");
        CONTRA = config.getString("CONTRA");
    }
/*
    static {
        Properties infoDB = new Properties();
        String urlT = null;
        String usuarioT = null;
        String contraT = null;

        try {
            infoDB.load(new FileInputStream("config.properties"));
            urlT = infoDB.getProperty("URL");
            usuarioT = infoDB.getProperty("USUARIO");
            contraT = infoDB.getProperty("CONTRA");
        } catch (IOException e) {
            e.printStackTrace();
        }
        URL = urlT;
        USUARIO = usuarioT;
        CONTRA = contraT;	
    }
 */

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
		if (instancia == null) {
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
