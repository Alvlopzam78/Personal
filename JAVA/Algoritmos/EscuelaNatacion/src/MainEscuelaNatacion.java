import java.util.Scanner;

/*Alvaro Lopez
 * 04 oct 2021
 * Clase con metodo main que prueba la clase EscuelaNatacion
 */
public class MainEscuelaNatacion {
	
	public static final int PRECIO_METRO_CUADRADO = 1000;

	public static void main(String[] args) {
		EscuelaNatacion escuela1;
		int n;
		double largo, ancho, areaTotal, precioTotal;
		boolean alta;
		Scanner lec = new Scanner(System.in);
		
		n=lec.nextInt();
		escuela1 = new EscuelaNatacion("Nelson Vargas", "San Bernabe 948",n);
		
		for(int i=0;i<n;i++) {
			largo=lec.nextDouble();
			ancho=lec.nextDouble();
			alta = escuela1.altaAlberca(largo, ancho);
			System.out.println(alta);
		}
		
		areaTotal = escuela1.areaTotal();
		precioTotal = PRECIO_METRO_CUADRADO*areaTotal;
		
		System.out.println(precioTotal);
		
		System.out.println(escuela1.toString());
	}

}
