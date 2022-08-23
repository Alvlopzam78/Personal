/*Alvaro Lopez
 * 20 sept 2021
 * prueba de invocacion de metodos estaticos
 */
public class PruebaMetodosEstaticos {

	public static void main(String[] args) {
		System.out.println("7 x 9 "+Calculadora.multiplica(7,9));
		System.out.println("5 a la 4 "+Calculadora.potencia(5, 4));
		System.out.println(Calculadora.calculaUllman(26));
		System.out.println(Calculadora.calculaFactorial(0));
		System.out.println(Calculadora.calculaFactorial(5));
		System.out.println(Calculadora.calculaMaximoComunDivisor(756,525));
		System.out.println(Calculadora.calculaSerie1(4));
		System.out.println(Calculadora.calculaSerie2(5, 6));
		System.out.println(Calculadora.generaSerieFibonacci(0));
		System.out.println(Calculadora.generaSerieFibonacci(10));
	}
}