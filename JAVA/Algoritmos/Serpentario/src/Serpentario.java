import java.util.Objects;

/*Alvaro Lopez
 * 
 */
public class Serpentario {
	
	private String nombre;
	private Serpiente [][] serpientes;
	private Integer [] cantSerp;
	private final int TIPOS = 3;
	private final int MAX_SERP = 10;
	private final String [] NOM_TIPO = {"Constrictor", "Venenosa", "Varios"};
	
	public Serpentario(String nombre) {
		this.nombre = nombre;
		serpientes = new Serpiente[TIPOS][MAX_SERP];
		cantSerp = new Integer[TIPOS];
		for(int i = 0; i<TIPOS; i++)
			cantSerp[i] = 0;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getUnaSerpiente(int clave) {
		int pos, ren;
		boolean aux = false;
		Serpiente serp = new Serpiente(clave);
		String res = "Serpiente no encontrada";
		
		ren = 0;
		while(ren<TIPOS && !aux) {
			pos = ManejadorArreglosGenerico.busSecDesorden(serpientes[ren], cantSerp[ren], serp);
			if(pos>=0) {
				aux=true;
				res=serpientes[ren][pos].toString();
			}
			ren++;
		}
		return res;
			
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean altaSerpiente(String tipo, double longitud, double peso, String alimento, char genero){
		boolean res = false;
		Serpiente serp = new Serpiente(tipo, longitud, peso, alimento, genero);
		int posTipo, n;
		
		posTipo=ManejadorArreglosGenerico.busSecDesorden(NOM_TIPO, TIPOS, tipo);
		n = ManejadorArreglosGenerico.insertaFinal(serpientes[posTipo], cantSerp[posTipo], serp);
		if(n!=cantSerp[posTipo]) {
			res = true;
			cantSerp[posTipo]=n;
		}
		return res;
	}
	
	public String bajaSerpiente(int clave) {
		int pos, ren;
		boolean aux = false;
		Serpiente serp = new Serpiente(clave);
		String res = "Serpiente no encontrada";
		
		ren = 0;
		while(!aux && ren<TIPOS) {
			pos = ManejadorArreglosGenerico.busSecDesorden(serpientes[ren], cantSerp[ren], serp);
			if(pos>=0) {
				aux=true;
				res=serpientes[ren][pos].toString();
				cantSerp[ren] = ManejadorArreglosGenerico.eliminaPos(serpientes[ren], cantSerp[ren], pos);
			}
			ren++;
		}
		return res;
	}
	
	public int cuentaPorAlimento(String alimento){
		int res = 0;
		
		for(int i=0; i<TIPOS;i++)
			for(int j=0;j<cantSerp[i];j++)
				if(serpientes[i][j].getAlimento().equals(alimento))
					res++;
		return res;
	}
	
	public String tipoMaxSerp() {
		int maxPos;
		
		maxPos=ManejadorArreglosGenerico.posMayor(cantSerp, TIPOS);
		return NOM_TIPO[maxPos];
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serpentario other = (Serpentario) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	public int compareTo(Serpentario otro) {
		return this.nombre.compareTo(otro.nombre);
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("\nSerpentario de nombre: " + nombre);
		cad.append("\nCon serpientes:\n" );
		for(int i=0;i<TIPOS;i++) {
			cad.append(NOM_TIPO[i] + ": " + cantSerp[i]+"\n");
			for(int j=0;j<cantSerp[i];j++)
				cad.append(serpientes[i][j]+"\n");
		}
		return cad.toString();
	}
}
