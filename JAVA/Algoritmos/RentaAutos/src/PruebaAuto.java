/*Alvaro Lopez
 * 19 sept 2021
 * Codigo que prueba la clase Auto
 */
public class PruebaAuto {

	public static void main(String[] args) {
		Auto auto1, auto2, auto3, auto4, auto5;
		double rentaAuto1, rentaAuto4;
		
		auto1=new Auto("BMW",2022,0);
		auto2=new Auto("Honda",2015,30000);
		auto3=new Auto("Fiat",2018,4000);
		auto4=new Auto("Renault",2002,120000);
		auto5=new Auto("Volkswagen",2005,100000);
		
		System.out.println(auto1.toString());
		System.out.println(auto2.toString());
		System.out.println(auto3.toString());
		System.out.println(auto4.toString());
		System.out.println(auto5.toString());
		
		System.out.print("\n------Renta del auto 1------");
		rentaAuto1=auto1.renta("Alvaro", 123456789, 6);
		System.out.println("\nEl precio a pagar es de: "+rentaAuto1);
		System.out.println(auto1.toString());
		
		System.out.print("\n------Renta del auto 4------");
		rentaAuto4=auto4.renta("Laura", 987654321, 8);
		System.out.println("\nEl precio a pagar es de: "+rentaAuto4);
		System.out.println(auto4.toString());
		
		System.out.print("\n------Devolucion del auto 1------");
		auto1.devolucion(150);
		System.out.println(auto1.toString());
	}

}
