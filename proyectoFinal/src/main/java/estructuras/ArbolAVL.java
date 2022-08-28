/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import estructuras.LinkedList.Node;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author tommy_Burgos
 */
public class ArbolAVL<E extends Comparable<E>>   {
    private E data;
    ArbolAVL left, right;

    public ArbolAVL() {
        this.data=null;
        this.left=this.right=null;
    }
        
    
    public ArbolAVL(E data) {
        this.data=data;
        this.left=this.right=null;
    }
    public void rotacionIzquierda(){
        ArbolAVL n1=new ArbolAVL(this.data);
        n1.left=this.left;
        this.data=(E) this.right.data;
        this.right=this.right.right;
        this.left=n1;
    }
    public void rotacionDerecha(){
        ArbolAVL n1=new ArbolAVL(this.data);
        n1.right=this.right;
        this.data=(E) this.left.data;
        this.left=this.left.left;
        this.right=n1;
    }
    public boolean add(E data){
        boolean insertado=false;
        if(data.compareTo(this.data)<0){
            if(this.left==null){
                this.left=new ArbolAVL(data);
                insertado= true;
            }
            
            else return this.left.add(data);
        }else if(data.compareTo(this.data)>0){
            if(this.right==null){
                this.right=new ArbolAVL(data);
                insertado= true;
            }else{
                insertado= this.right.add(data);
            }
        }else{
            return true;
        }
        if(insertado){
            this.balancear();
            return true;
    }return false;}
    public void balancear(){
        int fe=this.factorEquilibrio();
            if(fe==2){
                int feD=this.right.factorEquilibrio();
                if(feD==1){
                    this.rotacionDerecha();
                }else if(feD==-1){                    
                }
            }
            if(fe==2){
                int feI=this.left.factorEquilibrio();
                if(feI==1){
                    this.rotacionIzquierda();
                }else if(feI==-1){
                    
                }
        }
    }
    public int altura(){
        int a1,ad;
        if(left==null)a1=0;
        else a1=left.altura();
        
        if(right==null)ad=0;
        else ad=right.altura();
        
        if(a1>ad) return 1+a1;
        else return 1+ad;
    }
    public int factorEquilibrio(){
        int ai,ad;
        if(left==null)ai=0;
        else ai=left.altura();
        
        if(right==null)ad=0;
        else ad=right.altura();
        
        return ad-ai;
    }
    public ArbolAVL validarRec(String resp, ArbolAVL arb){
        if(arb.left!=null && (resp.equals("Si") || resp.equals("si"))){
            ArbolAVL.registrarNuevoRecorrido(resp);
            return arb.left;
            
        }else if(arb.right!=null && (resp.equals("No")|| resp.equals("no"))){
            ArbolAVL.registrarNuevoRecorrido(resp);
            return arb.right;
        }
        else{
            System.out.println("Lo siento, el animal que has escogido debe de ser de otro universo");
            System.out.println("No he podido adivinar que animal estas pensando");
            
        }
        
        
        return arb;
    }
    
    public boolean addRec(E data, ArbolAVL preg){        
        if(data.equals("Si")){
            if(this.left==null){
                this.left=preg;
                return true;
            }
            
            else return this.left.addRec(data,preg);
        }else if(data.equals("No")){
            if(this.right==null){
                this.right=preg;
                return true;
            }else{
                return this.right.addRec(data,preg);
            }
        }else{
            return true;
        }
    }
    
    public boolean addRec2(LinkedList listaData, ArbolAVL preg){
        /*LinkedList nueva=new LinkedList();
        for(int i=1;i<listaData.length;i++) {
            nueva.addLast(listaData[i]);
        }*/
        System.out.println("Esta es la lista :"+listaData.getSize()+listaData);
        System.out.println("Esto sigue> this.getData: "+this.getData());
        //System.out.println("Esto sigue> this.getLef.getData: "+this.getLeft().getData());
        //System.out.println("Esto sigue> this.getLef2.getData: "+this.getLeft().getLeft().getData());
        System.out.println("primer elemento: "+listaData.get(0));
        System.out.println("clase elemento: "+listaData.get(0).getClass());
        System.out.println("comp elemento: "+listaData.get(0).equals("si"));
            if (listaData.get(0).equals("Si")|| listaData.get(0).equals("si")) {
                if(this.left==null){
                    this.left=preg;
                    System.out.println("Entro al if: "+this.left);
                    return true;
                }

                else{
                    System.out.println("He ingresado al puto else");
                    listaData.removeFirst();
                    
                    return this.left.addRec2(listaData,preg);
                }
            } else if(listaData.equals("No")|| listaData.get(0).equals("no")){
                if(this.right==null){
                    this.right=preg;
                    return true;
                }else{
                    listaData.removeFirst();
                    return this.right.addRec2(listaData,preg);
                }
            }else{
                return true;
            }
        
    }
    
    public boolean addRec3(LinkedList listaData, ArbolAVL preg){           
        LinkedList.Node tmp = listaData.getHead();
        
        while(tmp.getNext()!=null) {   
            
            if(tmp.getDato().equals("Si")){
                if(this.left==null){
                    this.left=preg;
                    tmp=tmp.getNext();
                    return true;
                }

                else{
                    listaData.removeFirst();
                    return this.left.addRec3(listaData,preg);
                }
            }
            else if(tmp.equals("No")){
                if(this.right==null){
                    this.right=preg;
                    tmp=tmp.getNext();
                    return true;
                }else{
                    listaData.removeFirst();
                    return this.right.addRec3(listaData,preg);
                }
            }
            else{
                return true;
            }
            
         }return false;
    }
    /*public boolean addRec(LinkedList<String> preguntas, LinkedList<String> recorrido){
        
        for (int i = 0; i < recorrido.size(); i++) {
            
        }
    }*/

    public static LinkedList<String> leerInfoPreguntas(String nomfile){
        File f = new File(nomfile);
        if(f.exists())System.out.println("Existe");
        else{
           System.out.println("no Existe");
        }
        LinkedList info = new LinkedList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){            
            while (sc.hasNextLine())
            {
                String linea = sc.nextLine();    
                
                info.addLast(linea);                                
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage()+"aaaaa");
        }
        return info;
}
    public void aggPreguntas(String preg){    
        ArbolAVL izq=new ArbolAVL(preg);
        ArbolAVL der=new ArbolAVL(preg);
        if(this.left==null){            
            this.left=izq;                                                
        } else this.left.aggPreguntas(preg);
        if(this.right==null){            
            this.right=der;                                                
        } else this.right.aggPreguntas(preg);
        }
    
public static ArbolAVL creaArbol(LinkedList<String> preguntas, LinkedList<String[]> respuestas){
    ArbolAVL arbolTot=new ArbolAVL();
    if(preguntas.isEmpty()) return null;
    if(respuestas.isEmpty()) return null;        
    arbolTot.data=preguntas.get(0);
    for (int i = 1; i < preguntas.getSize(); i++) {
        arbolTot.aggPreguntas(preguntas.get(i));
        System.out.println("Estas son las preguntas " + preguntas.get(i));
        System.out.println(preguntas.getSize());
        
    }
    /*Stack pila=new Stack();
    for (int i = 0; i < respuestas.getSize()-1; i++) {
        for (int j = 1; j < respuestas.get(i).length; j++) {
            
        }
    }
    
   */
     System.out.println("HIJOS ARBOL TOMADO");
    System.out.println(arbolTot.data);
    System.out.println("Izq: "+arbolTot.left.data);
    System.out.println("Der: "+arbolTot.right.data);
    System.out.println("Izq 2: "+arbolTot.left.left.data);
    System.out.println("Der 2: "+arbolTot.right.right.data);
    LinkedList.Node nTemp= respuestas.getHead();
    for (int i = 0; i < respuestas.getSize(); i++) {
               
        System.out.println("Respuesta: "+respuestas.get(i)[0]);
        //ArbolAVL tmp=arbolTot;
        String resp=(String)respuestas.get(i)[0];
        ArbolAVL tmp=new ArbolAVL(resp);
        System.out.println(tmp.getData());
        LinkedList nueva=new LinkedList();
        for(int j=1;j<respuestas.get(i).length;j++) {
            nueva.addLast(respuestas.get(i)[j]);
            
        }
        arbolTot.addRec2(nueva, tmp);
        /*
        for (int j = 1; j < respuestas.get(i).length; j++) {
            System.out.println("HASTA AQUÍ BIEN");            
            
            System.out.println(resp);
            //arbolTot.addRec(resp, tmp);            
            /*tmp= tmp.validarRec((String)respuestas.get(i)[j], tmp);
            if(nTemp.getNext()==null){
                tmp.setData(resp);
            }nTemp=nTemp.getNext();
            //nTemp=nTemp.getNext();
        }*///arbolTot.addRec2(respuestas.get(i),new ArbolAVL((String)resp), nueva);
    }
    System.out.println("HIJOS ARBOL TOMADO 2.0");
    System.out.println("Izq: "+arbolTot.left.data);
    System.out.println("Der: "+arbolTot.right.data);
    System.out.println("Izq 2: "+arbolTot.left.left.data);
    System.out.println("Der 2: "+arbolTot.right.right.data);            
    //ArbolAVL tmp=arbolTot;
   
    return arbolTot;    
}

    public void setData(E data) {
        this.data = data;
    }

    public void setLeft(ArbolAVL left) {
        this.left = left;
    }

    public void setRight(ArbolAVL right) {
        this.right = right;
    }
public static LinkedList<String[]> leerInfo(String nomfile){
        File f = new File(nomfile);
        if(f.exists())System.out.println("Existe");
        else{
           System.out.println("no Existe");
        }
        LinkedList info = new LinkedList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){            
            while (sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] resp=linea.split(" ");
                
                info.addLast(resp);                                
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage()+"aaaaa");
        }
        return info;
}

public static LinkedList<String[]> leerInfo2(String nomfile){
        File f = new File(nomfile);
        if(f.exists())System.out.println("Existe");
        else{
           System.out.println("no Existe");
        }
        LinkedList info = new LinkedList<>();
        try(Scanner sc = new Scanner(new File(nomfile))){            
            while (sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] resp=linea.split(",");
                
                info.addLast(resp);                                
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage()+"aaaaa");
        }
        return info;
}

public static void registrarNuevoRecorrido(String detalle){
        try(FileWriter fw = new FileWriter("ayudaRecorrido.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)){
            out.print(detalle+",");
        } catch (Exception e) {
            System.out.println(e.getMessage());
    }
}
public static void registrarNuevoNodo(String pregunta,String respuesta){
        File tmp=new File("ayudaRecorrido.txt");
        LinkedList<String[]> datosRegistro=ArbolAVL.leerInfo2("ayudaRecorrido.txt");
        tmp.delete();
        try(FileWriter fw = new FileWriter("recorridoNuevo.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)){
            out.print(respuesta);
            for (String get : datosRegistro.get(0)) {
                out.print(" "+get);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
    }
}
    

    public E getData() {
        return data;
    }

    public ArbolAVL getLeft() {
        return left;
    }

    public ArbolAVL getRight() {
        return right;
    }
    public static void presentar1(){
        System.out.println("Listo!! Vamos a empezar");
        System.out.println("Te hare unas cuantas preguntas antes de decirte mi respuesta");
        System.out.println("Si deseas salir solo deberas escribir (SALIR) y volveras ");
        System.out.println("Deberas responder estas preguntas escribiendo Si o No (Escribe Si) para continuar");
            
    }
    public static void bienvenida(String nombre){
        System.out.println("*******************"+"BIENVENIDO "+nombre+"*******************");
        System.out.println("Soy Patronus y voy a intentar adivinar el animal que estas pensando");
        System.out.println("Piensa en un animal");
        System.out.println("Listo? (Si/No): ");
    }
    
    
    public static void main(String[] args) {
        
        //System.out.println(listaPreguntas.head.getNext());
        
        
        
        ArbolAVL raiz=new ArbolAVL(80);
        ArbolAVL raiz2=new ArbolAVL("Es un mamifero?");
        
        //Lado Izquierdo principal
        String p1="este animal es carnívoro?";
        ArbolAVL nodo1=new ArbolAVL(p1);
        raiz2.addRec("Si", nodo1);              
        //Tercer nivel Si
        String p3="se para sobre 4 patas?";
        ArbolAVL nodo3=new ArbolAVL(p3);
        nodo1.addRec("Si", nodo3);
        //Tercer nivel No
        ArbolAVL nodo4=new ArbolAVL(p3);
        nodo1.addRec("No", nodo4);
        
        //Nivel final    
        String an1="Oso";
        ArbolAVL nodo5=new ArbolAVL(an1);
        nodo3.addRec("Si", nodo5);
        
        String an5="León";
        ArbolAVL nodo12=new ArbolAVL(an5);
        nodo3.addRec("No",nodo12);
        
        String an2="Venado";
        ArbolAVL nodo7=new ArbolAVL(an2);
        nodo4.addRec("Si", nodo7);
        
        
        //Lado Derecho principal
        ArbolAVL nodo2=new ArbolAVL(p1);
        raiz2.addRec("No", nodo2);
        //Tercer nivel Si
        ArbolAVL nodo8=new ArbolAVL(p3);
        nodo2.addRec("Si", nodo8);        
        //Tercer nivel No
        ArbolAVL nodo9=new ArbolAVL(p3);
        nodo2.addRec("No", nodo9);
        //Nivel final 
        String an3="Lechuza";
        ArbolAVL nodo10=new ArbolAVL(an3);
        nodo8.addRec("No", nodo10);
        
        String an4="Paloma";
        ArbolAVL nodo11=new ArbolAVL(an4);
        nodo9.addRec("No", nodo11);
        
        raiz.add(100);
        raiz.add(60);
        
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe tu nombre: ");
        String nombre=sc.nextLine();
        ArbolAVL.bienvenida(nombre);//Bienvenida
        String continuar=sc.next();
        ArbolAVL direccion=raiz2;
        
        while(continuar.equals("Si") || continuar.equals("si") && !((continuar.equals("no")|| continuar.equals("No")))){
            ArbolAVL.presentar1();//Instrucciones            
            String resp=sc.next();
            while(!(resp.equals("Salir")|| resp.equals("salir")) && (direccion.left!=null || direccion.right!=null)){                
                while((!resp.equals("Si") && !resp.equals("si")) && !resp.equals("No")&&!resp.equals("no")){
                    System.out.println("Asegurese de estar escribiendo bien la orden"); 
                    System.out.println("Deberas responder estas preguntas escribiendo Si o No (Si) para continuar");
                    resp=sc.next();             
                    
        }
                
                System.out.println(direccion.data);
                resp=sc.next();
                direccion=direccion.validarRec(resp, direccion);
                
                               
            }System.out.println("El animal en el que estas pensando es un "+direccion.data + "?");
            resp=sc.next();
            if(resp.equals("Si") || resp.equals("si")){
                System.out.println("Genial!! gracias por jugar");
            }else if(resp.equals("no") || resp.equals("No")){
                System.out.println("Creo que estuve igual cerca");
                System.out.println("Me esforzare más la proxima vez");
            }
            break;                                                                                               
            
        }
        //System.out.println(raiz2.left.right.left.data);
        //System.out.println(raiz2.left.left.left.data);
        /*boolean f= raiz.add(110);
        System.out.println(raiz2.data);
        System.out.println("Si->"+raiz2.left.data);
        System.out.println("No->"+raiz2.right.data);
        System.out.println("Si->"+raiz2.left.left.data);
        System.out.println("Si->"+raiz2.left.left.left.data);
        
        
        System.out.println("-----------");
        System.out.println(raiz);
        raiz.rotacionIzquierda();
        System.out.println(raiz.data);
        System.out.println(f);
        */
    }
    
 
    
}
