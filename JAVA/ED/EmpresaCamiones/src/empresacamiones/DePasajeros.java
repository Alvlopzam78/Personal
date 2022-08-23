/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresacamiones;

/**
 *
 * @author Alvlopzam
 */

public class DePasajeros extends Camion{
    private int totPasajeros;
    
    public DePasajeros(){
        super();
    }
    
    public DePasajeros(String marca, String numMotor, String placas, int totPasajeros){
        super(marca, numMotor, placas);
        this.totPasajeros = totPasajeros;
    }
    
    public DePasajeros(String placa){
        super(placa);
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        
        cad.append("\nCamion de pasajeros");
        cad.append(super.toString());
        cad.append("\nTotal de pasajeros: ").append(totPasajeros);
        return cad.toString();
    } 
}
