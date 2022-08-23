import java.util.Objects;

/*Alvaro Lopez Zamora
 * 23 Nov 2021
 * Clase que modela la realidad de un cine con un arreglo de salas de cine con una matriz de espectadores
 */

public class Cine {
	private String nombre;
	private String direccion;
	private SalaCine[] salas;
	private int numSalas;
	private final int MAX_SALAS = 20;
	private final int MAX_COLS = 25;
	
	public Cine(String nombre, String direccion) { //constructor de un cine
		this.nombre = nombre;
		this.direccion = direccion;
		this.numSalas = 0;
		salas = new SalaCine[MAX_SALAS]; //se instancia el arreglo de salas
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getNumSalas() {
		return numSalas;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getUnaSala(int numSala) {
		SalaCine s = new SalaCine(numSala);
		int pos;
		String res = "Sala no encontrada";
		
		pos = ManejadorArreglosGenerico.busSecDesorden(salas, numSalas, s);
		if(pos!=-1) //se verifica la posicion para poder continuar
			res = salas[pos].toString();
		return res;
	}
	
	public String getEspectadorSala(int numSala, String asiento) { //ver la info de un espectador desde el cine
		SalaCine s = new SalaCine(numSala);
		int pos;
		String res = "Epectador no encontrado";
		
		pos = ManejadorArreglosGenerico.busSecDesorden(salas, numSalas, s);
		if(pos!=-1) {
			res = salas[pos].getUnEspectador(asiento);
		}
		return res;
	}
	
	public boolean altaSala(String tipo, int numFilas, int numCol, String pelicula) { //dar una sala de alta
		boolean res = false;
		SalaCine s = new SalaCine(tipo, numFilas, numCol, pelicula);
		int n;
		
		n = ManejadorArreglosGenerico.insertaFinal(salas, numSalas, s);
		if(n!=numSalas && numCol<=MAX_COLS) {
			res = true;
			numSalas=n;
		}
		return res;
	}
	
	public boolean bajaSala(int numSala) { //dar una sala de baja
		SalaCine s = new SalaCine(numSala);
		int pos;
		boolean res = false;
		
		pos = ManejadorArreglosGenerico.busSecDesorden(salas, numSalas, s);
		if(pos!=-1) {
			ManejadorArreglosGenerico.eliminaPos(salas, numSalas, pos);
			numSalas--;
			res=true;
		}
		return res;
	}
	
	public boolean compraBoleto(int numSala, String asiento, String nombre, int edad, String alimento) { //da de alta  un espectador en una sala especifica
		SalaCine s = new SalaCine(numSala);
		int pos;
		boolean res = false;
		
		pos = ManejadorArreglosGenerico.busSecDesorden(salas, numSalas, s);
		if(pos!=-1)
			res = salas[pos].altaEspectador(asiento, nombre, edad, alimento);
		return res;
	}
	
	public boolean devuelveBoleto(int numSala, String asiento){ //da de baja un espectador de una sala especifica
		SalaCine s = new SalaCine(numSala);
		int pos;
		boolean res = false;
		
		pos = ManejadorArreglosGenerico.busSecDesorden(salas, numSalas, s);
		if(pos!=-1) 
			res = salas[pos].bajaEspectador(asiento);
		return res;
	}
	
	public boolean compraAlimento(int numSala, String asiento, String alimento) { //hace un setAlimento() al espectador indicado
		SalaCine s = new SalaCine(numSala);
		int pos;
		boolean res = false;
		
		pos = ManejadorArreglosGenerico.busSecDesorden(salas, numSalas, s);
		if(pos!=-1)
			res = salas[pos].setAlimento(asiento, alimento);
		return res;
	}
	
	public int salaMasLlena() { //cual es la sala mas llena
		SalaCine may = salas[0];
		
		for(int i=1;i<numSalas;i++) 
			if(salas[i].getNumAsientosOcupados()>may.getNumAsientosOcupados())
				may = salas[i];
		return may.getNumSala();
	}
	
	public int cuantosMayEdadSala(int numSala) { //cuantos mayores de edad hay en una cierta sala
		SalaCine s = new SalaCine(numSala);
		int pos;
		int res = 0;
		
		pos = ManejadorArreglosGenerico.busSecDesorden(salas, numSalas, s);
		if(pos!=-1) 
			for(int i=0; i<salas[pos].getNumFilas();i++)
				for(int j=0;j<salas[pos].getNumCol();j++) 
					if(salas[pos].getEdadEspectador(i, j)>=18)
						res++;
		return res;
	}
	
	public int cuantosAlimentoSala(int numSala, String alimento) { //cuantos hay en una sala que hayan comprado cierto alimento
		SalaCine s = new SalaCine(numSala);
		int pos;
		int res = 0;
		
		pos = ManejadorArreglosGenerico.busSecDesorden(salas, numSalas, s);
		if(pos!=-1)
			for(int i=0; i<salas[pos].getNumFilas();i++)
				for(int j=0;j<salas[pos].getNumCol();j++) 
					if(salas[pos].getAlimentoEspectador(i,j).equals(alimento))
						res++;
		return res;
			
	}
	
	public int compareTo(Cine otro) {
		return this.getDireccion().compareTo(otro.direccion);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cine other = (Cine) obj;
		return Objects.equals(direccion, other.direccion);
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("Cine llamado: " + nombre);
		cad.append("\nUbicado en: " + direccion);
		cad.append("\nCon " + numSalas + " salas");
		for(int i=0; i<numSalas;i++) {
			cad.append("\nSala " + salas[i].getNumSala() + " --> Pelicula: " + salas[i].getPelicula());
		}
		return cad.toString();
	}
	
}
