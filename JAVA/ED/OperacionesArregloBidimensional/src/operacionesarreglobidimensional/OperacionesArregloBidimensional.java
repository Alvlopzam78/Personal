/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operacionesarreglobidimensional;

/**
 *
 * @author Alvlopzam
 */
public class OperacionesArregloBidimensional {

    public static double sumaPorRenglon(double[][] mat, int n, int m){
        
    }
    
    
    
    public static double sumaPorColumna(){
        
    }
    
    public String toString(){
        
    }
    
    public static double sumaDiagonalPrincipal(double [][] mat, int n){
        if(n>0)
            return mat[n-1][n-1]+sumaDiagonalPrincipal(mat, n-1);
        else
            return 0;
    }
    
    public static double[][] sumaMatrices(){
        
    }
    
    public static double[][] multiplicaMatrices(){
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
