/* Alvaro Lopez
 * 04 nov 2021
 * Clase que contiene metodos estaticos para manejar matrices
 */

public class ManejadorMatrices {
	public static double sumaCol(double[][] mat, int col, int m) {
		double suma=0;
		
		for(int i=0; i<m; i++) {
			suma+=mat[i][col];
		}
		return suma;
	}
	
	public static double sumaRen(double[][] mat, int ren, int n) {
		return ManejadorArreglos.suma(mat[ren], n);
	}
	
	public static double sumaTodosElem(double[][] mat, int m, int n) {
		double suma=0;
		
		for(int i=0; i<m; i++) {
			suma+=ManejadorArreglos.suma(mat[i], n);
		}
		return suma;
	}
	
	public static double sumaDiagonalPrin(double[][] mat, int m) {
		double suma = 0;
		
		for(int i=0; i<m; i++) {
			suma+=mat[i][i];
		}
		return suma;
	}
	
	public static double sumaDiagonSec(double[][] mat, int m) { 
		double suma=0;
		int j=m-1;
		
		for(int i=0; i<m; i++) {
			suma+=mat[i][j];
			j--;
		}
		return suma; 
	}
	
	public static int posMenorCol(double[][] mat, int col, int m) {
		double min=mat[0][col];
		int pos=0;
		
		for(int i=1; i<m; i++) {
			if(min>mat[i][col]) {
				min=mat[i][col];
				pos=i;
			}
		}
		return pos;
	}
	
	public static int posMayorCol(double[][] mat, int col, int m) {
		double max=mat[0][col];			
		int pos=0;
		
		for(int i=1; i<m; i++) {
			if(max<mat[i][col]) {		
				max=mat[i][col];		
				pos=i;
			}
		}
		return pos;						
	}
	
	public static int posMenorRen(double[][] mat, int ren, int n) {
		return ManejadorArreglos.posMenor(mat[ren], n);
	}
	
	public static int posMayorRen(double[][] mat, int ren, int n) {
		return ManejadorArreglos.posMayor(mat[ren], n);
	}
	
	public static int[] posMenor(double[][] mat, int m, int n) {
		int[] res= {0,0};
		int minRen=ManejadorArreglos.posMenor(mat[0], n);
		double minMat=mat[0][0];
		res[1]=minRen;
		
		for(int j=1; j<m; j++) {
			minRen=ManejadorArreglos.posMenor(mat[j], n);
			if(mat[j][minRen]<minMat) {
				minMat=mat[j][minRen];
				res[0]=j;
				res[1]=minRen;
			}
		}
		return res;
	}
	public static int[] posMayor(double[][] mat, int m, int n) {
		int[] res= {0,0};
		int maxRen=ManejadorArreglos.posMayor(mat[0], n);
		double maxMat=mat[0][maxRen];
		res[1]=maxRen;
		
		for(int j=1; j<m; j++) {
			maxRen=ManejadorArreglos.posMayor(mat[j], n);
			if(mat[j][maxRen]>maxMat) {
				maxMat=mat[j][maxRen];
				res[0]=j;
				res[1]=maxRen;
			}
		}
		return res;
	}
	public static double[][] sumaAyB(double[][] mat1, int m1, int n1, double[][] mat2, int m2, int n2) {
		double[][] suma;
		
		if(m1==m2 && n1==n2) {
			suma=new double[m1][n1];
			for(int j=0; j<m1; j++) {
				for(int i=0; i<n1; i++) {
					suma[j][i]=mat1[j][i]+mat2[j][i];
				}
			}
		}
		else {
			suma=null;
		}
		return suma;
	}
	public static double[][] multiplicaAyB(double[][] mat1, int m1, int n1, double[][] mat2, int m2, int n2){
		double[][] res;
		double suma;
		
		if(n1==m2) {
			res=new double[m1][n2];
			for(int j=0; j<m1; j++) {
				for(int k=0; k<n2; k++) {
					suma=0;
					for(int i=0; i<n1; i++) {
						suma+=(mat1[j][i]*mat2[i][k]);
					}
					res[j][k]=suma;
				}
			}
			
		}
		else {
			res=null;
		}
		return res;
	}
	public static double[][] traspuesta(double[][] mat, int m, int n) {
		double[][] res=new double[n][m];
		
		for(int j=0; j<m; j++) {
			for(int i=0; i<n; i++) {
				res[i][j]=mat[j][i];
			}
		}
		return res;
	}
	public static boolean esSimetrica(double[][] mat, int m) {
		boolean res=true;
		int i;
		int j=0;
		
		while(res && j<m) { 
			i=j+1;
			while(i<m && mat[j][i]==mat[i][j]) {
				i++;
			}
			if(i!=m) {
				res=false;
			}
			j++;
		}
		
		return res;
	}
	public static boolean esIdentidad(double[][] mat, int m) {
		boolean res=true;
		int j=0;
		int i;
		
		while(res && j<m) {
			i=0;
			while(res && i<m) {
				if(i==j && mat[j][i]!=1) {
					res=false;
				}
				else if(i!=j && mat[j][i]!=0) {
					res=false;
				}
				i++;
			}
			j++;
		}
		return res;
	}
	
	public static int buscaRenglonDesordenado(double[][] mat, int renglon, int n, double x) {
		return ManejadorArreglos.busSecDesorden(mat[renglon], n, x);
	}
	public static int buscaRenglonOrdenado(double[][] mat, int renglon, int n, double x) {
		return ManejadorArreglos.busSecOrdenada(mat[renglon], n, x);
	}
	public static int buscaColumna(double[][] mat, int columna, int m, double x) {
		int j=0;
		
		while(j<m && mat[j][columna]!=x) {
			j++;
		}
		if(j==m) {
			j=-1;
		}
		return j;
	}
	public static int[] buscaEnMatriz(double[][] mat, int m, int n, double x) {
		int[] res= {-1, -1};
		int j=0;
		int pos;
		boolean encontre=false;
		
		while(!encontre && j<m) {
			pos=ManejadorArreglos.busSecDesorden(mat[j], n, x);
			if(pos>=0) {
				res[0]=j;
				res[1]=pos;
				encontre=true;
			}
			j++;
		}
		return res;
	}
	public static boolean matEqualsOther(double[][] mat1, int m1, int n1, double[][] mat2, int m2, int n2) {
		boolean res=true;
		int i, j;
		
		if(m1==m2 && n1==n2) {
			j=0;
			while(res && j<m1) {
				i=0;
				while(i<n1 && mat1[j][i]==mat2[j][i]) {
					i++;
				}
				if(i!=n1) {
					res=false;
				}
				j++;
			}
		}
		else {
			res=false;
		}
		return res;
	}
}
