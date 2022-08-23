import java.util.Scanner;

/*Alvaro Lopez
 * 29 sept 2021
 * Programa que prueba los metodos de la clase Compania
 */
public class PruebaCompania {

	public static void main(String[] args) {
		Compania c1;
		Scanner lec = new Scanner(System.in);
		//String nombre, direccion, ciudad, director;
		double venta;
		int n;
		
		/*nombre=lec.next();
		direccion=lec.next();
		ciudad=lec.next();
		director=lec.next();
		*/
		
		c1=new Compania("Empaques S.A de C.V", "Constitucion 42", "Querétaro", "Sr. Perez", 1000);
		
		n = lec.nextInt();
		
		for(int i=1;i<=n;i++) {
			boolean res;
			
			venta=lec.nextDouble();
			res = c1.altaVenta(venta);
			System.out.println(res);
		}
		
		System.out.println("\npromedio: " + c1.promedioVentas());
		System.out.println("Mes con más ventas " + c1.mesMayVentas());
		System.out.println("Mes con menos ventas " + c1.mesMenVentas());
		System.out.println("Numero de meses arriba del promedio: " + c1.cuantosArribaPromedio());
		System.out.println("Monto total de ventas: " + c1.totalMontoVentas());
		
		System.out.println(c1.toString());
	}
}
