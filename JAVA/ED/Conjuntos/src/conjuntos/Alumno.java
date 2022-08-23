/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conjuntos;

/**
 *
 * @author Alvlopzam
 */
public class Alumno {
    private int clave;
    private double promedio;
    private String nom;

    public Alumno(){
        
    }
    
    public Alumno(int clave, double promedio, String nom) {
        this.clave = clave;
        this.promedio = promedio;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Alumno{" + "clave=" + clave + ", promedio=" + promedio + ", nom=" + nom + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        return this.clave == other.clave;
    }

    public double getPromedio() {
        return promedio;
    }
    
    
}
