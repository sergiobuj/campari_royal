/**
 * Paquete que contiene todo el Sabelotodo desarrollado por Sergio Botero Uribe 200710001010
 */
package sabe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Sergio Botero 200710001010
 *
 * @version 3.0
 * 
 */

 /** 
 * Clase que extiende de JFrame y es la pantalla principal.
 */
public class FramePpal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	/**
	 * label  que se usa para rellenar vacios
	 */
	JLabel empty1,empty, notValid;

	/**
	 * boton de la primera ventana
	 * 
	 */
	JButton play, quit, info;

	/**
	 * Cte para manejo de evento
	 */
	public static final String EMPEZAR = "empieza",SALIR = "salir",INFO = "info";

	/**
	 * imagen usada en la ventana de informacion
	 */
	ImageIcon cara = new ImageIcon("Images/cara.png");
	/**
	 * imagen usada para representar las casillas nulas
	 */
	ImageIcon muro = new ImageIcon("Images/muro.png");
	

	/**
	 * Archivo que se lee para preguntas y para tablero
	 */
	ReadFile textBoard, textQuestions;

	/**
	 * numero
	 */
	int columns, rows, position = 0;

	/**
	 * Matriz del tablero
	 */
	Space board[][];

	/**
	 * Frame donde se desarrolla el juego
	 */
	FrameGame theGame;

	/**
	 * comboBox de donde se seleccionan el numero de preguntas para ganar el juego
	 */
	JComboBox comboNumQ;

	/**
	 * arreglo
	 */
	ArrayList playersNames, questions1 = new ArrayList(),
			questions2 = new ArrayList(), questions3 = new ArrayList(),
			questions4 = new ArrayList();

	/**
	 * panel donde se introducen los nombres de los jugadores
	 */
	PanelNames panelNames;

	/**
	 * Constructor de la ventana principal donde aparecen los espacios para
	 * escribir los nombres de los jugadores. Es un JFrame y contiene una
	 * botonera y un JPanel con los campos de texto.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 *             se lanza en caso de que el "LookAndFeel" no se pueda hacer.
	 * @throws IllegalAccessException
	 *             se lanza en caso de que el "LookAndFeel" no se pueda hacer.
	 * @throws InstantiationException
	 *             se lanza en caso de que el "LookAndFeel" no se pueda hacer.
	 * @throws ClassNotFoundException
	 *             se lanza en caso de que el "LookAndFeel" no se pueda hacer.
	 * 
	 */
	public FramePpal() throws IOException, ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		String numQs[] = { "2 Preguntas correctas",
				"3 Preguntas correctas", "4 Preguntas correctas" };

		this.setTitle("Juego Sabelotodo v3.0");
		this.setLayout(new BorderLayout());
		this.add(panelNames = new PanelNames(this));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(500, 300));
		this.setResizable(true);
		JPanel buttons = new JPanel();
		this.add(buttons, BorderLayout.SOUTH);
		buttons.setLayout(new GridLayout(0, 3, 20, 20));
		buttons.add(empty1 = new JLabel("                   Ganar al Responder"));
		buttons.add(comboNumQ = new JComboBox(numQs));
		buttons.add(empty = new JLabel("de cada tema."));
		buttons.add(play = new JButton("Empezar"));
		play.setActionCommand(EMPEZAR);
		play.addActionListener(this);
		buttons.add(quit = new JButton("Salir"));
		quit.setActionCommand(SALIR);
		quit.addActionListener(this);
		buttons.add(info = new JButton("Acerca de"));
		info.setActionCommand(INFO);
		info.addActionListener(this);

		comboNumQ.setEditable(false);
		comboNumQ.setAlignmentX((float) CENTER_ALIGNMENT);

		play.setEnabled(false);
		JPanel left = new JPanel();
		this.add(left, BorderLayout.WEST);
		JPanel up = new JPanel();
		this.add(up, BorderLayout.NORTH);
		up.setLayout(new BorderLayout());
		textBoard = new ReadFile("tablero.txt");
		this.pack();
		this.setResizable(false);

	}

	/**
	 * este metodo lee la primera linea del archivo del tablero y saca los
	 * valores de fila y columna para después almacenarlos en las variables que
	 * se van a usar después para crear el tablero. Puede lanzar un error de IO
	 * y por eso se hace el try catch ahi mismo. Además controla que los valores
	 * en el documentos de texto designados para el tamaño del tablero sean
	 * validos.
	 */
	public void readSize() {
		String line;
		try {
			line = textBoard.readLine();
			Scanner scan = new Scanner(line);
			rows = scan.nextInt();
			columns = scan.nextInt();
			if (rows == 0) {
				/**
				 * Este mensaje de error es mostrado cuando el numero de filas
				 * en el archivo que especifica las dimensiones del tablero es
				 * igual a cero.
				 */
				JOptionPane
						.showMessageDialog(
								null,
								"el tablero no se puede crear con un numero"
										+ '\n'
										+ "de filas igual a 0."
										+ '\n'
										+ " "
										+ '\n'
										+ "Por favor cambie el archivo del tablero para jugar."
										+ '\n' + "El juego se cerrará. ",
								"Juego Sabelotodo -ERROR-",
								JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			if (columns == 0) {
				/**
				 * Este mensaje de error es mostrado cuando el numero de
				 * columnas en el archivo que especifica las dimensiones del
				 * tablero es igual a cero.
				 */
				JOptionPane
						.showMessageDialog(
								null,
								"el tablero no se puede crear con un numero"
										+ '\n'
										+ "de columnas igua a 0."
										+ '\n'
										+ " "
										+ '\n'
										+ "Por favor cambie el archivo del tablero para jugar."
										+ '\n' + "El juego se cerrará. ",
								"Juego Sabelotodo -ERROR-",
								JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			if (rows < 0) {
				/**
				 * Este mensaje de error es mostrado cuando el numero de filas
				 * en el archivo que especifica las dimensiones del tablero es
				 * menor que 1.
				 */
				JOptionPane
						.showMessageDialog(
								null,
								"el tablero no se puede crear con un numero"
										+ '\n'
										+ "de filas negativo."
										+ '\n'
										+ " "
										+ '\n'
										+ "Por favor cambie el archivo del tablero para jugar."
										+ '\n' + "El juego se cerrará. ",
								"Juego Sabelotodo -ERROR-",
								JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
			if (columns < 0) {
				/**
				 * Este mensaje de error es mostrado cuando el numero de
				 * columnas en el archivo que especifica las dimensiones del
				 * tablero es menor que 1.
				 */
				JOptionPane
						.showMessageDialog(
								null,
								"el tablero no se puede crear con un numero"
										+ '\n'
										+ "de columnas negativo."
										+ '\n'
										+ " "
										+ '\n'
										+ "Por favor cambie el archivo del tablero para jugar."
										+ '\n' + "El juego se cerrará. ",
								"Juego Sabelotodo -ERROR-",
								JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(
							null,
							"Las dimensiones del tablero no están"
									+ '\n'
									+ "bien especificadas o el formato no es el adecuado."
									+ '\n'
									+ " "
									+ '\n'
									+ "Por favor cambie el archivo del tablero para jugar."
									+ '\n' + "El juego se cerrará. ",
							"Juego Sabelotodo -ERROR-",
							JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
		board = new Space[rows][columns];
	}

	/**
	 * Este metodo crea los espacios que llenaran el tablero del juego y lo hace
	 * leyendo todas las lineas del archivo de texto ... tomando la información
	 * de las casillas y las adiciona en la matriz
	 * 
	 */
	public void createSpaces() {
		boolean done = false;
		int currentLine = 1;

		while (!done) {
			String line2;
			try {
				
				line2 = textBoard.readLine();
				currentLine++;
				Scanner scan = new Scanner(line2);
				try {
					int theRow = scan.nextInt();

					int theColumn = scan.nextInt();
					int theTheme = scan.nextInt();
					oneSpace(theRow, theColumn, theTheme, currentLine);

				} catch (Exception err) {
					JOptionPane
							.showMessageDialog(
									null,
									"Se produjo un error porque existe un valor determinado para  "
											+ '\n'
											+ "la creación de una casilla que no es válido."
											+ '\n'
											+ '\n'
											+ "Este valor no aparece entre los rangos esperados"
											+ '\n'
											+ "El error está en la linea numero "
											+ currentLine
											+ " del archivo del tablero."
											+ '\n'
											+ '\n'
											+ "El juego no se puede ejecutar y se cerrará."
											+ '\n' + '\n',
									"Juego Sabelotodo -ERROR-",
									JOptionPane.ERROR_MESSAGE);
					System.exit(0);

				}
			} catch (Exception e) {
				done = true;
			}
		}

	}

	/**
	 * este metodo puede muy bien ser eliminado... pero de cierta forma da mas
	 * claridad... se encarga de crear una casilla y de adicionarla a la matriz
	 * de tablero
	 * 
	 * @param row
	 *            es la fila de cada casilla que es sacada del archivo de texto
	 * @param column
	 *            es la columna de cada casilla que es sacada del archivo de
	 *            texto
	 * @param theme
	 *            es el tema de cada casilla que es sacada del archivo de texto
	 * @param line
	 *            es la linea que se está leyendo en el archivo de texto en ese
	 *            momento ... esto es solo para efectos de que se lance una
	 *            exception.
	 * 
	 * 
	 */
	public void oneSpace(int row, int column, int theme, int line) {
		Space space = new Space(row, column, theme, line);
		board[row - 1][column - 1] = space;
	}

	/**
	 * Metodo que se encarga de pasar la informacion, tales como preguntas
	 */
	public void passInfo() {
		theGame.questions1 = this.questions1;
		theGame.questions2 = this.questions2;
		theGame.questions3 = this.questions3;
		theGame.questions4 = this.questions4;
		theGame.numToWin = comboNumQ.getSelectedIndex() + 2;
	}

	/**
	 * este metodo se encarga de recorrer la matriz e ir llenando el GridLayout
	 * del tablero con cada casilla sacada de la matriz. cuando no encuentra una
	 * casilla en la matriz aqui simplemente se llena con un Label que indica
	 * que es una posicion no valida
	 * 
	 */
	public void fillBoard() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Space currentSpace = board[i][j];
				if (currentSpace == null) {
					theGame.board.add(notValid = new JLabel());
					notValid.setIcon(muro);
					//notValid.setAlignmentX((float) CENTER_ALIGNMENT);
				} else {
					theGame.board.add(currentSpace);
				}
			}
		}
	}

	/**
	 * el main
	 * 
	 * @param args
	 * @throws IOException,
	 *             que es generada si no se encuentra el archivo de texto con
	 *             las especificacines del tablero.
	 * @throws UnsupportedLookAndFeelException
	 *             se lanza por el "LookAndFeel"
	 * @throws IllegalAccessException
	 *             se lanza por el "LookAndFeel"
	 * @throws InstantiationException
	 *             se lanza por el "LookAndFeel"
	 * @throws ClassNotFoundException
	 *             se lanza por el "LookAndFeel"
	 */
	public static void main(String[] args) throws IOException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {

		FramePpal frame;
		try {
			frame = new FramePpal();
			frame.setVisible(true);
		} catch (FileNotFoundException e) {
			JOptionPane
					.showMessageDialog(
							null,
							"El archivo encargado de especificar las"
									+ '\n'
									+ "dimensiones del tablero no está."
									+ '\n'
									+ ""
									+ '\n'
									+ "Por favor busque el archivo del tablero y pongalo"
									+ '\n'
									+ "en la carpeta del 'Sabelotodo' para jugar"
									+ '\n' + "El juego se cerrará. ",
							"Juego Sabelotodo -ERROR-",
							JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
	}

	/**
	 * metodo que es usado para iniciar el juego, aui se cargan las dimensiones
	 * del tablero, se crean los espacios y se llena el tablero despues de haber
	 * leido la matriz, en este punto ya quedan los jugadores tambien en sus
	 * posiciones iniciales. se carga desde el boton de jugar.
	 * 
	 * @throws IOException
	 */
	public void initiateGame() {
		loadQuestions();
		this.readSize();
		this.createSpaces();
		this.setVisible(false);
		playersNames = panelNames.players;
		theGame = new FrameGame(rows, columns, playersNames, board);
		this.fillBoard();
		theGame.setVisible(true);
		this.givePositions();
		JOptionPane.showMessageDialog(null, "Preguntas del Juego Sabelotodo." + '\n'
				+ "El juego tiene: " + '\n' + questions1.size()
				+ " preguntas de Geografía" + '\n' + questions2.size()
				+ " preguntas de Historia" + '\n' + questions3.size()
				+ " preguntas de Deportes" + '\n' + questions4.size()
				+ " preguntas de Cultura General" + '\n' + "",
				"Juego Sabelotodo -INFORMACIÓN-", JOptionPane.PLAIN_MESSAGE);
		passInfo();
		this.dispose();

	}

	/**
	 * este metodo intenta darle una posicion a los jugadores en el tablero...
	 * una posicion a cada uno.
	 * 
	 */
	public void givePositions() {
		boolean stop = false;
		for (int i = 0; i < rows && !stop; i+=2) {
			for (int j = 0; j < columns && !stop; j+=2) {
				Space currentSpace = board[i][j];
				if (currentSpace != null) {
					Player player = (Player) playersNames.get(position);
					player.newPos(currentSpace);
					position++;
					if (position == playersNames.size()) {
						stop = true;
					}
				}
			}
		}
	}

	/**
	 * lee las preguntas del archivo de texto y las carga en
	 * 
	 * 
	 */
	public void loadQuestions() {
		String question = null, answer1 = null, answer2 = null, answer3 = null, correct = null, type;
		int topic = 0;

		try {
			textQuestions = new ReadFile("preguntasYRespuestas.txt");

			boolean done = false;
			while (!done) {
				try {
					String line = textQuestions.readLine();
					Scanner scan = new Scanner(line);
					type = scan.next();
					if (type.equals("p")) {
						topic = scan.nextInt();
						question = scan.nextLine();
					} else if (type.equals("c")) {
						correct = scan.nextLine();
					} else if (type.equals("r")) {
						if (answer1 == null) {
							answer1 = scan.nextLine();
						} else if (answer2 == null) {
							answer2 = scan.nextLine();
						} else if (answer3 == null) {
							answer3 = scan.nextLine();

						}
					}

					if (question != null && answer1 != null && answer2 != null
							&& answer3 != null && correct != null) {
						switch (topic) {
						case (1):
							questions1.add(new Question(1, question, correct,
									answer1, answer2, answer3));
							question = null;
							answer1 = null;
							answer2 = null;
							answer3 = null;
							correct = null;
							type = null;
							break;
						case (2):
							questions2.add(new Question(1, question, correct,
									answer1, answer2, answer3));
							question = null;
							type = null;
							answer1 = null;
							answer2 = null;
							answer3 = null;
							correct = null;
							break;
						case (3):
							questions3.add(new Question(1, question, correct,
									answer1, answer2, answer3));
							question = null;
							answer1 = null;
							answer2 = null;
							type = null;
							answer3 = null;
							correct = null;
							break;
						case (4):
							questions4.add(new Question(1, question, correct,
									answer1, answer2, answer3));
							question = null;
							answer1 = null;
							answer2 = null;
							answer3 = null;
							type = null;
							correct = null;
							break;
						}// switch
					}// fin if de switch

				} catch (Exception error) {
					done = true;
				}// while
			}
		} catch (FileNotFoundException e) {
			JOptionPane
					.showMessageDialog(
							null,
							"El archivo encargado de especificar las"
									+ '\n'
									+ "preguntas del juego no está."
									+ '\n'
									+ ""
									+ '\n'
									+ "Por favor busque el archivo de preguntas y pongalo"
									+ '\n'
									+ "en la carpeta del 'Sabelotodo' para jugar"
									+ '\n' + "El juego se cerrará. ",
							"Juego Sabelotodo -ERROR-",
							JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}

		if (questions1.size() == 0) {
			JOptionPane
					.showMessageDialog(
							null,
							"No se puede jugar si no se tiene al menos"
									+ '\n'
									+ "una pregunta de cada categoria"
									+ '\n'
									+ "falta al menos una pregunta del area tematica 1"
									+ '\n'
									+ "Por favor cambie el archivo de preguntas y pongalo"
									+ '\n'
									+ "en la carpeta del 'Sabelotodo' para jugar"
									+ '\n' + "El juego se cerrará. ",
							"Juego Sabelotodo -ERROR-",
							JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		} else if (questions2.size() == 0) {
			JOptionPane
					.showMessageDialog(
							null,
							"No se puede jugar si no se tiene al menos"
									+ '\n'
									+ "una pregunta de cada categoria"
									+ '\n'
									+ "falta al menos una pregunta del area tematica 2"
									+ '\n'
									+ "Por favor cambie el archivo de preguntas y pongalo"
									+ '\n'
									+ "en la carpeta del 'Sabelotodo' para jugar"
									+ '\n' + "El juego se cerrará. ",
							"Juego Sabelotodo -ERROR-",
							JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		} else if (questions3.size() == 0) {
			JOptionPane
					.showMessageDialog(
							null,
							"No se puede jugar si no se tiene al menos"
									+ '\n'
									+ "una pregunta de cada categoria"
									+ '\n'
									+ "falta al menos una pregunta del area tematica 3"
									+ '\n'
									+ "Por favor cambie el archivo de preguntas y pongalo"
									+ '\n'
									+ "en la carpeta del 'Sabelotodo' para jugar"
									+ '\n' + "El juego se cerrará. ",
							"Juego Sabelotodo -ERROR-",
							JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		} else if (questions4.size() == 0) {
			JOptionPane
					.showMessageDialog(
							null,
							"No se puede jugar si no se tiene al menos"
									+ '\n'
									+ "una pregunta de cada categoria"
									+ '\n'
									+ "falta al menos una pregunta del area tematica 4"
									+ '\n'
									+ "Por favor cambie el archivo de preguntas y pongalo"
									+ '\n'
									+ "en la carpeta del 'Sabelotodo' para jugar"
									+ '\n' + "El juego se cerrará. ",
							"Juego Sabelotodo -ERROR-",
							JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}

	}

	/**
	 * este action performed se encarga de los tres botones de la ventana
	 * principal, el de jugar que llama el metodo de iniciar el juego, el de
	 * salir que simplemente cierra la aplicacion, y el de información que tiene
	 * una ventana con información sobre el juego.
	 */
	public void actionPerformed(ActionEvent event) {
		String events = event.getActionCommand();

		if (events.equals("empieza")) {
			initiateGame();

		} else if (events.equals("salir")) {
			JOptionPane.showMessageDialog(null,
					"              Gracias por jugar SABELOTODO" + '\n'
					+ '\n' + " " + '\n' + "" + '\n' + ""
							+ "     vuelva pronto a probar sus conocimientos."
							+ '\n' + " " + '\n' + "" + '\n' + "",
					"Juego Sabelotodo -SALIDA-",
					JOptionPane.PLAIN_MESSAGE);

			System.exit(0);
		} else if (events.equals("info")) {
			JOptionPane.showMessageDialog(this, "Juego 'Sabelotodo' creado "
					+ '\n' + "por Sergio Botero Uribe 200710001010" + '\n'
					+ "en JAVA para Fundamentos de programación" + '\n'
					+ "universidad EAFIT primer semestre."+ '\n'
					+ "Trabajo final",
					"Juego Sabelotodo -ACERCA DE SABELOTODO-",
					JOptionPane.PLAIN_MESSAGE, cara);

		}

	}

}
