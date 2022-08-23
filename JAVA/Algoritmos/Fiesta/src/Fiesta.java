import java.util.Objects;

/* Alvaro Lopez
 * 4 nov 2021
 * Clase que modela una fiesta con invitados y vacunas
 */

public class Fiesta {
	private String lugar;
	private String fecha;
	private Persona[] invitados;
	private int numInvitados;
	private final int MAX_INVITADOS = 50;
	
	public Fiesta(String lugar, String fecha) {
		invitados = new Persona[MAX_INVITADOS];
		numInvitados = 0;
		this.lugar = lugar;
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public String getFecha() {
		return fecha;
	}

	public int getNumInvitados() {
		return numInvitados;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getUnInvitado(int pos) {
		Persona invitado = null;
		
		if(pos>=0 && pos<numInvitados)
			invitado = invitados[pos];
		
		return invitado.toString();
	}
	
	public String getUnInvitado(String curp) {
		Persona invitado = new Persona(curp);
		int pos;
		
		pos = ManejadorArreglosGenerico.busSecDesorden(invitados, numInvitados, invitado);
		return invitados[pos].toString();
	}
	
	public boolean altaInvitado(String curp, String nombre, String edoCivil) {
		boolean res = false;
		Persona invitado;
		
		if(numInvitados < MAX_INVITADOS) {
			invitado = new Persona(curp, nombre, edoCivil);
			numInvitados = ManejadorArreglosGenerico.insertaFinal(invitados, numInvitados, invitado);
			res = true;
		}
		return res;
	}
	
	public boolean altaVacunaInvitado(String curp, String vacuna) {
		boolean res = false;
		Persona per = new Persona(curp);
		int bus;
		
		bus = ManejadorArreglosGenerico.busSecDesorden(invitados, numInvitados, per);
		if(bus>=0) {
			invitados[bus].altaVacuna(vacuna);
			res = true;
		}
		return res;
	}
	
	public String bajaInvitado(String curp) {
		String res = "Invitado no encontrado";
		Persona per = new Persona(curp);
		int bus;
		
		bus = ManejadorArreglosGenerico.busSecDesorden(invitados, numInvitados, per);
		if(bus>=0) {
			numInvitados = ManejadorArreglosGenerico.eliminaPos(invitados, numInvitados, bus);
			res = invitados[bus].toString();
		}
		return res;
	}
	
	public int cuantosGenero(char genero){
		int res=0;
		
		for(int i=0;i<numInvitados;i++) {
			if(invitados[i].getGenero()==genero)
				res++;
		}
		return res;
	}
	
	public boolean estaInvitado(String curp) {
		int bus;
		Persona per = new Persona(curp);
		boolean res=false;
		
		bus=ManejadorArreglosGenerico.busSecDesorden(invitados, numInvitados, per);
		if(bus>=0)
			res=true;
		return res;
	}
	
	public String elMasJoven() {
		Persona men = invitados[0];
		
		for(int i=1;i<numInvitados;i++)
			if(invitados[i].calculaEdad()<men.calculaEdad())
				men = invitados[i];
		return men.toString();
	}
	
	public String elMasViejo() {
		Persona may = invitados[0];
		
		for(int i=1;i<numInvitados;i++)
			if(invitados[i].calculaEdad()>may.calculaEdad())
				may = invitados[i];
		return may.toString();
	}
	
	public double promedioEdad() {
		double sum=0;
		double prom;
		
		for(int i=0;i<numInvitados;i++)
			sum+=invitados[i].calculaEdad();
		prom = sum/numInvitados;
		return prom;
	}
	
	public int cuantosEdoCivil(String edoCivil) {
		int res=0;
		
		for(int i=0;i<numInvitados;i++) {
			if(invitados[i].getEdoCivil().equals(edoCivil))
				res++;
		}
		return res;
	}
	
	public int cuantosVacunaAplicada(String vacuna) {
		int res=0;
		
		for(int i=0;i<numInvitados;i++) {
			if(invitados[i].vacunaAplicada(vacuna))
				res++;
		}
		return res;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lugar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fiesta other = (Fiesta) obj;
		return Objects.equals(fecha, other.fecha);
	}
	
	public int compareTo(Fiesta otra) {
		int res = -1;
		
		if(fecha.compareTo(otra.fecha)==0)
			res=0;
		else
			if(fecha.compareTo(otra.fecha)>0)
				res=1;
		return res;
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("Fiesta en: " + lugar);
		cad.append("fecha: " + fecha);
		cad.append("Invitados: " + numInvitados);
		for(int i=0;i<numInvitados;i++)
			cad.append(invitados[i].toString());
		return cad.toString();
	}
}
