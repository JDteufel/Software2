package co.edu.poli.ejemplo1.controlador;

import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.scene.control.*;
import co.edu.poli.ejemplo1.modelo.Nequi;
import co.edu.poli.ejemplo1.modelo.Pagos;
import co.edu.poli.ejemplo1.modelo.PayPal;
import co.edu.poli.ejemplo1.modelo.PayPalAdapter;

public class ControladorPagos {
    
    @FXML private RadioButton Nequi, PayPal;

    @FXML private TextField Monto;

    @FXML private Button Pagar;

    private ToggleGroup toggleGroup;

    @FXML
    public void initialize() {
        toggleGroup = new ToggleGroup();
        Nequi.setToggleGroup(toggleGroup);
        PayPal.setToggleGroup(toggleGroup);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }


    @FXML
    private void Pagar() {
        double monto;
        Pagos metodoPago;

        if (toggleGroup.getSelectedToggle() == null) {
            mostrarAlerta("Error", "Por favor, selecciona un método de pago.");
            return;
        }
        
        try {
            monto = Double.parseDouble(Monto.getText());
            if (monto <= 0) {
                mostrarAlerta("Error", "El monto debe ser mayor a 0.");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Por favor, ingresa un monto válido.");
            return;
        }

        if (Nequi.isSelected()) {
            metodoPago = new Nequi();
        } else {
            metodoPago = new PayPalAdapter(new PayPal());
        }

        double resultado = metodoPago.Cobro(monto);
        mostrarAlerta("Resultado del Pago", "El monto total procesado es: " + resultado);
    }

}