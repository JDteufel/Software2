package co.edu.poli.ejemplo1.controlador;

import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.scene.control.*;

public class ControladorPagos {
    
    @FXML private RadioButton Nequi, PayPal;
    @FXML private TextField Monto;

    @FXML
    public void initialize() {
        ToggleGroup toggleGroup = new ToggleGroup();
        Nequi.setToggleGroup(toggleGroup);
        PayPal.setToggleGroup(toggleGroup);
    }

}