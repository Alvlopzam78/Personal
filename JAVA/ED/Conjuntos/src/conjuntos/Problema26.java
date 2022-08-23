/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conjuntos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



/**
 *
 * @author Alvlopzam
 */
public class Problema26 {
    private static void leeArch(Scanner lec, ConjuntoA<String> ingles, ConjuntoA<String> frances, ConjuntoA<String> otros){
        String idioma;
        String nombre;
        int i;
        
        while(lec.hasNextLine()){
            String line = lec.nextLine();
            i = line.indexOf(",");
            idioma = line.substring(0, i).toLowerCase();
            nombre = line.substring(i+2).toUpperCase();
            if(idioma.equals("ingles"))
                ingles.agrega(nombre);
            else if(idioma.equals("frances"))
                frances.agrega(nombre);
            else
                otros.agrega(nombre);
        }
    }
        
    public static boolean creaConjuntos(String nomArch, ConjuntoA<String> ingles, ConjuntoA<String> frances, ConjuntoA<String> otros){
        try(Scanner lec = new Scanner(new File(nomArch))){
            leeArch(lec, ingles, frances, otros);
            return true;
        }catch(FileNotFoundException fnfe){
            return false;
        }
    }
    
    public static String inglesYFrances(ConjuntoA<String> ingles, ConjuntoA<String> frances){
        StringBuilder cad = new StringBuilder();
        ConjuntoADT<String> inglesYFrances;
        inglesYFrances = ingles.interseccion(frances);
        cad.append(inglesYFrances.iterator().next());
        return cad.toString();
    }
    
    public static int numIngles(ConjuntoA<String> ingles){
        return ingles.getCardinalidad();
    }
    
    public static String AlMenos3Idiomas(ConjuntoA<String> ingles, ConjuntoA<String> frances, ConjuntoA<String> otros){
        StringBuilder cad = new StringBuilder();
        ConjuntoADT<String> conjInter;
        conjInter = ingles.interseccion(frances).interseccion(otros);
        cad.append(conjInter.iterator().next());
        return cad.toString();
    }
    
    public static void main(String[] args) {
        ConjuntoA<String> ingles = new ConjuntoA();
        ConjuntoA<String> frances = new ConjuntoA();
        ConjuntoA<String> otros = new ConjuntoA();
        
        if(creaConjuntos("Encuesta", ingles, frances, otros)){
            System.out.println(ingles.toString());
            System.out.println(frances.toString());
            System.out.println(otros.toString());
            System.out.println(inglesYFrances(ingles, frances));
            System.out.println(numIngles(ingles));
            System.out.println(AlMenos3Idiomas(ingles, frances, otros));
        }
        
    }
}
