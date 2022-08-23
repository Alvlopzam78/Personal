import java.util.ArrayList;

/* Alvaro Lopez
 * 10 oct 2021
 * Clase que modela la realidad de una galeria con maximo 100 pinturas
 */

public class Galeria {
	private String nombre;
	private int telefono;
	private Pintura[] pinturas;
	private int totPinturas;
	private final int MAX = 100;
	
	public Galeria() {
		pinturas = new Pintura[MAX];
		totPinturas = 0;
	}
	
	public Galeria(String nombre, int telefono) {
		this();
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public Galeria(String nombre, int telefono, int numPinturas) {
		pinturas = new Pintura[numPinturas];
		totPinturas = 0;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public int getTotPinturas() {
		return totPinturas;
	}
	
	public String getUnaPintura(int indice) {
		String res;
		
		if(indice < totPinturas)
			res = pinturas[indice].toString();
		else
			res="Pintura no registrada";
		return res;
	}
	
	public String getUnaPinturaXNombre(String nombre) {
		String res;
		Pintura p = new Pintura(nombre);
		int i = 0;
		
		while(i < totPinturas && pinturas[i].compareTo(p)<0) {
			i++;
		}
		if(i==totPinturas || !pinturas[i].equals(p))
			res = "Pintura no registrada";
		else
			res = pinturas[i].toString();
		return res;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public boolean altaPintura(String nombre, String pintor, double precio, String tecnica, int aho) {
		int pos;
		boolean res = false;
		Pintura pintura;
		
		if(totPinturas < pinturas.length) {
			pintura = new Pintura(nombre, pintor, precio, tecnica, aho);
			pos=0;
			while(pos<totPinturas  && pinturas[pos].compareTo(pintura)<0) {
				pos++;
			}
			if(pos==totPinturas || !pinturas[pos].equals(pintura)) {
				for(int i=totPinturas; i>pos; i--)
					pinturas[i]=pinturas[i-1];
				pinturas[pos]=pintura;
				totPinturas++;
				res=true;
			}
		}
		return res;
	}
	
	public ArrayList<String> consultaPintorTecnica(String pintor, String tecnica){
		ArrayList<String> res = new ArrayList<String>();
		
		for(int i=0;i<totPinturas;i++) {
			if(pinturas[i].getPintor().equals(pintor) && pinturas[i].getTecnica().equals(tecnica))
				res.add(pinturas[i].toString());
		}
		if(res.isEmpty())
			res=null;
		return res;
	}
	
	public boolean consultaPorPrecio(double precio) {
		int i=0;
		boolean res;
		
		while(i < totPinturas && pinturas[i].getPrecio()>=precio) {
			i++;
		}
		if(i==totPinturas)
			res = false;
		else
			res = true;
		return res;
	}
	
	public double precioPromVenta() {
		double res;
		double suma = 0;
		
		for(int i=0; i<totPinturas;i++) {
			suma+=pinturas[i].getPrecio();
		}
		res = suma/totPinturas;
		return res;
	}
	
	public String pinturaMasBarata() {
		int posMin=0;
		
		for(int i=1;i<totPinturas;i++) {
			if(pinturas[i].getPrecio()<pinturas[posMin].getPrecio()) {
				posMin=i;
			}
		}
		return pinturas[posMin].toString();
	}
	
	public int cuantosTecnica(String tecnica) {
		int res=0;
		
		for(int i=0;i<totPinturas;i++) {
			if(pinturas[i].getTecnica().equals(tecnica))
				res++;
		}
		return res;
	}
	
	public int cuantasPinturasEnRango(int n1, int n2) {
		int res=0;
		
		for(int i=0; i<totPinturas;i++) {
			if(pinturas[i].getPrecio()>=n1 && pinturas[i].getPrecio()<=n2)
				res++;
		}
		return res;
	}
	
	public double unaVenta(String nombre) {
		double precio=-1;
		int pos;
		Pintura p = new Pintura(nombre);
		
		pos=0;
		while(pos<totPinturas && pinturas[pos].compareTo(p)<0) {
			pos++;
		}
		if(pos<totPinturas && pinturas[pos].equals(p)) {
			precio = pinturas[pos].getPrecio();
			for(int i=pos; i<totPinturas-1; i++)
				pinturas[i]=pinturas[i+1];
			totPinturas--;
			pinturas[totPinturas] = null;
		}
		return precio;
	}
	
	public int compareTo(Galeria otra) {
		int res = -1;
		
		if(this.nombre.equals(otra.nombre))
			res=0;
		else
			if(this.nombre.compareTo(otra.nombre)>0)
				res=1;
		return res;
	}
	
	public boolean equals(Galeria otra) {
		boolean res = false;
		
		if(this.nombre.equals(otra.nombre))
			res=true;
		return res;
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("\nGaleria:            " + nombre);
		cad.append("\nTelefono:           " + telefono);
		cad.append("\nNumero de pinturas: " + totPinturas);
		cad.append("\nPinturas: ");
		for(int i=0;i<totPinturas;i++) {
			cad.append(pinturas[i].toString()+"\n");
		}
		return cad.toString();
	}
}



