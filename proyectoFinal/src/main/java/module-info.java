module espol.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;

    opens espol.proyectofinal to javafx.fxml;
    exports espol.proyectofinal;
}
