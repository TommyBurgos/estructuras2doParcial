/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

/**
 *
 * @author tommy_Burgos
 */
public class ArbolBinario <E extends Comparable<E>>  {
    //---------------- nested Node class ----------------
    private static class Node<E> {
        private E element;// reference to the element stored at this node
        private Node<E> left;
        private Node<E> right;
        
        public E getElement( ) { return element; }
        public Node<E> getLeft( ) { return left; }
        public Node<E> getRigh( ) { return right; }
        public void setLeft(Node<E> n) { left = n; }
        public void setRight(Node<E> n) { right = n; }
        
        public Node( ) { }
        public Node( E rootData) { element = rootData;}
        
        public boolean esHoja(){
            return this.getRigh()==null && this.getLeft()==null;
        }
        @Override
        public String toString(){
            return element.toString();
        }
        
       
    } //----------- end of nested Node class ---------
    
    // instance variables of BinaryTree
    private Node<E> root = null;// root node of the tree (or null if empty)
        
    public ArbolBinario( ) { }// constructs an initially empty tree
    
    public ArbolBinario(E rootData) {
        root = new Node(rootData);
    }
    
    
    public String preOrden(){
        return preOrden(root).replaceAll(" +", " ").substring(1);  
    }
    private String preOrden(Node<E> p){
        if (p == null) return " ";
        return " " + p.toString() + " " + preOrden(p.left) +" "+ preOrden(p.right);
    }
    
    private boolean isEmpty(){
        return root==null;
    }
    public String inOrden(){
        if (root == null) return "";
        return inOrden(root).replaceAll(" +", " ").substring(1);
    }
    private String inOrden(Node<E> p){
        if(p == null) return "";
        return " " + inOrden(p.left) +" "+ p.toString() + " " +  inOrden(p.right);
    }
    
    
    public String postOrden(){
        if (root == null) return "";
        return postOrden(root).replaceAll(" +", " ").substring(1);  
    }
    private String postOrden(Node<E> p){
        if(p == null) return "";
        return " " + postOrden(p.left) +" "+ postOrden(p.right)+ " " +p.toString() ;
    }
    
    
    public boolean contains(E element){
        if (element == null )
            return false;
        return contains(root, element);
    }
    private boolean contains(Node<E> p, E element){
        if (p == null)
            return false;
        if(element.compareTo(p.element) == 0){
            return true;
        }
        if(element.compareTo(p.element) > 0)
            return contains(p.right, element);
        return contains(p.left, element);
    }
    
    
    public boolean add(E element){
        if (element == null)
            return false;
        root = add(root, element);
        return true;
    }
    private Node<E> add(Node<E> p, E element){
        if(p == null)
             return new Node(element);
        if (element.compareTo(p.element)== 0)
             return p;
        if (element.compareTo(p.element) > 0)
             p.right= add(p.right, element);
        else
             p.left= add(p.left, element);
        return p;
    }

    public Node<E> getRoot() {
        return root;
    }
    
    
    public int altura(Node arbol){                
        if(arbol==null){
            return 0;
        }
        if(arbol!=null) 
            return 1 + Math.max(altura(arbol.getLeft()), altura(arbol.getRigh())) ;       
        return 0;
    }
    //Contar la cantidad de nodos que existen el arbol
    public int size(Node arb){
        //Caso Base
        if(arb==null){//Si el arbol se encuentra vacio, retornara que tiene 0
            return 0;
        }
        //Recursivo
        if(arb!=null){
            /*Se realizará el conteo por cada lado de los nodos
            de forma recursiva, para así repetir el proceso hasta el final, para luego sumar el total de cada lado*/
            int contIzq= size(arb.getLeft());
            int contDer= size(arb.getRigh());
            int total=contIzq+contDer;
            return total;
        }
        return 0;
    }
  //Para contar cuantas hojas existen en el arbol
    public int hojas(Node arb){
        int var=0;
        //Caso Base
        //Si se define que el nodo ingresado es hoja, retoran 1
        if(arb.esHoja()){
            return 1;
        }else{//Caso Recursivo         
            if(arb.getLeft()!=null){
                var +=hojas(arb.getLeft());
            }
            if(arb.getRigh()!=null){
                var+=hojas(arb.getRigh());
            }
        }
        return var;
    }
    //Cuenta la cantidad de nodos alojados en lado izquierdo del arbol
    public int izquierdos(Node arb){
        //Caso Base
        if(arb == null){
            return 0;
        }else{//Caso Recursivo
            izquierdos(arb.getLeft());
            if(arb != root){
                System.out.println(arb.element+"-");
            }
        }
        return 0;
    }
        
    
    //TAREA #10
    public boolean esEspejo (ArbolBinario<E> arbol2){
        ArbolBinario<E> ayuda1=null;
        ArbolBinario<E> ayuda2=null;
        if(arbol2==null)return false;
        if(this.root!= arbol2.root)return false;
        boolean bd1=false;
        boolean bd2=false;
        if(arbol2!=null){
            if(arbol2.root.getLeft()==this.root.right){
                ayuda1.root=arbol2.root.getLeft();                
                bd1=true;
                ayuda1.esEspejo(arbol2);                
            }
            if(arbol2.root.getRigh()==this.root.left){
                ayuda2.root=arbol2.root.getLeft();
                bd2=true;
                ayuda2.esEspejo(arbol2);
            }
        }
        return(bd1 && bd2);        
    }
    /*
    public boolean esEspejo (ABB<E> arbol2){
        
        Node<E> ext=root;
        Node<E> nuevo=arbol2.getRoot();
        if(arbol2==null) return false;
         if(arbol2!=null){            
            if(arbol2.root.left.getElement()==ext.right.getElement()){            
                ext=ext.right;
                nuevo=arbol2.getRoot().left;
            }if(nuevo.right.getElement()==ext.left.getElement()){            
                ext=ext.left;
                nuevo=arbol2.getRoot().right;            
        }arbol2.esEspejo(arbol2);
         }      
        return false;        
    }
    */
      public Node<E> espejo (Node<E> p){        
        ArbolBinario<E> ext =null;        
        ext.root=p;
        Node<E> ingDe=p.right;
        Node<E> ingIzq=p.left;
        if(p==null){
            return ext.root;
        }
        if(p!=null){
            ext.root.left=ingDe;          
            ext.root.right=ingIzq;
            
            ext.espejo(ext.root.left);
            ext.espejo(ext.root.right);
        }        
        return ext.root;
        
    }
       
}
