package co.edu.poli.ejemplo2.controlador;

import java.util.List;

import co.edu.poli.ejemplo2.modelo.CatalogoProductos;
import co.edu.poli.ejemplo2.modelo.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControladorInicio {
    @FXML
    private Button bttCambio, bttCrear, bttVerHist;

    @FXML
    private TextField txtDesc, txtId, txtIdCambio, txtIdHist, txtPrecio, txtPrecioCambio;

    @FXML
void bttCrear(ActionEvent event) {
    try {
        String id = txtId.getText().trim();
        String descripcion = txtDesc.getText().trim();
        String precioTexto = txtPrecio.getText().trim();

        if (id.isEmpty() || descripcion.isEmpty() || precioTexto.isEmpty()) {
            mostrarError("Todos los campos deben estar llenos.");
            return;
        }

        double precio = Double.parseDouble(precioTexto);

        Producto producto = new Producto(id, descripcion);
        producto.setPrecio(precio);

        CatalogoProductos.agregarProducto(producto);

        mostrarConfirmacion("Producto creado con éxito:\n" + producto);

        txtId.clear();
        txtDesc.clear();
        txtPrecio.clear();

    } catch (NumberFormatException e) {
        mostrarError("El precio debe ser un número válido.");
    }
}

@FXML
void bttVerHist(ActionEvent event) {
    String id = txtIdHist.getText().trim();

    if (id.isEmpty()) {
        mostrarError("Debes ingresar un ID de producto.");
        return;
    }

    Producto producto = CatalogoProductos.getProducto(id);

    if (producto == null) {
        mostrarError("No se encontró un producto con ID: " + id);
        return;
    }

    List<Double> historial = producto.getHistorialPrecios();
    StringBuilder mensaje = new StringBuilder("Precios del producto " + id + ":\n");
    mensaje.append("Precio actual: $").append(producto.getPrecio()).append("\n");

    if (historial.isEmpty()) {
        mensaje.append("No hay precios anteriores guardados.");
    } else {
        mensaje.append("Historial de precios anteriores:\n");
        for (int i = 0; i < historial.size(); i++) {
            mensaje.append(" - Cambio ").append(i + 1).append(": $").append(historial.get(i)).append("\n");
        }
    }

    mostrarConfirmacion(mensaje.toString());
    txtIdHist.clear();
}

@FXML
void bttCambio(ActionEvent event) {
    String id = txtIdCambio.getText().trim();
    String nuevoPrecioTexto = txtPrecioCambio.getText().trim();

    if (id.isEmpty() || nuevoPrecioTexto.isEmpty()) {
        mostrarError("Debes ingresar el ID del producto y el nuevo precio.");
        return;
    }

    Producto producto = CatalogoProductos.getProducto(id);

    if (producto == null) {
        mostrarError("No se encontró un producto con ID: " + id);
        return;
    }

    try {
        double nuevoPrecio = Double.parseDouble(nuevoPrecioTexto);
        producto.setPrecio(nuevoPrecio);  // Guarda automáticamente el estado anterior
        mostrarConfirmacion("Precio actualizado correctamente.\nNuevo precio: $" + nuevoPrecio);

        txtIdCambio.clear();
        txtPrecioCambio.clear();
    } catch (NumberFormatException e) {
        mostrarError("El precio debe ser un número válido.");
    }
}

private void mostrarError(String mensaje) {
    Alert alerta = new Alert(Alert.AlertType.ERROR);
    alerta.setTitle("Error");
    alerta.setHeaderText(null);
    alerta.setContentText(mensaje);
    alerta.showAndWait();
}

private void mostrarConfirmacion(String mensaje) {
    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    alerta.setTitle("Confirmación");
    alerta.setHeaderText(null);
    alerta.setContentText(mensaje);
    alerta.showAndWait();
}

}