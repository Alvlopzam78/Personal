/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructurasenlzadas;

import java.util.Iterator;

/**
 *
 * @author Alvlopzam
 */
public class EstructurasEnlzadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EE<Integer> e1 = new EE();
        EE<Integer> e2 = new EE();
        
        int suma;
        Iterator<Integer> it;
        
        System.out.println("\nEE vacia: " + e1);
        
        e1.agregaFinal(1);
        e1.agregaFinal(3);
        e1.agregaFinal(5);
        e1.agregaFinal(7);
        e1.agregaFinal(9);
        e1.agregaFinal(11);
        e1.agregaFinal(13);
        e1.agregaFinal(15);
        e1.agregaFinal(17);
        e1.agregaFinal(19);
        e1.agregaFinal(21);
        e1.agregaFinal(23);
        
        System.out.println("\nEE con 4 datos: \n" + e1);
        
//        e1.agregaFinal(333333);
//        System.out.println("\nEE con 4 datos: \n" + e1);
        
        //a) Obtener la suma de los datos
        suma = 0;
        for(Integer num: e1)
            suma += num;
        System.out.println("\nLa suma es = " + suma);
        
        //b) Si hay algun dato mayor que 20
        boolean mayor20 = false;
        it = e1.iterator();
        while(it.hasNext() && !mayor20)
            mayor20 = it.next() > 20;
        if(mayor20)
            System.out.println("Si hay algún dato mayor que 20");
        
        //c) Queremos saber si tenemos guardado el 18
        boolean esta18 = false;
        it = e1.iterator();
        while(it.hasNext() && !esta18)
            esta18 = it.next() == 18;
        if(esta18)
            System.out.println("Si está el 18");
        else
            System.out.println("No está el 18");
        
        System.out.println("\nEE con 4 datos: \n" + e1);
        e1.insertaAntesQue(18, 5);
        System.out.println("\nEE con 5 datos: \n" + e1);
        
        e2.agregaFinal(2);
        e2.agregaFinal(4);
        e2.agregaFinal(6);
        e2.agregaFinal(8);
        e2.agregaFinal(10);
        e2.agregaFinal(12);
        e2.agregaFinal(14);
        e2.agregaFinal(16);
        e2.agregaFinal(18);
        
        System.out.println("e1 \n" + e1 + "\n");
        System.out.println("e2 \n" + e2 + "\n");
        
        e1.mezcla(e2);
        System.out.println("e1 \n" + e1 + "\n");
    }
}
