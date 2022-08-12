/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import java.util.ArrayList;

/**
 *
 * @author JUAN XXIII
 */
public class Heap <E extends Comparable<E>>{
    private E[] array;
    private int capacity=100;
    private int efectivo;
    private boolean isMax; //true ->MAX; false -> MIN

    public Heap(E data[]) {
        if (data.length<capacity){
            array= (E[])new Comparable[capacity];
        }else{
            array= (E[])new Comparable[data.length];
            capacity= data.length-1;
        }
        System.arraycopy(data, 0, array, 0, data.length);
        isMax=true;
        efectivo= data.length-1;
    }
    
    public Heap(E data[], int capacity) {
        if (data.length<capacity){
            array= (E[])new Comparable[capacity];
            this.capacity=capacity;
        }else{
            array= (E[])new Comparable[data.length];
            this.capacity= data.length-1;
        }
        System.arraycopy(data, 0, array, 0, data.length);
        efectivo= data.length-1;
        isMax=true;
    }
    
    public Heap(int capacity){
        array= (E[])new Comparable[capacity];
        efectivo=-1;
        isMax=true;
    }
        
    public Heap(){
        array= (E[])new Comparable[capacity];
        efectivo=-1;
        isMax=true;
    }
    
    public void setMax(boolean bool){
        isMax= bool;
    }
    
    public boolean isEmpty(){return efectivo==-1;}
    
    public int size(){return efectivo+1;}
    
    private int posLeft(int posNode){
        if (2*posNode+1 <= efectivo)
            return 2*posNode+1;
        return -1;
    }
    
    private int posRight(int posNode){
        if (2*posNode+2 <= efectivo)
            return 2*posNode+2;
        return -1;
    }
    
    private int posParent(int posNode){
        if (posNode != 0)
            return (posNode-1)/2;
        return -1;
    }
    
    private void intercambiar (int a, int b){
        E temp = array[a];
        array[a]=array[b];
        array[b]=temp;
    }
    
    private void adjust (int posNode){
        int posMax, left, right;        
        posMax = posNode;
        left = posLeft(posNode);
        right = posRight(posNode);  
        if(isMax==true){
            if(left>=0 && array[left].compareTo(array[posMax])>0)
            posMax=left;
            if(right>=0 && array[right].compareTo(array[posMax])>0)
            posMax=right;
        }
        else{
            if(left>=0 && array[left].compareTo(array[posMax])<0)
            posMax=left;
            if(right>=0 && array[right].compareTo(array[posMax])<0)
            posMax=right;        
        }
        
        if(posMax!= posNode){
            intercambiar(posNode,posMax);
            adjust(posMax);
        }
    }
    
    public void makeHeap( ){
        for(int  i = posParent(efectivo); i >= 0; i--){
            adjust(i);
        }
    }
    
    public E dequeue (){
        if(!isEmpty()){
            E max = array[0];
            intercambiar(0,efectivo);
            efectivo --;
            adjust(0);
            return max;
        }
        return null;
    }
    
    public void queue (E element){
        int padre, i;
        if(efectivo < capacity){
            if(isMax==true){
                array[++efectivo] = element;
            i=efectivo ;
            padre = posParent(i);
            while((i>=0  &&  padre >= 0) && array[i].compareTo(array[padre] )>0 ){
                intercambiar(i,padre);
                i= padre;
                padre = posParent(i);
            }
            }
            else{
            array[++efectivo] = element;
            i=efectivo ;            
            padre = posParent(i);
            
            while((i>=0  &&  padre >= 0) && array[i].compareTo(array[padre] )<0 ){
                intercambiar(i,padre);
                i= padre;
                padre = posParent(i);                
            }
        }
        }
        
    }
      
    public ArrayList<E> Heapsort (){
        ArrayList<E> lista = new ArrayList<>();
        while(!isEmpty())
            lista.add(dequeue());
        return lista;
    }
}
