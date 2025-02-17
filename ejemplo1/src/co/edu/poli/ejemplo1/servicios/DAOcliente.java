package co.edu.poli.ejemplo1.servicios;

import java.util.*;
import co.edu.poli.ejemplo1.modelo.*;

public interface DAOcliente {
	void createCliente(Cliente A);
	Cliente readCliente(String idCliente);
	List<Cliente> readAllCliente();
	void updateCliente(Cliente A);
	void deleteCliente(String idCliente);
}