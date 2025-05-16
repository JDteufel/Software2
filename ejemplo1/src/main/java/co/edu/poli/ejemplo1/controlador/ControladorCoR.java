package co.edu.poli.ejemplo1.controlador;

import co.edu.poli.ejemplo1.modelo.ManejadorProducto;
import co.edu.poli.ejemplo1.modelo.Producto;
import co.edu.poli.ejemplo1.modelo.ProductoAlimenticio;
import co.edu.poli.ejemplo1.modelo.ProductoElectrico;
import co.edu.poli.ejemplo1.modelo.ValidarDescripcion;
import co.edu.poli.ejemplo1.modelo.ValidarPrecio;
import co.edu.poli.ejemplo1.modelo.ValidarTipo;
import co.edu.poli.ejemplo1.vista.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ControladorCoR {

    @FXML
    private Button bttAtras, bttCrear, bttSiguiente;

    @FXML
    private RadioButton selAlim, selElec;

    @FXML
    private TextField txtValidar, txtId, txtDescr, txtPrecio;

    @FXML
    private Rectangle valDescr, valPrecio, valTipo;

    private ManejadorProducto ValidarTipo;
    private ManejadorProducto ValidarPrecio;
    private ManejadorProducto ValidarDescripcion;
    private ManejadorProducto actualValidador;
    private Producto productoValidar;

    @FXML
    void bttAtras(ActionEvent event) {
        cambiarVista("FormularioInicio");
    }

    @FXML
    void bttCrear(ActionEvent event) {

        valTipo.setFill(Color.LIGHTGRAY);
        valPrecio.setFill(Color.LIGHTGRAY);
        valDescr.setFill(Color.LIGHTGRAY);

        String id = txtId.getText();
        String tipo = selAlim.isSelected() ? "Alimenticio" : selElec.isSelected() ? "Electrico" : "";
        String descripcion = txtDescr.getText();
        double precio;

        try {
            precio = Double.parseDouble(txtPrecio.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Precio inválido");
            return;
        }

        if (tipo.isEmpty()) {
            mostrarAlerta("Error", "Seleccione un tipo de producto");
            return;
        }

        if (tipo.equals("Alimenticio")) {
            productoValidar = new ProductoAlimenticio(id, tipo, descripcion, precio, "100cal");
        } else {
            productoValidar = new ProductoElectrico(id, tipo, descripcion, precio, "220v");
        }

        ValidarTipo = new ValidarTipo();
        ValidarPrecio = new ValidarPrecio();
        ValidarDescripcion = new ValidarDescripcion();

        ValidarTipo.setSiguiente(ValidarPrecio);
        ValidarPrecio.setSiguiente(ValidarDescripcion);

        actualValidador = ValidarTipo;

        mostrarAlerta("Paso a paso", "Producto creado. Presiona 'Siguiente' para validar.");
    }

    @FXML
    public void initialize() {
        ValidarTipo = new ValidarTipo();
        ValidarPrecio = new ValidarPrecio();
        ValidarDescripcion = new ValidarDescripcion();

        ValidarTipo.setSiguiente(ValidarPrecio);
        ValidarPrecio.setSiguiente(ValidarDescripcion);
    }

    @FXML
    void bttSiguiente(ActionEvent event) {
    if (productoValidar == null || actualValidador == null) {
        txtValidar.setText("Primero crea un producto.");
        return;
    }

    boolean paso = actualValidador.puedeProcesar(productoValidar);
    String nombreValidador = "";

    if (actualValidador instanceof ValidarTipo) {
        valTipo.setFill(paso ? Color.LIGHTGREEN : Color.SALMON);
        nombreValidador = "Tipo";
    } else if (actualValidador instanceof ValidarPrecio) {
        valPrecio.setFill(paso ? Color.LIGHTGREEN : Color.SALMON);
        nombreValidador = "Precio";
    } else if (actualValidador instanceof ValidarDescripcion) {
        valDescr.setFill(paso ? Color.LIGHTGREEN : Color.SALMON);
        nombreValidador = "Descripción";
    }

    if (!paso) {
        txtValidar.setText("Validación fallida en: " + nombreValidador);
        actualValidador = null;
        return;
    }

    actualValidador = actualValidador.getSiguiente();

    if (actualValidador == null) {
        txtValidar.setText("Producto validado correctamente.");
        } else {
            txtValidar.setText("Validación exitosa en: " + nombreValidador + ". Presiona 'Siguiente'.");
        }
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
}
