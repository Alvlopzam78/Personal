import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Alvaro Lopez 
 * 04 nov 2021
 * Main que prueba los metodos estaticos de matrices
 */

public class MainMatrices {
	public static final int NUM_REN=10;
	
	public static final int NUM_COL=10;
	
	public static void imprimeMatriz(double[][] mat, int m, int n) {
		for(int j=0; j<m; j++) {
			for(int i=0; i<n; i++) {
				System.out.print("\t"+mat[j][i]);
			}
			System.out.println();
		}
		System.out.println(); 
	}
	
	public static void leeMatriz(double[][] mat, int m, int n, String nomArch) {
		File entrada=new File(nomArch);
		
		try(Scanner lec=new Scanner(entrada)){
			for(int j=0; j<m; j++) {
				for(int i=0; i<n; i++) {
					mat[j][i]=lec.nextDouble();
				}
			}
			lec.close();
		}
		
		catch(FileNotFoundException fnfe) {
			System.err.println("E R R O R "+fnfe);
			System.exit(-1);
		}
	}

	public static void main(String[] args) {
		double[][] mat=new double[NUM_REN][NUM_COL];
		
		leeMatriz(mat, 4, 4, "Matriz.txt");
		imprimeMatriz(mat, 4, 4);
		
		System.out.println("Suma de columna 2: "+ManejadorMatrices.sumaCol(mat, 2, 4));
		
		System.out.println("Suma de renglon 1: "+ManejadorMatrices.sumaRen(mat, 1, 5));
		
		System.out.println("Suma de de todos los elementos: "+ManejadorMatrices.sumaTodosElem(mat, 4, 5));
		
		System.out.println("Suma de la diagonal principal "+ManejadorMatrices.sumaDiagonalPrin(mat, 4));
	
		System.out.println("Suma de la diagonal secundaria "+ManejadorMatrices.sumaDiagonSec(mat, 4));
		
		System.out.println("Pos menor en columna 3: "+ManejadorMatrices.posMenorCol(mat, 3, 4));
		
		System.out.println("Pos mayor en columna 3: "+ManejadorMatrices.posMayorCol(mat, 3, 4));
		
		System.out.println("Pos menor en reglon 2:  "+ManejadorMatrices.posMenorRen(mat, 2, 4));
		
		System.out.println("Pos mayor en reglon 2: "+ManejadorMatrices.posMayorRen(mat, 2, 4));
	}
}
