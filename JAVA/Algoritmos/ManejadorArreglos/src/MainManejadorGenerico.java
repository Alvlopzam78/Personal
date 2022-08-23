/* Alvaro Lopez
 * 29 oct 2021
 * Main para el manejador generico
 */
public class MainManejadorGenerico {

	public static void main(String[] args) {
		String[] a = {"Alvaro", "Laura", "Javier", "Glenna"};
		int pos;
		
		pos = ManejadorArreglosGenerico.busBinaria(a, a.length, "Laura");
		System.out.println(pos);
	}
}
