/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodosrecursivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Alvlopzam
 */
public class MetodosRecursivos {
    public static int calculaFactorial(int n) {
        if(n==0 || n==1)
            return 1;
        else
            return n * calculaFactorial(n-1);
    }

    public static int sumaElementos(int [] a, int total) {
        if(total == 0)
            return 0;
        else
            return a[total-1] + sumaElementos(a,total-1);
    }

    public static void imprimeArrDer(int [] a, int total) {
        if(total>0){
            System.out.print(a[total-1] + "\t");
            imprimeArrDer(a,total-1);
        }
    }

    public static void imprimeArrIzq(int [] a, int total) {
        imprimeArrIzq(a,total,0);
    }

    private static void imprimeArrIzq(int [] a, int total, int index){
        if(total>index) {
            System.out.print(a[index] + "\t");
            imprimeArrIzq(a,total,index+1);
        }
    }

    public static void imprimeArrIzq2(int [] a, int total) {
        if(total>0) {
            imprimeArrIzq2(a, total-1);
            System.out.print(a[total-1] + "\t");
        }
    }
    
    public static int cuentaPalabras(String nomArch){
        try(Scanner lec = new Scanner(new File(nomArch))){
            return leeArch(lec,0);
        }catch(FileNotFoundException fnfe){
            return -1;
        }
    }
    
    private static int leeArch(Scanner lec, int tot){
        if(lec.hasNext()){
            lec.next();
            return leeArch(lec,tot+1);
        }
        else{
            return tot;
        }
    }
    
    public static int calculaFibonacci(int n){
        if(n == 0 || n == 1)
            return n;
        else
            return calculaFibonacci(n-1) + calculaFibonacci(n-2);
    }
    
    public static void torresDeHanoi(String origen, String destino, String aux, int n){
        if(n==1)
            System.out.println("Mover de " + origen + " a " + destino);
        else{
            torresDeHanoi(origen, aux, destino, n-1);
            System.out.println("Mover 1 disco de " + origen + " a " + destino);
            torresDeHanoi(aux, destino, origen, n-1);
        }
    }
    
    public static <T> boolean arreglosInversos (T[] arr1, int t1, T[] arr2, int t2){
        if(t1==t2 && t1!=0)
            return comparaArreglos(arr1, arr2, t1, 0);
        else
            return false;
    }
    
    private static <T> boolean comparaArreglos(T[] arr1, T[] arr2, int t, int i){
        if(i<t)
            if(arr1[i].equals(arr2[(t-1)-i]))
                return comparaArreglos(arr1, arr2, t, i+1);
            else
                return false;
        else
            return true;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*int[] a = {1,2,3,4};
        
        System.out.println(calculaFactorial(4));
        System.out.println(sumaElementos(a,4));
        imprimeArrDer(a,4);
        System.out.println();
        imprimeArrIzq(a,4);
        System.out.println();
        imprimeArrIzq2(a,4);*/
        
        //System.out.println(cuentaPalabras("colores"));
        //System.out.println(calculaFibonacci(4));
        //torresDeHanoi("origen", "destino", "aux", 4);
        
        Integer[] a = {1,2,3,4,5,6,7,8,9};
        Integer[] b = {9,8,7,6,5,4,3,2,1};
        
        System.out.println(arreglosInversos(a,9,b,9));
                
        
        
    }
    
}
