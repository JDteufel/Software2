package co.edu.poli.ejemplo2.controlador;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

import co.edu.poli.ejemplo2.modelo.CatalogoProductos;
import co.edu.poli.ejemplo2.modelo.Producto;
import co.edu.poli.ejemplo2.modelo.Cliente;
import co.edu.poli.ejemplo2.modelo.Gestor;
import co.edu.poli.ejemplo2.modelo.MementoPrecio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class ControladorMementObserver {
    @FXML
    private Button bttCambio, bttCrear, bttVerHist, bttCliente, volver, bbtano;

    @FXML
    private TextField txtDescripcion, txtId, txtIdCambio, txtIdHist, txtPrecio, txtPrecioCambio, txtDescuento, txtCliente;

    @FXML
    private RadioButton rbtSuscripcion;

    private Gestor gestor = new Gestor();

    private Stack<Map<String, MementoPrecio>> mementos = new Stack<>();

    private void saveState() {
        Map<String, MementoPrecio> snapshot = new HashMap<>();
        CatalogoProductos.getTodos().forEach((id, producto) -> {
            snapshot.put(id, new MementoPrecio(producto.getPrecio()));
        });
        mementos.push(snapshot);
    }

    private void restoreState() {
        if (!mementos.isEmpty()) {
            Map<String, MementoPrecio> snapshot = mementos.pop();
            StringBuilder mensaje = new StringBuilder("Estado restaurado correctamente.\nCambios de precios:\n");

            snapshot.forEach((id, memento) -> {
                Producto producto = CatalogoProductos.getProducto(id);
                if (producto != null) {
                    double precioActual = producto.getPrecio();
                    double precioAnterior = memento.getPrecioGuardado();
                    producto.setPrecio(precioAnterior);
                    mensaje.append(" - Producto ID: ").append(id)
                           .append(", Precio actual: $").append(precioActual)
                           .append(" -> Precio restaurado: $").append(precioAnterior).append("\n");
                }
            });

            mostrarConfirmacion(mensaje.toString());
        } else {
            mostrarError("No hay estados previos para restaurar.");
        }
    }

    @FXML
    void bttCrear(ActionEvent event) {
        saveState(); // Save state before creating a new product
        try {
            String id = txtId.getText().trim();
            String descripcion = txtDescripcion.getText().trim();
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
            txtDescripcion.clear();
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

        List<Double> historial = MementoPrecio.getHistorialPrecios(id);
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
        saveState(); // Save state before changing a product's price
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
            producto.setPrecio(nuevoPrecio);
            mostrarConfirmacion("Precio actualizado correctamente.\nNuevo precio: $" + nuevoPrecio);

            txtIdCambio.clear();
            txtPrecioCambio.clear();
        } catch (NumberFormatException e) {
            mostrarError("El precio debe ser un número válido.");
        }
    }

    @FXML
    void txtDescuento(ActionEvent event) {
        String descuentoTexto = txtDescuento.getText().trim();

        if (descuentoTexto.isEmpty()) {
            mostrarError("Debes ingresar un valor de descuento.");
            return;
        }

        try {
            double descuento = Double.parseDouble(descuentoTexto);
            mostrarConfirmacion("Descuento aplicado: " + descuento + "%");
            txtDescuento.clear();
        } catch (NumberFormatException e) {
            mostrarError("El descuento debe ser un número válido.");
        }
    }

    @FXML
    void bttCliente(ActionEvent event) {
        String clienteNombre = txtCliente.getText().trim();

        if (clienteNombre.isEmpty()) {
            mostrarError("Debes ingresar el nombre del cliente.");
            return;
        }

        Cliente cliente = new Cliente(clienteNombre);
        cliente.setSuscripcion(rbtSuscripcion.isSelected());

        if (cliente.isSuscripcion()) {
            gestor.addCliente(cliente);
            mostrarConfirmacion("Cliente suscrito con éxito.");
        } else {
            mostrarConfirmacion("Cliente creado sin suscripción.");
        }

        txtCliente.clear();
    }

    @FXML
    void bttObserver(ActionEvent event) {
        String descuentoTexto = txtDescuento.getText().trim();

        if (descuentoTexto.isEmpty()) {
            mostrarError("Debes ingresar un valor de descuento.");
            return;
        }

        try {
            double descuento = Double.parseDouble(descuentoTexto);

            if (descuento < 0 || descuento > 100) {
                mostrarError("El descuento debe estar entre 0 y 100.");
                return;
            }

            CatalogoProductos.getTodos().values().forEach(producto -> {
                producto.aplicarDescuento(descuento);
            });

            List<String> notificaciones = gestor.notifyClientes("Se aplicó un descuento del " + descuento + "% a todos los producto.");
            StringBuilder mensaje = new StringBuilder("Descuento aplicado correctamente.\n");
            mensaje.append("Notificaciones enviadas:\n");
            for (String notificacion : notificaciones) {
                mensaje.append(" - ").append(notificacion).append("\n");
            }

            mostrarConfirmacion(mensaje.toString());
            txtDescuento.clear();
        } catch (NumberFormatException e) {
            mostrarError("El descuento debe ser un número válido.");
        }
    }

    @FXML
    void rbtSuscripcion(ActionEvent event) {
        
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

    @FXML
    void volver(ActionEvent event) {
        restoreState();
    }

    private int currentYear = 2025;

    @FXML
    void bttano(ActionEvent event) {
        String id = txtIdCambio.getText().trim();

        if (id.isEmpty()) {
            mostrarError("Debes ingresar el ID del producto.");
            return;
        }

        Producto producto = CatalogoProductos.getProducto(id);

        if (producto == null) {
            mostrarError("No se encontró un producto con ID: " + id);
            return;
        }

        // Ensure the original price is saved in the history
        List<Double> historial = MementoPrecio.getHistorialPrecios(id);
        if (historial.isEmpty()) {
            MementoPrecio.guardarEstado(producto, producto.getPrecio());
        }

        double precioOriginal = historial.get(0); // Retrieve the original price
        double nuevoPrecio = precioOriginal * Math.pow(1.03, currentYear - 2025 + 1); // Apply 3% increase per year

        MementoPrecio.guardarEstado(producto, producto.getPrecio()); // Save current state
        producto.setPrecio(nuevoPrecio);

        currentYear++; // Increment the year

        String mensaje = String.format(
            "Se avanzó un año al %d.\nNuevo precio del producto con ID: %s es $%.2f",
            currentYear, id, nuevoPrecio
        );
        mostrarConfirmacion(mensaje);
    }

}