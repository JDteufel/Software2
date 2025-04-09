module co.edu.poli.ejemplo1 {
	requires java.base;
	requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.poli.ejemplo2.vista to javafx.fxml;
    opens co.edu.poli.ejemplo2.controlador to javafx.fxml;
    exports co.edu.poli.ejemplo2.vista;
    exports co.edu.poli.ejemplo2.controlador;
}