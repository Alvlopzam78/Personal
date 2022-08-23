import java.util.ArrayList;

/*Alvaro Lopez	
 * 27 sept 2021
 * Clase que contiene metodos estaticos para manjar arreglos
 */

public class ManejadorArreglos {
	public static double suma(double[] a,int n) {
		double res = 0;
		
		for(int i=0;i<n;i++)
			res+=a[i];
		return res;
	}
	
	public static double promedio(double[] a, int n) {
		double prom;
		
		prom=suma(a, n)/n;
		return prom;
	}
	
	public static int posMayor(double[] a, int n) {
		int mayorIndex = 0;
		
		for(int i=1; i<n; i++) {
			if(a[i]>a[mayorIndex]) {
				mayorIndex=i;
			}
		}
		return mayorIndex;
	}
	
	public static int posMenor(double[] a, int n) {
		int menorIndex = 0;
		
		for(int i=1; i<n; i++) {
			if(a[i]<a[menorIndex]) {
				menorIndex=i;
			}
		}
		return menorIndex;
	}
	
	public static int cuantosMayX(double[] a, int n, double x) {
		int res=0;
		
		for(int i=0;i<n;i++) {
			if(a[i]>x)
				res++;
		}
		return res;
	}
	
	public static int cuantosMenX(double[] a, int n, double x) {
		int res=0;
		
		for(int i=0;i<n;i++) {
			if(a[i]<x)
				res++;
		}
		return res;
	}
	
	public static ArrayList<Integer> cualesMayX(double[] a, int n, double x){
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++) {
			if(a[i]>x)
				res.add(i);
		}
		return res;
	}
	
	public static ArrayList<Integer> cualesMenX(double[] a, int n, double x){
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++) {
			if(a[i]<x)
				res.add(i);
		}
		return res;
	}
	
	public static void swap(double[] a, int n1, int n2) {
		double aux;
		
		aux=a[n1];
		a[n1]=a[n2];
		a[n2]=aux;
	}
	
	public static void invierte(double[] a, int n) {
		int index = n-1;
		
		for(int i=0;i<n/2;i++) {
			swap(a,i,index-i);
		}
	}
	
	public static void kCorrimientoDerecha(double[] a, int n, int k) {
		for(int i=0;i<k;i++) {
			for(int l=n-1;l>0;l--)
				a[l]=a[l-1];
			a[i]=0;
		}
	}
	
	public static void kCorrimientoIzquierda(double[] a, int n, int k) {
		for(int i=0;i<k;i++) {
			for(int l=0;l<n-1;l++) {
				a[l]=a[l+1];
			}
			a[n-1-i]=0;
		}
	}
	
	public static int posMin(double[] a, int n, int inicio) {
		int indiceMin=inicio;
		
		for(int i=inicio+1; i<n; i++) {
			if(a[indiceMin]>a[i]) {
				indiceMin=i;
			}
		}
		return indiceMin;
	}
	
	public static void seleccionDirecta(double[] a, int n) {
		int indiceMin;
		
		for(int i=0; i<n-1; i++) { //Me paro uno antes porque el segundo for arranca en i+1
			indiceMin=posMin(a, n, i);
			swap(a, indiceMin, i);
		}
	}
	
	public static void seleccionDirectaED(double[] a, int n) {
		double menor;
		int pos;
		
		for(int i=0;i<n-1;i++) {
			menor = a[i];
			pos = i;
			
			for(int j=i+1;j<n;j++)
				if(a[j]<menor) {
					menor = a[j];
					pos = j;
				}
			a[pos]=a[i];
			a[i]=menor;
			
		}
	}
	
	public static int busSecDesorden(double[] a, int n, double busca) {
		int i=0;
		
		while(i<n && a[i]!=busca) {
			i++;
		}
		if(i==n) {
			i=-1;
		}
		return i;
	}
	
	public static int busSecOrdenada(double[] a, int n, double busca) {
		int i=0;
		
		while(i<n  && a[i]<busca) {
			i++;
		}
		if(i==n || a[i]!=busca) {
			i=-i-1;
		}
		
		return i;
	}
	
	public static int busBinaria(double[] a, int n, double busca) {
		int res;
		int inicio=0;
		int fin=n-1;
		int mitad=(inicio+fin)/2;
		
		while(inicio<=fin && a[mitad]!=busca) {	
			if(busca<a[mitad]) {
				fin=mitad-1;
			}
			else {
				inicio=mitad+1;
			}
			mitad=(inicio+fin)/2;
		}
		if(fin<inicio) { //No lo encontro
			res=-inicio-1; //(inicio+1)*-1
		}
		else {
			res=mitad;
		}
		
		return res;
	}
	
	public static void unCorrimientoIzquierda(double[] a, int n,  int pos) {
		for(int i=pos; i<n-1; i++) {
			a[i]=a[i+1];
		}
	}
	
	public static void unCorrimientoDerecha(double[] a, int n,  int pos) {
		for(int i=n; i>pos; i--) {
			a[i]=a[i-1];
		}
	}
	
	public static int eliminaEnDesorden(double[] a , int n, double num) {
		int pos;
		
		pos=busSecDesorden(a, n, num);
		eliminaPos(a, n, pos);
		return n;
	}
	
	public static int eliminaEnOrden(double[] a , int n, double num) {
		int pos;
		
		pos=busBinaria(a, n, num);
		eliminaPos(a, n, pos);
		return n;
	}
	
	public static int eliminaPos(double[] a, int n, int pos) {
		if(pos>=0 && pos<n) {
			unCorrimientoIzquierda(a, n, pos);
			n--;
			a[n] = 0;
		}
		return n;
	}
	
	public static int insertaEnOrden(double[] a, int n, double x) {
		int pos;
		
		if(n<a.length) {
			pos=busBinaria(a, n, x);
			if(pos<0) {
				pos=-pos-1;
				unCorrimientoDerecha(a, n, pos);
				a[pos]=x;
				n++;
			}	
		}
		return n;
	}
	
	public static int inserta(double[] a, int n, int pos, double x) {
		if(n<a.length) {
			unCorrimientoDerecha(a, n, pos);
			a[pos]=x;
			n++;
		}
		return n;
	}
	
	public static int insertaFinal(double[] a, int n, double x) {
		return inserta(a, n, n, x);
	}
	public static int insertaInicio(double[] a, int n, double x) {
		return inserta(a, n, 0, x);
	}
	
	
}
