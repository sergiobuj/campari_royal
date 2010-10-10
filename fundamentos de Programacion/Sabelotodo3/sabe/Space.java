/**
 * Paquete que contiene todo el Sabelotodo desarrollado por Sergio Botero Uribe 200710001010
 */
package sabe;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * @author Sergio Botero 200710001010
 * @version 2.0
 */
/**
 * Contiene toda la información de casilla
 */
public class Space extends JButton{
	private static final long serialVersionUID = 1L;

	/**
	 * Valor que determina la fila de esta casilla
	 */
	public int myRow;
	/**
	 * Valor que determina la columna de esta casilla
	 */
	public int myColumn;
	/**
	 * Valor que determina el tema de esta casilla
	 */
	int theTopic;
	

	
	public Space(int row, int column, int topic, int line) {
		myRow = row-1;
		myColumn = column-1;
		theTopic = topic;
		this.setText(null);
		
		switch (topic) {
		case (1):
			this.setBackground(Color.red);
		


			break;
		case (2):
			this.setBackground(Color.yellow);


			break;
		case (3):
			this.setBackground(Color.blue);
		

			break;
		case (4):
			this.setBackground(Color.green);


			break;
		default:
			JOptionPane.showMessageDialog(null,
					"Se produjo un error porque existe un valor determinado para  "
							+ '\n' + "el tema de una casilla que no es válido."
							+ '\n' + '\n' + "Este valor aparece como -" + topic
							+ "-" + '\n' + "en la linea numero " + line
							+ " del archivo del tablero." + '\n' + '\n'
							+ "El juego no se puede ejecutar y se cerrará."
							+ '\n' + '\n', "Juego Sabelotodo -ERROR-",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			break;
		}
	}


	/** devuelve el tema de la casilla
	 * @return the theTopic que es un numero entre 1 y 4
	 */
	public int getTheTopic() {
		return theTopic;
	}

	/**entrega el numero de la columna en el tablero
	 * @return the myColumn
	 */
	public int getMyColumn() {
		return myColumn;
	}

	/**entrega el numero de la fila en el tablero
	 * @return the myRow
	 */
	public int getMyRow() {
		return myRow;
	}
}
