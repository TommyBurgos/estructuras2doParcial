/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectofinal;

import java.io.File;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    
    
    
   
    //(scanner.nextLine() + "\n");
            @FXML
     void getTextRes(MouseEvent event)  throws FileNotFoundException {
                
                 FileChooser fileChooser = new FileChooser();
                File file = fileChooser.showOpenDialog(new Stage());
                   try{
                       Scanner scanner = new Scanner(file);
                       FileWriter writer= new FileWriter("Respuestas2.txt");
                       while(scanner.hasNextLine()){
                            writer.write(scanner.nextLine() + "\n");
                            
                       
                   }
                       System.out.println("se creo el archivo respuestas2");
                       Alert a = new Alert(Alert.AlertType.CONFIRMATION,"El archivo de respuestas se subió correctamente");
                       a.show();
                       writer.close();
                   }catch(IOException e){
                       System.out.println("un error con el archivo");
                       e.printStackTrace();
                   }
    
    }
     
     @FXML
     void getTextPreg(MouseEvent event)  throws FileNotFoundException {
                
                 FileChooser fileChooser = new FileChooser();
                File file = fileChooser.showOpenDialog(new Stage());
                   try{
                       Scanner scanner = new Scanner(file);
                       FileWriter writer= new FileWriter("Preguntas2.txt");
                       while(scanner.hasNextLine()){
                            writer.write(scanner.nextLine() + "\n");
                            
                       
                   }
                       System.out.println("se creo el archivo preguntas2");
                       Alert a = new Alert(Alert.AlertType.CONFIRMATION,"El archivo de preguntas se subió correctamente");
                       a.show();
                       writer.close();
                   }catch(IOException e){
                       System.out.println("un error con el archivo");
                       e.printStackTrace();
                   }
    
    }



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
