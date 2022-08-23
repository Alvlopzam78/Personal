/* Alvaro Lopez
 * 10 oct 2021
 * Clase que modela la realidad de una pintura
 */

public class Pintura {
	private String nombre;
	private String pintor;
	private double precio;
	private String tecnica;
	private int aho;
	
	public Pintura() {
		
	}
	
	public Pintura(String nombre) {
		this.nombre = nombre;
	}
	
	public Pintura(String nombre, String pintor, double precio, String tecnica, int aho) {
		this.nombre = nombre;
		this.pintor = pintor;
		this.precio = precio;
		this.tecnica = tecnica;
		this.aho = aho;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getPintor() {
		return pintor;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public String getTecnica() {
		return tecnica;
	}
	
	public int getAho() {
		return aho;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int compareTo(Pintura otra) {
		int res = -1;
		
		if(this.nombre.equals(otra.nombre))
			res=0;
		else
			if(this.nombre.compareTo(otra.nombre)>0)
				res=1;
		return res;
	}
	
	public boolean equals(Pintura otra) {
		boolean res = false;
		
		if(this.nombre.equals(otra.nombre))
			res=true;
		return res;
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("\nPintura: " + nombre);
		cad.append(" Pintor:  " + pintor);
		cad.append(" Precio:  " + precio);
		cad.append(" Tecnica: " + tecnica);
		cad.append(" Aho:     " + aho);
		return cad.toString();
	}
}
