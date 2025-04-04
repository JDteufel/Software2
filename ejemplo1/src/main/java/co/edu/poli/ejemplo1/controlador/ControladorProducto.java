package co.edu.poli.ejemplo1.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import co.edu.poli.ejemplo1.servicios.ConsultaEsp;
import co.edu.poli.ejemplo1.servicios.DAOimplementProducto;
import co.edu.poli.ejemplo1.vista.App;
import co.edu.poli.ejemplo1.modelo.Producto;
import co.edu.poli.ejemplo1.modelo.ProductoFactory;
import co.edu.poli.ejemplo1.modelo.Empleado;
import co.edu.poli.ejemplo1.modelo.AlimenticioFactory;
import co.edu.poli.ejemplo1.modelo.Departamento;
import co.edu.poli.ejemplo1.modelo.ElectricoFactory;

import java.util.List;

public class ControladorProducto {

    @FXML
    private Button btt_CP, btt_DP, btt_RP, btt_UP, bttAllP, bttInicio, bttGetId, bttcom;

    @FXML
    private RadioButton selAlim, selElec;

    @FXML
    private ToggleGroup tipoProducto;

    @FXML
    private TextField txtId_CP, txtNmbr_CP, txtPrecio, txtCal, txtVolt;

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

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void toggleCampos(boolean esAlimenticio) {
        txtCal.setDisable(!esAlimenticio);
        txtVolt.setDisable(esAlimenticio);
    }

    @FXML
    public void create(ActionEvent event) {
        String idProducto = txtId_CP.getText();
        String descripcion = txtNmbr_CP.getText();
        double precio;

        try {
            precio = Double.parseDouble(txtPrecio.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El precio debe ser un número válido.");
            return;
        }

        ProductoFactory factory = null;

        if (selAlim.isSelected()) {
            factory = new AlimenticioFactory();
        } else if (selElec.isSelected()) {
            factory = new ElectricoFactory();
        } else {
            mostrarAlerta("Error", "Debes seleccionar un tipo de producto.");
            return;
        }

        Producto producto = factory.crearProducto(idProducto, descripcion, precio,
                selAlim.isSelected() ? txtCal.getText() : txtVolt.getText());
        consulta.create(producto);
        mostrarAlerta("Éxito", "Producto creado correctamente:\n" + producto);
    }

    @FXML
    void bttGetId(ActionEvent event) {
        
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
    void bttAllP(ActionEvent event) {

    }

    @FXML
    void bttInicio(ActionEvent event) {
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
    void btt_DP(ActionEvent event) {

    }

    @FXML
    public void read(ActionEvent event) {
        String idProducto = txtId_CP.getText();

        if (idProducto == null || idProducto.isEmpty()) {
            mostrarAlerta("Error", "Debes ingresar un ID de producto.");
            return;
        }

        Producto producto = consulta.read(idProducto);

        if (producto == null) {
            mostrarAlerta("Error", "No se encontró un producto con el ID: " + idProducto);
        } else {
            mostrarAlerta("Producto encontrado", producto.toString());
        }
    }

    @FXML
    void btt_UP(ActionEvent event) {

    }

    @FXML
    void bttcom(ActionEvent event) {
        Departamento dptoVentas = new Departamento("Ventas");
        Departamento dptoTI = new Departamento("Tecnología");

        Empleado e1 = new Empleado("E001", "Juan Pérez");
        Empleado e2 = new Empleado("E002", "María López");
        Empleado e3 = new Empleado("E003", "Carlos Gómez");

        dptoVentas.agregarComponente(e1);
        dptoVentas.agregarComponente(e2);
        dptoTI.agregarComponente(e2);
        dptoTI.agregarComponente(e3);

        StringBuilder mensaje = new StringBuilder("📌 Empleados por Departamento:\n");

        for (Departamento depto : List.of(dptoVentas, dptoTI)) {
            mensaje.append("\n📂 ").append(depto.getNombre()).append(":\n");
            for (Empleado emp : depto.obtenerEmpleados()) {
                mensaje.append("  - ").append(emp.getNombre()).append("\n");
            }
        }

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Departamentos y Empleados");
        alerta.setHeaderText("Información de Empleados por Departamento");
        alerta.setContentText(mensaje.toString());
        alerta.showAndWait();

    }

}