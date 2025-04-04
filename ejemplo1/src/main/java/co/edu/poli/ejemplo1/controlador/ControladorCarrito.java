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
import co.edu.poli.ejemplo1.modelo.CarritoVIP;

public class ControladorCarrito {

    @FXML
    private Button bttFin, bttInicio, bttVer;

    @FXML
    private RadioButton selDesc, selEnvio, selPunto, selVIP;

    @FXML
    private TextField txtCompra, txtDesc, txtPunto, txtVIP;

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
        Carrito compra = new CompraNormal();
        StringBuilder detalles = new StringBuilder("Detalles de la compra:\n");
        double descuentoAplicado = 0;
        boolean envioGratuito = false;

        if (selDesc.isSelected()) {
            try {
                double descuento = Double.parseDouble(txtDesc.getText());
                compra = new Descuento(compra, descuento); 
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
                Puntos puntosCompra = new Puntos(compra); 
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
            compra = new EnvioGratis(compra, 0); 
            envioGratuito = true;
            detalles.append("- Envío: Gratis\n");
        } else {
            compra = new EnvioGratis(compra, 6000);
            detalles.append("- Envío: Con costo (6000)\n");
        }

        if (selVIP.isSelected()) {
            String nombreUsuario = txtVIP.getText();
            CarritoVIP carritoVIP = new CarritoVIP(compra, nombreUsuario);
            compra = carritoVIP;

            if (carritoVIP.esUsuarioVIP()) {
                detalles.append("- Usuario VIP detectado: Prioridad en el envío.\n");
            } else {
                detalles.append("- Usuario no es VIP.\n");
            }
        } else {
            detalles.append("- Usuario VIP no seleccionado.\n");
        }

        double total = compra.FinalizarCompra();
        detalles.append("Total de la compra: ").append(total);

        mostrarAlerta("Compra Finalizada", detalles.toString());
    }
    
}
