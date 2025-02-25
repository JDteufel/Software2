package co.edu.poli.ejemplo1.servicios;

import java.util.List;
import co.edu.poli.ejemplo1.modelo.Producto;

public interface DAOproducto {
	void createProducto(Producto producto);

	Producto readProducto(String idProducto);

	List<Producto> readAllProducto();

	void updateProducto(Producto producto);

	void deleteProducto(String idProducto);
}
