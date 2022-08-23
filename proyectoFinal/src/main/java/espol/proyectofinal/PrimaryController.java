package espol.proyectofinal;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PrimaryController {
    @FXML
    private Button nobt;

    @FXML
    private ComboBox<?> numpreguntas;

    @FXML
    private VBox preguntas;

    @FXML
    private Text preguntasTxt;

    @FXML
    private Text preguntasTxt1;

    @FXML
    private HBox respuesta;

    @FXML
    private Button sibt;

    @FXML
    void regresar(MouseEvent event) throws IOException {
        App.setRoot("inicio");

    }
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
