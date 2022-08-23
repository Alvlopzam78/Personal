/* Alvaro Lopez
 * 20 sept 2021
 * deposito de muchos metodos estaticos
 */
public class Calculadora {
	//Falta esImpar()
	
	public static double multiplica(double n1, double n2) {
		double res=0;
		
		for(int i=1;i<=n2;i++)
			res+=n1;
		return res;
	}
	
	public static double potencia(double n1, double n2) {
		double res=1;
		
		for(int i=1;i<=n2;i++)
			res*=n1;
		return res;
	}
	
	public static String calculaUllman(int num) {
		StringBuilder cad = new StringBuilder();
		
		cad.append(num);
		while(num!=1) {
			if(num%2==0) {
				num=num/2;
			}
			else {
				num=3*num+1;
			}
			cad.append(" "+num);
		}
		return cad.toString();
	}
	
	public static int calculaFactorial(int n) {
		int fact=1;
		
		for(int i=2;i<=n;i++) {
			fact*=i;
		}
		return fact;
	}
	
	public static int calculaMaximoComunDivisor(int m, int n) {
		int c;
		
		while(n!=0) {
			c=n;
			n=m%n;
			m=c;
		}
		return m;
	}
	
	public static int calculaSerie1(int n) {
		int res=0;
		
		for(int i=1;i<=n;i++) {
			res+=Math.pow(i, i);
		}
		return res;
	}
	
	public static double calculaSerie2(int n, int numero) {
		double sum=0;
		
		for(int i=1;i<=n;i++) {
			switch(i%3) {
			case 1: sum+=numero/3.0;
				break;
			case 2: sum+=numero/5.0;
				break;
			case 0: sum+=numero/7.0;
			}
		}
		return sum;
	}
	
	//public static boolean esDivisiblePor11(int n) {
		
	//}
	
	public static String generaSerieFibonacci(int n) {
		StringBuilder cad = new StringBuilder();
		
		int n1=0;
		int n2=1;
		int nesimo;
		
		cad.append(n1);
		cad.append(" "+n2);
		for(int i=3;i<=n;i++) {
			nesimo=n1+n2;
			cad.append(" "+nesimo);
			n1=n2;
			n2=nesimo;
		}
		return cad.toString();
	}
}