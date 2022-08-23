/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructurasenlzadas;

import java.util.Iterator;

/**
 *
 * @author Alvlopzam
 */
public class EE <T> implements Iterable<T>{
    private Nodo<T> primero;

    public EE() {
        primero = null;
    }
    
    public boolean estaVacia(){
        return primero == null;
    }
    
    //Agrega un nuevo dato al inicio de la EE
    public void agregaInicio(T nuevoDato){
        Nodo<T> nuevoNodo = new Nodo(nuevoDato);
        nuevoNodo.setDir(primero);
        primero = nuevoNodo;
    }
    
    // Agrega al final de la EE
    public void agregaFinal(T nuevoDato){
        Nodo<T> nuevoNodo = new Nodo(nuevoDato);
        
        if(this.estaVacia())
            primero = nuevoNodo;
        else{
            Nodo<T> temporal = primero;
            while (temporal.getDir() != null)
                temporal = temporal.getDir();
            temporal.setDir(nuevoNodo);
        }
    }
    
    //Hacer el elimina
    // Hay que considerar si es el único, si está vacía, debe regresar el dato
    //Hay que hacer quita primero y quita último
    
    public T quitaPrimero(){
        if(this.estaVacia())
            throw new RuntimeException("Estructura vacía");
        
        T res = primero.getDato();
        Nodo<T> temp = primero;
        primero = primero.getDir();
        temp.setDir(null);
        return res;
    }
    
    public T quitaUltimo(){
        if(this.estaVacia())
            throw new RuntimeException("Estructura vacía");
        Nodo<T> aux = primero;
        T res;
        
        if(aux.getDir() == null){
            res = primero.getDato();
            primero = null;
        }else{
            while(aux.getDir().getDir() != null)
                aux = aux.getDir();
            res = aux.getDir().getDato();
            aux.setDir(null);
        }
        return res;
    }
    
    public boolean buscaDato(T dato){
        return buscaDato(primero, dato);
    }
    
    private boolean buscaDato(Nodo<T> actual, T dato){
        if(actual == null)
            return false;
        else
            if(actual.getDato().equals(dato))
                return true;
            else
                return buscaDato(actual.getDir(), dato);
    }
    
    public T quitaDato(T dato){
        if(this.estaVacia())
            throw new RuntimeException("Estructura vacía");
        T eliminado = null;
        Nodo<T> actual = primero;
        
        if(primero.getDato().equals(dato)){
            eliminado = primero.getDato();
            primero = primero.getDir();
            actual.setDir(null);
        }else{
            while(actual.getDir() != null && !actual.getDir().getDato().equals(dato))
                actual = actual.getDir();
            if(actual.getDir() != null){
                Nodo<T> temp = actual.getDir();
                eliminado = temp.getDato();
                actual.setDir(temp.getDir());
                temp.setDir(null);
            }
        }
        return eliminado;
    }
    
    /*public String toString(){
        StringBuilder cad = new StringBuilder();
        Nodo<T> temporal = primero;
        
        while(temporal != null){
            cad.append(temporal.getDato()).append("\n");
            temporal = temporal.getDir();
        }
        return cad.toString();
    }*/
    
    public String toString(){
        return toString(primero, new StringBuilder());
    }
    
    private String toString(Nodo<T> actual, StringBuilder cad){
        if(actual == null)
            return cad.toString();
        else{
            cad.append(actual.getDato()).append("\n");
            return toString(actual.getDir(), cad);
        }
    }
    
//    public boolean eliminaSiguiente(T dato){
//        boolean res = false;
//        
//        if(this.estaVacia())
//            throw new RuntimeException("Estructura vacía");
//        
//        Nodo<T> elimina;
//        
//        
//    }
    
//    private Nodo<T> buscaNodo(T dato){
//        return buscaNodo(primero, dato);
//    }
//    
//    private Nodo<T> buscaNodo(Nodo<T> primero, T dato){
//        
//    }
    
    public Iterator<T> iterator(){
        return new IteradorEE(primero);
    }
    
    public boolean insertaAntesQue(T refer, T nuevo){
        if(this.estaVacia())
            throw new ColeccionVaciaExcepcion("Estructura vacía");
    
        Nodo<T> actual = primero;
        Nodo<T> nuevoNodo = new Nodo(nuevo);
        boolean res = false;
        
        if(primero.getDato().equals(refer)){
            nuevoNodo.setDir(primero);
            primero = nuevoNodo;
            res = true;
        }else{
            while(actual.getDir() != null && !actual.getDir().getDato().equals(refer))
                actual = actual.getDir();
            if(actual.getDir() != null){
                nuevoNodo.setDir(actual.getDir());
                actual.setDir(nuevoNodo);
                res = true;
            }
        }
        return res;
    }
    
//    public int eliminaTodosRepetidosORdenado(){
//       int n = 0;
//       
//       if(!this.estaVacia()){
//           Nodo<T> actual = primero;
//           Nodo<T> aux;
//           T dato;
//           
//       }
//    }
    
    public void mezcla(EE<T> objEE){ // Corregir se usa bandera y dentro del while se pregutna si actual tiene vecino o no. En el ahile se pregunta si actual 2 es nulo o no y por la bandera
        Nodo<T> act1 = primero;
        Nodo<T> act2 = objEE.primero;
        Nodo<T> aux1 = act1.getDir();
        Nodo<T> aux2 = act2.getDir();
        Nodo<T> temp1 = null;
        Nodo<T> temp2 = null;
        
        if(this.estaVacia())
            this.primero = objEE.primero;
        else if(objEE != null){
            while(act2.getDir()!=null){
                temp1 = aux1.getDir();
                temp2 = aux2.getDir();
                act1.setDir(act2);
                act2.setDir(aux1);
                aux1.setDir(aux2);
                act1 = act2.getDir();
                act2 = aux1.getDir();
                aux1 = temp1;
                aux2 = temp2;
            }
            if(temp1!=null)
                act2.setDir(temp1);
        }
    }
}

