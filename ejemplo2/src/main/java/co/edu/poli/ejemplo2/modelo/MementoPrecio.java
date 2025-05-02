package co.edu.poli.ejemplo2.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MementoPrecio {
    private final double precioGuardado;
    private static final Map<String, List<MementoPrecio>> historialPrecios = new HashMap<>();

    public MementoPrecio(double precio) {
        this.precioGuardado = precio;
    }

    public double getPrecioGuardado() {
        return precioGuardado;
    }

    public static void guardarEstado(Producto producto, double precioActual) {
        historialPrecios
            .computeIfAbsent(producto.getIdProducto(), k -> new ArrayList<>())
            .add(new MementoPrecio(precioActual));
    }

    public static List<Double> getHistorialPrecios(String idProducto) {
        List<MementoPrecio> historial = historialPrecios.getOrDefault(idProducto, new ArrayList<>());
        List<Double> precios = new ArrayList<>();
        for (MementoPrecio memento : historial) {
            precios.add(memento.getPrecioGuardado());
        }
        return precios;
    }

    public static boolean deshacerCambioPrecio(Producto producto) {
        List<MementoPrecio> historial = historialPrecios.get(producto.getIdProducto());
        if (historial != null && !historial.isEmpty()) {
            MementoPrecio memento = historial.remove(historial.size() - 1);
            producto.setPrecio(memento.getPrecioGuardado());
            return true;
        }
        return false;
    }
}
