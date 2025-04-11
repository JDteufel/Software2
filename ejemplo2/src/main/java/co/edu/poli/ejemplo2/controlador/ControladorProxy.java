package co.edu.poli.ejemplo2.controlador;

import co.edu.poli.ejemplo2.vista.App;
import co.edu.poli.ejemplo2.modelo.ProductoSimple;
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
        String usuario = txtUsuario.getText();
        if (usuario == null || usuario.isEmpty()) {
            mostrarAlerta("Error", "El campo de usuario está vacío.");
            return;
        }

        if ("Juan David Gómez Cárdenas".equals(usuario) || 
            "Deivid Rodríguez Cruz".equals(usuario) || 
            "Hillary Liv Rodríguez Sagbini".equals(usuario)) {
            StringBuilder mensaje = new StringBuilder("Lista de productos:\n");
            for (ProductoSimple producto : ProductoSimple.crearListaProductos()) {
                mensaje.append(producto.toString()).append("\n");
            }
            mostrarAlerta("Acceso concedido", mensaje.toString());
        } else {
            mostrarAlerta("Acceso denegado", "Usuario no autorizado.");
        }
    }
}
