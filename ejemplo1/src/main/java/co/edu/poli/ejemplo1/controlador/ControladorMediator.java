package co.edu.poli.ejemplo1.controlador;

import java.util.ArrayList;

import co.edu.poli.ejemplo1.modelo.Cliente;
import co.edu.poli.ejemplo1.modelo.Pedido;
import co.edu.poli.ejemplo1.modelo.Producto;
import co.edu.poli.ejemplo1.modelo.ProductoAlimenticio;
import co.edu.poli.ejemplo1.modelo.ProductoElectrico;
import co.edu.poli.ejemplo1.vista.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControladorMediator {

    @FXML
    private Button bttAtras, bttRegistrar, bttPedir;

    @FXML
    private TextField txtCliente, txtPedido;

    private Cliente clienteEjemplo1 = new Cliente("C001", "Juan Perez");
    private Cliente clienteEjemplo2 = new Cliente("C002", "Maria Gomez");

    private Producto productoEjemplo1 = new ProductoAlimenticio("P001", "Alimenticio", "Manzana Roja", 2.5, "80kcal");
    private Producto productoEjemplo2 = new ProductoElectrico("P002", "Electrico", "Lámpara LED", 15.0, "110V");
    private Producto productoEjemplo3 = new ProductoAlimenticio("P003", "Alimenticio", "Pera Verde", 3.0, "100kcal");

    private Pedido pedidoEjemplo1;
    private Pedido pedidoEjemplo2;

    @FXML
    void initialize() {
        pedidoEjemplo1 = new Pedido();
        pedidoEjemplo1.setNumero("001");
        ArrayList<Producto> productosPedido1 = new ArrayList<>();
        productosPedido1.add(productoEjemplo1);
        productosPedido1.add(productoEjemplo2);
        pedidoEjemplo1.setProductos(productosPedido1);

        pedidoEjemplo2 = new Pedido();
        pedidoEjemplo2.setNumero("002");
        ArrayList<Producto> productosPedido2 = new ArrayList<>();
        productosPedido2.add(productoEjemplo3);
        pedidoEjemplo2.setProductos(productosPedido2);
    }

    private void cambiarVista(String vista) {
        System.out.println("Intentando abrir la vista: " + vista);
        try {
            App.cambiarVista(vista);
            System.out.println("Vista " + vista + " abierta correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir la vista de " + vista);
        }
    }

   private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    void bttAtras(ActionEvent event) {
        cambiarVista("FormularioInicio");
    }   

    @FXML
    void bttRegistrar(ActionEvent event) {
        String idCliente = txtCliente.getText().trim();
        String idPedido = txtPedido.getText().trim();

        if (idCliente.isEmpty() || idPedido.isEmpty()) {
            mostrarAlerta("Error", "Por favor ingrese el ID del cliente y del pedido.");
            return;
        }

        Cliente cliente = null;
        if (idCliente.equals(clienteEjemplo1.getIdCliente())) {
            cliente = clienteEjemplo1;
        } else if (idCliente.equals(clienteEjemplo2.getIdCliente())) {
            cliente = clienteEjemplo2;
        } else {
            mostrarAlerta("Error", "Cliente no encontrado.");
            return;
        }

        Pedido pedido = null;
        if (idPedido.equals(pedidoEjemplo1.getNumero())) {
            pedido = pedidoEjemplo1;
        } else if (idPedido.equals(pedidoEjemplo2.getNumero())) {
            pedido = pedidoEjemplo2;
        } else {
            mostrarAlerta("Error", "Pedido no encontrado.");
            return;
        }

        pedido.setCliente(cliente.getNombre());

        co.edu.poli.ejemplo1.modelo.MediatorCarrito mediatorCarrito = new co.edu.poli.ejemplo1.modelo.MediatorCarrito(cliente, pedido, null);
        mediatorCarrito.registrarEnCarrito();

        mostrarAlerta("Carrito", "Pedido registrado en carrito: " + pedido.toString() +
            "\nCliente notificado: " + cliente.toString());
    }

    @FXML
    void bttPedir(ActionEvent event) {
        String idPedido = txtPedido.getText().trim();
        String idCliente = txtCliente.getText().trim();

        if (idPedido.isEmpty() || idCliente.isEmpty()) {
            mostrarAlerta("Error", "Por favor ingrese el ID del pedido y del cliente.");
            return;
        }

        Pedido pedido = null;
        if (idPedido.equals(pedidoEjemplo1.getNumero())) {
            pedido = pedidoEjemplo1;
        } else if (idPedido.equals(pedidoEjemplo2.getNumero())) {
            pedido = pedidoEjemplo2;
        } else {
            mostrarAlerta("Error", "Pedido no encontrado.");
            return;
        }

        Cliente cliente = null;
        if (idCliente.equals(clienteEjemplo1.getIdCliente())) {
            cliente = clienteEjemplo1;
        } else if (idCliente.equals(clienteEjemplo2.getIdCliente())) {
            cliente = clienteEjemplo2;
        } else {
            mostrarAlerta("Error", "Cliente no encontrado.");
            return;
        }

        pedido.setCliente(cliente.getNombre());

        co.edu.poli.ejemplo1.modelo.MediatorCarrito mediatorCarrito = new co.edu.poli.ejemplo1.modelo.MediatorCarrito(cliente, pedido, null);
        mediatorCarrito.notificarCliente();

        mostrarAlerta("Carrito", "Cliente notificado: " + cliente.toString() +
            "\nPedido actualizado: " + pedido.toString());
    }
}
