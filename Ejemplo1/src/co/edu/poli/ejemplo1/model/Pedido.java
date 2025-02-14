package co.edu.poli.ejemplo1.model;

import java.util.List;

public class Pedido {

    // Atributos privados
    private String numero;
    private String fecha;
    private Cliente cliente;
    private List<Producto> productos; // Corrige el nombre a plural para mayor claridad

    // Constructor vacío
    public Pedido() {
    }

    // Constructor con parámetros (opcional)
    public Pedido(String numero, String fecha, Cliente cliente, List<Producto> productos) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.productos = productos;
    }

    // Métodos Getters y Setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    @Override
    public String toString() {
        return "Pedido{numero='" + numero + "', fecha='" + fecha + "', cliente=" + cliente + ", productos=" + productos + "}";
    }

}
