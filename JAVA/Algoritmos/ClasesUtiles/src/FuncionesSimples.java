import java.util.ArrayList;

/*Alvaro Lopez
 * 20 sept 2021
 * Programa que conteien diversos metodos estaticos simples
 */
public class FuncionesSimples {
	public static int factorial(int n) {
		int fact=1;
		
		for(int i=2;i<=n;i++) {
			fact*=i;
		}
		return fact;
	}
	
	public static double[] fibonacci(int n) {
		double[] fibo=new double[n];
		
		fibo[0]=0;
		fibo[1]=1;
		for(int i=2;i<n;i++) {
			fibo[i]=fibo[i-2]+fibo[i-1];
		}
		return fibo;
	}
	
	public static ArrayList<Double> ullman(double num) {
		ArrayList<Double> ullman=new ArrayList<Double>();
		
		ullman.add(num);
		while(num!=1) {
			if(num%2==0) {
				num=num/2;
			}
			else {
				num=3*num+1;
			}
			ullman.add(num);
		}
		return ullman;
	}
}
