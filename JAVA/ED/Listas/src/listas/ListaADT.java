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
public interface ListaADT <T> extends Iterable<T>{
    public Iterator<T> iterator();
    public boolean estaVacia();
    public T quitaPrimero();
    public T quitaUltimo();
    public T quita(T dato);
    public String toString();
    public boolean contiene(T dato);
    public int calculaTamanio();
    public T consultaPrimero();
    public T consultaUltimo();
}
