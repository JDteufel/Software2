package co.edu.poli.ejemplo2.modelo;

import java.util.HashMap;
import java.util.Map;

public class ProveedorFactory {
    private static final Map<String, Proveedor> proveedores = new HashMap<>();

    public static Proveedor getProveedor(String nombre, String contacto, String direccion) {
        String key = nombre + "_" + contacto + "_" + direccion;
        if (!proveedores.containsKey(key)) {
            proveedores.put(key, new Proveedor(nombre, contacto, direccion));
        }
        return proveedores.get(key);
    }
}