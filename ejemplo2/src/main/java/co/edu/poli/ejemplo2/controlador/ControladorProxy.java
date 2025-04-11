package co.edu.poli.ejemplo2.controlador;

import co.edu.poli.ejemplo2.vista.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControladorProxy {
    @FXML
    private Button acceso, back;

    @FXML
    private TextField txtUsuario;

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    void back(ActionEvent event) {
        try {
            App.cambiarVista("FormularioInicio");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir el formulario de Cliente.");
        } 
    }

    @FXML
    void acceso(ActionEvent event) {
        
    }
}
