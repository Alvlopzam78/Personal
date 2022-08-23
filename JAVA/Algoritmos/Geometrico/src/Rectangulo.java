/* Alvaro Lopez Zamora
 * 11 sept 2021
 * Describir una figura geometrica con forma de rectangulo
 */
public class Rectangulo {
	private double base;
	private double altura;
	
	public Rectangulo() {
		
	}
	
	public Rectangulo(double base, double altura) {
		this.base=base;
		this.altura=altura;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public double getBase() {
		return base;
	}
	
	public void setAltura(double altura) {
		this.altura=altura;
	}
	
	public void setBase(double base) {
		this.base=base;
	}
	
	public double calculaArea() {
		double a;
		
		a=base*altura;
		return a;
	}
	
	public double calculaPerimetro() {
		double p;
		
		p=2*base+2*altura;
		return p;
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("\nRectangulo con altura: "+altura);
		cad.append(" y con base: "+base);
		return cad.toString();
	}
	
	public int compareTo(Rectangulo otro) {
		int res;
		
		if(this.calculaArea()==otro.calculaArea()) 
			res=0;
		else
			if(this.calculaArea()>otro.calculaArea()) 
				res=1;
			else
				res=-1;
		return res;
		}
	
	public boolean equals(Rectangulo otro) {
		boolean res;
		
		if(this.calculaArea()==otro.calculaArea())
			res=true;
		else
			res=false;
		return res;
	}
}

