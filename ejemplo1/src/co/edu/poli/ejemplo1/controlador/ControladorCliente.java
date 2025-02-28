package co.edu.poli.ejemplo1.controlador;

import java.util.*;
import co.edu.poli.ejemplo1.servicios.DAO;
import co.edu.poli.ejemplo1.modelo.Cliente;


public class ControladorCliente {

    private DAO<Cliente, String> DAO;
    
    private ControladorCliente(DAO DAO) {
    	this.DAO = DAO;
    }
    
	public void create(String idCliente, String nombre) {
		Cliente cliente = new Cliente(idCliente, nombre);
		DAO.create(cliente);
	}
	
	public Cliente read(String id) {
		return DAO.read(id);
	}
	
	public List<Cliente> readAll(){
		return DAO.readAll();
		
	}
	
	public void update(String idCliente, String nombre) {
		Cliente cliente = new Cliente(idCliente, nombre);
		DAO.update(cliente);
	}
	
	public void delete(String id) {
		DAO.delete(id);
	}
}