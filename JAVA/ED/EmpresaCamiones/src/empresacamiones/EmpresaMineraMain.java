/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package empresacamiones;

/**
 *
 * @author Alvlopzam
 */

public class EmpresaMineraMain {

    /**
     * @param args the command line arguments
     */
        public static int calculaFactorial(int n){
        if(n==0 || n==1)
            return 1;
        else 
            return n * calculaFactorial(n-1);
    }
        
    public static void main(String[] args) {
       EmpresaMinera empresa = new EmpresaMinera("ALZ");
       
       /* System.out.println(empresa.altaCamion("Honda", "213", "ABC234", 6.7));
        System.out.println(empresa.altaCamion("Honda", "567", "BGH789", 3.0));
        System.out.println(empresa.altaCamion("Mercedes", "765", "HGK543", 21.6));
        
        System.out.println(empresa.altaCamion("Honda", "912", "KJL876", 23));
        System.out.println(empresa.altaCamion("Mercedes", "345", "OLP912", 56));
        System.out.println(empresa.altaCamion("Mercedes", "891", "YUI459", 34));
        
        System.out.println(empresa.repCamionesPasajeros());
        System.out.println(empresa.updateCap("ABC234", 10.7));
        System.out.println(empresa.dePasajerosMarca("Mercedes"));
        System.out.println(empresa.totTon());
        empresa.guardaEnArchivo();*/
        
        System.out.println(calculaFactorial(4));
    }
    
}
