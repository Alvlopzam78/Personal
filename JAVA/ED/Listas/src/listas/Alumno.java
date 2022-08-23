/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

/**
 *
 * @author Alvlopzam
 */
public class Alumno implements Comparable<Alumno>{
    private String nombre;
    private int claveUnica;
    private int calificacion;

    public Alumno(String nombre, int claveUnica, int calificacion) {
        this.nombre = nombre;
        this.claveUnica = claveUnica;
        this.calificacion = calificacion;
    }

    public Alumno(int claveUnica) {
        this.claveUnica = claveUnica;
    }

    public String getNombre() {
        return nombre;
    }

    public int getClaveUnica() {
        return claveUnica;
    }
    
    public int compareTo(Alumno otro){
        return this.claveUnica - otro.claveUnica;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getCalificacion() {
        return calificacion;
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
        return this.claveUnica == other.claveUnica;
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        
        cad.append("\nNombe del alumno: " + nombre);
        cad.append("\nClave unica: " + claveUnica);
        cad.append("\nCalificacion: " + calificacion);
        return cad.toString();
    }
}
