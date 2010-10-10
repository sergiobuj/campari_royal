import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

/**
 * PanelTablero
 * Panel que maneja el tablero con las celdas
 */
public class PanelTablero 
	extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private int numFilas;
	//private int numColumnas;
	private Celda [][] tablero;
	
	private ImageIcon cuadroAzul = null;
	//private ImageIcon cuadroRojo = null;
	//private ImageIcon cuadroBlanco = null;
	//private ImageIcon cuadroCafe = null;

	/**
	 * PanelTablero
	 * Consturctor.  Se cargan las imagenes que se van a mostrar
	 * sobre los botones
	 */
	public PanelTablero() {
		cargarImagenes();
	}
	
	/**
	 * dimensionarTablero
	 * se crea la matriz de celdas y se agregan al panel 
	 * en un gridLayout
	 */
	public void dimensionarTablero(int numFilas, int numColumnas) {
		
		setLayout(new GridLayout(numFilas, numColumnas));
		
		tablero = new Celda[numFilas][numColumnas];
		
		for (int i = 0; i < numFilas; i++) {
			for (int j = 0; j < numColumnas; j++) {
				Celda celda = new Celda(this, cuadroAzul, i, j);
				tablero[i][j] = celda;
				this.add(celda);
			}
		}
	}
	
	/**
	 * actionPerformed
	 * Se invoca cuando el usuario hace click en una celda.
	 * En el mensaje se recibe la fila y columna de la celda
	 * que presiono el usuario.
	 */
    public void actionPerformed(ActionEvent e) {
    	String s = e.getActionCommand();
	    Scanner scanner = new Scanner(s);
	    int fila = scanner.nextInt();
	    int columna = scanner.nextInt();
	    System.out.println("Click en casilla " + fila + "," + columna);	
    }
	
	/**
	 * cargarImagenes
	 * Se cargan las imagenes que se van a usar sobre los botones
	 */
	private void cargarImagenes() {
		cuadroAzul = createImageIcon("imagenes/azul.png");
		//cuadroRojo = createImageIcon("imagenes/rojo.png");
		//cuadroBlanco = createImageIcon("imagenes/blanco.png");
		//cuadroCafe = createImageIcon("imagenes/cafe.png");
	}
	
    /**
     * creteImageIcon 
     * Retorna un ImageIcon para dibujar sobre una celda, 
     * o null si el path es invalido. 
     **/
    private static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = PanelTablero.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("No pude encontrar el siguiente archivo: " + path);
            return null;
        }
    }	
}
