package co.edu.poli.ejemplo1.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import co.edu.poli.ejemplo1.servicios.ConsultaEsp;
import co.edu.poli.ejemplo1.servicios.DAOimplementProducto;
import co.edu.poli.ejemplo1.vista.App;
import co.edu.poli.ejemplo1.modelo.Producto;
import co.edu.poli.ejemplo1.modelo.ProductoAlimenticio;
import co.edu.poli.ejemplo1.modelo.ProductoElectrico;
import co.edu.poli.ejemplo1.modelo.Empleado;
import co.edu.poli.ejemplo1.modelo.Departamento;
import java.util.List;

public class ControladorProducto {

    @FXML
    private Button btt_CP, btt_DP, btt_RP, btt_UP, bttAllP, abrirCliente, abrirPagos;

    @FXML
    private RadioButton selAlim, selElec;

    @FXML
    private ToggleGroup tipoProducto;

    @FXML
    private TextField txtId_CP, txtNmbr_CP, txtCal, txtVolt;

    private ConsultaEsp<Producto, String> consulta;

    public ControladorProducto() {
        this.consulta = new DAOimplementProducto();
    }

    @FXML
    public void initialize() {
        txtCal.setDisable(true);
        txtVolt.setDisable(true);

        selAlim.setOnAction(event -> toggleCampos(true));
        selElec.setOnAction(event -> toggleCampos(false));
    }

    private void toggleCampos(boolean esAlimenticio) {
        txtCal.setDisable(!esAlimenticio);
        txtVolt.setDisable(esAlimenticio);
    }

    @FXML
    public void create() {
        String idProducto = txtId_CP.getText();
        String descripcion = txtNmbr_CP.getText();

        Producto producto = null;

        if (selAlim.isSelected()) {
            String calorias = txtCal.getText();
            producto = new ProductoAlimenticio(idProducto, "Alimenticio", descripcion, calorias);
        } else if (selElec.isSelected()) {
            String voltaje = txtVolt.getText();
            producto = new ProductoElectrico(idProducto, "Eléctrico", descripcion, voltaje);
        } else {
            mostrarAlerta("Error", "Debes seleccionar un tipo de producto.");
            return;
        }
        consulta.create(producto);
        mostrarAlerta("Éxito", "Producto creado correctamente:\n" + producto);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    
    @FXML
    private void abrirCliente() {
        System.out.println("Intentando abrir la vista de Cliente...");
        try {
            App.cambiarVista("FormularioCliente");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir el formulario de Cliente.");
        }
    }

    @FXML
    private void abrirPagos() {
        try {
            App.cambiarVista("MetodosdePago");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir el formulario de Pagos.");
        }
    }

    @FXML
    void click(ActionEvent event) {
        // Crear departamentos con empleados
        Departamento dptoVentas = new Departamento("Ventas");
        Departamento dptoTI = new Departamento("Tecnología");

        Empleado e1 = new Empleado("E001", "Juan Pérez");
        Empleado e2 = new Empleado("E002", "María López");
        Empleado e3 = new Empleado("E003", "Carlos Gómez");

        dptoVentas.agregarComponente(e1);
        dptoVentas.agregarComponente(e2);
        dptoTI.agregarComponente(e2);
        dptoTI.agregarComponente(e3);

        // Construir el mensaje con los empleados por departamento
        StringBuilder mensaje = new StringBuilder("📌 Empleados por Departamento:\n");

        for (Departamento depto : List.of(dptoVentas, dptoTI)) {
            mensaje.append("\n📂 ").append(depto.getNombre()).append(":\n");
            for (Empleado emp : depto.obtenerEmpleados()) {
                mensaje.append("  - ").append(emp.getNombre()).append("\n");
            }
        }

        // Mostrar mensaje en una ventana emergente
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Departamentos y Empleados");
        alerta.setHeaderText("Información de Empleados por Departamento");
        alerta.setContentText(mensaje.toString());
        alerta.showAndWait();
    }
    @FXML
    void abrirEnvio(ActionEvent event) {
        try {
            App.cambiarVista("FormularioEnvio");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir el formulario de Envio.");
        }
    }
}