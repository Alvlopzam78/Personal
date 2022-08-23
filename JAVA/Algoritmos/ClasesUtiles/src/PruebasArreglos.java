
public class PruebasArreglos {

	private static final int CELDAS=700;
	
	public static void main(String[] args) {
		double[] arr;
		int [] a= {5, 4, 7, 9};
		
		
		arr=new double[CELDAS];
		System.out.println(arr.length);
		arr[0]=7.1;
		arr[1]=3.2;
		System.out.println(arr[0]);
		System.out.println(arr[3]);
	}

}
