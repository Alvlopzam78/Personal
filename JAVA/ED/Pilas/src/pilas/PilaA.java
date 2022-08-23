/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas;

/**
 *
 * @author Alvlopzam
 */
public class PilaA <T> implements PilaADT <T>{
    private T[] datosPila;
    private int tope;
    private final int MAXIMO = 20;
	
	public PilaA() {
		datosPila = (T[]) new Object[MAXIMO];
		tope = -1; //indica pila vacia
	}

	public void push(T dato) {
		if(tope == this.datosPila.length - 1) //la pila esta llena
			expand();
		tope++;
		datosPila[tope] = dato;
	}
	
	private void expand() {
		T[] masGrande = (T[]) new Object[this.datosPila.length * 2];
		
		for(int i=0; i<=tope; i++)
			masGrande[i] = datosPila[i];
		datosPila = masGrande;
	}

	public T pop() {
		T resultado;
		
		if(this.isEmpty())
			throw new ColeccionVaciaExcepcion("La pila está vacía");
		resultado = this.datosPila[tope];
		this.datosPila[tope] = null;
		tope--;
		return resultado;
	}

	public boolean isEmpty() {
		return tope == -1;
	}

	public T peek() {
		if(this.isEmpty())
			throw new ColeccionVaciaExcepcion("La pila está vacía");
		return this.datosPila[tope];
	}
	
	public void multiPop( int n) {
		int cont = 0;
		
		if(n<=tope+1)
			while(cont<n) {
				pop();
				cont++;
			}
	}
	
	public boolean equals(Object obj) {
		boolean res = false;
		int i = 0;
		
		if(obj!=null && this.getClass().equals(obj.getClass()))
			if(this.tope==((PilaA)obj).tope) {
				while(i<tope+1 && this.datosPila[i].equals(((PilaA)obj).datosPila[i]))
					i++;
				if(i==tope+1) {
					res=true;
				}
			}
		return res;
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		for (int i = tope; i>=0; i--)
			cad.append(datosPila[i] + "\n");
		return cad.toString();
	}
}
