package espol.proyectofinal;

import estructuras.ArbolAVL;
import estructuras.LinkedList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PrimaryController implements Initializable{
    @FXML
    private Button nobt;

    @FXML
    private ComboBox<Integer> numpreguntas;

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
    private Text preguntaTexto;
    
    LinkedList<String> listaPreguntas=ArbolAVL.leerInfoPreguntas("preguntas.txt");   
    LinkedList<String> listaRespuestas=ArbolAVL.leerInfo("respuestas.txt");   
    ArbolAVL raiz2=new ArbolAVL(listaPreguntas.getFirst());
    ArbolAVL direccion=raiz2;
    int nPreg=listaPreguntas.getSize();

    @FXML
    void regresar(MouseEvent event) throws IOException {
        App.setRoot("inicio");

    }
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // System.out.println(listaRespuestas.get(0).getClass());
        preguntaTexto.setFont(new Font(28));
        preguntaTexto.setText("LIST@?");                
        ArbolAVL nodo1=new ArbolAVL(listaPreguntas.get(0));        
        raiz2.addRec("Si", nodo1);                  
        ArbolAVL nodo3=new ArbolAVL(listaPreguntas.get(1));       
        nodo1.addRec("Si", nodo3);        
        ArbolAVL nodo5 = new ArbolAVL("Oso");
        nodo3.addRec("Si", nodo5);
        System.out.println(nPreg);
        sibt.setOnAction(                
                e -> {
                    if(direccion.getLeft() !=null || direccion.getRight()!=null){
                        System.out.println("Inicia: "+direccion.getData());
                        
                        preguntaTexto.setText((String)direccion.getData());
                        direccion=direccion.validarRec("Si", direccion);                                        
                    
                        System.out.println("Term: "+direccion.getData());
                    }else{
                        preguntaTexto.setText("El animal que estas pensando es un "+ direccion.getData()+"?");
                    }
                    
                    
                });
        
        //preguntas.getChildren().add(preguntaTexto);
        ObservableList<Integer> tipos = FXCollections.observableArrayList(5,10,15,20);
        numpreguntas.setItems(tipos);
        System.out.println("----------");
    } 
}
