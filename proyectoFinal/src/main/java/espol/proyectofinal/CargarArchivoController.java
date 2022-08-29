/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectofinal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author User
 */
public class CargarArchivoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button preg;

    @FXML
    private Text preguntasTxt;

    @FXML
    private Text preguntasTxt1;

    @FXML
    private Button resp;

  

    @FXML
    void ingresarJuego(MouseEvent event) throws IOException {
        App.setRoot("JuegoPersonalizado");

    }
    
    @FXML
    void regresar(MouseEvent event) throws IOException {
        App.setRoot("inicio");

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
