package co.edu.poli.ejemplo1.controlador;

import co.edu.poli.ejemplo1.modelo.*;
import co.edu.poli.ejemplo1.vista.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class ControladorComm {

    // Productos disponibles
    Producto p1 = new ProductoAlimenticio("1", "Alimento", "Manzana", 2.5, "80kcal");
    Producto p2 = new ProductoElectrico("2", "Electrico", "Lámpara", 15.0, "110V");
    Producto p3 = new ProductoAlimenticio("3", "Alimento", "Pera", 3.0, "100kcal");
    Producto p4 = new ProductoElectrico("4", "Electrico", "PC", 150.0, "500V");
    Producto p5 = new ProductoAlimenticio("5", "Alimento", "Sandía", 4.0, "200kcal");
    Producto p6 = new ProductoElectrico("6", "Electrico", "Televisor", 200.0, "220V");

    private Pedido pedido = new Pedido();
    private GestorComandos gestor = new GestorComandos();

    @FXML
    private TextArea textarea;

    @FXML
    private Button agregar;

    @FXML
    private Button bttAtras;

    @FXML
    private ComboBox<Producto> comida;

    @FXML
    private ComboBox<Producto> electricos;

    @FXML
    private Button eliminar;

    @FXML
    public void initialize() {
        comida.getItems().addAll(p1, p3, p5);
        electricos.getItems().addAll(p2, p4, p6);
    }

    @FXML
    void agregar(ActionEvent event) {
        Producto seleccionado = comida.getValue() != null ? comida.getValue() : electricos.getValue();
        if (seleccionado != null) {
            Comando cmd = new AgregarProductoComando(pedido, seleccionado);
            gestor.ejecutarComando(cmd);
            actualizarTextArea();
            comida.getSelectionModel().clearSelection();
            electricos.getSelectionModel().clearSelection();
        } else {
            mostrarAlerta("Selecciona un producto", "Debes seleccionar un producto para agregar.");
        }
    }
    

    @FXML
    void eliminar(ActionEvent event) {
        Producto seleccionado = comida.getValue() != null ? comida.getValue() : electricos.getValue();
        if (seleccionado != null && pedido.getProducto().contains(seleccionado)) {
            Comando cmd = new EliminarProductoComando(pedido, seleccionado);
            gestor.ejecutarComando(cmd);
            actualizarTextArea();
            comida.getSelectionModel().clearSelection();
            electricos.getSelectionModel().clearSelection();
        } else {
            mostrarAlerta("Producto no encontrado", "El producto no está en el pedido.");
        }
    }
    

    private void actualizarTextArea() {
        StringBuilder contenido = new StringBuilder("Productos en el pedido:\n");
        for (Producto p : pedido.getProducto()) {
            contenido.append(p.toString()).append("\n");
        }
        textarea.setText(contenido.toString());
    }

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
}
