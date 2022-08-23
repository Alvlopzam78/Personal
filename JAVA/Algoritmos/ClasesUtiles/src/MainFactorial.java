import java.util.Scanner;

/*Alvaro Lopez
 * 20 sept 2021
 * Codigo que prueba la funcion factorial
 */
public class MainFactorial {

	public static void main(String[] args) {
		Scanner lec;
		int n;
		int res;
		
		lec=new Scanner(System.in);
		n=lec.nextInt();
		res=FuncionesSimples.factorial(n);
		System.out.println(res);
	}

}
