/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

import java.util.Iterator;

/**
 *
 * @author Alvlopzam
 */
public abstract class Lista <T> implements ListaADT <T>{
    protected NodoDoble<T> primero;
    protected NodoDoble<T> ultimo;

    public Lista() {
        primero = null;
        ultimo = null;
    }
    
    public Iterator<T> iterator(){
        return new IteradorLista(primero);
    }
    
    public boolean estaVacia(){
        return primero == null; //o preguntar por el último o preguntar por ambos. Pero es suficiente por uno
    }
    
    public String toString(){
        return toString(primero, new StringBuilder());
    }
    
    private String toString(NodoDoble<T> actual, StringBuilder cad){
        if(actual == null)
            return cad.toString();
        else{
            cad.append(actual.getDato()).append("\n");
            return toString(actual.getSiguiente(), cad);
        }
    }
    
    public boolean contiene (T dato){
        return contiene(ultimo, dato);
    }
    
    private boolean contiene(NodoDoble<T> actual, T dato){
        if(actual == null)
            return false;
        else{
            if(actual.getDato().equals(dato))
                return true;
            else
                return contiene(actual.getAnterior(), dato);
        }
    }
    
    public T quitaPrimero(){
        T resultado = null;
        
        if(!this.estaVacia()){
            resultado = primero.getDato();
            primero = primero.getSiguiente();
            if(primero == null) // había un solo nodo en la estructura
                ultimo = null; // la lista quedó vacía 
            else{
                primero.getAnterior().setSiguiente(null);
                primero.setAnterior(null);
            }
        }
        return resultado;
    }
    
    public T quitaUltimo(){
        T resultado = null;
        
        if(!this.estaVacia()){
            resultado = ultimo.getDato();
            ultimo = ultimo.getAnterior();
            if(ultimo == null) // había un solo nodo en la estructura
                primero = null; // la lista quedó vacía 
            else{
                ultimo.getSiguiente().setAnterior(null);
                ultimo.setSiguiente(null);
            }
        }
        return resultado;
    }
    
    public T quita(T dato){
        T resultado = null;
        
        if(!this.estaVacia()){
            if(primero.getDato().equals(dato))
                resultado = quitaPrimero();
            else if(ultimo.getDato().equals(dato))
                    resultado = quitaUltimo();
            else{
                NodoDoble<T> actual = primero.getSiguiente();
                while(actual != null && !actual.getDato().equals(dato))
                    actual = actual.getSiguiente();
                if(actual != null){ //Encontramos el dato
                    resultado = actual.getDato();
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                    actual.setAnterior(null);
                    actual.setSiguiente(null);
                }
            }
        }
        return resultado;
    }
    
    public int calculaTamanio(){
        return calculaTamanio(primero, 0);
    }
    
    private int calculaTamanio(NodoDoble<T> actual, int n){
        if(actual != null)
            return n;
        else
            return calculaTamanio(actual.getSiguiente(), n + 1);
    }
    
    
}
