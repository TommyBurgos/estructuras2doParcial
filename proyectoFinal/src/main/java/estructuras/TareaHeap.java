/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import estructuras.Heap;
import java.util.*;

/**
 *
 * @author miguel
 */
public class TareaHeap {
    public static void main(String[] args){
        Integer[] arreglo = {15,1,28,35,10,5,8,21,50,42};
        Heap<Integer> monticulo= new Heap(arreglo,20);
        monticulo.makeHeap();
        
        ArrayList<Integer>  lista= monticulo.Heapsort();
        System.out.println("Lista Ordenada: "+lista);
        
        Heap<Integer> monticulo2= new Heap(20);
        monticulo2.setMax(false);
        monticulo2.queue(15);monticulo2.queue(1);monticulo2.queue(28);monticulo2.queue(35);
        monticulo2.queue(10);monticulo2.queue(5);monticulo2.queue(8);monticulo2.queue(21);
        monticulo2.queue(50);monticulo2.queue(42);
        
        ArrayList<Integer> lista2= monticulo2.Heapsort();
        System.out.println("Lista Ordenada: "+lista2);

        
        
    }
    
  
}
