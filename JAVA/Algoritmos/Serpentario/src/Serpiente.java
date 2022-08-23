import java.util.Objects;

/*Alvaro Lopez	
 * 08 nov 2021
 * Clase que modela a una serpiente
 */

public class Serpiente {
	private int clave;
	private static int generadorClave = 110;
	private String tipo;
	private double longitud;
	private double peso;
	private String alimento;
	private char genero;
	
	public Serpiente(int clave) {
		this.clave = clave;
	}
	
	public Serpiente (String tipo, double longitud, double peso, String alimento, char genero) {
		clave=generadorClave;
		generadorClave+=10;
		this.tipo = tipo;
		this.longitud = longitud;
		this.peso = peso;
		this.alimento = alimento;
		this.genero = genero;
	}

	public int getClave() {
		return clave;
	}

	public String getTipo() {
		return tipo;
	}

	public double getLongitud() {
		return longitud;
	}

	public double getPeso() {
		return peso;
	}

	public String getAlimento() {
		return alimento;
	}

	public char getGenero() {
		return genero;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clave);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serpiente other = (Serpiente) obj;
		return clave == other.clave;
	}
	
	public int compareTo(Serpiente otra){
		return this.clave - otra.clave;
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("\n\tSerpiente de tipo: " + tipo);
		cad.append("\n\tcon clave:" + clave);
		cad.append("\n\tde genero: " + genero);
		cad.append("\n\tde longitud y peso: " + longitud + ", " + peso);
		cad.append("\n\tcon alimento: " + alimento+"\n");
		return cad.toString();
	}
}
