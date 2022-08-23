import java.util.Objects;

/*Alvaro Lopez Zamora
 * 23 Nov 2021
 * Clase que modela la realida de una sala de cine
 */

public class SalaCine {
	private int numSala;
	private String tipoSala;
	private int numAsientosOcupados;
	private Espectador[][] asientos;
	private int tamano;
	private int numFilas;
	private int numCol;
	private String pelicula;
	private final String[] filas = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"};
	private static int consecutivoNumSala = 1;
	
	public SalaCine(String tipoSala, int numFilas, int numCol, String pelicula) { //Constructor de una sala con una matriz de espectadores "no" existentes
		Espectador esp = new Espectador("Sin boleto");
		
		asientos = new Espectador[numFilas][numCol];
		for(int i=0;i<numFilas;i++){
			for(int j=0;j<numCol;j++) {
				asientos[i][j] = esp;
			}
		}
		numAsientosOcupados = 0;
		this.numSala = consecutivoNumSala;
		consecutivoNumSala++;
		this.tipoSala = tipoSala;
		this.numFilas = numFilas;
		this.numCol = numCol;
		this.tamano = numFilas*numCol;
		this.pelicula = pelicula;
	}
	
	public SalaCine(int numSala) {
		this.numSala = numSala;
	}

	public int getNumSala() {
		return numSala;
	}
	
	public int getTamano() {
		return tamano;
	}

	public String getTipoSala() {
		return tipoSala;
	}

	public int getNumAsientosOcupados() {
		return numAsientosOcupados;
	}

	public int getNumFilas() {
		return numFilas;
	}

	public int getNumCol() {
		return numCol;
	}

	public String getPelicula() {
		return pelicula;
	}
	
	public String getUnEspectador(String asiento) { //ver la informacion de un espectador
		String filaStr = asiento.substring(0, 1); //toma del asiento solo la letra en mayuscula
		String colStr = asiento.substring(1); //toma del asiento solo el numero
		int colInt = Integer.parseInt(colStr); //convierte el numero a int
		int filaInt = ManejadorArreglosGenerico.busBinaria(filas, numFilas, filaStr); //busca la letra en el arreglo filas
		String res = "Espectador no encontrado";
		
		if(filaInt != -1 && colInt<numCol) //Se verifica que se pueda acceder a la matriz
			if(!asientos[filaInt][colInt-1].getAsiento().equals("Sin boleto")) //se busca que el asiento este ocupado
				res = asientos[filaInt][colInt-1].toString();
			else
				res = "Asiento libre";
		return res;
	}
	
	public int getEdadEspectador(int n, int m) { //regresa la edad de un espectador
		int res=0;
		
		if(n<numFilas && m<numCol)
			if(!asientos[n][m].getAsiento().equals("Sin boleto"))
				res=asientos[n][m].getEdad();
		return res;
	}
	
	public String getAlimentoEspectador(int n, int m) { //regresa el aliimento de un espectador
		String res = "Sin alimento";
		
		if(n<numFilas && m<numCol)
			if(!asientos[n][m].getAsiento().equals("Sin boleto"))
				res=asientos[n][m].getAlimento();
		return res;
	}

	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}
	
	public boolean altaEspectador(String asiento, String nombre, int edad, String alimento) { //dar de alta un espectador en la matriz
		String filaStr = asiento.substring(0, 1);
		String colStr = asiento.substring(1);
		int colInt = Integer.parseInt(colStr);
		int filaInt = ManejadorArreglosGenerico.busBinaria(filas, numFilas, filaStr);
		boolean res = false;
		Espectador esp = new Espectador(asiento, nombre, edad, alimento);
		
		if(filaInt != -1 && colInt<=numCol) {
			if(asientos[filaInt][colInt-1].getAsiento().equals("Sin boleto")) {
				asientos[filaInt][colInt-1] = esp;
				res = true;
				numAsientosOcupados ++;
			}
		}
		return res;
	}
	
	public boolean bajaEspectador(String asiento) { //dar de baja un espectador de la matriz
		String filaStr = asiento.substring(0, 1);
		String colStr = asiento.substring(1);
		int colInt = Integer.parseInt(colStr);
		int filaInt = ManejadorArreglosGenerico.busBinaria(filas, numFilas, filaStr);
		boolean res = false;
		Espectador esp = new Espectador("Sin boleto");
		
		if(filaInt != -1 && colInt<=numCol) {
			asientos[filaInt][colInt-1] = esp;
			res = true;
		}
		return res;
	}
	
	public boolean salaVacia(int numSala) { //regresa, si existe, el numero de alguna sala vacia
		boolean res = true;
		int j=0;
		int i;
		
		while(res && j<numFilas) {
			i=0;
			while(res && i<numCol) {
				if(!asientos[j][i].getAsiento().equals("Sin boleto"))
					res=false;
				i++;
			}
			j++;
		}
		return res;
	}
	
	public boolean setAlimento(String asiento, String alimento) {
		String filaStr = asiento.substring(0, 1);
		String colStr = asiento.substring(1);
		int colInt = Integer.parseInt(colStr);
		int filaInt = ManejadorArreglosGenerico.busBinaria(filas, numFilas, filaStr);
		boolean res = false;
		
		if(filaInt != -1 && colInt<=numCol) {
			if(!asientos[filaInt][colInt-1].getAsiento().equals("Sin boleto")) {
				asientos[filaInt][colInt-1].setAlimento(alimento);
				res = true;
			}
		}
		return res;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalaCine other = (SalaCine) obj;
		return numSala == other.numSala;
	}

	public int compareTo(SalaCine otra) {
		int res = -1;
		
		if(this.numSala==otra.numSala)
			res = 0;
		else
			if(this.numSala>otra.numSala)
				res = 1;
		return res;
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("\nSala " + numSala);
		cad.append("\nTipo: " + tipoSala);
		cad.append("\nAsientos: " + tamano);
		cad.append("\nAsientos Ocupados: "+ numAsientosOcupados);
		cad.append("\nPelicula: " + pelicula);
		cad.append("\n\n");
		for(int i=0;i<numCol;i++)
			cad.append("\t" + (i+1));
		for(int j=0; j<numFilas; j++) {
			cad.append("\n" + filas[j] + "\t");
			for(int i=0; i<numCol; i++) {
				if(asientos[j][i].getAsiento()=="Sin boleto")
					cad.append("Libre\t");
				else
					cad.append("Ocupado\t");
			}
			cad.append("\n");
		}
		cad.append("\n"); 
		return cad.toString();
	}
}
