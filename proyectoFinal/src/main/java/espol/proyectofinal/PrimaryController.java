package espol.proyectofinal;

import estructuras.ArbolAVL;
import estructuras.LinkedList;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    LinkedList<String[]> listaRespuestas=ArbolAVL.leerInfo("respuestas.txt");   
    ArbolAVL raiz2=new ArbolAVL(listaPreguntas.getFirst());       
    //ArbolAVL direccion=raiz2;
    ArbolAVL arbRaiz=ArbolAVL.creaArbol(listaPreguntas, listaRespuestas);
    ArbolAVL arbTmp=ArbolAVL.creaArbolXcant(listaPreguntas, listaRespuestas, 2);
    
    ArbolAVL direccion=arbRaiz;
    //ArbolAVL direccion=arbTmp;
    int nPreg=listaPreguntas.getSize()-1;

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
       /*
        System.out.println(listaPreguntas.get(0));
        System.out.println(listaPreguntas.get(1));
        System.out.println(listaPreguntas.get(2));
        System.out.println(arbRaiz.getData());
        System.out.println(arbRaiz.getLeft().getData());
        System.out.println(arbRaiz.getLeft().getLeft().getData());
        System.out.println(arbRaiz.getLeft().getLeft().getLeft().getData());
        System.out.println("Otro lado");
        System.out.println(arbRaiz.getLeft().getData());
        System.out.println(arbRaiz.getLeft().getRight().getData());
        System.out.println(arbRaiz.getLeft().getRight().getLeft().getData());
        System.out.println(arbRaiz.getRight().getLeft().getRight().getData());
        System.out.println(arbRaiz.getRight().getRight().getRight().getData());
        System.out.println("Direccion: ");
        System.out.println(direccion.getLeft().getLeft().getLeft().getData());
        System.out.println(direccion.getLeft().getRight().getLeft().getData());
        System.out.println(direccion.getRight().getLeft().getRight().getData());
        System.out.println(direccion.getRight().getRight().getRight().getData());*/
        //ArbolAVL arbRaiz=ArbolAVL.creaArbol(listaPreguntas, listaRespuestas);
        /*System.out.println("PRINCIPAL..");
        System.out.println(arbRaiz.getData());
        System.out.println(arbRaiz.getLeft().getData());
        System.out.println(arbRaiz.getRight().getData());
        System.out.println(arbRaiz.getLeft().getLeft().getData());
        System.out.println(arbRaiz.getRight().getRight().getData());*/
        
        
        //System.out.println("ARBOL NUEVO PRUEBA, DATA:"+arbRaiz.getData());
        /*ArbolAVL arbRaiz=new ArbolAVL("Inicio");
        arbRaiz.aggPreguntas("metodo1");
        arbRaiz.aggPreguntas("metodo2");
        arbRaiz.aggPreguntas("metodo3");
        System.out.println("Raiz: "+ arbRaiz.getData());
        System.out.println("Izq"+ arbRaiz.getLeft().getData());
        System.out.println("Der"+ arbRaiz.getRight().getData());
        System.out.println("Izq, Izq"+ arbRaiz.getLeft().getLeft().getData());
        System.out.println("Der, Der"+ arbRaiz.getRight().getRight().getData());
          */                      
        preguntaTexto.setFont(new Font(28));
        preguntaTexto.setText(direccion.getData().toString());                
        ArbolAVL nodo1=new ArbolAVL(listaPreguntas.get(0));        
        raiz2.addRec("Si", nodo1);                  
        ArbolAVL nodo3=new ArbolAVL(listaPreguntas.get(1));       
        nodo1.addRec("Si", nodo3);        
        ArbolAVL nodo5 = new ArbolAVL("Oso");
        nodo3.addRec("Si", nodo5);
        System.out.println(nPreg);
        sibt.setOnAction(                
                e -> {
                    if(direccion.getLeft()!=null || direccion.getRight()!=null){
                        direccion=direccion.validarRec("Si", direccion);
                        nPreg-=1;                        
                        System.out.println("Con fe, con fe: "+direccion.getLeft().getData());
                        if(direccion.getLeft() !=null || direccion.getRight()!=null){
                            System.out.println("Inicia: "+direccion.getData());

                            preguntaTexto.setText((String)direccion.getData());
                            

                            System.out.println("Term: "+direccion.getData());
                            //System.out.println(direccion.getLeft().getData());
                            //System.out.println(direccion.getRight().getData());
                            System.out.println(arbRaiz.getLeft().getLeft().getLeft().getData());
                        }else{
                            if(direccion.esHoja()){
                                preguntaTexto.setText("El animal que estas pensando es un "+ direccion.getData()+"?");
                                direccion=direccion.validarRec("Si", direccion);
                                nPreg-=1;
                            }else{
                                System.out.println("Parece que puedo estar necesitando m[as informaci??n");
                                preguntaTexto.setText("Parece que puedo estar necesitando m[as informaci??n");
                            }
                            
                        }
                    }else{
                        System.out.println("TOY AQUIIIIIIIIIII");
                        preguntaTexto.setText("GENIAL!! Verdad que soy increible?");
                    }
                    
                    
                    
                });
        nobt.setOnAction(                
                e -> {
                    if(direccion.getLeft()!=null || direccion.getRight()!=null){
                      direccion=direccion.validarRec("no", direccion); 
                      nPreg-=1;
                    if(direccion.getLeft() !=null || direccion.getRight()!=null){
                        System.out.println("Inicia: "+direccion.getData());
                        
                        preguntaTexto.setText((String)direccion.getData());
                       
                    
                        System.out.println("Term: "+direccion.getData());
                        System.out.println("Si se ejecuta el no");
                        System.out.println(arbRaiz.getLeft().getLeft().getLeft().getData());
                        
                       
                    }else{
                        preguntaTexto.setText("El animal que estas pensando es un "+ direccion.getData()+"?");
                        direccion=direccion.validarRec("no", direccion);
                        nPreg-=1;
                    }  
                    }else{
                        preguntaTexto.setText("Debe ser de otro universo!! Me esforzare m??s la proxima vez");
                    }
                    
                    
                    
                
                    
                    
                });
        //preguntas.getChildren().add(preguntaTexto);
        ObservableList<Integer> tipos = FXCollections.observableArrayList(2,5,10,15,20);
        numpreguntas.setItems(tipos);
        System.out.println("----------");
    } 
}
