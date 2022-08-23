import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Alvaro Lopez
 * 08 nov 2021
 * Clase con main que prueba los metodos de la clase CompaniaConMatriz
 */

public class MainCompania {

	public static void main(String[] args) {
		Compania comp = new Compania("ALZ");
		File ent = new File("Ventas2021.txt");
		String mes, depto;
		double venta;
		
		try(Scanner lec = new Scanner(ent);){
			while(lec.hasNext()) {
				mes = lec.next();
				depto = lec.next();
				venta = lec.nextDouble();
				if(comp.altaVenta(venta, mes, depto))
					System.out.println("Alta exitosa");
				else
					System.out.println("Error en alta");
			}
			lec.close();
			System.out.println(comp.toString());
			System.out.println("El mes con mas ventas del departamento Niños es:      " + comp.mesConMasVentas("Niños"));
			System.out.println("\nEl promedio de las ventas en Noviembre es:            " + comp.promVentasMes("Noviembre"));
			System.out.println("\nEl promedio de ventas del departamento Caballeros es: " + comp.promVentasDepto("Caballeros"));
			System.out.println("\n¿Hay un mes sin ventas? " + comp.mesSinVentas());	
		} 
		
		catch(FileNotFoundException fnfe) {
			System.err.println("ERROR " + fnfe);
			System.exit(-1);
		}
	
		
	}
}
