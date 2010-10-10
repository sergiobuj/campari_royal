import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * EjemploArchivo
 * Programa muy sencillo que crea una matriz de botones.
 * El tamanyo de la matriz se lee de un archivo tipo txt.
 */
public class EjemploArchivo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelTablero panelTablero; 
	private Archivo archivo;
	private int numFilas;
	private int numColumnas;
	
	/**
	 * Constructor
	 * Se adiciona el panel del tablero y se trata de
	 * abrir el archivo
	 */
	public EjemploArchivo() throws FileNotFoundException {
        this.setTitle("Tablero dinamico");
        //setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        
        panelTablero = new PanelTablero();
        add(panelTablero, BorderLayout.CENTER);		
        
        archivo = new Archivo("tablero.txt");
	}
		
	/**
	 * leerTamanyo
	 * Trata de leer el numero de filas y columnas del archivo
	 */
	public void leerTamanyo() throws IOException {
		String s = archivo.leerUnaLinea();
		Scanner scanner = new Scanner(s); 
		numFilas = scanner.nextInt();
		numColumnas = scanner.nextInt();
	}
	
	/**
	 * dimensionarTablero
	 * Se crea el tablero con el numero de filas y columnas
	 * leidas del archivo
	 */
	public void dimensionarTablero() {
		panelTablero.dimensionarTablero(numFilas, numColumnas);
	}
	
	/**
	 * inicializarJuego
	 * Se lee el tamanyo del tablero, se crea el tablero
	 * y se visualiza
	 */
	public void inicializarJuego() 
		throws FileNotFoundException, IOException {
		leerTamanyo();
		dimensionarTablero();
		pack();
		setVisible(true);	
	}
	
	/**
	 * main
	 * Programa principal.
	 * Se crea una instancia del juego y se inicializa
	 */
	public static void main(String [] args) 
		throws FileNotFoundException, IOException {
		EjemploArchivo ejemploArchivo = new EjemploArchivo();
		ejemploArchivo.inicializarJuego();
	}	
	
}