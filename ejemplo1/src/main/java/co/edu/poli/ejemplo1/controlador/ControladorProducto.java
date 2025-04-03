package co.edu.poli.ejemplo1.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import co.edu.poli.ejemplo1.servicios.ConsultaEsp;
import co.edu.poli.ejemplo1.servicios.DAOimplementProducto;
import co.edu.poli.ejemplo1.vista.App;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.List;

import co.edu.poli.ejemplo1.modelo.Departamento;
import co.edu.poli.ejemplo1.modelo.Director;
import co.edu.poli.ejemplo1.modelo.Empleado;
import co.edu.poli.ejemplo1.modelo.Producto;
import co.edu.poli.ejemplo1.modelo.ProductoAlimenticioBuilder;
import co.edu.poli.ejemplo1.modelo.ProductoElectricoBuilder;

public class ControladorProducto {

    @FXML
    private Button btt_CP, btt_DP, btt_RP, btt_UP, bttAllP, abrirCliente;

    @FXML
    private RadioButton selAlim, selElec;

    @FXML
    private ToggleGroup tipoProducto;

    @FXML
    private TextField txtId_CP, txtNmbr_CP, txtCal, txtVolt;

    private ConsultaEsp<Producto, String> consulta;
    private Director director;

    public ControladorProducto() {
        this.consulta = new DAOimplementProducto();
        this.director = new Director();
    }

    @FXML
    public void initialize() {
        txtCal.setDisable(true);
        txtVolt.setDisable(true);

        // Agrupamos los RadioButton en un ToggleGroup para que solo uno esté activo a la vez
        ToggleGroup toggleGroup = new ToggleGroup();
        selAlim.setToggleGroup(toggleGroup);
        selElec.setToggleGroup(toggleGroup);

        // Configuramos la acción para cambiar los campos
        selAlim.setOnAction(event -> toggleCampos(true));
        selElec.setOnAction(event -> toggleCampos(false));
    }

    private void toggleCampos(boolean esAlimenticio) {
        txtCal.setDisable(!selAlim.isSelected());
        txtVolt.setDisable(!selElec.isSelected());
    }

    @FXML
    public void create() {
        String idProducto = txtId_CP.getText();
        String descripcion = txtNmbr_CP.getText();

        Producto producto = null;

        if (selAlim.isSelected()) {
            String aporteCalorico = txtCal.getText();
            
            ProductoAlimenticioBuilder builder = new ProductoAlimenticioBuilder();
            builder.setIdProducto(idProducto);
            builder.setTipo("Alimenticio");
            builder.setDescripcion(descripcion);
            builder.setAporteCalorico(aporteCalorico);
            producto = builder.getProduct();
            
        } else if (selElec.isSelected()) {
            String voltajeEntrada = txtVolt.getText();
            
            ProductoElectricoBuilder builder = new ProductoElectricoBuilder();
            builder.setIdProducto(idProducto);
            builder.setTipo("Eléctrico");
            builder.setDescripcion(descripcion);
            builder.setVoltajeEntrada(voltajeEntrada);
            producto = builder.getProduct();
            
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
        try {
            App.cambiarVista("FormularioCliente");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir el formulario de Cliente.");
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