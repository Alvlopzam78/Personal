/* Alvaro Lopez Zamora
 * 13 sept 2021
 * Programa que calcula el espacio ocuapdo por 3 mesas rectangulares
 */
public class EjecutableMesas {

	public static void main(String[] args) {
		Rectangulo m1, m2, m3;
		double area;
		
		m1=new Rectangulo(2,1.8);
		m2=new Rectangulo(1,1.5);
		m3=new Rectangulo(3,2);
		area=m1.calculaArea()+m2.calculaArea()+m3.calculaArea();
		System.out.println("Area ocupada por las mesas: "+area);
		System.out.println();
	}

}
