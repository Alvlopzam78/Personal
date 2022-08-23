/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colas;

import pilas.PilaA;
import pilas.PilaADT;

/**
 *
 * @author Alvlopzam
 */
public class ProblemasColas {
    public static <T> void invierteCola(ColaADT<T> cola){
        PilaADT <T> pila = new PilaA();
        copiaAPila(cola, pila);
        copiaACola(pila, cola);
    }
    
    private static <T> void copiaAPila(ColaADT<T> cola, PilaADT<T> pila){
        if(!cola.estaVacia()){
            pila.push(cola.quita());
            copiaAPila(cola, pila);
        }
    }
    
    private static <T> void copiaACola(PilaADT<T> pila, ColaADT<T> cola){
        if(!pila.isEmpty()){
            cola.agrega(pila.pop());
            copiaACola(pila, cola);
        }
    }
    
    public static <T> void eliminaRepetidos(ColaADT<T> cola){
        if(cola!=null){
            ColaADT<T> aux = new ColaA();
            T dato;
            while(!cola.estaVacia()){
                dato = cola.quita();
                aux.agrega(dato);
                while(!cola.estaVacia() && dato.equals(cola.consultaPrimero()))
                    cola.quita();
            }
            copiaCola(aux, cola); //Falta programarlo 
        }
    }
    
    public static <T> void eliminaOcurrencias(ColaADT<T> cola, T dato){
        if(cola!=null){
            ColaADT<T> aux = new ColaA();
            while(!cola.estaVacia()){
                if(!cola.consultaPrimero().equals(dato))
                    aux.agrega(cola.quita());
                else
                    cola.quita();
            }
            copiaCola(cola, aux);
        }
    }
    
    public static void main(String[] args) {
        ColaADT<Integer> c1 = new ColaA();
        
        c1.agrega(23);
        c1.agrega(45);
        c1.agrega(2);
        c1.agrega(23);
        c1.agrega(18);
        System.out.println(c1.toString());
        invierteCola(c1);
        System.out.println(c1.toString());
    }
}
