/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

/**
 *
 * @author Alvlopzam
 * @param <T>
 */
public class ListaOrdenada <T extends Comparable<T>> extends Lista<T> implements ListaOrdenadaADT<T>{
    public void agrega(T dato){
        NodoDoble<T> nuevo = new NodoDoble(dato);
        
        if(this.estaVacia()){
            primero = nuevo;
            ultimo = nuevo;
        }else if(dato.compareTo(ultimo.getDato()) >= 0){ //El nuevo dato pasa a ser el último
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }else if(dato.compareTo(primero.getDato()) <= 0){ //El nuevo dato pasa a ser el primero
            primero.setAnterior(nuevo);
            nuevo.setSiguiente(primero);
            primero = nuevo;
        }else{ //El nuevo dato se agrega a una posición intermedia
            NodoDoble<T> actual = primero;
            while(actual.getDato().compareTo(dato) < 0)
                actual = actual.getSiguiente();
            nuevo.setAnterior(actual.getAnterior());
            nuevo.setSiguiente(actual);
            actual.getAnterior().setSiguiente(nuevo);
            actual.setAnterior(nuevo);
        }
    }
    public T consultaPrimero(){
        T resultado = null;
        
        if(!this.estaVacia())
            resultado = primero.getDato();
        return resultado;
    }
    public T consultaUltimo(){
        T resultado = null;
        
        if(!this.estaVacia())
            resultado = ultimo.getDato();
        return resultado;
    }
    
    //Sobreescritura del método por razones de eficiencia 
    public boolean contiene (T dato){
        return contiene(primero, dato);
    }
    
    private boolean contiene(NodoDoble<T> actual, T dato){
        if(actual == null)
            return false;
        else{
            if(actual.getDato().equals(dato))
                return true;
            else if(actual.getDato().compareTo(dato) > 0)
                return false;
            else
                return contiene(actual.getSiguiente(), dato);
        }
    }
    
    //Sobreesccritura del método por razones de eficiencia
    public T quita(T dato){
        T resultado = null;
        
        if(!this.estaVacia()){
            if(primero.getDato().equals(dato))
                resultado = quitaPrimero();
            else if(ultimo.getDato().equals(dato))
                    resultado = quitaUltimo();
            else if(ultimo.getDato().compareTo(dato) > 0 && primero.getDato().compareTo(dato) < 0){
                    NodoDoble<T> actual = primero.getSiguiente();
                    while(actual.getDato().compareTo(dato) < 0)
                        actual = actual.getSiguiente();
                    if(actual.getDato().equals(dato)){ //Encontramos el dato
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
    
    //Solución iterativa
//    public boolean equals(Object otra){
//        boolean res = false;
//        NodoDoble<T> act1;
//        NodoDoble<T> act2;
//        
//        if(otra != null && this.getClass().equals(otra.getClass()))
//            act1 = this.primero;
//            act2 = ((ListaOrdenada) otra).primero;
//            while(act1 != null && act2 != null && act1.getDato().equals(act2.getDato())){
//                act1 = act1.getSiguiente();
//                act2 = act2.getSiguiente();
//            }
//            if(act1 == null && act2 == null)
//                res = true;
//            }
//        return res;
//    }
    
    //solución recursiva 
    public boolean equals (Object otra){
        NodoDoble<T> act1 = null;
        NodoDoble<T> act2 = null;
        if(otra != null && this.getClass().equals(otra.getClass()))
            act1 = this.primero;
            act2 = ((ListaOrdenada) otra).primero;
            return equals(otra, act1, act2);                
    }
    
    private boolean equals (Object otra, NodoDoble<T> act1, NodoDoble<T> act2){
        if(act1 == null && act2 == null)
            return true;
        else
            if(act1 != null && act2 != null && act1.getDato().equals(act2.getDato())){
                act1 = act1.getSiguiente();
                act2 = act2.getSiguiente();
                return equals(otra, act1, act2);
            }else
                return false;
    }
}
