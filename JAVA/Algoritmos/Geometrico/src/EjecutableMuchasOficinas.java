import java.util.Scanner;

/*Alvaro L
 * 13 sept 2021
 * Código que funciona para n oficinas con k tapetes
 */
public class EjecutableMuchasOficinas {

	public static void main(String[] args) {
		int n,k;
		double areaTot, areaTap, base, altura, rad; 
		Rectangulo rec;
		Circulo cir;
		Scanner lec;
		
		lec=new Scanner(System.in);
		areaTot=0;
		System.out.println("¿Cuántas oficinas son?");
		n=lec.nextInt();
		for(int i=1;i<=n;i++) {
			System.out.println("Dame la base y la altura de la oficina "+i);
			base=lec.nextDouble();
			altura=lec.nextDouble();
			rec=new Rectangulo(base,altura);
			System.out.println("Cuántos tapetes tiene la oficina "+i);
			k=lec.nextInt();
			areaTap=0;
			for(int x=1;x<=k;x++) {
				System.out.println("Dame el radio del tapete "+x);
				rad=lec.nextDouble();
				cir=new Circulo(rad);
				areaTap+=cir.calculaArea();
			}
			areaTot+=rec.calculaArea()-areaTap;
		}
		System.out.println("El area total descubierta es "+areaTot);
	}
}
