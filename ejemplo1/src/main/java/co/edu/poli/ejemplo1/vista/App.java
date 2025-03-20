package co.edu.poli.ejemplo1.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Stage primaryStage;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        cambiarVista("FormularioCliente");
        primaryStage.setTitle("Gestión de Clientes y Productos");
        primaryStage.show();
    }

    public static void cambiarVista(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/co/edu/poli/ejemplo1/vista/" + fxml + ".fxml"));
        Parent root = fxmlLoader.load();
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public static void main(String[] args) {
        launch();
    }
}