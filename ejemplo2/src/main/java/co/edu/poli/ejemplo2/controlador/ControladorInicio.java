package co.edu.poli.ejemplo2.controlador;

import co.edu.poli.ejemplo2.modelo.*;
import co.edu.poli.ejemplo2.vista.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import java.util.ArrayList;
import java.util.List;

public class ControladorInicio {

    @FXML
    private ListView<String> listPedidos;

    @FXML
    private Button facade, flyweight, proxy;

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public List<ProductoSimple> crearListaProductos() {
        List<ProductoSimple> lista = new ArrayList<>();
        lista.add(new ProductoSimple("001", "Laptop"));
        lista.add(new ProductoSimple("002", "Mouse"));
        lista.add(new ProductoSimple("003", "Impresora"));
        lista.add(new ProductoSimple("004", "Teclado"));
        lista.add(new ProductoSimple("005", "Monitor"));
        return lista;
    }

    @FXML
    void flyweight(ActionEvent event) {
        Inventario inventario = Inventario.inventarioBase();

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Patrón Flyweight aplicado:\n\n");

        inventario.getProductos().forEach(p -> {
            mensaje.append(p.toString()).append("\n");
            if (p.getProveedor() != null) {
                mensaje.append("Proveedor: ").append(p.getProveedor().toString()).append("\n\n");
            }
        });

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Demostración Flyweight");
        alerta.setHeaderText("Flyweight: Productos y Proveedores Compartidos");
        alerta.setContentText(mensaje.toString());
        alerta.showAndWait();
    }

    @FXML
    void facade(ActionEvent event) {
        try {
            App.cambiarVista("FormularioFacade");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir el formulario de Facade.");
        }   
    }

    @FXML
    void proxy(ActionEvent event) {
        try {
            App.cambiarVista("FormularioProxy");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir el formulario de Proxy.");
        }
    }
}
