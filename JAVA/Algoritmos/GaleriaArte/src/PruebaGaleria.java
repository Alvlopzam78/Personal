import java.util.ArrayList;
import java.util.Scanner;

/* Alvaro Lopez
 * 10 oct 2021
 * Clase con main que prueba los metodos de la clase galeria
 */

public class PruebaGaleria {

	public static void main(String[] args) {
		Galeria galeria;
		Scanner lec = new Scanner(System.in);
		int n, aho, n1, n2;
		double precio;
		String pintura, pintor, tecnica, nombre;
		boolean alta;
		ArrayList<String> resConsulta;
		
		System.out.println("¿Cuantas pinturas vas a registrar?");
		n = lec.nextInt();
		galeria = new Galeria("Coronel Arroyo",24571112,n);
		
		for(int i=1;i<=n;i++) {
			System.out.println("Nombre de la pintura " + (i));
			pintura=lec.next();
			System.out.println("Pintor de la pintura " + (i));
			pintor=lec.next();
			System.out.println("Precio de la pintura " + (i));
			precio=lec.nextDouble();
			System.out.println("Tecnica de la pintura " + (i));
			tecnica=lec.next();
			System.out.println("Aho de la pintura " + (i));
			aho=lec.nextInt();
			alta = galeria.altaPintura(pintura, pintor, precio, tecnica, aho);
			System.out.println(alta);
		}
		
		System.out.println("Indica el nombre del pintor y la tecnica que desees buscar");
		pintor=lec.next();
		tecnica=lec.next();
		resConsulta = galeria.consultaPintorTecnica(pintor, tecnica);
		if(resConsulta != null)
			System.out.println(resConsulta.toString());
		else
			System.out.println("No hay obras que cumplan con las condiciones de la consulta");
		
		System.out.println("Indica el precio que deseas consultar");
		precio=lec.nextInt();
		System.out.println(galeria.consultaPorPrecio(precio));
		
		System.out.println("El promedio de tus pinturas es: " + galeria.precioPromVenta());
		
		System.out.println("La pintura más barata es: " + galeria.pinturaMasBarata());
		
		System.out.println("¿Qué tecnica deseas consultar?");
		tecnica=lec.next();
		System.out.println(galeria.cuantosTecnica(tecnica));
		
		System.out.println("Indica los limites del rango (en orden) de precios que deseas consultar");
		n1=lec.nextInt();
		n2=lec.nextInt();
		System.out.println(galeria.cuantasPinturasEnRango(n1, n2));
		
		System.out.println(galeria.toString());
		
		System.out.println("Indica el nombre de la pintura que vas a vender");
		nombre = lec.next();
		System.out.println(galeria.unaVenta(nombre));
		
		System.out.println(galeria.toString());
	}

}
