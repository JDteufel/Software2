package co.edu.poli.ejemplo1.controlador;

import co.edu.poli.ejemplo1.modelo.Envio;
import co.edu.poli.ejemplo1.modelo.EnvioNacional;
import co.edu.poli.ejemplo1.modelo.EnvioInternacional;
import co.edu.poli.ejemplo1.modelo.Mercancia;
import co.edu.poli.ejemplo1.modelo.Documento;
import co.edu.poli.ejemplo1.modelo.ProductoNormal;
import co.edu.poli.ejemplo1.modelo.ProductoFragil;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ControladorEnvio {

    @FXML
    private Button bt1;

    @FXML
    private ComboBox<String> cb1; // ComboBox para tipo de envío

    @FXML
    private ComboBox<String> cb2; // ComboBox para tipo de mercancía

    @FXML
    void ListarEnvios(Event event) { 
        if (cb1.getItems().isEmpty()) { 
            cb1.getItems().addAll("Nacional", "Internacional");
        }
    }

    @FXML
    void ListarMercancia(Event event) { 
        if (cb2.getItems().isEmpty()) { 
            cb2.getItems().addAll("Documento", "Producto Frágil", "Producto Normal");
        }
    }

    @FXML
    void procesarEnvio() {
        String tipoEnvio = cb1.getValue();
        String tipoMercancia = cb2.getValue();

        if (tipoEnvio == null || tipoMercancia == null) {
            mostrarAlerta("Error", "Debes seleccionar un tipo de envío y un tipo de mercancía.");
            return;
        }

        // Crear la instancia de Envio según la selección del usuario
        Envio envio;
        if ("Nacional".equals(tipoEnvio)) {
            envio = new EnvioNacional();
        } else {
            envio = new EnvioInternacional();
        }

        // Crear la instancia de Mercancia según la selección del usuario
        Mercancia mercancia;
        switch (tipoMercancia) {
            case "Documento":
                mercancia = new Documento(envio);
                break;
            case "Producto Frágil":
                mercancia = new ProductoFragil(envio);
                break;
            case "Producto Normal":
                mercancia = new ProductoNormal(envio);
                break;
            default:
                mostrarAlerta("Error", "Tipo de mercancía no válido.");
                return;
        }

        // Mostrar mensaje de confirmación en una alerta
        mostrarAlerta("Envío Procesado", 
                "Se ha enviado de manera " + tipoEnvio.toLowerCase() + 
                " una mercancía de tipo " + tipoMercancia.toLowerCase() + ".");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}


