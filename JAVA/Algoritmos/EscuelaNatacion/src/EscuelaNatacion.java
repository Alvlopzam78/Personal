/*Alvaro Lopez
 * 04 oct 2021
 * Clase que modela la realidad de una escuela de natacon con albercas rectangulares
 */
public class EscuelaNatacion {
	private String nombre;
	private String domicilio;
	private int numAlbercas;
	private Rectangulo[] albercas;
	private final int MAX_ALBERCAS = 10;
	
	public EscuelaNatacion() {
		numAlbercas = 0;
		albercas = new Rectangulo[MAX_ALBERCAS];
	}
	
	public EscuelaNatacion(String nombre, String domicilio) {
		this();
		this.nombre = nombre;
		this.domicilio = domicilio;
	}
	
	public EscuelaNatacion(String nombre, String domicilio, int num) {
		numAlbercas = 0;
		albercas = new Rectangulo[num];
		this.nombre = nombre;
		this.domicilio = domicilio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public int getNumAlbercas() {
		return numAlbercas;
	}
	
	public String getUnaAlberca(int numAlberca) {
		String res;
		
		if(numAlberca < numAlbercas)
			res = albercas[numAlberca-1].toString();
		else
			res="Alberca no registrada";
		return res;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public boolean altaAlberca(double largo, double ancho) {
		boolean res = false;
		Rectangulo alberca;
		
		if(numAlbercas < albercas.length) {
			alberca = new Rectangulo(largo, ancho);
			albercas[numAlbercas] = alberca;
			numAlbercas++;
			res = true;
		}
		return res;
	}
	
	public double areaTotal() {
		double sumaArea = 0;
		
		for(int i=0;i<numAlbercas;i++) {
			sumaArea+=albercas[i].calculaArea();
		}
		return sumaArea;
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("\nEscuela de Natacion");
		cad.append("\nNombre:             " + nombre);
		cad.append("\nDomicilio:          " + domicilio);
		cad.append("\nNumero de Albercas: " + numAlbercas);
		cad.append("\nDimensiones de las albercas: ");
		for(int i=0;i<numAlbercas;i++) {
			cad.append(albercas[i]);
		}
		return cad.toString();
	}
	
	public int compareTo(EscuelaNatacion otra) {
		int res = -1;
		
		if(this.nombre.equals(otra.nombre))
			res = 0;
		else 
			if(this.nombre.compareTo(otra.nombre)>0)
				res=1;
		return res;
	}
	
	public boolean equals(EscuelaNatacion otra) {
		boolean res = false;
		
		if(this.nombre.equals(otra.nombre))
			res=true;
		return res;
	}
}
