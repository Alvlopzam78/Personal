import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*Alvaro Lopez
 * 28 nov 2021
 * Clase que controla la VistaCalculadora
 */

public class ControladorCalculadora extends VistaCalculadora{
	private int num1;
	private int num2;
	private String operador;
	private double res;
	
	public ControladorCalculadora() {
		unoBt.addActionListener(new EscuchadorDigitos());
		dosBt.addActionListener(new EscuchadorDigitos());
		tresBt.addActionListener(new EscuchadorDigitos());
		cuatroBt.addActionListener(new EscuchadorDigitos());
		cincoBt.addActionListener(new EscuchadorDigitos());
		seisBt.addActionListener(new EscuchadorDigitos());
		sieteBt.addActionListener(new EscuchadorDigitos());
		ochoBt.addActionListener(new EscuchadorDigitos());
		nueveBt.addActionListener(new EscuchadorDigitos());
		ceroBt.addActionListener(new EscuchadorDigitos());
		sumaBt.addActionListener(new EscuchadorOperadores());
		restaBt.addActionListener(new EscuchadorOperadores());
		divideBt.addActionListener(new EscuchadorOperadores());
		multiBt.addActionListener(new EscuchadorOperadores());
		igualBt.addActionListener(new EscuchadorIgual());
	}
	
	private class EscuchadorDigitos implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			String nomBoton;
			
			nomBoton = ae.getActionCommand();
			numTxt.setText(numTxt.getText()+nomBoton);
		}
	}
	
	private class EscuchadorOperadores implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			num1 = Integer.parseInt(numTxt.getText());
			operador = ae.getActionCommand();
			numTxt.setText(null);
		}
	}
	
	private class EscuchadorIgual implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			num2 = Integer.parseInt(numTxt.getText());
			if(operador.equals("+"))
				res = num1 + num2;
			else if(operador.equals("-"))
				res = num1 - num2;
			else if(operador.equals("*"))
				res = num1*num2;
			else if(operador.equals("/"))
				res = num1/num2;
			numTxt.setText(""+res);
		}
	}
	
	public static void main(String[] args) {
		ControladorCalculadora calc = new ControladorCalculadora();
	}
}
