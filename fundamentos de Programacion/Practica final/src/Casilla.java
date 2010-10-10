import java.awt.Color;

import javax.swing.JButton;

public class Casilla extends JButton {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int fila;

	int columna;

	int tema;

	//Icon temas1 = new ImageIcon (getClass().getResource("files/tema1.gif"));
	//Icon temas2 = new ImageIcon (getClass().getResource("files/tema2.gif"));
	//Icon temas3 = new ImageIcon (getClass().getResource("files/tema3.gif"));
	//Icon temas4 = new ImageIcon (getClass().getResource("files/tema4.gif"));

	public Casilla(int fila1, int columna1, int tema1) {

		this.fila = fila1-1;
		this.columna = columna1-1;
		this.tema = tema1;
		this.setEnabled(false);
		this.setText(null);

		switch (tema) {
		case (1):
			this.setBackground(Color.RED);
			//this.setIcon(temas1);
			break;

		case (2):
			//this.setIcon(temas2);
			this.setBackground(Color.ORANGE);
			break;

		case (3):
			//this.setIcon(temas3);
			this.setBackground(Color.blue);
			break;

		case (4):
			//this.setIcon(temas3);
			this.setBackground(Color.GREEN);
			break;

		}

	}

	/**
	 * @return the columna
	 */
	public int getColumna() {
		return columna;
	}

	/**
	 * @return the fila
	 */
	public int getFila() {
		return fila;
	}

	/**
	 * @return the tema
	 */
	public int getTema() {
		return tema;
	}

}
