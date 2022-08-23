/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresacamiones;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alvlopzam
 */

public class EmpresaMinera implements Serializable{
    private String nomEmpresa;
    private Camion[] camiones;
    private int totCamiones;
    private final int MAX_CAMIONES = 50;
    
    public EmpresaMinera(){
        
    }
    
    public EmpresaMinera(String nomEmpresa){
        camiones = new Camion[MAX_CAMIONES];
        totCamiones = 0;
        this.nomEmpresa = nomEmpresa;
    }
    
    //alta camiones de pasajeros
    public boolean altaCamion(String marca, String numMotor, String placas, int totPasajeros){
        boolean res = false;
        
        if(totCamiones < MAX_CAMIONES){
            camiones[totCamiones] = new DePasajeros(marca, numMotor, placas, totPasajeros);
            totCamiones++;
            res = true;
        }
        return res;
    }
    
    //alta camiones de volteo
        public boolean altaCamion(String marca, String numMotor, String placas, double capTon){
        boolean res = false;
        
        if(totCamiones < MAX_CAMIONES){
            camiones[totCamiones] = new DeVolteo(marca, numMotor, placas, capTon);
            totCamiones++;
            res = true;
        }
        return res;
    }
    
    //Reporte camiones de pasajero
    public String repCamionesPasajeros(){
        StringBuilder cad = new StringBuilder();
        
        for(int i = 0; i <totCamiones; i++)
            if(camiones[i] instanceof DePasajeros)
                cad.append(((DePasajeros)camiones[i]).toString());
        return cad.toString();
    }
    
    //Actualizar capacidad de un camion de volteo dada la placa
    public boolean updateCap(String placa, double nuevaCap){
        boolean res = false;
        DeVolteo camionAux = new DeVolteo(placa);
        int i = 0;
        
        while(i<totCamiones && !camiones[i].equals(camionAux))
            i++;
        if(i<totCamiones && camiones[i] instanceof DeVolteo){
            ((DeVolteo) camiones[i]).setCapacidadTon(nuevaCap);
            res = true;
        }
        return res;
    }
    
    //Total de camiones de pasajeros de cierta marca
    public int dePasajerosMarca(String marca){
        int cont = 0;
        
        for(int i=0; i<totCamiones; i++){
            if(camiones[i] instanceof DePasajeros && camiones[i].getMarca().equals(marca))
                cont++;    
        }
        return cont;
    }
    
    //Total de toneladas que puede ser transportado
    public double totTon(){
        double cont = 0;
        
        for(int i=0; i<totCamiones;i++)
            if(camiones[i] instanceof DeVolteo)
                cont+= ((DeVolteo) camiones[i]).getCapTon();
        return cont;
    }
    
    //guardamos todo en un archivo
    public void guardaEnArchivo(){
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("EmpresaMinera.obj"));
            for(int i=0;i<totCamiones;i++){
                salida.writeObject(camiones[i]);
            }
            salida.close();
        } catch (IOException ex) {
            
        }   
    }
    
}
