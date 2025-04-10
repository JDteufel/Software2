package co.edu.poli.ejemplo2.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        cambiarVista("formularioInicio");
        primaryStage.setTitle("Gestión de Clientes y Productos");
        primaryStage.show();
    }

    public static void cambiarVista(String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/co/edu/poli/ejemplo2/vista/" + fxml + ".fxml"));
            Parent root = fxmlLoader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            System.err.println("Error al cargar la vista: " + fxml + ".fxml. Verifica la ruta y el archivo.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}