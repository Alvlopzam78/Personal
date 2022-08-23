import java.util.Scanner;

/* Alvaro Lopez Zamora
 * 15 sept 2021
 * Programa que resuelve probelma para la creacion de dos cuentas y hacer un desposito y un retiro
 */
public class EjecutableCuentaBanco {

	public static void main(String[] args) {
		CuentaBanco cuenta1, cuenta2;
		String nombre1, nombre2;
		double saldoAp1, retiro, deposito;
		Scanner lec;
		
		lec=new Scanner(System.in);
		System.out.println("Cuenta 1");
		System.out.println("Indique su nombre");
		nombre1=lec.next();
		System.out.println("Indique el saldo de apertura");
		saldoAp1=lec.nextDouble();
		cuenta1=new CuentaBanco(nombre1, saldoAp1);
		System.out.println("\nCuenta creada. "+cuenta1.toString());
		System.out.println("\n¿Cuánto desea retirar?");
		retiro=lec.nextDouble();
		while(cuenta1.retiro(retiro)==false) {
			System.out.println("Fondos insuficientes");
			System.out.println("Indique de nuevo el monto");
			retiro=lec.nextDouble();
		}
		System.out.println("Retiro Exitoso");
		System.out.println("\nCuenta 2");
		cuenta2=new CuentaBanco();
		System.out.println("Indique su nombre");
		nombre2=lec.next();
		cuenta2.setNomTit(nombre2);
		System.out.println("\nCuenta actualizada. "+cuenta2.toString());
		System.out.println("\n¿Cuánto desea depositar?");
		deposito=lec.nextDouble();
		cuenta2.deposito(deposito);
		
		System.out.println("\nInformacion actualizada de las cuentas:");
		System.out.println(cuenta1.toString());
		System.out.println(cuenta2.toString());
	}
}
