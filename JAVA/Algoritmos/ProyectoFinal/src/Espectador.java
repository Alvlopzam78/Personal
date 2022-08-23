import java.util.Objects;

/*Alvaro Lopez Zamora
 * 23 Nov 2021
 * Clase que modela la realidad de un Espectador de un Cine
 */

public class Espectador {
	private String asiento;
	private String nombre;
	private int edad;
	private String alimento;
	
	public Espectador(String asiento) { //constructor para un espectador simple
		this.asiento = asiento;
		this.alimento = "";
	}

	public Espectador(String asiento, String nombre, int edad, String alimento) { //constructor para un espectador
		this.asiento = asiento;
		this.nombre = nombre;
		this.edad = edad;
		this.alimento = alimento;
	}

	public String getAsiento() {
		return asiento;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public String getAlimento() {
		return alimento;
	}
	
	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Espectador other = (Espectador) obj;
		return Objects.equals(asiento, other.asiento);
	}
	
	public int compareTo(Espectador otro) {
		return asiento.compareTo(otro.getAsiento());
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("Espectador con asiento: " + asiento);
		cad.append("\nllamado: " + nombre);
		cad.append("\nde edad: " + edad);
		cad.append("\nque compro: " + alimento);
		
		return cad.toString();
	}
}
