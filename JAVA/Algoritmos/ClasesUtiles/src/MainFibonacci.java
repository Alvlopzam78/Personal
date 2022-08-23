import java.util.Scanner;

/*Alvaro Lopez
 * 20 sept 2021
 * Codigo que prueba la funcion fibonacci
 */
public class MainFibonacci {	
	public static void imprimeArreglo(double[] a, int n) {
		for(int i=0;i<n;i++) {
			System.out.print("\t"+a[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner lec;
		int n;
		double[] res;
		
		lec=new Scanner(System.in);
		n=lec.nextInt();
		res=FuncionesSimples.fibonacci(n);
		imprimeArreglo(res,res.length);
		System.out.println(res[4]);
	}
}
