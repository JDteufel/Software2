package co.edu.poli.ejemplo2.controlador;

import co.edu.poli.ejemplo2.modelo.*;
import co.edu.poli.ejemplo2.vista.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControladorInicio {

    @FXML
    private ListView<String> listPedidos;

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
        try {
            App.cambiarVista("FormularioFacade");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir el formulario de Cliente.");
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
    void proxy(ActionEvent event) {
        
    }

}
