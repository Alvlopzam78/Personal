import java.util.Scanner;

/* Álvaro
 * 8 sept 2021
 * Primer código en Java que convierte pesos a dolares
 */
public class EjecutableConversionDlls {

	public static void main(String[] args) {
		double pesos,dlls;
		Scanner lec;
		
		lec=new Scanner(System.in);
		System.out.println("Dame la cantidad en pesos a convertir:");
		pesos=lec.nextDouble();
		dlls=pesos/20.19;
		System.out.println("La cantidad en dólares es "+dlls);
	}

}
