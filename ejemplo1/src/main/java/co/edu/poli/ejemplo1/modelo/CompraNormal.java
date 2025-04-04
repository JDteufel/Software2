package co.edu.poli.ejemplo1.modelo;

public class CompraNormal implements Carrito {
    double precio1, precio2, precio3, precio4, precio5, precio6, precio7, precio8, precio9, precio10;

    public CompraNormal() {
        precio1 = 1000.0;
        precio2 = 2000.0;
        precio3 = 3000.0;
        precio4 = 4000.0;
        precio5 = 5000.0;
        precio6 = 6000.0;
        precio7 = 7000.0;
        precio8 = 8000.0;
        precio9 = 9000.0;
        precio10 = 10000.0;
    }

    @Override
    public double FinalizarCompra() {
        return precio1 + precio2 + precio3 + precio4 + precio5 + precio6 + precio7 + precio8 + precio9 + precio10;
    }
}
