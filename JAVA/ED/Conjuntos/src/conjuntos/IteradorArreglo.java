/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conjuntos;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Alvlopzam
 */
public class IteradorArreglo <T> implements Iterator <T>{
    private T[] datos;
    private int total;
    private int actual;

    public IteradorArreglo(T[] datos, int total) {
        this.datos = datos;
        this.total = total;
        this.actual = 0;
    }

    @Override
    public boolean hasNext() {
        return actual < total;
    }

    @Override
    public T next() {
        if(hasNext()){
            T res = datos[actual];
            actual++;
            return res;
        }else
            throw new NoSuchElementException();
    }
    
    
}
