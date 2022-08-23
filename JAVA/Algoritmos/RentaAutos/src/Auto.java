/* Alvaro Lopez
 * 19 sept 2021
 * Clase que modela la realidad de un auto en una compañia de renta de autos
 */
public class Auto {
	private int claveUnica;
	private String marca;
	private int anio;
	private double numKM;
	private String nomCliente;
	private int numLic;
	private static int consecutivoClaveUnica=1010; //No olvidar poner en UML
	
	public Auto() {
		claveUnica=consecutivoClaveUnica;
		consecutivoClaveUnica+=1010;
		nomCliente="Disponible";
		numLic=0;
	}
	
	public Auto(String marca, int anio, double numKM) {
		this();
		this.marca=marca;
		this.anio=anio;
		this.numKM=numKM;
	}
	
	public int getClaveUnica() {
		return claveUnica;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public int getAnio() {
		return anio;
	}
	
	public double getNumKM() {
		return numKM;
	}
	
	public String getNomCliente() {
		return nomCliente;
	}
	
	public int getNumLic() {
		return numLic;
	}
	
	public double renta(String nomCliente, int numLic, int dias) {
		double renta=0;
		
		this.nomCliente=nomCliente;
		this.numLic=numLic;
		if (anio<2005)
			renta=dias*200;
		else
			renta=dias*300;
		if (numKM<20000)
			renta+=dias*20;
		return renta;
	}
	
	public void devolucion(double recorridoKM) {
		nomCliente="Disponible";
		numLic=0;
		numKM+=recorridoKM;
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("\nAuto con clave unica: "+claveUnica);
		cad.append("\n               Marca: "+marca);
		cad.append("\n                Anio: "+anio);
		cad.append("\n          Kilometros: "+numKM);
		cad.append("\n         Rentado por: "+nomCliente);
		cad.append("\n            Licencia: "+numLic);
		
		return cad.toString();
	}
	
	public int compareTo(Auto otro) {
		int res;
		
		if(this.claveUnica==otro.claveUnica)
			res=0;
		else
			if(this.claveUnica<otro.claveUnica)
				res=1;
			else
				res=-1;
		return res;
	}
	
	public boolean equals(Auto otro) {
		boolean res;
		
		if(this.claveUnica==otro.claveUnica)
			res=true;
		else
			res=false;
		return res;
	}

}
