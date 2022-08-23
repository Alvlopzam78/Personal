/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

/**
 *
 * @author Alvlopzam
 */
public class Libro implements Comparable<Libro>{
    private String autor;
    private String titulo; 
    private int clave;

    public Libro(String autor, String titulo, int clave) {
        this.autor = autor;
        this.titulo = titulo;
        this.clave = clave;
    }

    public Libro(int clave) {
        this.clave = clave;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public int compareTo(Libro otro){
        return this.clave - otro.clave;
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
        final Libro other = (Libro) obj;
        return this.clave == other.clave;
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        
        cad.append("\nTitulo del libro: " + titulo);
        cad.append("\nAutor: " + autor);
        cad.append("\nClave: " + clave);
        return cad.toString();
    }
}
