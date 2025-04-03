package co.edu.poli.ejemplo1.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.util.List;
import co.edu.poli.ejemplo1.servicios.DAO;
import co.edu.poli.ejemplo1.vista.App;
import co.edu.poli.ejemplo1.modelo.Cliente;

public class ControladorCliente {
	private DAO<Cliente, String> DAO;

    @FXML
    private Button bttAll, btt_C, btt_D, btt_R, btt_U, abrirProducto, abrirProveedor;

    @FXML
    private TextField txtAll, txtId_C, txtId_D, txtId_R, txtId_U, txtNmbr_C, txtNmbr_U;

    public ControladorCliente() {}

    public void setDAO(DAO<Cliente, String> DAO) {
        this.DAO = DAO;
    }


    @FXML
    private void create(ActionEvent event) {
        String id = txtId_C.getText();
        String nombre = txtNmbr_C.getText();
        if (!id.isEmpty() && !nombre.isEmpty()) {
            Cliente cliente = new Cliente(id, nombre);
            DAO.create(cliente);
            limpiarCampos();
        }
    }

    @FXML
    private void read(ActionEvent event) {
        String id = txtId_R.getText();
        Cliente cliente = DAO.read(id);
        if (cliente != null) {
            txtAll.setText(cliente.toString());
        } else {
            txtAll.setText("Cliente no encontrado.");
        }
    }

    @FXML
    private void update(ActionEvent event) {
        String id = txtId_U.getText();
        String nombre = txtNmbr_U.getText();
        if (!id.isEmpty() && !nombre.isEmpty()) {
            Cliente cliente = new Cliente(id, nombre);
            DAO.update(cliente);
            limpiarCampos();
        }
    }

    @FXML
    private void delete(ActionEvent event) {
        String id = txtId_D.getText();
        if (!id.isEmpty()) {
            DAO.delete(id);
            limpiarCampos();
        }
    }

    @FXML
    private void readAll(ActionEvent event) {
        List<Cliente> clientes = DAO.readAll();
        txtAll.setText(clientes.toString());
    }
    
    private void limpiarCampos() {
        txtId_C.clear();
        txtNmbr_C.clear();
        txtId_R.clear();
        txtId_U.clear();
        txtNmbr_U.clear();
        txtId_D.clear();
    }
    
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    
    @FXML
    private void abrirProducto() {
        System.out.println("Intentando abrir la vista de productos...");
        try {
            App.cambiarVista("FormularioProducto");
            System.out.println("Vista de productos abierta correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir el formulario de Producto.");
        }
    }
    
    @FXML
    void abrirProveedor(ActionEvent event) {
        System.out.println("Intentando abrir la vista de proveedor...");
        try {
            App.cambiarVista("FormularioProveedor");
            System.out.println("Vista de proveedor abierta correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir el formulario de Producto.");
        }
    }
}