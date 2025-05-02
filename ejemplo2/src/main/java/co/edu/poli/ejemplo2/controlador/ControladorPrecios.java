package co.edu.poli.ejemplo2.controlador;


import co.edu.poli.ejemplo2.modelo.CatalogoProductos;
import co.edu.poli.ejemplo2.modelo.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import co.edu.poli.ejemplo2.modelo.ProductoSimple;

public class ControladorPrecios {

    @FXML
    private Button Cambiar;

    @FXML
    private TextField ID;

    @FXML
    private TextField Precio;

    @FXML
    private TextArea Productos;

    @FXML
    private Button Volver;

    @FXML
    private Button Lista;
    
{
    CatalogoProductos.agregarProducto(new ProductoSimple("001", "Mouse"));
    CatalogoProductos.agregarProducto(new ProductoSimple("002", "Teclado"));
    CatalogoProductos.agregarProducto(new ProductoSimple("003", "Monitor"));
    CatalogoProductos.agregarProducto(new ProductoSimple("004", "Laptop"));
    CatalogoProductos.agregarProducto(new ProductoSimple("005", "Impresora"));
}


   @FXML
void cambiar(ActionEvent event) {
    String id = ID.getText();
    String precioStr = Precio.getText();
    Producto producto = CatalogoProductos.getProducto(id);

    if (producto == null) {
        Productos.setText("Producto no encontrado.\n");
        return;
    }

    try {
        double nuevoPrecio = Double.parseDouble(precioStr);
        producto.setPrecio(nuevoPrecio);
        Productos.setText("Precio actualizado.\n");
    } catch (NumberFormatException e) {
        Productos.setText("Precio inválido.\n");
    }

    mostrarProductos();
}

@FXML
void volver(ActionEvent event) {
    String id = ID.getText();
    Producto producto = CatalogoProductos.getProducto(id);

    if (producto == null) {
        Productos.setText("Producto no encontrado.\n");
        return;
    }

    if (producto.deshacerCambioPrecio()) {
        Productos.setText("Cambio deshecho.\n");
    } else {
        Productos.setText("No hay cambios para deshacer.\n");
    }

    mostrarProductos();
}

@FXML
void Lista(ActionEvent event) {

    mostrarProductos();
    ID.clear();
    Precio.clear();
}

private void mostrarProductos() {
    StringBuilder sb = new StringBuilder();
    for (Producto p : CatalogoProductos.getTodos().values()) {
        sb.append("ID: ").append(p.getIdProducto())
          .append(", Descripción: ").append(p.getDescripcion())
          .append(", Precio: ").append(p.getPrecio())
          .append("\n");
    }
    Productos.setText(sb.toString());
}

}
