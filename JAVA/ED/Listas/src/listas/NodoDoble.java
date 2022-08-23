/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

/**
 *
 * @author Alvlopzam
 */
public class NodoDoble <T>{
    private T dato;
    private NodoDoble<T> anterior;
    private NodoDoble<T> siguiente;

    public NodoDoble(T dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public NodoDoble<T> getAnterior() {
        return anterior;
    }

    public NodoDoble<T> getSiguiente() {
        return siguiente;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }

    public void setSiguiente(NodoDoble<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
