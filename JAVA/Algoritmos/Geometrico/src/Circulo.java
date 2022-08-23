/* Alvaro Lopez
 * 10 sept 2021
 * Describir una forma geometrica con forma de ciruclo
 */
public class Circulo {
	private double radio;
	
	public Circulo() {
		
	}
	
	public Circulo(double radio) {
		this.radio=radio;
	}
	
	public double getRadio() {
		return radio;
	}
	
	public void setRadio(double radio) {
		this.radio=radio;
	}
	
	public double calculaArea() {
		double a;
		
		// a=3.1416*radio*radio; Es correcto pero puede ser mejor
		a=Math.PI*Math.pow(radio, 2);
		return a;
	}
	
	public double circunferencia() {
		return Math.PI*2*radio; //Ambas opciones son correctas pero la primera es mas clara
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("\nCirculo con radio: "+radio);
		return cad.toString();
	}
	
	public int compareTo(Circulo otro) {
		int res;
		
		if(this.radio==otro.radio)
			res=0;
		else
			if(this.radio>otro.radio)
				res=1;
				else
					res=-1;
		return res;
	}
	
	public boolean equals(Circulo otro) {
		boolean res;
		
		if(this.radio==otro.radio)
			res=true;
		else
			res=false;
		return res;
	}
}
