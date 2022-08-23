import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControladorCine extends VistaCine{

	private Cine cine = new Cine("Cine ALZ","Av. Vasco de Quiroga 234");
	
	public ControladorCine(String titulo) {
		super(titulo);
		
		//agregamos a los botones escuchadores para poder establecer la funcionalidad de la vista
		altaBt.addActionListener(new EscuchadorAlta()); 
		bajaBt.addActionListener(new EscuchadorBajaBuscaMay());
		verSalaBt.addActionListener(new EscuchadorBajaBuscaMay());
		verEspBt.addActionListener(new EscuchadorVerEspDev());
		compraBoletoBt.addActionListener(new EscuchadorCompraBoleto());
		devuelveBoletoBt.addActionListener(new EscuchadorVerEspDev());
		compraAlimentoBt.addActionListener(new EscuchadorCompraAlimento());
		salaMasLlenaBt.addActionListener(new EscuchadorSalaLlenaInfo());
		cuantosAlimentoBt.addActionListener(new EscuchadorCuantosAlimento());
		cuantosMayEdadBt.addActionListener(new EscuchadorBajaBuscaMay());
		infoCineBt.addActionListener(new EscuchadorSalaLlenaInfo());
	}
	
	private class EscuchadorAlta implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			JFrame parent = new JFrame();
			String tipoStr, pelicula;
			int filas, columnas;
			
			//Leer la informacion de la vista
			tipoStr = tipoTxt.getText();
			filas = Integer.parseInt(filasTxt.getText());
			columnas = Integer.parseInt(colsTxt.getText());
			pelicula = peliculaTxt.getText();
			if(cine.altaSala(tipoStr, filas, columnas, pelicula))
				JOptionPane.showMessageDialog(parent, "Alta de sala exitosa"); //se muestra un PopUp
			else
				JOptionPane.showMessageDialog(parent, "Error en alta de sala");
			
		}
	}
	
	private class EscuchadorBajaBuscaMay implements ActionListener{//se implementa un solo escuchador para metodos similares
		public void actionPerformed(ActionEvent ae) {
			JFrame parent = new JFrame();
			int numSala;
			String nomBoton, res;
			
			nomBoton = ae.getActionCommand();	//se guarda el nombre del boton presionado 
			numSala = Integer.parseInt(salaTxt.getText());
			res="";
			if(nomBoton.equals("Dar sala de baja")) //se valida el nombre del boton para saber que hacer
				if(cine.bajaSala(numSala))
					JOptionPane.showMessageDialog(parent, "Baja de sala exitosa");
				else
					JOptionPane.showMessageDialog(parent, "Error en baja de sala");
			else if(nomBoton.equals("Ver sala"))
				infoTxt.setText(cine.getUnaSala(numSala));
				else {
					res = ""+cine.cuantosMayEdadSala(numSala);
					infoTxt.setText("Hay " + res+ " espectadores mayores de edad " + "en la sala " + numSala);
				}
		}
	}
	
	private class EscuchadorVerEspDev implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			JFrame parent = new JFrame();
			String asiento;
			int numSala;
			String nomBoton;
			
			nomBoton = ae.getActionCommand();
			asiento = asientoTxt.getText();
			numSala = Integer.parseInt(salaTxt.getText());
			
			if(nomBoton.equals("Info espectador"))
				infoTxt.setText(cine.getEspectadorSala(numSala, asiento));
			else if(cine.devuelveBoleto(numSala, asiento))
					JOptionPane.showMessageDialog(parent, "Boleto devuelto");
				else
					JOptionPane.showMessageDialog(parent, "Error en devolucion");
		}
	}
	
	private class EscuchadorCompraBoleto implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			JFrame parent = new JFrame();
			int numSala;
			String asiento;
			String nombre;
			int edad;
			String alimento;
			
			numSala = Integer.parseInt(salaTxt.getText());
			asiento = asientoTxt.getText();
			nombre = nombreTxt.getText();
			edad = Integer.parseInt(edadTxt.getText());
			alimento = alimentoJCB.getSelectedItem().toString(); //se guarda la opcion seleccionada de la lista desplegable
			
			if(cine.compraBoleto(numSala, asiento, nombre, edad, alimento))
				JOptionPane.showMessageDialog(parent, "Compra de boleto exitosa");
			else
				JOptionPane.showMessageDialog(parent, "Error en compra de boleto");
		}
	}
	
	public class EscuchadorCompraAlimento implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			JFrame parent = new JFrame();
			int numSala;
			String asiento;
			String alimento;
			
			numSala = Integer.parseInt(salaTxt.getText());
			asiento = asientoTxt.getText();
			alimento = alimentoJCB.getSelectedItem().toString();
			
			if(cine.compraAlimento(numSala, asiento, alimento))
				JOptionPane.showMessageDialog(parent, "Compra de alimento exitosa");
			else
				JOptionPane.showMessageDialog(parent, "Error en compra de alimento");
		}
	}
	
	public class EscuchadorSalaLlenaInfo implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			int num;
			String sala;
			String nomBoton;
			
			nomBoton = ae.getActionCommand();
			if(nomBoton.equals("Sala mas llena")){
					num = cine.salaMasLlena();
					sala = cine.getUnaSala(num);
					infoTxt.setText(sala);
			}
			else
				infoTxt.setText(cine.toString());
		}
	}
	
	public class EscuchadorCuantosAlimento implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			int numSala;
			String alimento;
			String res;
			
			numSala = Integer.parseInt(salaTxt.getText());
			alimento = alimentoJCB.getSelectedItem().toString();
			res = ""+cine.cuantosAlimentoSala(numSala, alimento);
			if(!alimento.equals(""))
				infoTxt.setText("Hay " + res + " espectadores que compraron " + alimento + " en la sala " + numSala);
			else
				infoTxt.setText("E R R O R");
		}
	}
	
	public void altaArchivo() { //metodo para la lectura del archivo
		File ent = new File("cine.txt");
		String tipoSala, nombreEsp, asiento, alimento, pelicula;
		int numFilas, numCol, edad, n, numSala;
		
		try(Scanner lec = new Scanner(ent);){
			while(lec.hasNext()){
				tipoSala = lec.next();
				numFilas = lec.nextInt();
				numCol = lec.nextInt();
				pelicula = lec.next();
				if(cine.altaSala(tipoSala, numFilas, numCol, pelicula))
					System.out.println("Alta de sala existosa");
				else
					System.out.println("Error en alta de sala");
				n = lec.nextInt();
				for(int i=1;i<=n;i++) {
					numSala = lec.nextInt();
					asiento = lec.next();
					nombreEsp = lec.next();
					edad = lec.nextInt();
					alimento = lec.next();
					if(cine.compraBoleto(numSala, asiento, nombreEsp, edad, alimento))
						System.out.println("Alta de espectador existosa");
					else
						System.out.println("Error en alta de espectador");
				}
			}
			lec.close();
		}
		catch(FileNotFoundException fnfe) {
			System.err.println("ERROR " + fnfe);
			System.exit(-1);
		}
	}
	public static void main(String[] args) {
		ControladorCine contCine = new ControladorCine("Cine ALZ");
		contCine.altaArchivo(); //se lee el archivo al ejecutar
	}

}
