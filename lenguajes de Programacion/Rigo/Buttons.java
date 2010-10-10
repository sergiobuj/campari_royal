import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Buttons extends JButton implements ActionListener {

	// 1 para pared...2 para Rigo... 3 para tesoro
	int type = 0, fila, columna, tesoOriginal=0;

	Interfaz laInter;

	private static final long serialVersionUID = 1L;

	public Buttons(int fila, int columna, Interfaz laInter) {

		this.fila = fila;
		this.columna = columna;
		this.setText("0");
		this.addActionListener(this);
		this.laInter = laInter;
	}

	public void actionPerformed(ActionEvent arg0) {

		switch (laInter.reType) {
		case (1):
			tesoOriginal++;
			if (tesoOriginal == 6) {
				tesoOriginal = 0;
			}
			this.setText("" + tesoOriginal);
			type=0;
			break;
		case (2):
			type++;
			if (type == 6) {
				type = 1;
			}

			switch(type){
			case(1):
				this.setText("X");				
			break;
			case(2):
				this.setText(">");
				break;
			case(3):
				this.setText("v");
				break;
			case(4):
				this.setText("<");
				break;
			case(5):
				this.setText("^");
				break;
			}
		}

		laInter.clikeadoCol = this.columna;
		laInter.clikeadoFila = this.fila;

		if (type >= 2) {
			laInter.revisaRigo();
		}
	}

	/*
	 * public int randy() { Random randy = new Random(); int rand =
	 * randy.nextInt(6); return rand; }
	 */
	public int getColumna() {
		return columna;
	}

	public int getFila() {
		return fila;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	public int getTesoOriginal() {
		return tesoOriginal;
	}
}
