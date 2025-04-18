package co.edu.poli.ejemplo1.controlador;

import co.edu.poli.ejemplo1.modelo.Director;
import co.edu.poli.ejemplo1.modelo.Proveedor;
import co.edu.poli.ejemplo1.vista.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class ControladorProveedor {
    @FXML
    private Button bttOk, bttInicio;

    @FXML
    private RadioButton selCertif, selEvalua, selPolEntr;

    @FXML
    private TextField txtCertif, txtEvalua, txtPolEntr;
    
    private Proveedor.Builder builder = new Proveedor.Builder();
    private Director director = new Director();
    
    @FXML
    public void initialize() {
        txtCertif.setDisable(true);
        txtEvalua.setDisable(true);
        txtPolEntr.setDisable(true);
    }
    
    @FXML
    void selCertif(ActionEvent event) {
        txtCertif.setDisable(!selCertif.isSelected());
    }
    
    @FXML
    void selEvalua(ActionEvent event) {
        txtEvalua.setDisable(!selEvalua.isSelected());
    }
    
    @FXML
    void selPolEntr(ActionEvent event) {
        txtPolEntr.setDisable(!selPolEntr.isSelected());
    }
    
    @FXML
    void bttOk(ActionEvent event) {
        String eval = selEvalua.isSelected() ? txtEvalua.getText() : "No especificado";
        String cert = selCertif.isSelected() ? txtCertif.getText() : "No especificado";
        String polEntr = selPolEntr.isSelected() ? txtPolEntr.getText() : "No especificado";

        director.constructProveedor(builder, eval, cert, polEntr);
        Proveedor proveedor = builder.getProduct();
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información del Proveedor");
        alert.setHeaderText("Datos del Proveedor Generado");
        alert.setContentText(proveedor.toString());
        alert.showAndWait();
    }

    @FXML
    private void bttInicio() {
        System.out.println("Intentando abrir la vista de inicio...");
        try {
            App.cambiarVista("FormularioInicio");
            System.out.println("Vista de inicio abierta correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir el formulario de inicio.");
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
