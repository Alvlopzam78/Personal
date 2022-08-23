/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructurasenlzadas;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Alvlopzam
 */
public class IteradorEE<T> implements Iterator<T>{
    private Nodo<T> actual;
    
    public IteradorEE (Nodo<T> actual){
        this.actual = actual;
    }
    
    public boolean hasNext(){
        return actual != null;
    }
    
    public T next(){
        if(this.hasNext()){
            T dato = actual.getDato();
            actual = actual.getDir();
            return dato;
        }
        throw new NoSuchElementException();
    }
    
}
