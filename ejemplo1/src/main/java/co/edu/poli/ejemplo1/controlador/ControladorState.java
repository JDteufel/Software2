package co.edu.poli.ejemplo1.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class ControladorState {

    @FXML
    private Button bttAdd, bttCrear;

    @FXML
    private ListView<String> listProduc;

    @FXML
    private TextField txtCliente, txtPedido, txtProduc;

    private ObservableList<String> productos = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        listProduc.setItems(productos);
    }

    @FXML
    void bttAdd(ActionEvent event) {
        String producto = txtProduc.getText().trim();
        if (!producto.isEmpty()) {
            productos.add(producto);
            txtProduc.clear();
        } else {
            mostrarAlerta("Campo vacío", "Escribe el nombre o descripción del producto.");
        }
    }

    @FXML
    void bttCrear(ActionEvent event) {
        String cliente = txtCliente.getText().trim();
        String numero = txtPedido.getText().trim();

        if (cliente.isEmpty() || numero.isEmpty() || productos.isEmpty()) {
            mostrarAlerta("Faltan datos", "Debes ingresar cliente, número de pedido y al menos un producto.");
            return;
        }

        StringBuilder resumen = new StringBuilder();
        resumen.append("Pedido: ").append(numero).append("\n");
        resumen.append("Cliente: ").append(cliente).append("\n");
        resumen.append("Productos:\n");
        for (String prod : productos) {
            resumen.append("- ").append(prod).append("\n");
        }

        mostrarAlerta("Pedido creado", resumen.toString());

        txtCliente.clear();
        txtPedido.clear();
        txtProduc.clear();
        productos.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
