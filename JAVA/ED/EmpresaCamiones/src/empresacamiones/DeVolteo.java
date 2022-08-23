/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresacamiones;

/**
 *
 * @author Alvlopzam
 */

public class DeVolteo extends Camion{
    private double capacidadTon;
    
    public DeVolteo(){
        super();
    }
    
    public DeVolteo(String marca, String numMotor, String placas, double capacidadTon){
        super(marca, numMotor, placas);
        this.capacidadTon = capacidadTon;
    }
    
    public DeVolteo(String placa){
        super(placa);
    }
    
    public void setCapacidadTon(double nuevaCap){
        this.capacidadTon = nuevaCap;
    }
    
    public double getCapTon(){
        return this.capacidadTon;
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        
        cad.append("\nCamion de volteo");
        cad.append(super.toString());
        cad.append("\nCapacidad de Toneladas: ").append(capacidadTon);
        return cad.toString();
    }
}
