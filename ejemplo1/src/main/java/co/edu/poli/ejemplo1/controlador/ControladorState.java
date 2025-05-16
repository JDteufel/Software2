package co.edu.poli.ejemplo1.controlador;

import java.util.ArrayList;

import co.edu.poli.ejemplo1.modelo.Cliente;
import co.edu.poli.ejemplo1.modelo.EstadoNuevo;
import co.edu.poli.ejemplo1.modelo.Pedido;
import co.edu.poli.ejemplo1.modelo.Producto;
import co.edu.poli.ejemplo1.modelo.ProductoAlimenticio;
import co.edu.poli.ejemplo1.modelo.ProductoElectrico;
import co.edu.poli.ejemplo1.vista.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControladorState {

    @FXML
    private Button bttCancelar, bttBuscar, bttEntregar, bttEnviar, bttInicio, bttPagar;

    @FXML
    private Label lblEstado;

    @FXML
    private ListView<String> listAction, listPedidos;

    @FXML
    private TextField txtId;

    private ObservableList<String> pedidos = FXCollections.observableArrayList();
    private ObservableList<String> historial = FXCollections.observableArrayList();

    private Cliente clienteEjemplo1 = new Cliente("C001", "Juan Perez");
    private Cliente clienteEjemplo2 = new Cliente("C002", "Maria Gomez");

    private Producto productoEjemplo1 = new ProductoAlimenticio("P001", "Alimenticio", "Manzana Roja", 2.5, "80kcal");
    private Producto productoEjemplo2 = new ProductoElectrico("P002", "Electrico", "Lámpara LED", 15.0, "110V");
    private Producto productoEjemplo3 = new ProductoAlimenticio("P003", "Alimenticio", "Pera Verde", 3.0, "100kcal");

    private Pedido pedidoEjemplo1;
    private Pedido pedidoEjemplo2;

    private Pedido pedido;

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
    void initialize() {
        listPedidos.setItems(pedidos);
        listAction.setItems(historial);
        actualizarEstado("Sin crear");

        pedidoEjemplo1 = new Pedido();
        pedidoEjemplo1.setNumero("001");
        pedidoEjemplo1.setCliente(clienteEjemplo1.getNombre());
        ArrayList<Producto> productosPedido1 = new ArrayList<>();
        productosPedido1.add(productoEjemplo1);
        productosPedido1.add(productoEjemplo2);
        pedidoEjemplo1.setProductos(productosPedido1);
        pedidoEjemplo1.cambiarEstado(new EstadoNuevo(pedidoEjemplo1));

        pedidoEjemplo2 = new Pedido();
        pedidoEjemplo2.setNumero("002");
        pedidoEjemplo2.setCliente(clienteEjemplo2.getNombre());
        ArrayList<Producto> productosPedido2 = new ArrayList<>();
        productosPedido2.add(productoEjemplo3);
        pedidoEjemplo2.setProductos(productosPedido2);
        pedidoEjemplo2.cambiarEstado(new EstadoNuevo(pedidoEjemplo2));

        pedidos.add(pedidoEjemplo1.toString());
        pedidos.add(pedidoEjemplo2.toString());
    }

    @FXML
    void bttBuscar(ActionEvent event) {
        String id = txtId.getText().trim();
        if (id.equals("001")) {
            pedido = pedidoEjemplo1;
            historial.clear();
            historial.add("Pedido seleccionado: " + pedido.getNumero());
            actualizarEstadoDesdeObjeto();
        } else if (id.equals("002")) {
            pedido = pedidoEjemplo2;
            historial.clear();
            historial.add("Pedido seleccionado: " + pedido.getNumero());
            actualizarEstadoDesdeObjeto();
        } else {
            mostrarAlerta("No encontrado", "No existe un pedido con ese número.");
            pedido = null;
            historial.clear();
            actualizarEstado("Sin crear");
        }

        pedido.cambiarEstado(new EstadoNuevo(pedido));
    }

    @FXML
    void bttPagar(ActionEvent event) {
        if (verificarPedido()) {
            String estadoAnterior = pedido.getEstado().getClass().getSimpleName();
            pedido.getEstado().pagar();
            String estadoActual = pedido.getEstado().getClass().getSimpleName();
            if (!estadoAnterior.equals(estadoActual)) {
                actualizarEstadoDesdeObjeto();
            } else {
                mostrarAlerta("Estado no válido", "No se puede pagar el pedido en el estado actual: " + estadoAnterior.replace("Estado", ""));
            }
        }
    }

    @FXML
    void bttEnviar(ActionEvent event) {
        if (verificarPedido()) {
            String estadoAnterior = pedido.getEstado().getClass().getSimpleName();
            pedido.getEstado().enviar();
            String estadoActual = pedido.getEstado().getClass().getSimpleName();
            if (!estadoAnterior.equals(estadoActual)) {
                actualizarEstadoDesdeObjeto();
            } else {
                mostrarAlerta("Estado no válido", "No se puede enviar el pedido en el estado actual: " + estadoAnterior.replace("Estado", ""));
            }
        }
    }

    @FXML
    void bttEntregar(ActionEvent event) {
        if (verificarPedido()) {
            String estadoAnterior = pedido.getEstado().getClass().getSimpleName();
            pedido.getEstado().entregar();
            String estadoActual = pedido.getEstado().getClass().getSimpleName();
            if (!estadoAnterior.equals(estadoActual)) {
                actualizarEstadoDesdeObjeto();
            } else {
                mostrarAlerta("Estado no válido", "No se puede entregar el pedido en el estado actual: " + estadoAnterior.replace("Estado", ""));
            }
        }
    }

    @FXML
    void bttCancelar(ActionEvent event) {
        if (verificarPedido()) {
            String estadoAnterior = pedido.getEstado().getClass().getSimpleName();
            pedido.getEstado().cancelar();
            String estadoActual = pedido.getEstado().getClass().getSimpleName();
            if (!estadoAnterior.equals(estadoActual)) {
                actualizarEstadoDesdeObjeto();
            } else {
                mostrarAlerta("Estado no válido", "No se puede cancelar el pedido en el estado actual: " + estadoAnterior.replace("Estado", ""));
            }
        }
    }

    @FXML
    void bttInicio(ActionEvent event) {
        historial.clear();
        pedido = null;
        cambiarVista("FormularioInicio");
    }

    private void actualizarEstado(String estado) {
        lblEstado.setText("Estado: " + estado);
    }

    private void actualizarEstadoDesdeObjeto() {
        String nombreEstado = pedido.getEstado().getClass().getSimpleName().replace("Estado", "");
        historial.add("Estado cambiado a: " + nombreEstado);
        actualizarEstado(nombreEstado);
    }

    private boolean verificarPedido() {
        if (pedido == null) {
            mostrarAlerta("Pedido no creado", "Primero crea un pedido.");
            return false;
        }
        return true;
    }

}