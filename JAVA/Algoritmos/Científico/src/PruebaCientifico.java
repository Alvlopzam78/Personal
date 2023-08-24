/* Alvaro L
 * 17 sept 2021
 * Codigo que preuba la clase cientifico
 */

public class PruebaCientifico {

	public static void main(String[] args) {
		Cientifico c1, c2;
		
		c1=new Cientifico("Alvaro","Matematicas",2001);
		System.out.print(c1.toString());
		
		c2=new Cientifico("Pep","Fisica",2004);
		System.out.println(c2.toString());
		
		int compare = c2.compareTo(c1);
		System.out.println(compare);
		
		boolean equals = c1.equals(c2);
		System.out.println(equals);
		
		c2.setAreaEspecialidad("Quimica");
		System.out.println(c2.toString());
		
		String noombre = c1.getNombre();
		System.out.println(noombre);
		
		boolean ej7 = c1.estaOrdenCreciente(21, 22);
		System.out.println(ej7);
		
		String ej8 = c2.ordenaCreciente(26, 23);
		System.out.println(ej8);
		
		boolean ej9 = c1.esImpar(5);
		System.out.println(ej9);
		
		double funcion1 = c1.calculaFuncion1(100);
		System.out.println(funcion1);
		
		double funcion2 = c2.calculaFuncion2(9);
		System.out.println(funcion2);
		
		double funcion3 = c1.calculaFuncion3(4, 2);
		System.out.println(funcion3);
	}

}
