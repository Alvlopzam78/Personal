/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package colas;

/**
 *
 * @author Alvlopzam
 */
public class Colas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ColaADT<Integer> c1 = new ColaA();
        
        c1.agrega(23);
        c1.agrega(45);
        c1.agrega(2);
        c1.agrega(23);
        c1.agrega(18);
        //System.out.println("\nCola luego de agregar algunos elementos:\n" + c1);
        
        ///System.out.println("\nElemento eliminado: " + c1.quita());
        //System.out.println("\nLuego de quitar un elemento:\n" + c1);
        System.out.println(c1.toString());
        c1.multiQuita(2);
        System.out.println(c1.toString());
    }
    
}
