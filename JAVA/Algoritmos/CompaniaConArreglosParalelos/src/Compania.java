/*Alvaro Lopez	
 * 29 sept 2021
 * Clase que modela la realidad de una empresa
 */

public class Compania {
	private String nombre;
	private String direccion;
	private String ciudad;
	private String director;
	private double[] ventas;
	private final String[] NOM_MES={"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
	private int cantVentas;
	private final int TOTAL_MESES=12;
	
	public Compania() {
		ventas = new double[TOTAL_MESES];
		cantVentas = 0;
	}
	
	public Compania(String nombre, String direccion, String ciudad, String director) {
		this();
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.director = director;
	}
	
	public Compania(String nombre, String direccion, String ciudad, String director, int tam) {
		this.cantVentas=0;
		ventas = new double[tam];
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.director = director;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public String getDirector() {
		return director;
	}
	
	public double getUnaVenta(int mes) {
		double venta;
		
		if(mes<=cantVentas)
			venta = ventas[mes-1];
		else
			venta = -1;
		return venta;
	}
	
	public int getCantVentas() {
		return cantVentas;
	}
	
	public boolean altaVenta(double venta) {
		boolean res = false;
		
		if(cantVentas<ventas.length) {
			ventas[cantVentas]=venta;
			cantVentas++;
			res = true;
		}
		return res;
	} 
	
	public double promedioVentas() {
		return ManejadorArreglos.promedio(ventas,cantVentas);	
	}
	
	public String mesMayVentas() {
		int pos;
		
		pos = ManejadorArreglos.posMayor(ventas, cantVentas);
		return NOM_MES[pos];
	}
	
	public String mesMenVentas() {
		int pos;
		
		pos = ManejadorArreglos.posMenor(ventas, cantVentas);
		return NOM_MES[pos];
	}
	
	public int cuantosArribaPromedio() {
		double prom;
		
		prom=ManejadorArreglos.promedio(ventas, cantVentas);
		return ManejadorArreglos.cuantosMayX(ventas, cantVentas, prom);
	}
	
	public double totalMontoVentas() {
		return ManejadorArreglos.suma(ventas, cantVentas);
	}
	
	/*public String cualesMesesMayProm() {
		
	}*/
	
	public String mesConVenta(double venta){
		int pos;
		String mes;
		
		pos = ManejadorArreglos.busSecDesorden(ventas, cantVentas, venta);
		if(pos>=0)
			mes=NOM_MES[pos];
		else
			mes="Venta no encontrada";
		return mes;
	}
	
	public double ventaEnMes(String mes) {
		double venta;
		int i=0;
		
		while(i<cantVentas && !mes.equals(NOM_MES[i])){
			i++;
		}
		if(i==cantVentas) {
			venta = -1;
		}
		else
			venta=ventas[i];
		return venta;
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("\nCompañía de nombre: "+nombre);
		cad.append("\nDireccon:           "+direccion);
		cad.append("\nCiudad:             "+ciudad);
		cad.append("\nDirector:           "+director);
		cad.append("\nCantidad de Ventas: "+cantVentas);
		cad.append("\nCon ventas por mes: ");
		for(int i=0;i<cantVentas;i++) {
			cad.append("\n\t" + NOM_MES[i] +": " + ventas[i]);
		}
		return cad.toString();
	}
	
	public int compareTo(Compania otro) {
		int res;
		
		if(this.nombre.equals(otro.nombre))
			res=0;
		else
			if(this.nombre.compareTo(otro.nombre)>0)
				res=1;
			else
				res=-1;
		return res;
	}
	
	public boolean equals(Compania otro) {
		boolean res;
		
		if(this.nombre.equals(otro.nombre))
			res=true;
		else
			res=false;
		return res;
	}
}
