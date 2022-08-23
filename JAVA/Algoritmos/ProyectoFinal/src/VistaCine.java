import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

/* Alvaro Lopez Zamora
 * 23 nov 2021
 * Clase que diseña la vista para la clase cine
 */

public class VistaCine extends JFrame{
	private JLabel taquillaLb, basuraLb1, basuraLb2, salaLb, asientoLb, nombreLb, edadLb, alimentoLb, datosSalasLb, tipoLb, filasLb, columnasLb, peliculaLb;
	protected JTextField salaTxt, asientoTxt, nombreTxt, edadTxt, tipoTxt, filasTxt, colsTxt, peliculaTxt;
	protected JButton altaBt, bajaBt, verSalaBt, verEspBt, compraBoletoBt, devuelveBoletoBt, compraAlimentoBt, salaMasLlenaBt, cuantosAlimentoBt, cuantosMayEdadBt, infoCineBt;
	protected JTextArea infoTxt;
	private final String[] alimentos = {"","Palomitas", "Refresco","Dulces","Combo"}; //arreglo para la lista desplegable
	protected final JComboBox<String> alimentoJCB = new JComboBox<String>(alimentos);
	protected JScrollPane pane;
	
	public VistaCine(String titulo) { //constructor de la vista con la instanciacion de todos los componentes
		super(titulo);
		Font font = new Font("Courier", Font.BOLD,12);
		
		taquillaLb = new JLabel("Taquilla");
		taquillaLb.setFont(font);
		basuraLb1 = new JLabel("       ");
		basuraLb2 = new JLabel("       ");
		salaLb = new JLabel("Numero de sala");
		asientoLb = new JLabel("Numero de asiento");
		nombreLb = new JLabel ("Nombre");
		edadLb = new JLabel("Edad");
		alimentoLb = new JLabel("Alimento");
		datosSalasLb = new JLabel("Datos salas");
		datosSalasLb.setFont(font);
		tipoLb = new JLabel("Tipo de sala");
		filasLb = new JLabel("Numero de filas");
		columnasLb = new JLabel("Numero de columnas");
		peliculaLb = new JLabel("Pelicula");
		salaTxt = new JTextField(12);
		asientoTxt = new JTextField(12);
		nombreTxt = new JTextField(12);
		edadTxt = new JTextField(12);
		tipoTxt = new JTextField(12);
		filasTxt = new JTextField(12);
		colsTxt = new JTextField(12);
		peliculaTxt = new JTextField(12);
		altaBt = new JButton("Registrar sala");
		bajaBt = new JButton("Dar sala de baja");
		verSalaBt = new JButton("Ver sala");
		verEspBt = new JButton("Info espectador");
		compraBoletoBt = new JButton("Compra boleto");
		devuelveBoletoBt = new JButton("Devuelve boleto");
		compraAlimentoBt = new JButton("Compra alimento");
		salaMasLlenaBt = new JButton("Sala mas llena");
		cuantosAlimentoBt = new JButton("Cuantos de cierto alimento");
		cuantosMayEdadBt = new JButton("Cuantos mayores de edad");
		infoCineBt = new JButton("Info cine");
		infoTxt = new JTextArea(20,35);
		pane = new JScrollPane(infoTxt); //instanciamos un objeto de JScrollPane para las scroll bars
		
		this.setLayout(new FlowLayout()); //establecemos el layout de nuestra vista
		JPanel p1 = new JPanel(); //instanciamos un nuevo panel
		p1.setLayout(new GridLayout(7,2)); //establecemos el layuot del panel
		p1.add(taquillaLb);
		p1.add(basuraLb1);
		p1.add(salaLb);
		p1.add(salaTxt);
		p1.add(asientoLb);
		p1.add(asientoTxt);
		p1.add(nombreLb);
		p1.add(nombreTxt);
		p1.add(edadLb);
		p1.add(edadTxt);
		p1.add(alimentoLb);
		p1.add(alimentoJCB);
		this.add(p1); //agregamos cada componente al panel y luego el panel a nuestra vista
		
		JPanel p2 = new JPanel();
		p2.add(pane);
		this.add(p2);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(5,2));
		p3.add(datosSalasLb);
		p3.add(basuraLb2);
		p3.add(tipoLb);
		p3.add(tipoTxt);
		p3.add(filasLb);
		p3.add(filasTxt);
		p3.add(columnasLb);
		p3.add(colsTxt);
		p3.add(peliculaLb);
		p3.add(peliculaTxt);
		this.add(p3);
		
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(2,5));
		p4.add(compraBoletoBt);
		p4.add(devuelveBoletoBt);
		p4.add(compraAlimentoBt);
		p4.add(cuantosMayEdadBt);
		p4.add(cuantosAlimentoBt);
		p4.add(salaMasLlenaBt);
		p4.add(altaBt);
		p4.add(bajaBt);
		p4.add(verSalaBt);
		p4.add(verEspBt);
		this.add(p4);
		
		JPanel p5 = new JPanel();
		p5.setLayout(new GridLayout(2,1));
		p5.add(infoCineBt);
		this.add(p5);
		
		this.setBounds(25, 25, 1100, 500); //establecemos las dimensiones y la posicion de nuestra vista
		this.setVisible(true); //establecemos que sea visible
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //establecemos la accion de cierre
	}
	
	/*public static void main(String[] args) {
		VistaCine vistaCine = new VistaCine("P R U E B A");
	}*/

}
