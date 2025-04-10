package co.edu.poli.ejemplo2.controlador;

import co.edu.poli.ejemplo2.modelo.Cliente;
import co.edu.poli.ejemplo2.modelo.InterfazCliente;
import co.edu.poli.ejemplo2.modelo.ProductoSimple;
import co.edu.poli.ejemplo2.vista.App;
import co.edu.poli.ejemplo2.modelo.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControladorFacade {

    @FXML
    private Button activarPago;

    @FXML
    private Button addCarrito;

    @FXML
    private Button addCliente;

    @FXML
    private Button back;

    @FXML
    private Button resumen;

    @FXML
    private Button addPago;

    @FXML
    private Button bloquearPago;

    @FXML
    private ListView<String> listPago;

    @FXML
    private ListView<String> listPedido;

    @FXML
    private TextField txtClienteID;

    @FXML
    private TextField txtClienteNombre;

    @FXML
    private TextField txtDescrip;

    @FXML
    private TextField txtIdP;

    @FXML
    private TextField txtNuevaFormaPago;

    @FXML
    private Button updateCliente;

    private InterfazCliente interfaz;

    @FXML
    void AddCliente(ActionEvent event) {
        String id = txtClienteID.getText();
        String nombre = txtClienteNombre.getText();

        if (id.isEmpty() || nombre.isEmpty()) {
            mostrarAlerta("Error", "ID y nombre del cliente son requeridos.");
            return;
        }

        Cliente cliente = new Cliente(id, nombre);
        interfaz = new InterfazCliente(cliente);
        mostrarAlerta("Cliente creado", cliente.toString());
    }

    @FXML
    void UpdateCliente(ActionEvent event) {
        if (interfaz == null) {
            mostrarAlerta("Error", "Primero crea el cliente.");
            return;
        }

        String nuevoNombre = txtClienteNombre.getText();
        interfaz.getInfoCliente().actualizarNombre(nuevoNombre);
        mostrarAlerta("Cliente actualizado", interfaz.getInfoCliente().mostrarInformacion());
    }

    @FXML
    void AddCarrito(ActionEvent event) {
        if (interfaz == null) {
            mostrarAlerta("Error", "Primero crea el cliente.");
            return;
        }

        String idProd = txtIdP.getText();
        String descripcion = txtDescrip.getText();

        if (idProd.isEmpty() || descripcion.isEmpty()) {
            mostrarAlerta("Error", "ID y descripción del producto son requeridos.");
            return;
        }

        Producto producto = new ProductoSimple(idProd, descripcion);
        interfaz.getHistorial().realizarPedido(producto);
        listPedido.getItems().add(producto.toString());
    }

    @FXML
    void AddPago(ActionEvent event) {
        if (interfaz == null) {
            mostrarAlerta("Error", "Primero crea el cliente.");
            return;
        }

        String tipo = txtNuevaFormaPago.getText();
        if (tipo.isEmpty()) {
            mostrarAlerta("Error", "Ingresa una forma de pago.");
            return;
        }

        interfaz.getPagos().agregarFormaDePago(tipo);
        actualizarFormasPago();
    }

    @FXML
    void BloquearPago(ActionEvent event) {
        if (interfaz == null) return;

        String tipo = txtNuevaFormaPago.getText();
        if (!tipo.isEmpty()) {
            interfaz.getPagos().bloquearFormaDePago(tipo);
            actualizarFormasPago();
        }
    }

    @FXML
    void ActivarPago(ActionEvent event) {
        if (interfaz == null) return;

        String tipo = txtNuevaFormaPago.getText();
        if (!tipo.isEmpty()) {
            interfaz.getPagos().activarFormaDePago(tipo);
            actualizarFormasPago();
        }
    }

    private void actualizarFormasPago() {
        listPago.getItems().clear();
        interfaz.getPagos().verFormasDePago().forEach((tipo, activa) -> {
            String estado = activa ? "Activa" : "Bloqueada";
            listPago.getItems().add(tipo + " - " + estado);
        });
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    void Back(ActionEvent event) {
        try {
            App.cambiarVista("FormularioInicio");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir el formulario de Cliente.");
        } 
    }

    @FXML
    void Resumen(ActionEvent event) {
        if (interfaz == null) {
            mostrarAlerta("Error", "Primero debes crear un cliente.");
            return;
        }
    
        StringBuilder mensaje = new StringBuilder();
    
        mensaje.append("Cliente:\n")
               .append(interfaz.getInfoCliente().mostrarInformacion())
               .append("\n\n");
    
        mensaje.append("Pedidos:\n");
        if (interfaz.getHistorial().verHistorial().isEmpty()) {
            mensaje.append("Sin pedidos registrados.\n");
        } else {
            interfaz.getHistorial().verHistorial().forEach(p ->
                mensaje.append("- ").append(p.toString()).append("\n"));
        }
    
        mensaje.append("\nFormas de Pago:\n");
        if (interfaz.getPagos().verFormasDePago().isEmpty()) {
            mensaje.append("Sin formas de pago registradas.\n");
        } else {
            interfaz.getPagos().verFormasDePago().forEach((tipo, activa) -> {
                String estado = activa ? "Activa" : "Bloqueada";
                mensaje.append("- ").append(tipo).append(": ").append(estado).append("\n");
            });
        }
    
        mostrarAlerta("Resumen del Cliente", mensaje.toString());
    }
}