/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espol.practicaabb;

/**
 *
 * @author tommy_Burgos
 */
public class ArbolBinario<E extends Comparable<E>> {
    private E data;
    private ArbolBinario<E> left,right;
    
    public ArbolBinario(E data){
        this.data=data;
        left=right=null;
    }
    public boolean isEmpty(){
        if(data==null)return true;
        //if(left.data==null && right.data==null) return true;                      
        return false;
    }
    public int altura(){
        if(data==null)return 0;
        int izq,der;
        izq=der=0;
        
        return 1+ Math.max(left.altura(),right.altura());
    }
    public boolean esHoja(){
        return this.right==null && this.getLeft()==null;
    }
    public void recorridoPrefijo(){
        System.out.println(data);
        if(left!=null)left.recorridoPrefijo();
        if(right!=null)right.recorridoPrefijo();
    }
    
    public void recorridoPosfijo(){
        System.out.println(data);
        if(left!=null)left.recorridoPrefijo();
        if(right!=null)right.recorridoPrefijo();
    }
    
    public void recorridoInfijo(){
        System.out.println(data);
        if(left!=null)left.recorridoPrefijo();
        if(right!=null)right.recorridoPrefijo();
    }
    public boolean insert(E element){
        ArbolBinario root=new ArbolBinario(data);
        if(element==null)return false;
        root = insert(root,element);
        return true;
    }
    
    public ArbolBinario insert(ArbolBinario ab, E dato){
      
        if(ab==null)return new ArbolBinario<>(dato);
        if(dato.compareTo((E)ab.data)==0)return ab;
        if(dato.compareTo((E)ab.data)>0){
            ab.right=insert(ab.right,dato);
            System.out.println(ab.right.data);
        }
        else{
            ab.left=insert(ab.left,dato);
        }return ab;
    }
    
    public ArbolBinario search(ArbolBinario ab, E dato){
        if(this.isEmpty())return null;
        ArbolBinario arbIzq=this.left;
        ArbolBinario arbDer=this.right;
        if(this.esHoja()){    
            if(arbIzq.data.compareTo(dato)==0) return arbIzq;
            else if(arbDer.data.compareTo(dato)==0) return arbDer;
        }search(arbIzq, dato);
        search(arbDer, dato);
        
        return null;
    }
    public ArbolBinario encontrarMenorDLMayores(ArbolBinario ab){
        if(ab.left==null) return null;
        ArbolBinario mEm= ab;
        while(mEm.right !=null){
            mEm=mEm.right;
    }return mEm;
    }
    
    public ArbolBinario delete(ArbolBinario ab, E dato){
        ArbolBinario mEm=encontrarMenorDLMayores(ab);
       if(ab.isEmpty())return null;
       if(ab.data.compareTo(dato)== 0){
            if(ab.esHoja()) return null;
            if(ab.right == null)  return ab.left;
            if(ab.left  == null)  return ab.right;
            ab.data=(encontrarMenorDLMayores(ab.left).data);
            ab.left= delete(ab.left, (E)ab.data);
            return ab;
        }if(ab.data.compareTo(dato)>0){
            ab.right= delete(ab.right, dato);
        }else{
            ab.left= delete(ab.left, data);
        }
        return ab;
    }
    
 @Override
    public String toString() {
        return "ArbolBinario{" + "data=" + data + ", left=" + left.data + ", right=" + right.data + '}';
    }
    public E getData() {
        return data;
    }

    public ArbolBinario<E> getLeft() {
        return left;
    }

    public ArbolBinario<E> getRight() {
        return right;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setLeft(ArbolBinario<E> left) {
        this.left = left;
    }

    public void setRight(ArbolBinario<E> right) {
        this.right = right;
    }

   
    
    
    
}

