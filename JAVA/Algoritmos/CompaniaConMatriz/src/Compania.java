import java.util.Objects;

/*Alvaro Lopez
 * 08 nov 2021
 * Clase que modela la realidad de una compañia con departamentos
 */

public class Compania {
	private String nombre;
	private double[][] ventas;
	private final String[] NOM_MES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
	private final String[] DEPTOS = {"Caballeros", "Damas", "Niños", "Juguetes"};
	private final int TOT_MESES = 12;
	private final int TOT_DEPTOS = 4;
	
	public Compania(String nombre) {
		ventas = new double[TOT_MESES][TOT_DEPTOS];
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public double getUnaVenta(String mes, String depto) {
		double venta;
		int posMes;
		int posDepto;
		
		posMes = ManejadorArreglosGenerico.busSecDesorden(NOM_MES, TOT_MESES, mes);
		posDepto = ManejadorArreglosGenerico.busSecDesorden(DEPTOS, TOT_DEPTOS, depto);
		if(posMes>=0 && posDepto>=0)
			venta = ventas[posMes][posDepto];
		else
			venta = -1;
		
		return venta;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean altaVenta(double venta, String mes, String depto) {
		boolean res = false;
		int posMes;
		int posDepto;
		
		posMes = ManejadorArreglosGenerico.busSecDesorden(NOM_MES, TOT_MESES, mes);
		posDepto = ManejadorArreglosGenerico.busSecDesorden(DEPTOS, TOT_DEPTOS, depto);
		if(posMes>=0 && posDepto>=0) {
			ventas[posMes][posDepto] = venta;
			res = true;
		}
		return res;
	}
	
	public String mesConMasVentas(String depto) {
		int posDepto;
		int posMes=0;
		String mes = "Mes no encontrado";
		
		posDepto = ManejadorArreglosGenerico.busSecDesorden(DEPTOS, TOT_DEPTOS, depto);
		if(posDepto>=0)
			posMes = ManejadorMatrices.posMayorCol(ventas, posDepto, TOT_MESES);
			mes = NOM_MES[posMes];
		return mes;
	}
	
	public double promVentasMes(String mes) {
		double prom;
		int posMes;
		
		posMes = ManejadorArreglosGenerico.busSecDesorden(NOM_MES, TOT_MESES, mes);
		if(posMes>=0)
			prom = ManejadorArreglos.promedio(ventas[posMes], TOT_DEPTOS);
		else
			prom = -1;
		return prom;
	}
	
	public double promVentasDepto(String depto) {
		int posDepto;
		double prom;
		double suma;
		
		posDepto = ManejadorArreglosGenerico.busSecDesorden(DEPTOS, TOT_DEPTOS, depto);
		if(posDepto>=0) {
			suma = ManejadorMatrices.sumaCol(ventas, posDepto, TOT_MESES);
			prom = suma/TOT_MESES;
		}
		else
			prom = -1;
		return prom;
	}
	
	public String mesSinVentas() {
		boolean aux = false;
		int i, j;
		String mes = "Mes no encontrado";
		
		i = 0;
		while(i<TOT_MESES && !aux) {
			j = 0;
			while(j<TOT_DEPTOS && ventas[i][j]==0) {
				j++;
			}
			if(j==TOT_DEPTOS) {
				aux=true;
				mes = NOM_MES[i];
			}
			i++;
		}
		return mes;
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
		Compania other = (Compania) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	public int compareTo(Compania otra) {
		int res = -1;
		
		if(this.nombre.compareTo(otra.nombre)==0)
			res=0;
		else
			if(this.nombre.compareTo(otra.nombre)>0)
				res=1;
		return res;
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("\nCompañía de nombre: "+nombre);
		cad.append("\nCon ventas por mes y departamento: \n\n");
		
		for(int i=0; i<TOT_DEPTOS; i++) {
			if(DEPTOS[i]=="Caballeros")
				cad.append("\t\t\t\t" + DEPTOS[i] + "\t");
			else
				cad.append(DEPTOS[i] + "\t\t");
		}
		cad.append("\n");
		for(int j=0; j<TOT_MESES; j++) {
			if(NOM_MES[j].endsWith("embre")) 
				cad.append("\t" + NOM_MES[j]);
			else
				cad.append("\t" + NOM_MES[j]+"     ");
			for(int i=0; i<TOT_DEPTOS; i++) {
				cad.append("\t\t"+ventas[j][i]);
			}
			cad.append("\n");
		}
		cad.append("\n"); 
		return cad.toString();
	}
}
