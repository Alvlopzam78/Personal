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
public class ConjuntoA <T> implements ConjuntoADT <T> {
    private int cardinalidad;
    private T[] coleccion;
    private final int MAX = 20;

    public ConjuntoA() {
        coleccion = (T[]) new Object[MAX];
        cardinalidad = 0;
    }
    
    public ConjuntoA(int max) {
        coleccion = (T[]) new Object[max];
        cardinalidad = 0;
    }

    public int getCardinalidad() {
        return cardinalidad;
    }
    
    public boolean estaVacio(){
        return cardinalidad == 0;
    }
    
    public boolean contiene(T dato){
        return contiene(dato,0)>=0;
    }
    
    private int contiene(T dato, int indice){
        if (indice == cardinalidad)
            return -1;
        else
            if(coleccion[indice].equals(dato))
                return indice;
            else
                return contiene(dato, indice + 1);
    }
    
    public boolean agrega(T dato){
        boolean res;
        
        res = contiene(dato);
        if(!res){ //el dato no está contenido en el conjunto
            if(cardinalidad == coleccion.length) //Está lleno
                expande();
            coleccion[cardinalidad] = dato;
            cardinalidad++;
        }
        return !res;
    }
    
    private void expande(){
        T[] masGrande = (T[]) new Object[coleccion.length * 2];
        
        expande(masGrande, 0);
        coleccion = masGrande;
    }
    
    private void expande(T[] arreglo, int indice){
        if(indice < cardinalidad){
            arreglo[indice] = coleccion[indice];
            expande(arreglo, indice + 1);
        }
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        return toString(cad, 0);
    }
    
    private String toString(StringBuilder cad, int i){
        if(i < cardinalidad){
            cad.append(coleccion[i].toString() + "\n");
            return toString(cad, i+1);
        }else{
            return cad.toString();
        }
    }
    
    public Iterator <T> iterator(){
        return new IteradorArreglo(coleccion, cardinalidad);
    }
    
    public ConjuntoADT <T> union (ConjuntoADT <T> otro){
        ConjuntoA <T> conjUnion = new ConjuntoA(this.cardinalidad);
        
        copiaArreglo(0, conjUnion);
        Iterator <T> it = otro.iterator();
        while(it.hasNext())
            conjUnion.agrega(it.next());
        return conjUnion;   
    }
    
    private void copiaArreglo(int i, ConjuntoA <T> conjUnion){
        if(i < cardinalidad){
            conjUnion.coleccion[i] = coleccion[i];
            copiaArreglo(i+1, conjUnion);
        }else
            conjUnion.cardinalidad = this.cardinalidad;
    }
    
    public ConjuntoADT <T> interseccion(ConjuntoADT <T> otro){
        ConjuntoA <T> conjInter;
        
        if(this.cardinalidad < otro.getCardinalidad()){
            conjInter = new ConjuntoA(this.cardinalidad);
            interseccionRec(this.iterator(), otro, conjInter,0);
        }else{
            conjInter = new ConjuntoA(otro.getCardinalidad());
            interseccionRec(otro.iterator(), this, conjInter,0);
        }
        return conjInter;
    }
    
    private void interseccion (Iterator<T> it, ConjuntoADT<T> conj, ConjuntoA<T> conjInter){
        T objeto;
        int i = 0;
        
        while(it.hasNext()){
            objeto = it.next();
            if(conj.contiene(objeto)){
                conjInter.coleccion[i] = objeto;
                i++;
            }
        }
        conjInter.cardinalidad = i;
        
    }
    
    private void interseccionRec (Iterator<T> it, ConjuntoADT<T> conj, ConjuntoA<T> conjInter, int i){
        if(it.hasNext()){
            T obj = it.next();
            if(conj.contiene(obj)){
                conjInter.coleccion[i] = obj;
                interseccionRec(it, conj, conjInter, i+1);
            }else
                interseccionRec(it, conj, conjInter, i);
        }else{
            conjInter.cardinalidad = i;
        }
        
    }
    
    public T quita (T dato){
        T resp;
        int pos = contiene(dato,0);
        
        if(pos>=0){
            resp = coleccion[pos];
            coleccion[pos]=coleccion[cardinalidad-1];
            cardinalidad--;
            return resp;
        }else
            throw new RuntimeException("Dato no encontrado");    
    }
    
    public ConjuntoADT <T> diferencia (ConjuntoADT <T> otro){
        ConjuntoA <T> conjDif = new ConjuntoA(cardinalidad);
        
        diferencia(0, otro, conjDif);
        return conjDif;
    }
    
    private void diferencia(int i, ConjuntoADT <T> otro, ConjuntoA <T> conjDif){
        if(i < cardinalidad){
            if(!otro.contiene(coleccion[i])){
                conjDif.coleccion[conjDif.cardinalidad] = coleccion[i];
                conjDif.cardinalidad ++;
            }
            diferencia(i+1, otro, conjDif);
        }
    }
    
    public static <T> boolean equals(ConjuntoADT<T> c1, ConjuntoADT<T> c2){
        boolean res = false;
        int cont = 0;
        
        if(c1.getCardinalidad() == c2.getCardinalidad()){
            Iterator<T> it2 = c2.iterator();
            while(it2.hasNext() && c1.contiene(it2.next()))
                cont++;
        }
        if(cont == c1.getCardinalidad())
            res = true;
        return res;
    }
    
    public boolean equals (Object obj){
        int i = 0;
        boolean res = false;
        if(obj!=null && obj instanceof ConjuntoA){
            ConjuntoA c2 = (ConjuntoA) obj;
            if(this.cardinalidad == c2.getCardinalidad())
                while(i<cardinalidad && c2.contiene(coleccion[i]))
                    i++;
            res = i == cardinalidad;
        }
        return res;
    }
}
