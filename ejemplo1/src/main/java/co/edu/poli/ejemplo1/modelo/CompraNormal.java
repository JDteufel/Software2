package co.edu.poli.ejemplo1.modelo;

import java.util.ArrayList;
import java.util.List;

public class CompraNormal implements Carrito {
    private List<Double> precios;

    public CompraNormal() {
        precios = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            precios.add(i * 1000.0);
        }
    }

    @Override
    public double FinalizarCompra() {
        return precios.stream().mapToDouble(Double::doubleValue).sum();
    }
}