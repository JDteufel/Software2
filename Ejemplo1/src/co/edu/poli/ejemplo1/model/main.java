package co.edu.poli.ejemplo1.model;
import java.util.ArrayList;
import java.util.List;


public class main {

	public static void main(String[] args) {
		Cliente nombre = new Cliente("0011", "Luis");
		Producto p1 = new Producto("001", "Leche");
		Producto p2 = new Producto("002", "Cereal");
		
		 List<Producto> productos = new ArrayList<>();
	        productos.add(p1);
	        productos.add(p2);

	        // Crear un pedido con los productos
	        
	        Pedido orden = new Pedido("1001", "2025-02-07", nombre, productos);

	        // Imprime el pedido con información detallada
	        System.out.println(orden);
	        //Deivid Rodriguez, Hillarry Rodriguez, Juan David Gomez
	        }
	    }
