/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

import java.util.Iterator;

/**
 *
 * @author Alvlopzam
 */
public class MateriaSemestre{
    private String nombreMateria;
    private String salon;
    private int semestre;
    private String maestro;
    private ListaOrdenada<Alumno> alumnos;
    private ListaOrdenada<Libro> bibliografia;

    public MateriaSemestre(String nombreMateria, String salon, int semestre, String maestro) {
        this.nombreMateria = nombreMateria;
        this.salon = salon;
        this.semestre = semestre;
        this.maestro = maestro;
        alumnos = new ListaOrdenada<Alumno>();
        bibliografia = new ListaOrdenada<Libro>();
    }
    
    public Alumno bajaAlumno(int claveUnica){
        Alumno al = new Alumno(claveUnica);
        
        return alumnos.quita(al);
    }
    
    public String altaAlumno(String nombre, int claveUnica, int calificacion){
        Alumno al = new Alumno(nombre, claveUnica, calificacion);
        String res;
        
        if(alumnos.contiene(al))
            res = "Alumno ya registrado";
        else{
            alumnos.agrega(al);
            res = "Registro exitoso";
        }
        return res;
    }

    public void cambioSalon(String salon) {
        this.salon = salon;
    }
    
    public String agregaLibro(String autor, String titulo, int clave){
        Libro lib = new Libro(autor, titulo, clave);
        String res;
        
        if(bibliografia.contiene(lib))
            res = "Libro ya registrado";
        else{
            bibliografia.agrega(lib);
            res = "Registro exitoso";
        }
        return res;
    }
    
    public Libro bajaLibro(int clave){
        Libro lib = new Libro(clave);
        
        return bibliografia.quita(lib);
    }
    
    public double promAlumnos(){
        int n = 0;
        double suma = 0;
        
        for(Alumno al: alumnos){
            suma += al.getCalificacion();
            n += 1;
        }
        return suma/n;
    }
    
    public String consultaAlumno(int clave){
        Alumno al = new Alumno(clave);
        Alumno al2 = null;
        Iterator<Alumno> it = alumnos.iterator();
        String res = null;
        
        if(!alumnos.estaVacia()){
            al2 = it.next();
            while(it.hasNext() && al2.compareTo(al) < 0)
                al2 = it.next();
            if(al2.equals(al))
                res = al2.toString();
        }
        return res;
    }
    
    public boolean arribaProm(int n, double prom){
        Iterator<Alumno> it = alumnos.iterator();
        int i = 0;
        boolean res = false;
        
        while(it.hasNext() && i<n)
            if(it.next().getCalificacion()>prom)
                i++;
        if(i==n)
            res = true;
        return res;
    }
    
    public int librosDe(String autor){
        Iterator<Libro> it = bibliografia.iterator();
        int i = 0;
        
        while(it.hasNext())
            if(it.next().getAutor().equals(autor))
                i++;
        return i;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public String getSalon() {
        return salon;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getMaestro() {
        return maestro;
    }
    
    
}
