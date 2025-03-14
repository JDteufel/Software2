package co.edu.poli.ejemplo1.controlador;

import java.util.*;
import co.edu.poli.ejemplo1.servicios.DAOimplementProducto;
import co.edu.poli.ejemplo1.modelo.*;

public class ControladorProducto {
	private DAOimplementProducto consulta;

	public ControladorProducto() {
		this.consulta = new DAOimplementProducto();
	}

	public void create(String idProducto, String tipo, String descripcion, String extra) {
		Producto producto;

		if (tipo.equals("Eléctrico")) {
			producto = new ProductoElectrico(idProducto, tipo, descripcion, extra);
		} else {

			producto = new ProductoAlimenticio(idProducto, tipo, descripcion, extra);
		}

		consulta.create(producto);
	}

	public Producto read(String idProducto) {
		return consulta.read(idProducto);
	}

	public List<Producto> readAll() {
		return consulta.readAll();
	}

	public void update(Integer idProducto, String descripcion) {
		Producto producto = new ProductoElectrico(idProducto.toString(), "electrico", descripcion, "220");
		consulta.update(producto);
	}

	public void delete(String idProducto) {
		consulta.delete(idProducto);
	}
}
