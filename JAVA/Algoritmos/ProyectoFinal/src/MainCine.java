import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Alvaro Lopez Zamora
 * 23 nov 2021
 * Clase con main que prueba los métodos de la clase Cine, SalaCine y Espectador
 */

public class MainCine {

	public static void main(String[] args) {
		Cine cine = new Cine("Cine ALZ", "Av. Vasco de Quiroga, 224");
		File ent = new File("cine.txt");
		String tipoSala, nombreEsp, asiento, alimento, pelicula;
		int numFilas, numCol, edad, n, numSala;
		
		try(Scanner lec = new Scanner(ent);){ //leemos el archivo
			while(lec.hasNext()){
				tipoSala = lec.next();
				numFilas = lec.nextInt();
				numCol = lec.nextInt();
				pelicula = lec.next();
				if(cine.altaSala(tipoSala, numFilas, numCol, pelicula))
					System.out.println("Alta de sala existosa");
				else
					System.out.println("Error en alta de sala");
				n = lec.nextInt(); //indica cuanto espectadores dara de alta
				for(int i=1;i<=n;i++) { //lo hace por cada espectador
					numSala = lec.nextInt();
					asiento = lec.next();
					nombreEsp = lec.next();
					edad = lec.nextInt();
					alimento = lec.next();
					if(cine.compraBoleto(numSala, asiento, nombreEsp, edad, alimento))
						System.out.println("Alta de espectador existosa");
					else
						System.out.println("Error en alta de espectador");
				}
			}
			lec.close(); //se debe cerrar el archivo
			
			//pruebas
			System.out.println(cine.getUnaSala(5));
			System.out.println(cine.bajaSala(2));
			System.out.println(cine.devuelveBoleto(1, "B13"));
			System.out.println(cine.getUnaSala(1));
			System.out.println(cine.compraAlimento(1,"C7","Palomitas"));
			System.out.println(cine.getEspectadorSala(1, "C7"));
			System.out.println(cine.salaMasLlena());
			System.out.println(cine.getEspectadorSala(1, "C1"));
			}
		
		catch(FileNotFoundException fnfe) {
			System.err.println("ERROR " + fnfe);
			System.exit(-1);
		}
	}

}
