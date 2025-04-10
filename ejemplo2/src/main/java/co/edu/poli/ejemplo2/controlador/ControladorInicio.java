package co.edu.poli.ejemplo2.controlador;

import co.edu.poli.ejemplo2.modelo.Inventario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControladorInicio {

    @FXML
    private ListView<?> listPedidos;

    @FXML
    private TextField txtDescrip, txtIdC, txtIdP, txtNombre;

    @FXML
    private Button facade, flyweight, proxy;

    @FXML
    void flyweight(ActionEvent event) {
        // Creamos un inventario y agregamos productos
        Inventario inventario = new Inventario();
        inventario.agregarProducto("001", "Laptop", "TechCorp", "123456", "Calle 1");
        inventario.agregarProducto("002", "Mouse", "TechCorp", "123456", "Calle 1");
        inventario.agregarProducto("003", "Impresora", "PrintWorld", "789101", "Avenida 5");

        // Construimos el mensaje de salida
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Patrón Flyweight aplicado:\n\n");

        inventario.getProductos().forEach(p -> {
            mensaje.append(p.toString()).append("\n----------------------\n");
        });

        // Mostramos el mensaje en un cuadro de alerta
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Demostración Flyweight");
        alerta.setHeaderText("Flyweight: Productos y Proveedores Compartidos");
        alerta.setContentText(mensaje.toString());
        alerta.showAndWait();
    }

    @FXML
    void facade(ActionEvent event) {
    // Crear cliente desde la interfaz
    Cliente cliente = new Cliente(txtIdC.getText(), txtNombre.getText());

    // Crear fachada
    InterfazCliente interfaz = new InterfazCliente(cliente);

    // Actualizar nombre por si se quiere cambiar luego
    interfaz.getInfoCliente().actualizarNombre(txtNombre.getText());

    // Agregar pedido (producto)
    Producto producto = new ProductoSimple(txtIdP.getText(), txtDescrip.getText());
    interfaz.getHistorial().realizarPedido(producto);

    // Agregar formas de pago
    interfaz.getPagos().agregarFormaDePago("Tarjeta de crédito");
    interfaz.getPagos().bloquearFormaDePago("Tarjeta de crédito");

    // Mostrar resumen con alerta
    StringBuilder mensaje = new StringBuilder();
    mensaje.append("Cliente:\n").append(interfaz.getInfoCliente().mostrarInformacion()).append("\n\n");

    mensaje.append("Pedidos:\n");
    interfaz.getHistorial().verHistorial().forEach(p -> mensaje.append(p).append("\n"));

    mensaje.append("Formas de pago:\n");
    interfaz.getPagos().verFormasDePago().forEach((tipo, activa) -> {
        mensaje.append(tipo).append(": ").append(activa ? "Activa" : "Bloqueada").append("\n");
    });

    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    alerta.setTitle("Demostración Facade");
    alerta.setHeaderText("Patrón Facade: Gestión simplificada del cliente");
    alerta.setContentText(mensaje.toString());
    alerta.showAndWait();
    }

    @FXML
    void proxy(ActionEvent event) {
        
    }

}
