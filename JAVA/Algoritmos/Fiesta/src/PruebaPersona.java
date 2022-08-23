/* Alvaro Lopez
 * 29 oct 2021
 * Clase persona
 */
public class PruebaPersona {

	public static void main(String[] args) {
		Persona p1, p2;
		
		p1 = new Persona("loza011107hdfpmla4", "Alvaro", "soltero");
		System.out.println(p1.toString());
		System.out.println(p1.calculaEdad());

	}

}
