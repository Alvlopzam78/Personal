import java.util.ArrayList;
import java.util.Scanner;

/*Alvaro Lopez
 * 20 sept 2021
 * Codigo que prueba la funcion ullman
 */
public class MainUllman {

	public static void main(String[] args) {
		Scanner lec;
		int n;
		ArrayList<Double> res;
		
		lec=new Scanner(System.in);
		n=lec.nextInt();
		res=FuncionesSimples.ullman(n);
		System.out.println(res.toString()); //Hay que poner el toString para saber que estamos haciendo 
		//Mostrar el elemento en pos=4. Es decir el 5to de la serie
		System.out.println(res.get(4));
	}

}
