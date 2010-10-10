import javax.swing.*;

/**
 * Celda
 * Se maneja la informacion de una celda del juego.
 * Celda hereda de JButton
 */
public class Celda extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Celda
	 * Se recibe el panel que va a responder a los clicks del usuario,
	 * el icono para pintar sobre el boton
	 * la fila y la columna de la celda
	 */
	public Celda(PanelTablero panelTablero, ImageIcon icon, int fila, int columna){
		setIcon(icon);	
		setActionCommand(fila + " " + columna);
		addActionListener(panelTablero);
	}
}