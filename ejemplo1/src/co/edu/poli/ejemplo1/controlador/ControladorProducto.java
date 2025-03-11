package co.edu.poli.ejemplo1.controlador;

import java.io.*;
import java.util.*;
import co.edu.poli.ejemplo1.servicios.ConsultaEsp;
import co.edu.poli.ejemplo1.servicios.DAOimplementProducto;
import co.edu.poli.ejemplo1.modelo.Producto;

public class ControladorProducto {
	 private ConsultaEsp<Producto, String> consulta;
	 
	 private ControladorProducto() {
	    	this.consulta = (ConsultaEsp<Producto, String>) new DAOimplementProducto();
	    }
	 
	 public void create(String idProducto, String tipo, String descripcion) {
		 if(tipo == "Eléctrico") {
			 Producto producto = new ProductoElectrico(idProducto, tipo, descripcion);
		 } else(tipo == "Eléctrico") {
			 Producto producto = new Producto(idProducto, tipo, descripcion);
		 }
			consulta.create(producto);
		}
		
		public Producto read(String idProducto) {
			return consulta.read(idProducto);
		}
		
		public List<Producto> readAll(){
			return consulta.readAll();
			
		}
		
		public void update(String idProducto, String tipo, String descripcion) {
			Producto producto = new Producto(idProducto, tipo, descripcion);
			consulta.update(producto);
		}
		
		public void delete(String idProducto) {
			consulta.delete(idProducto);
		}
}