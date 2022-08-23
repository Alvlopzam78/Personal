/* Alvaro Lopez Zamora
 * 15 sept 2021
 * Clase que modela la realidad de una cuenta de banco
 */
public class CuentaBanco {
	private int numCta;
	private String nomTit;
	private double saldo;
	private static int consecutivoNumCta=123;
	
	public CuentaBanco() {
		numCta=consecutivoNumCta;
		consecutivoNumCta+=10;
	}
	
	public CuentaBanco(String nomTit, double saldo) {
		this();
		this.nomTit=nomTit;
		this.saldo=saldo;
	}
	
	public int getNumCta() {
		return numCta;
	}
	
	public String getNomTit() {
		return nomTit;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setNomTit(String nuevoNom) {
		nomTit=nuevoNom;
	}
	
	public boolean retiro(double cant) {
		boolean res=false;
		
		if(cant<=saldo) {
			saldo-=cant;
			res=true;
		}
		return res;
	}
	
	public void deposito(double cant) {
		saldo+=cant;
	}
	
	public String toString() {
		StringBuilder cad = new StringBuilder();
		
		cad.append("\nCuenta numero "+numCta);
		cad.append(" perteneciente a "+nomTit);
		cad.append(" con saldo "+saldo);
		
		return cad.toString();
	}
	
	public int compareTo(CuentaBanco otro) {
		int res;
		
		if(this.numCta==otro.numCta)
			res=0;
		else
			if(this.numCta>otro.numCta)
				res=1;
			else
				res=-1;
		return res;
	}
	
	public boolean equals(CuentaBanco otro) {
		boolean res;
		
		if(this.numCta==otro.numCta)
			res=true;
		else
			res=false;
		return res;
	}
}
