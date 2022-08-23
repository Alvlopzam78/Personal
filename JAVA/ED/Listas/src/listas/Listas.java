/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listas;

import java.util.Iterator;

/**
 *
 * @author Alvlopzam
 */
public class Listas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaOrdenada<Integer> l1 = new ListaOrdenada();
        ListaOrdenada<Integer> l2 = new ListaOrdenada();
        int suma = 0;
        Iterator<Integer> it;
        
        
        //CP1: lista vacía
        System.out.println("\nCP1: lista vacía\n"+l1);
        
        //CP2: con un elemento 
        l1.agrega(45);
        System.out.println("\nCP2: lista con un elemento\n" + l1);
        
        //CP3: agregamos algo más chico que el primero
        l1.agrega(16);
        System.out.println("\nCP3: lista luego de agregar un valor menor al primero\n" + l1);
        
        //CP4: agregamos algo más grande que el último
        l1.agrega(89);
        System.out.println("\nCP4: lista luego de agregar un valor mayor al último\n" + l1);
        
        //CP5: agregamos uno intermedio 
        l1.agrega(54);
        System.out.println("\nCP5: lista luego de agregar un valor intermedio\n" + l1);
        
        //CP6: agregamos un dato repetido
        l1.agrega(16);
        System.out.println("\nCP6: lista luego de agregar un valor repetido\n" + l1);
        
        //Vamos a sumar los datos dentro de la lista
        for(Integer num: l1)
            suma += num;
        System.out.println("\nSuma de los elementos de la lista: " + suma);
        
        //Vamos a preguntarnos si la lista contiene un dato específico
        it = l1.iterator();
        boolean encontro = false;
        while (it.hasNext() && !encontro)
            encontro = it.next() == 89;
        if(encontro)
            System.out.println("\nSi está");
        else
            System.out.println("\nNo está");
        
        System.out.println(l1.toString());
        
        l2.agrega(16);
        l2.agrega(16);
        l2.agrega(45);
        l2.agrega(54);
        l2.agrega(89);

        System.out.println(l1.equals(l2));
        
        
        
//        //CP7: se quita el primero
//        System.out.println("\nCP7: se quita el primero: " + l1.quita(16));
//        
//        System.out.println(l1.toString());
//        
//        //CP8: se quita el último
//        System.out.println("\nCP8: se quita el último: " + l1.quita(89));
//        
//        System.out.println(l1.toString());
//        
//        //CP9: se intenta quitar un dato que no está
//        System.out.println("\nCP9: se intenta quitar un dato que no está: " + l1.quita(109));
//        
//        System.out.println(l1.toString());
//        
//        //CP10: se quita un dato intermedio
//        System.out.println("\nCP10: se quita un dato intermedio: " + l1.quita(45));
//        
//        System.out.println(l1.toString());
        


        MateriaSemestre ED = new MateriaSemestre("Estructuras de Datos", "CC202", 4, "Silvia Guardati");
        System.out.println(ED.altaAlumno("Álvaro López", 198442, 9));
        System.out.println(ED.altaAlumno("Alex", 99999, 10));
        //System.out.println(ED.bajaAlumno(99999));
        System.out.println(ED.getSalon());
        ED.cambioSalon("CC301");
        System.out.println(ED.getSalon());
        System.out.println(ED.agregaLibro("Silvia", "ED", 101));
        //System.out.println(ED.bajaLibro(101));
        System.out.println(ED.promAlumnos());
        System.out.println(ED.consultaAlumno(198442));
        System.out.println(ED.arribaProm(2, 8));
        System.out.println(ED.librosDe("Silvia"));
    }
    
}
