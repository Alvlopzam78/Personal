/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructurasenlzadas;

/**
 *
 * @author Alvlopzam
 */
public class Nodo <T>{
    private T dato;
    private Nodo<T> dir;

    public Nodo() {
        this.dir = null;
    }

    public Nodo(T dato) {
        this.dato = dato;
        this.dir = null;
    }

    public T getDato() {
        return dato;
    }

    public Nodo<T> getDir() {
        return dir;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setDir(Nodo<T> dir) {
        this.dir = dir;
    }   
}
