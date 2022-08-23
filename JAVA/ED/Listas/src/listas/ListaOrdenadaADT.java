/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package listas;

/**
 *
 * @author Alvlopzam
 * @param <T>
 */
public interface ListaOrdenadaADT <T extends Comparable<T>> extends ListaADT<T>{
    public void agrega(T dato);
}
