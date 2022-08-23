/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresacamiones;

/**
 *
 * @author Alvlopzam
 */
public abstract class Camion {
    private String marca;
    private String numMotor;
    private String placas;
    
    public Camion(){
        
    }
    
    public Camion(String marca, String numMotor, String placas){
        this.marca = marca;
        this.numMotor = numMotor;
        this.placas = placas;
    }
    
    public Camion(String placa){
        this.placas = placa;
    }
    
    public String getMarca(){
        return this.marca;
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        
        cad.append("\nCamion de marca:     ").append(marca);
        cad.append("\nCon número de motor: ").append(numMotor);
        cad.append("\nCon placas:          ").append(placas);
        return cad.toString();
    }
    
    public boolean equals(Object obj){
        boolean res = false;
        
        if(obj!=null && obj instanceof Camion)
            res = this.placas == ((Camion) obj).placas;
        return res;
    }
}
