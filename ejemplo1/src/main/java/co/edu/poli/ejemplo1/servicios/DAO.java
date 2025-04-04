package co.edu.poli.ejemplo1.servicios;

import java.util.List;

public interface DAO<T, ID> {    
	void create(T entidad);
	T read(ID id);
	List<T> readAll();
	void update(T entidad);
	void delete(ID id); 
}