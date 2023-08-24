/*Alvaro L
 * 13 sept 2021
 * Clase que describe a un cientifico matematico
 */
public class Cientifico {
	private String nombre;
	private String areaEspecialidad;
	private int anioNacimiento;
	
	public Cientifico() {
		
	}
	
	public Cientifico(String nombre,String areaEspecialidad,int anioNacimiento) {
		this.nombre=nombre;
		this.areaEspecialidad=areaEspecialidad;
		this.anioNacimiento=anioNacimiento;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getAreaEspecialidad() {
		return areaEspecialidad;
	}
	
	public int getAnioNacimiento() {
		return anioNacimiento;
	}
	
	public void setAreaEspecialidad(String nuevaArea) {
		this.areaEspecialidad=nuevaArea;
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("\nCientífico "+nombre);
		cad.append(" con  especialidad en "+areaEspecialidad);
		cad.append(" nacido en "+anioNacimiento);
		return cad.toString();
	}
	
	public int compareTo(Cientifico otro) {
		int res;
		
		if(this.nombre.equals(otro.nombre))
			res=0;
		else
			if(this.nombre.compareTo(otro.nombre)>0)
				res=1;
			else
				res=-1;
		return res;
	}
	
	public boolean equals(Cientifico otro) {
		boolean res;
		
		if(this.nombre.equals(otro.nombre))
			res=true;
		else
			res=false;
		return res;
	}
	
	public boolean estaOrdenCreciente(int numero1, int numero2) {
		boolean res=false;
		
		if(numero1<numero2)
			res=true;
		return res;
	}
	
	public String ordenaCreciente(int numero1, int numero2) {
		StringBuilder cad = new StringBuilder();
		
		if(numero1<numero2) {
			cad.append(numero1);
			cad.append("-");
			cad.append(numero2);
		}
		else {
			cad.append(numero2);
			cad.append("-");
			cad.append(numero1);
		}
		return cad.toString();
	}
	
	public boolean esImpar(int numero) {
		boolean res;
		
		if(numero%2==0)
			res=false;
		else
			res=true;
		return res;
	}
	
	public double calculaFuncion1(double x) {
		double res;
		
		if(x<=11)
			res=3*x+36;
		else
			if(x<=33)
				res=x*x-10;
			else
				if(x<=64)
					res=x+6;
				else
					res=0;
		return res;
	}
	
	public double calculaFuncion2(int x) {
		double res = 0;
		
		switch(x%4) {
		case 0: res=x*x;
			break;
		case 1: res=x/6.0;
			break;
		case 2: res=Math.sqrt(x);
			break;
		case 3: res=Math.pow(x,3)+5;
		}
		return res;
	}
	
	public double calculaFuncion3(int num,int v) {
		double res;
		
		switch(num) {
		case 1: res=100*v;
			break;
		case 2: res=Math.pow(100, v);
			break;
		case 3: res=100.0/v;
			break;
		default: res=0;
		}
		return res;
	}
}
