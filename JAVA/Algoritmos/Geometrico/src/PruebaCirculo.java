
public class PruebaCirculo {

	public static void main(String[] args) {
		Circulo c1, c2;
		int comp;
		
		c1=new Circulo(3.4);
		System.out.println(c1.toString());
		c2=new Circulo(7.8);
		System.out.println(c2.toString());
		
		comp=c1.compareTo(c2);
		if(comp==0)
			System.out.println("Los 2 objetos son iguales");
		else
			if(comp>0)
				System.out.println("c1 es mayor que c2");
			else
				System.out.println("c1 es menor que c2");
	}

}
