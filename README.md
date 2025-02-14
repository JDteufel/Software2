# Software2
import java.sql.*;

public class EjemploSingleton {

    // Propiedades
    private static conexion conn = null;
    private String driver;
    private String url;
    private String usuario;
    private String password;
 
    private conexionBD(){
 
 String url = "jdbc:mysql://localhost:3306/test";
 String driver = "com.mysql.jdbc.Driver";
 String usuario = "postgres";
 String password = "Qazplm11.";
  
 try{
     Class.forName(driver);
     conn = DriverManager.getConnection(url, usuario, password);
 }
 catch(ClassNotFoundException | SQLException e){
     e.printStackTrace();
 }
    }
 
    public static conexion getInstance(){
  
 if (conn == null){
     new EjemploSingleton();
 }
  
 return conn;
    }
}
