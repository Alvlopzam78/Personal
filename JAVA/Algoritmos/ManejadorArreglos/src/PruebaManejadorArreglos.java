import java.util.ArrayList;
import java.util.Scanner;

/*Alvaro Lopez
 * 27 sept 2021
 * Codigo que prueba los metodos estaticos de la clase ManejadorArreglos
 */
public class PruebaManejadorArreglos {
	public static int leeArreglo(double[] a) {
		int n;
		Scanner lec = new Scanner(System.in);
		
		System.out.println("¿Cuantas celdas tendra tu arreglo? MAX "+CELDAS);
		n=lec.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Indica el valor "+(i+1));
			a[i]=lec.nextDouble();
		}
		return n;
	}
	
	public static void imprimeArreglo(double[] a, int n) {
		for(int i=0;i<n;i++) {
			System.out.print("\t"+a[i]);
		}
		System.out.println();
	}
	
	private static final int CELDAS=100;

	public static void main(String[] args) {
		double[] arr = new double[CELDAS];
		double sumaArr, promArr, x;
		int n, n1, n2, mayorIndex, menorIndex, cuantosMayX, cuantosMenX, nn, nnn;
		ArrayList<Integer> cualesMayX, cualesMenX;
		Scanner lec = new Scanner(System.in);
		
		n=leeArreglo(arr);
		System.out.println("Tu arreglo es el siguiente:");
		imprimeArreglo(arr, n);
		System.out.println();
		
		/*sumaArr=ManejadorArreglos.suma(arr, n);
		System.out.println("La suma de los elementos de tu areglo es:     "+sumaArr);
		
		promArr=ManejadorArreglos.promedio(arr, n);
		System.out.println("El promedio de los elementos de tu areglo es: "+promArr);
		
		mayorIndex=ManejadorArreglos.posMayor(arr, n); 
		System.out.println("El indice del numero mas grande es:           "+mayorIndex);
		
		menorIndex=ManejadorArreglos.posMenor(arr, n);
		System.out.println("El indice del numero mas chico es:            "+menorIndex);
		
		System.out.println();
		System.out.println("Indica el parametro a utilizar (x)");
		x=lec.nextDouble();
		cuantosMayX=ManejadorArreglos.cuantosMayX(arr, n, x);
		System.out.println("El numero de elementos mayores que "+ x+" en tu arreglo es:              "+cuantosMayX);
		
		cuantosMenX=ManejadorArreglos.cuantosMenX(arr, n, x);
		System.out.println("El numero de elementos menores que "+ x+" en tu arreglo es:              "+cuantosMenX);
		
		cualesMayX=ManejadorArreglos.cualesMayX(arr, n, x);
		System.out.println("La lista de indices de los numeros mayores que "+ x+" en tu arreglo es: "+cualesMayX);
		
		cualesMenX=ManejadorArreglos.cualesMenX(arr, n, x);
		System.out.println("La lista de indices de los numeros menores que "+ x+" en tu arreglo es: "+cualesMenX);
		System.out.println();
		
		System.out.println("Indica los indices de los elementos que quieres cambiar");
		n1=lec.nextInt();
		n2=lec.nextInt();
		ManejadorArreglos.swap(arr, n1, n2);
		System.out.println("Tu arreglo actualizado es:");
		imprimeArreglo(arr,n);
		System.out.println();
		
		ManejadorArreglos.invierte(arr, n);
		System.out.println("Tu arreglo invertido es:");
		imprimeArreglo(arr,n);
		
		/*ManejadorArreglos.kCorrimientoDerecha(arr, n, 2);
		System.out.println("Tu arreglo con corrimiento a la derecha es:");
		imprimeArreglo(arr,n);
		
		ManejadorArreglos.kCorrimientoIzquierda(arr, n, 2);
		System.out.println("Tu arreglo con corrimiento a la izquierda es:");
//		imprimeArreglo(arr,n);
		*/
		
		ManejadorArreglos.seleccionDirecta(arr, n);
		imprimeArreglo(arr,n);
		nn = ManejadorArreglos.insertaEnOrden(arr, n, 7.4);
		if(n == nn)
			System.out.println("Mala insercion");
		else
			System.out.println("Todo bien");
		imprimeArreglo(arr,nn);
		nnn = ManejadorArreglos.eliminaEnOrden(arr, nn, 7.4);
		imprimeArreglo(arr,n);
		ManejadorArreglos.unCorrimientoIzquierda(arr, n, 0);
		imprimeArreglo(arr,7);
	}

}
