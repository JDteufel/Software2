package co.edu.poli.ejemplo1.controlador;

import co.edu.poli.ejemplo1.modelo.MostrarImpuestoVisitor;
import co.edu.poli.ejemplo1.modelo.Producto;
import co.edu.poli.ejemplo1.modelo.ProductoAlimenticio;
import co.edu.poli.ejemplo1.modelo.ProductoElectrico;
import co.edu.poli.ejemplo1.vista.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ControladorVisi {

    Producto p1 = new ProductoAlimenticio("1", "Alimento", "Manzana", 2.5, "80kcal");
    Producto p2 = new ProductoElectrico("2", "Electrico", "Lámpara", 15.0, "110V");
    Producto p3 = new ProductoAlimenticio("3", "Alimento", "Pera", 3.0, "100kcal");
    Producto p4 = new ProductoElectrico("4", "Electrico", "PC", 150.0, "500V");
    Producto p5 = new ProductoAlimenticio("5", "Alimento", "Sandía", 4.0, "200kcal");
    Producto p6 = new ProductoElectrico("6", "Electrico", "Televisor", 200.0, "220V");

    @FXML
    private Button impu, bttAtras;

    @FXML
    private ComboBox<Producto> produc;

    @FXML
    public void initialize() {
        produc.getItems().addAll(p1, p2, p3, p4, p5, p6);
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

@FXML
void impu(ActionEvent event) {
    Producto seleccionado = produc.getValue();
    if (seleccionado == null) {
        mostrarAlerta("Atención", "Selecciona un producto para calcular el impuesto.");
        return;
    }

    MostrarImpuestoVisitor visitor = new MostrarImpuestoVisitor();
    seleccionado.accept(visitor);
    produc.getSelectionModel().clearSelection(); 

    mostrarAlerta("Resultado del cálculo", visitor.getResultado());
}

}