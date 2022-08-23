import java.util.ArrayList;

/*Alvaro Lopez Zamora
 * 25 oct 2021
 * Casi lo mismo que el manejador arreglos pero generico 
 */

public class ManejadorArreglosGenerico {
	
	public static <T extends Comparable<T>> int posMayor(T[] a, int n) { //se utiliza T para señalar una clase generica
		int mayorIndex = 0;
		
		for(int i=1; i<n; i++) {
			if(a[i].compareTo(a[mayorIndex])>0) {
				mayorIndex=i;
			}
		}
		return mayorIndex;
	}
	
	public static <T extends Comparable<T>> int posMenor(T[] a, int n) { //extends comparable pide que la clase tenga programado un compareTo
		int menorIndex = 0;
		
		for(int i=1; i<n; i++) {
			if(a[i].compareTo(a[menorIndex])<0) {
				menorIndex=i;
			}
		}
		return menorIndex;
	}
	
	public static <T extends Comparable<T>> int cuantosMayX(T[] a, int n, T x) {
		int res=0;
		
		for(int i=0;i<n;i++) {
			if(a[i].compareTo(x)>0)
				res++;
		}
		return res;
	}
	
	public static <T extends Comparable<T>> int cuantosMenX(T[] a, int n, T x) {
		int res=0;
		
		for(int i=0;i<n;i++) {
			if(a[i].compareTo(x)<0)
				res++;
		}
		return res;
	}
	
	public static <T extends Comparable<T>> ArrayList<Integer> cualesMayX(T[] a, int n, T x){
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++) {
			if(a[i].compareTo(x)>0)
				res.add(i);
		}
		return res;
	}
	
	public static <T extends Comparable<T>> ArrayList<Integer> cualesMenX(T[] a, int n, T x){
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++) {
			if(a[i].compareTo(x)<0)
				res.add(i);
		}
		return res;
	}
	
	public static <T> void swap(T[] a, int n1, int n2) {
		T aux;
		
		aux=a[n1];
		a[n1]=a[n2];
		a[n2]=aux;
	}
	
	public static <T> void invierte(T[] a, int n) {
		int index = n-1;
		
		for(int i=0;i<n/2;i++) {
			swap(a,i,index-i);
		}
	}
	
	public static <T> void kCorrimientoDerecha(T[] a, int n, int k) {
		for(int i=0;i<k;i++) {
			for(int l=n-1;l>0;l--)
				a[l]=a[l-1];
			a[i]=null;
		}
	}
	
	public static <T> void kCorrimientoIzquierda(T[] a, int n, int k) {
		for(int i=0;i<k;i++) {
			for(int l=0;l<n-1;l++) {
				a[l]=a[l+1];
			}
			a[n-1-i]=null;
		}
	}

	public static <T> void kCorrimientoCirc(T[] a, int n, int k) {
		T aux;
		for(int i=0;i<k;i++) {
			aux=a[n-1];
			for(int l=n-1;l>0;l--)
				a[l]=a[l-1];
			a[0]=aux;
		}
	}
	
	
	public static <T extends Comparable<T>> int posMin(T[] a, int n, int inicio) {
		int indiceMin=inicio;
		
		for(int i=inicio+1; i<n; i++) {
			if(a[indiceMin].compareTo(a[i])>0) {
				indiceMin=i;
			}
		}
		return indiceMin;
	}
	
	public static <T extends Comparable<T>> void seleccionDirecta(T[] a, int n) {
		int indiceMin;
		
		for(int i=0; i<n; i++) {
			indiceMin=posMin(a, n, i);
			swap(a, indiceMin, i);
		}
	}
	
	public static <T>int busSecDesorden(T[] a, int n, T busca) {
		int i=0;
		
		while(i<n && !a[i].equals(busca)) {
			i++;
		}
		if(i==n) {
			i=-1;
		}
		return i;
	}
	
	public static <T extends Comparable<T>> int busSecOrdenada(T[] a, int n, T busca) {
		int i=0;
		
		while(i<n  && a[i].compareTo(busca)<0) {
			i++;
		}
		if(i==n || !a[i].equals(busca)) {
			i=-i-1;
		}
		
		return i;
	}
	
	public static <T extends Comparable <T>> int busBinaria(T[] a, int n, T busca) {
		int res;
		int inicio=0;
		int fin=n-1;
		int mitad=(inicio+fin)/2;
		
		while(inicio<=fin && !a[mitad].equals(busca)) {	
			if(busca.compareTo(a[mitad])<0) {
				fin=mitad-1;
			}
			else {
				inicio=mitad+1;
			}
			mitad=(inicio+fin)/2;
		}
		if(fin<inicio) {
			res=-inicio-1;
		}
		else {
			res=mitad;
		}
		
		return res;
	}
	
	public static <T> void unCorrimientoIzquierda(T[] a, int n,  int pos) {
		for(int i=pos; i<n-1; i++) {
			a[i]=a[i+1];
		}
	}
	
	public static <T> void unCorrimientoDerecha(T[] a, int n,  int pos) {
		for(int i=n; i>pos; i--) {
			a[i]=a[i-1];
		}
	}
	
	public static <T> int eliminaEnDesorden(T[] a , int n, T x) {
		int pos;
		
		pos=busSecDesorden(a, n, x);
		n=eliminaPos(a, n, pos);
		return n;
	}
	
	public static <T extends Comparable<T>> int eliminaEnOrden(T[] a , int n, T x) {
		int pos;
		
		pos=busSecOrdenada(a, n, x);
		n=eliminaPos(a, n, pos);
		return n;
	}
	
	public static <T> int eliminaPos(T[] a, int n, int pos) {
		if(pos>=0 && pos<n) {
			unCorrimientoIzquierda(a, n, pos);
			n--;
			a[n] = null;
		}
		return n;
	}
	
	public static <T extends Comparable<T>> int insertaEnOrden(T[] a, int n, T x) {
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
	
	public static <T> int inserta(T[] a, int n, int pos, T x) {
		if(n<a.length) {
			unCorrimientoDerecha(a, n, pos);
			a[pos]=x;
			n++;
		}
		return n;
	}
	
	public static <T> int insertaFinal(T[] a, int n, T x) {
		return inserta(a, n, n, x);
	}
	public static <T> int insertaInicio(T[] a, int n, T x) {
		return inserta(a, n, 0, x);
	}
}
