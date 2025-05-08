module co.edu.poli.ejemplo1 {
	requires java.base;
	requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens co.edu.poli.ejemplo1.vista to javafx.fxml;
    opens co.edu.poli.ejemplo1.controlador to javafx.fxml;
    exports co.edu.poli.ejemplo1.vista;
    exports co.edu.poli.ejemplo1.controlador;
}