package co.edu.poli.ejemplo1.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import co.edu.poli.ejemplo1.servicios.ConsultaEsp;
import co.edu.poli.ejemplo1.servicios.DAOimplementProducto;
import co.edu.poli.ejemplo1.vista.App;

import java.io.IOException;

import co.edu.poli.ejemplo1.modelo.Director;
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

}