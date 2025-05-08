package co.edu.poli.ejemplo1.controlador;

import co.edu.poli.ejemplo1.modelo.Cliente;
import co.edu.poli.ejemplo1.modelo.Contexto;
import co.edu.poli.ejemplo1.modelo.Descuento1raCompra;
import co.edu.poli.ejemplo1.modelo.DescuentoNulo;
import co.edu.poli.ejemplo1.modelo.DescuentoVIP;
import co.edu.poli.ejemplo1.vista.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControladorStrat {

    @FXML
    private Button bttAtras, bttPago;

    @FXML
    private TextField txtNombre, txtId, txtNeto;

    Cliente c1 = new Cliente("1076736852", "Juan Gómez");
    Cliente c2 = new Cliente("1020304050", "Don Numeral");
    Cliente c3 = new Cliente("7777777777", "Diosito");

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
    void bttAtras(ActionEvent event) {
        cambiarVista("FormularioInicio");
    }

    @FXML
    void bttPago(ActionEvent event) {
        String nombre = txtNombre.getText();
        String id = txtId.getText();
        double neto;

        try {
            neto = Double.parseDouble(txtNeto.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El valor ingresado en el campo neto no es válido.");
            return;
        }

        Cliente cliente = new Cliente(id, nombre);
        Contexto contexto = new Contexto(cliente);

        switch (nombre) {
            case "Juan Gómez":
                contexto.setStrategy(new Descuento1raCompra());
                break;
            case "Don Numeral":
                contexto.setStrategy(new DescuentoNulo());
                break;
            case "Diosito":
                contexto.setStrategy(new DescuentoVIP());
                break;
            default:
                mostrarAlerta("Error", "Cliente no reconocido.");
                return;
        }

        double descuento = contexto.procesarPago();
        double total = neto - (neto * descuento);

        mostrarAlerta("Pago calculado", "El descuento para " + nombre + " es del " + (descuento * 100) + "%.\n" +
                "Valor neto: $" + neto + "\n" +
                "Total a pagar: $" + total);
    }    
}
