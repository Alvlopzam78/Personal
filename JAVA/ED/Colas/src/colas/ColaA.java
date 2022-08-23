/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colas;

import java.util.ArrayList;

/**
 *
 * @author Alvlopzam
 */
public class ColaA <T> implements ColaADT <T> {
    private T[] cola;
    private int inicio;
    private int fin;
    private final int MAX = 20;
    
    public ColaA(){
        cola = (T[]) new Object[MAX];
        inicio = -1;
        fin = -1;
    }
    
    public ColaA(int max){
        cola = (T[]) new Object[max];
        inicio = -1;
        fin = -1;
    }

    public void agrega(T dato) {
        if (estaVacia())
            inicio = 0;
        else
            if((fin+1) % cola.length == inicio)
                expande();
        fin = (fin + 1) % cola.length;
        cola[fin] = dato;
    }
    
    private void expande(){
        int tam = cola.length;
        T[] masGrande = (T[]) new Object[tam * 2];
        
        for(int i = 0; i < tam; i++)
            masGrande[i] = cola[(inicio+i) % tam];
        cola = masGrande;
        inicio = 0;
        fin = tam-1;
    }
    
    public T quita() {
        if (estaVacia())
            throw new RuntimeException("Esta vacia");
        else{
            T resultado = cola[inicio];
            cola[inicio] = null;
            if(inicio == fin){
                inicio = -1;
                fin = -1;
            }
            else
                inicio = (inicio+1) % cola.length;
            return resultado;
        }
    }

    public boolean estaVacia() {
        return inicio == -1;
    }
    
    public T consultaPrimero() {
        if (estaVacia())
            throw new RuntimeException("Esta vacia");
        return cola[inicio];
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        
        if(!this.estaVacia()){
            int i = 0;
            
            while ((inicio + i) % cola.length != fin + 1){
                cad.append(cola[(inicio + i) % cola.length]).append("\n");
                i++;
            }
        }
        return cad.toString();
    }
    
    public int cuentaElementos(){
        int res = 0;
        if(!this.estaVacia()){
            if(inicio<=fin)
                res = fin - inicio + 1;
            else
                res = cola.length - inicio + fin + 1;
        }
        return res;
    }
    
    public T consultaUltimo(){
       if(estaVacia())
           throw new RuntimeException("Cola vacía");
       return cola[fin];
                 
    }
    
    public ArrayList<T> multiQuita(int n){
       ArrayList<T> res = new ArrayList();
       for(int i = 0; i<n; i++) 
           res.add(quita());
       return res;
    }
}
