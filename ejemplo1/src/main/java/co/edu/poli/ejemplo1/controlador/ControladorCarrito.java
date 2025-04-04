package co.edu.poli.ejemplo1.controlador;

import co.edu.poli.ejemplo1.vista.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import co.edu.poli.ejemplo1.modelo.CompraNormal;
import co.edu.poli.ejemplo1.modelo.EnvioGratis;
import co.edu.poli.ejemplo1.modelo.Descuento;
import co.edu.poli.ejemplo1.modelo.Puntos;
import co.edu.poli.ejemplo1.modelo.Carrito;

public class ControladorCarrito {

    @FXML
    private Button bttFin, bttInicio, bttVer;

    @FXML
    private RadioButton selDesc, selEnvio, selPunto;

    @FXML
    private TextField txtCompra, txtDesc, txtPunto;

    @FXML
    public void initialize() {
        
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }   

    @FXML
    void bttVer(ActionEvent event) {
        
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

    @FXML
    private void FinalizarCompra(ActionEvent event) {
        Carrito compra = new CompraNormal(); // Base purchase
        StringBuilder detalles = new StringBuilder("Detalles de la compra:\n");
        double descuentoAplicado = 0;
        boolean envioGratuito = false;

        if (selDesc.isSelected()) {
            try {
                double descuento = Double.parseDouble(txtDesc.getText());
                compra = new Descuento(compra, descuento); // Apply discount
                descuentoAplicado = descuento;
                detalles.append("- Descuento aplicado: ").append(descuento).append("%\n");
            } catch (NumberFormatException e) {
                mostrarAlerta("Error", "El valor del descuento debe ser un número válido.");
                return;
            }
        } else {
            detalles.append("- Descuento no aplicado.\n");
        }

        if (selPunto.isSelected()) {
            try {
                int puntos = Integer.parseInt(txtPunto.getText());
                Puntos puntosCompra = new Puntos(compra); // Apply points
                puntosCompra.setPuntosAcumulados(puntos);
                compra = puntosCompra;
                detalles.append("- Puntos usados: ").append(puntos).append("\n");
            } catch (NumberFormatException e) {
                mostrarAlerta("Error", "El número de puntos debe ser un número válido.");
                return;
            }
        } else {
            detalles.append("- Puntos no usados.\n");
        }

        if (selEnvio.isSelected()) {
            compra = new EnvioGratis(compra, 0); // Free shipping
            envioGratuito = true;
            detalles.append("- Envío: Gratis\n");
        } else {
            compra = new EnvioGratis(compra, 6000); // Shipping with cost
            detalles.append("- Envío: Con costo (6000)\n");
        }

        double total = compra.FinalizarCompra();
        detalles.append("Total de la compra: ").append(total);

        mostrarAlerta("Compra Finalizada", detalles.toString());
    }
    
}
