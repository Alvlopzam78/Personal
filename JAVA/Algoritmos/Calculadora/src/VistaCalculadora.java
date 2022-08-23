import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*Alvaro Lopez
 * 28 Nov 2021
 * Clase que programa la vista para una calculadora
 */

public class VistaCalculadora extends JFrame{
	protected JTextField numTxt;
	protected JButton unoBt, dosBt, tresBt, cuatroBt, cincoBt, seisBt, sieteBt, ochoBt, nueveBt, ceroBt, sumaBt, restaBt, multiBt, divideBt, igualBt;
	
	public VistaCalculadora() {
		unoBt = new JButton("1");
		dosBt = new JButton("2");
		tresBt = new JButton("3");
		cuatroBt = new JButton("4");
		cincoBt = new JButton("5");
		seisBt = new JButton("6");
		sieteBt = new JButton("7");
		ochoBt = new JButton("8");
		nueveBt = new JButton("9");
		ceroBt = new JButton("0");
		sumaBt = new JButton("+");
		restaBt = new JButton("-");
		divideBt = new JButton("/");
		multiBt = new JButton("*");
		igualBt = new JButton("=");
		numTxt = new JTextField(12);
		
		this.setLayout(new FlowLayout());
		JPanel p1 = new JPanel();
		
		p1.setLayout(new GridLayout(4,4));
		p1.add(unoBt);
		p1.add(dosBt);
		p1.add(tresBt);
		p1.add(numTxt);
		p1.add(cuatroBt);
		p1.add(cincoBt);
		p1.add(seisBt);
		p1.add(sumaBt);
		p1.add(sieteBt);
		p1.add(ochoBt);
		p1.add(nueveBt);
		p1.add(restaBt);
		p1.add(multiBt);
		p1.add(ceroBt);
		p1.add(divideBt);
		p1.add(igualBt);
		this.add(p1);
		
		this.setBounds(50, 50, 725, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/*public static void main(String[] args) {
		VistaCalculadora prueba = new VistaCalculadora();
	}*/
}
