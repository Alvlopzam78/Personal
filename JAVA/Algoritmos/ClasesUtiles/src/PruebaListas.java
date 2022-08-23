import java.util.ArrayList;

/*Alvaro Lopez
 * 24 sept 2021
 * pruebas de funcionamiento de un ArrayList
 */
public class PruebaListas {
	public static void main(String[] args) {
		ArrayList<Double> lista;
		int pos;
		double elemento;
		
		lista = new ArrayList<Double>();
		
		System.out.println(lista.toString());
		
		lista.add(1.7);
		System.out.println(lista.toString());
		lista. add(3.6);
		System.out.println(lista.toString());
		lista.add(0,8.5);
		System.out.println(lista.toString());
		pos=lista.indexOf(9);
		System.out.println("posicion de 3.6: "+pos);
		System.out.println("Numero de celdas de la lista: "+lista.size());
		lista.remove(8.5);
		System.out.println(lista.toString());
		System.out.println(lista.isEmpty());
		System.out.println(lista.contains(9));
		elemento=lista.get(0);
		System.out.println(elemento);
		lista.clear();
		System.out.println(lista.toString());
		lista.add(0, 4.8);
		System.out.println(lista.toString());
		lista.add(2.8);
		System.out.println(lista.toString());
		lista.set(1, 3.2);
		System.out.println(lista.toString());
	}
	
}
