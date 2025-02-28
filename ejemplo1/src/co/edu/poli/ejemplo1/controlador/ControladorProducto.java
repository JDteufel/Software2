package co.edu.poli.ejemplo1.controlador;

import java.io.*;
import java.util.*;
import co.edu.poli.ejemplo1.servicios.DAO;
import co.edu.poli.ejemplo1.modelo.Cliente;
import co.edu.poli.ejemplo1.modelo.Pedido;

public class ControladorProducto {
	 private DAO<Producto, String> DAO;
	 
	 private ControladorCliente(DAO DAO) {
	    	this.DAO = DAO;
	    }
}