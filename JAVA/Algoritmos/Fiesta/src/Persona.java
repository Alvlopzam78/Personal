import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/* Alvaro Lopez
 * 29 oct 2021
 * Persona con vacunas
 */
public class Persona implements Comparable<Persona>{
	private String nombre;
	private String curp;
	private char genero;
	private int ahoNac;
	private String cdNac;
	private String edoCivil;
	private String[] vacunas;
	private int numVacunas;
	private final int MAX_VACUNAS = 10;
	
	public Persona(String curp) {
		String ahoString;
		
		vacunas = new String[MAX_VACUNAS];
		numVacunas = 0;
		this.curp = curp.toUpperCase();
		cdNac = this.curp.substring(11, 13);
		ahoString = this.curp.substring(4, 6);
		ahoNac = Integer.parseInt(ahoString);
		if(ahoNac<20)
			ahoNac+=2000;
		else
			ahoNac+=1900;
		genero = this.curp.charAt(10);
	}

	public Persona(String curp, String nombre, String edoCivil) {
		this(curp);
		this.nombre = nombre;
		this.edoCivil = edoCivil;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCurp() {
		return curp;
	}

	public char getGenero() {
		return genero;
	}

	public int getAhoNac() {
		return ahoNac;
	}

	public String getCdNac() {
		return cdNac;
	}

	public String getUnaVacuna(int pos) {
		String nomVacuna = "Error";
		
		if(pos>=0 && pos<numVacunas)
			nomVacuna = vacunas[pos];
		
		return nomVacuna.toString();
	}

	public int getNumVacunas() {
		return numVacunas;
	}
	
	public String getEdoCivil() {
		return edoCivil;
	}
	
	public void setEdoCivi(String edoCivil) {
		this.edoCivil = edoCivil;
	}
	
	public int calculaEdad() {
		int ahos;
		int mes, dia;
		int diaHoy, mesHoy, ahoHoy;
		String mesStr, diaStr;
		Calendar calendario = new GregorianCalendar();
		
		mesStr = curp.substring(6, 8);
		diaStr = curp.substring(8, 10);
		mes = Integer.parseInt(mesStr)-1;
		dia = Integer.parseInt(diaStr)-1;
		mesHoy = calendario.get(Calendar.MONTH);
		diaHoy = calendario.get(Calendar.DAY_OF_MONTH);
		ahoHoy = calendario.get(Calendar.YEAR);
		ahos = ahoHoy - ahoNac;
		if(mesHoy<mes)
			ahos--;
		else
			if(mesHoy==mes && diaHoy<dia)
				ahos --;
		return ahos;
	}
	
	public boolean vacunaAplicada(String nomVacuna) {
		int pos;
		boolean res = false;
		
		pos = ManejadorArreglosGenerico.busBinaria(vacunas, numVacunas, nomVacuna);
		if(pos>=0)
			res = true;
		return res;
	}
	
	public boolean altaVacuna(String nomVacuna) {
		int n;
		boolean res;
		
		n = ManejadorArreglosGenerico.insertaEnOrden(vacunas, numVacunas, nomVacuna);
		if(n == numVacunas)
			res = false;
		else
			res = true;
		return res;
	}

	public int hashCode() {
		return Objects.hash(curp);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(curp, other.curp);
	}
	
	public int compareTo(Persona otra) {
		return curp.compareTo(otra.getCurp());
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Persona de nombre " + nombre);
		builder.append("\n curp= " + curp);
		builder.append("\n genero= " + genero);
		builder.append("\n ahoNac= " + ahoNac);
		builder.append("\n cdNac= " + cdNac);
		builder.append("\n edoCivil " + edoCivil);
		builder.append("\n numero de vacunas= " + numVacunas);
		for(int i=0;i<numVacunas;i++) {
			builder.append(vacunas[i].toString()+"\n");
		}
		return builder.toString();
	}
}
