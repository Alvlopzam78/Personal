/* ALvaro Lopez
 * 29 oct 2021
 * Prueba de Strings
 */
public class MainEntendiendoStrings {

	public static void main(String[] args) {
		String cadena = "Una frase con espacios, mayúsculas y minusculas...alguno acentos, etc...";
		String cad;
		
		System.out.println(cadena);
		if(cadena.contains("ú"))
			System.out.println("La cadena tiene un sub cadena ú");
		else
			System.out.println("La cadena NO tiene un sub cadena ú");
		System.out.println(cadena.toUpperCase());
		System.out.println(cadena);
		System.out.println(cadena.toLowerCase());
		cad = cadena.substring(0, 9);
		System.out.println(cad);
	}

}
