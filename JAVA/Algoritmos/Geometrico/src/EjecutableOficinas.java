import java.util.Scanner;

/* Alvaro Lopez Zamora
 * 11 sept 2021
 * Codigo que calcula el area de una oficina con tapetes circulares 
 */
public class EjecutableOficinas {

	public static void main(String[] args) {
		Rectangulo r;
		Circulo c1,c2,c3;
		double base, altura, r1, r2, r3, areaRect, areaC1, areaC2, areaC3, areaCT, areaT;
		Scanner lec;
		
		lec=new Scanner(System.in);
		base=lec.nextDouble();
		altura=lec.nextDouble();
		r1=lec.nextDouble();
		r2=lec.nextDouble();
		r3=lec.nextDouble();
		r=new Rectangulo(base,altura);
		c1=new Circulo(r1);
		c2=new Circulo(r2);
		c3=new Circulo(r3);
		areaRect=r.calculaArea();
		areaC1=c1.calculaArea();
		areaC2=c2.calculaArea();
		areaC3=c3.calculaArea();
		areaCT=areaC1+areaC2+areaC3;
		areaT=areaRect-areaCT;
		System.out.println(areaT);
	}
}
