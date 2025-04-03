package co.edu.poli.ejemplo1.controlador;

import co.edu.poli.ejemplo1.vista.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ControladorInicio {

    @FXML
    private Button carrito, cliente, envio, pago, produc, provee;

    @FXML
    void carrito(ActionEvent event) {
        cambiarVista("FormularioCarrito");
    }

    @FXML
    void cliente(ActionEvent event) {
        cambiarVista("FormularioCliente");
    }

    @FXML
    void envio(ActionEvent event) {
        cambiarVista("FormularioEnvio");
    }

    @FXML
    void pago(ActionEvent event) {
        cambiarVista("MetodosdePago");
    }

    @FXML
    void produc(ActionEvent event) {
        cambiarVista("FormularioProducto");
    }

    @FXML
    void provee(ActionEvent event) {
        cambiarVista("FormularioProveedor");
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

}
