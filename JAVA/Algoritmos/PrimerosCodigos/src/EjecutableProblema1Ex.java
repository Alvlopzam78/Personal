import java.util.Scanner;

/* Álvaro
 * 8 sept 2021
 * Código correspondiente al diagrama de flujo del problema 1 del primer parcial
 */
public class EjecutableProblema1Ex {

	public static void main (String[] args) {
		int comT,terrT,polT,clave,com,pol,terr,k,temp;
		char tipo;
		double prom,tempT,serT;
		String maxU,max;
		Scanner lec;
		
		lec=new Scanner(System.in);
		comT=0;
		terrT=0;
		polT=0;
		tempT=0;
		serT=0;
		System.out.println("Escribe tu clave");
		clave=lec.nextInt();
		while(clave!=-1) {
			com=0;
			pol=0;
			terr=0;
			System.out.println("¿Cuántas series viste?");
			k=lec.nextInt();
			serT=serT+k;
			for(int i=1;i<=k;i++) {
				System.out.println("Escribe el género de la serie "+i);
				tipo=lec.next().charAt(0);
				System.out.println("¿Cuántas temporadas tiene?");
				temp=lec.nextInt();
				switch(tipo) {
				case 'c': com++;
				break;
				case 'p': pol++;
				break;
				case 't': terr++;
				}
				tempT=tempT+temp;
			}
			if(com>terr & com>pol) {
				maxU="comedia";
			}
			else {
				if(pol>terr) {
					maxU="policíaca";
				}
				else {
					maxU="terror";
				}
			}
			System.out.println("El género que más viste fue: "+maxU);
			System.out.println();
			comT=comT+com;
			polT=polT+pol;
			terrT=terrT+terr;
			if(terr==0) {
				System.out.println(clave+" no miró terror");
				System.out.println();
			}
			System.out.println("Escribe la siguiente clave");
			clave=lec.nextInt();
		}
		prom = tempT/serT;
		if(comT>terrT & comT>polT) {
			max="comedia";
		}
		else {
			if(polT>terrT) {
				max="policíaca";
			}
			else {
				max="terror";
			}
		}
		System.out.println("El género más visto fue: "+max);
		System.out.println("El promedio de temporadas por serie es: "+prom);
	}
}
