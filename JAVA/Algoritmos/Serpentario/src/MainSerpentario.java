import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Alvaro Lopez
 * 10 nov 2021
 * Clase que prueba los metodos de la clase Serpentario
 */

public class MainSerpentario {

	public static void main(String[] args) {
		Serpentario serpentario = new Serpentario("ALZ");
		File ent = new File("Serpientes.txt");
		String tipo, alimento;
		double longitud, peso;
		char genero;
		
		try(Scanner lec = new Scanner(ent);){
			while(lec.hasNext()){
				tipo=lec.next();
				longitud=lec.nextDouble();
				peso=lec.nextDouble();
				alimento=lec.next();
				genero=lec.next().charAt(0);
				if(serpentario.altaSerpiente(tipo, longitud, peso, alimento, genero))
					System.out.println("Alta existosa");
				else
					System.out.println("Error en alta");
			}
			lec.close();
			System.out.println(serpentario.toString());
			System.out.println();
			System.out.println("La serpiente con clave 120 es: " + serpentario.getUnaSerpiente(120));
			System.out.println("El numero de serpientes que comen ratones es: " + serpentario.cuentaPorAlimento("Ratones") + "\n");
			System.out.println("La serpiente dada de baja fue: " + serpentario.bajaSerpiente(130));
			System.out.println("El tipo con mas ejemplares es: " + serpentario.tipoMaxSerp());
			System.out.println();
			System.out.println(serpentario.toString());
			
		}
		
		catch(FileNotFoundException fnfe) {
			System.err.println("ERROR " + fnfe);
			System.exit(-1);
		}
	}

}
