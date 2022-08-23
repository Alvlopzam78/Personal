/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conjuntos;

import java.util.Iterator;

/**
 *
 * @author Alvlopzam
 */
public interface ConjuntoADT <T> extends Iterable <T> {
    public boolean agrega(T dato);
    public boolean contiene(T dato);
    public int getCardinalidad();
    public boolean estaVacio();
    public String toString();
    public ConjuntoADT<T> union(ConjuntoADT <T> otro);
    public ConjuntoADT<T> interseccion(ConjuntoADT <T> otro);
    public ConjuntoADT<T> diferencia(ConjuntoADT <T> otro);
    public Iterator <T> iterator();
    public T quita(T dato);
}
