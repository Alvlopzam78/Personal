/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conjuntos;

import java.util.Iterator;

/**
 *
 * @author Alvlopzam
 */
public class Conjuntos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConjuntoADT <Integer> c1 = new ConjuntoA();
        ConjuntoADT <Alumno> c2 = new ConjuntoA();
        ConjuntoADT <Integer> c3 = new ConjuntoA();
        ConjuntoADT <Alumno> c4 = new ConjuntoA();
        ConjuntoADT <Integer> c5 = new ConjuntoA();
        ConjuntoADT <Integer> c6 = new ConjuntoA();
        ConjuntoADT <Integer> c7 = new ConjuntoA();
        ConjuntoADT <Integer> c8 = new ConjuntoA();
        ConjuntoADT <Integer> c9 = new ConjuntoA();
        ConjuntoADT <Integer> c10 = new ConjuntoA();
        ConjuntoADT <Integer> c11 = new ConjuntoA();
        
//        c1.agrega(23);
//        c1.agrega(3);
//        c1.agrega(43);
//        c1.agrega(17);
//        c1.agrega(40);
//        System.out.println("\nC1: \n" + c1);
//        c1.agrega(40);
//        System.out.println("\nC1: \n" + c1);
//        
//        c2.agrega(new Alumno(100, 8.5, "Luis"));
//        c2.agrega(new Alumno(108, 9, "Alicia"));
//        c2.agrega(new Alumno(110, 7.5, "Daniel"));
//        c2.agrega(new Alumno(103, 8.5, "Luisa"));
//        c2.agrega(new Alumno(105, 8.5, "Maria"));
//        System.out.println("\nC2: \n" + c2);
//        c2.agrega(new Alumno(100, 9, "XXX"));
//        System.out.println("\nC2: \n" + c2);
//        
//        //Ejemplo de acceso a los elementos del conjunto 
//        if(c2.getCardinalidad() > 0){
//            Iterator<Alumno> it = c2.iterator();
//            double suma = 0;
//            while(it.hasNext())
//                suma += it.next().getPromedio();
//            double prom;
//            prom = suma / c2.getCardinalidad();
//            System.out.println("\nPromedio de los alumnos: " + prom);
//        }else
//            System.out.println("\nNo hay alumnos en el conjunto");
//        
//       //Pruebas de la unión
//       c3.agrega(23);
//       c3.agrega(35);
//       c3.agrega(40);
//       c3.agrega(88);
//       c3.agrega(3);
//       c3.agrega(43);
//       System.out.println("\nC3: \n" + c3);
//       System.out.println("\nUnion de c1 y c3: \n" + c1.union(c3));
//       
//       //Pruebas de la interseccion 
//       c5.agrega(2);
//       c5.agrega(5);
//       c5.agrega(19);
//       c5.agrega(25);
//       
//       c6.agrega(1);
//       c6.agrega(4);
//       c6.agrega(20);
//       c6.agrega(24);
//       c6.agrega(7);
//       
//       c7.agrega(2);
//       c7.agrega(5);
//       c7.agrega(19);
//       c7.agrega(25);
//       
//       c8.agrega(2);
//       c8.agrega(4);
//       c8.agrega(8);
//       c8.agrega(20);
//       
//       c9.agrega(1);
//       c9.agrega(4);
//       c9.agrega(8);
//       c9.agrega(25);
//       
//       c10.agrega(4);
//       c10.agrega(5);
//       c10.agrega(7);
//       c10.agrega(19);
//       c10.agrega(21);
//       c10.agrega(25);
//
//       System.out.println("\nInterseccion de c5 y c6: \n" + c5.interseccion(c6));
//       System.out.println("\nInterseccion de c5 y c7: \n" + c5.interseccion(c7));
//       System.out.println("\nInterseccion de c5 y c8: \n" + c5.interseccion(c8));
//       System.out.println("\nInterseccion de c5 y c9: \n" + c5.interseccion(c9));
//       System.out.println("\nInterseccion de c5 y c10: \n" + c5.interseccion(c10));
       
        //Pruebas de la diferencia
        ConjuntoADT <String> colPrim = new ConjuntoA();
        ConjuntoADT <String> colores = new ConjuntoA();
        ConjuntoADT <String> colPermitidos = new ConjuntoA();
        
        //CP1: diferencia de conjuntos vacios
        System.out.println("\nCP1: con conjuntos vacios\n" + colPrim.diferencia(colores));
        
        //CP2: diferencia con elementos comunes
        colores.agrega("rojo");
        colores.agrega("verde");
        colores.agrega("negro");
        colores.agrega("azul");
        colores.agrega("blanco");
        
        colPrim.agrega("azul");
        colPrim.agrega("rojo");
        System.out.println("\nCP2: con conjuntos con elementos comunes\n" + colores.diferencia(colPrim));
        
        //CP3: diferencia sin elementos comunes
        colPermitidos.agrega("amarillo");
        colPermitidos.agrega("blanco");
        colPermitidos.agrega("gris");
        
        System.out.println("\nCP3: con conjuntos sin elementos comunes\n" + colPermitidos.diferencia(colPrim));
        
        //CP4: diferencia con conjuntos iguales
        System.out.println("\nCP2: con conjuntos iguales\n" + colPrim.diferencia(colPrim));
        
        //Pruebas del Equals
        System.out.println(ConjuntoA.equals(c5,c7));
        System.out.println(c5.equals(c7));
    }
}
