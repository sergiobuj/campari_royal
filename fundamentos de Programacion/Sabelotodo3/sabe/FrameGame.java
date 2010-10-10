/**
 * Paquete que contiene todo el Sabelotodo desarrollado por Sergio Botero Uribe 200710001010
 */
package sabe;

/**
 * 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

/**
 * @author Sergio Botero 200710001010 
 * @version 3.0
 * 
 * 
 */

/**
 * Clase que extiende de JFrame donde se desarrolla el juego.
 */
public class FrameGame extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;

	/**
	 * JPanel que va a contener información del juego en curso
	 */
	JPanel info;

	/**
	 * JPanel que muestra la informacion del turno
	 */
	JPanel turn;

	/**
	 * panel que muestra la informacion de un jugador
	 */
	JPanel positions, topic, player1, player2, player3, player4;

	/**
	 * panel que tiene el dado
	 */
	JPanel dice;
	/**
	 * panel que contiene el tablero
	 */
	JPanel board;
	/**
	 * panel que contiene los botones de movimiento
	 */
	JPanel movement;
	/**
	 * boton de movimiento
	 */
	JButton butDice, butUp, butDown, butLeft, butRight,butLeftUp,butLeftDown,butRightUp,butRightDown;

	/**
	 * imagen del dado
	 */
	ImageIcon dice1 = new ImageIcon("Images/1.png");
	/**
	 * imagen del dado
	 */
	ImageIcon dice2 = new ImageIcon("Images/2.png");
	/**
	 * imagen del dado
	 */
	ImageIcon dice3 = new ImageIcon("Images/3.png");
	/**
	 * imagen del dado
	 */
	ImageIcon dice4 = new ImageIcon("Images/4.png");
	/**
	 * imagen del dado
	 */
	ImageIcon dice5 = new ImageIcon("Images/5.png");
	/**
	 * imagen del dado
	 */
	ImageIcon dice6 = new ImageIcon("Images/6.png");
	/**
	 * imagen del dado
	 */
	ImageIcon dicePic = new ImageIcon("Images/dado.png");

	/**
	 * imagen del boton de movimiento
	 */
	ImageIcon arrowUp = new ImageIcon("Images/upB.png");
	
	/**
	 * imagen del boton de movimiento
	 */
	ImageIcon arrowUpR = new ImageIcon("Images/upR.png");
	/**
	 * imagen del boton de movimiento
	 */
	ImageIcon arrowDn = new ImageIcon("Images/downB.png");
	/**
	 * imagen del boton de movimiento
	 */
	ImageIcon arrowDnR = new ImageIcon("Images/downR.png");
	/**
	 * imagen del boton de movimiento
	 */
	ImageIcon arrowLeft = new ImageIcon("Images/leftB.png");
	/**
	 * imagen del boton de movimiento
	 */
	ImageIcon arrowLeftR = new ImageIcon("Images/leftR.png");
	/**
	 * imagen del boton de movimiento
	 */
	ImageIcon arrowRight = new ImageIcon("Images/rightB.png");
	/**
	 * imagen del boton de movimiento
	 */
	ImageIcon arrowRightR = new ImageIcon("Images/rightR.png");
	/**
	 * imagen del boton de movimiento
	 */
	ImageIcon arrowLeftUp = new ImageIcon("Images/leftUpB.png");
	/**
	 * imagen del boton de movimiento
	 */
	ImageIcon arrowLeftUpR = new ImageIcon("Images/leftUpR.png");
	/**
	 * imagen del boton de movimiento
	 */
	ImageIcon arrowLeftDn = new ImageIcon("Images/leftDnB.png");
	/**
	 * imagen del boton de movimiento
	 */
	ImageIcon arrowLeftDnR = new ImageIcon("Images/leftDnR.png");
	/**
	 * imagen del boton de movimiento
	 */
	ImageIcon arrowRightUp = new ImageIcon("Images/rightUpB.png");
	/**
	 * imagen del boton de movimiento
	 */
	ImageIcon arrowRightUpR = new ImageIcon("Images/rightUpr.png");
	/**
	 * imagen del boton de movimiento
	 */
	ImageIcon arrowRightDn = new ImageIcon("Images/rightDnB.png");
	/**
	 * imagen del boton de movimiento
	 */
	ImageIcon arrowRightDnR = new ImageIcon("Images/rightDnR.png");
	/**
	 * String usado para manejar los eventos con los botones
	 */
	static final String DICE = "dice",UP = "up", DOWN = "down",LEFT = "left",RIGHT = "right",RIGHTUP="rightU",RIGHTDN="rightD",LEFTUP="leftU",LEFTDN="leftD";
	/**
	 * random que genera el numero al azar del dado
	 */
	Random random;

	/**
	 * nombre del jugador
	 */
	JLabel name1, name2, name3, name4;
	/**
	 * puntos del area 1
	 */
	JLabel topic1_1, topic1_2, topic1_3, topic1_4;
	/**
	 * puntos del area 2
	 */
	JLabel topic2_1, topic2_2, topic2_3, topic2_4;
	/**
	 * puntos del area 3
	 */
	JLabel topic3_1, topic3_2, topic3_3, topic3_4;
	/**
	 * puntos del area 4
	 */
	JLabel topic4_1, topic4_2, topic4_3, topic4_4;
	/**
	 * muestra los temas en colores
	 */
	JLabel topic0, topic1, topic2, topic3, topic4;
	/**
	 * manej la informacion de jugador que tiene el turno
	 */
	JLabel currentName,currentNum, current1, current2, current3, current4, info1, info2,
			info3, info4;
	/**
	 * Jugador 1
	 */
	Player nameOf1 = null;
	/**
	 * Jugador 2
	 */
	Player nameOf2 = null;
	/**
	 * Jugador 3
	 */
	Player nameOf3 = null;
	/**
	 * Jugador 4
	 */
	Player nameOf4 = null;

	/**
	 * matriz que contiene el tablero del juego
	 */
	Space matrix[][];


	/**
	 * Jugador que tiene el turno de juego
	 */
	Player currentPlaying;

	/**
	 * Numero que varia de juego en juego
	 */
	int numToWin,rowsTotal, columnsTotal, movsLeft, currentPlayer = 0, numPlayers,
			numQ1 = 0, numQ2 = 0, numQ3 = 0, numQ4 = 0,totalOne,totalTwo,totalThree,totalFour;


	/**
	 * Arreglo qe contiene preguntas
	 */
	ArrayList questions1, questions2, questions3, questions4;
	/**
	 * Arreglo qe contiene jugadores
	 */
	ArrayList players, names,ranking;
	/**
	 * este es el contructor del frame que hace toda la interfaz del tablero y
	 * de la parte en si donde se desarrolla el juego.
	 * 
	 * @param rows
	 *            es el numero de filas que tiene el tablero.
	 * 
	 * @param columns
	 *            es el numero de columnas que tiene el tablero
	 * 
	 * @param names
	 *            es un ArrayList con los nombres de los jugadores.
	 * 
	 * @param matrix
	 *            la matriz de los botones y serve para determinar por donde se
	 *            puede mover el jugador en el tablero
	 */
	public FrameGame(int rows, int columns, ArrayList names, Space matrix[][]) {
		this.setTitle("Juego Sabelotodo v3.0");
		this.matrix = matrix;
		rowsTotal = rows;
		columnsTotal = columns;
		numPlayers = names.size();
		players = names;
		this.names = names;
		ranking = new ArrayList();

		this.setExtendedState(MAXIMIZED_BOTH);
		
		/**
		 * Este bloque carga cosas necesarias para el frame en general.
		 */
		random = new Random();
		this.setLayout(new BorderLayout());
		TitledBorder borderDice = BorderFactory.createTitledBorder("Dado");
		TitledBorder borderTurn = BorderFactory.createTitledBorder("Turno");
		TitledBorder borderPos = BorderFactory.createTitledBorder("Posiciones");
		TitledBorder borderBoard = BorderFactory.createTitledBorder("");

		/**
		 * Aqui se carga lo necesario para el panel del tablero ...y se carga.
		 */
		board = new JPanel();
		board.setLayout(new GridLayout(rows, columns));
		board.setBorder(borderBoard);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(900, 500));
		this.add(board, BorderLayout.CENTER);

		/**
		 * aqui se crea el panel del dado...se configuran los componenetes y
		 * luego se agrega en la creacion del panel de info
		 * 
		 */
		dice = new JPanel();
		dice.setLayout(new BorderLayout());
		dice.add(butDice = new JButton(),BorderLayout.CENTER);
		dice.setBorder(borderDice);
		dice.setPreferredSize(new Dimension(0, 100));
		butDice.setIcon(dicePic);
		butDice.setActionCommand(DICE);
		butDice.addActionListener(this);
		butDice.setBackground(Color.white);
		dice.setBackground(Color.white);
		butDice.setPreferredSize(new Dimension(100,99));
		butDice.setAlignmentX((float)CENTER_ALIGNMENT);
		butDice.setAlignmentY((float)CENTER_ALIGNMENT);
		

		/**
		 * Aqui se crea el panel que indica el jugador que tiene el turno de
		 * jugar..
		 */
		turn = new JPanel();
		turn.setBorder(borderTurn);
		turn.setLayout(new GridLayout(5, 2));
		turn.add(currentNum =new JLabel(""));
		turn.add(currentName = new JLabel(""));
		turn.add(info1 = new JLabel("1"));
		info1.setForeground(Color.red);
		info1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		turn.add(current1 = new JLabel(""));
		turn.add(info2 = new JLabel("2"));
		info2.setForeground(Color.yellow);
		info2.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		turn.add(current2 = new JLabel(""));
		turn.add(info3 = new JLabel("3"));
		info3.setForeground(Color.blue);
		info3.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		turn.add(current3 = new JLabel(""));
		turn.add(info4 = new JLabel("4"));
		info4.setForeground(Color.green);
		info4.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		turn.add(current4 = new JLabel(""));
		
		
		/**
		 * aqui se crea el panel de posiciones y se carga el minipanel de
		 * referencia de topicos
		 */
		int numRows = names.size() + 1;
		positions = new JPanel();
		positions.setLayout(new GridLayout(numRows, 0));
		positions.setBorder(borderPos);

		topic = new JPanel();
		topic.setLayout(new GridLayout(0, 5));
		topic0 = new JLabel("");
		topic1 = new JLabel("1");
		topic2 = new JLabel("2");
		topic3 = new JLabel("3");
		topic4 = new JLabel("4");
		topic1.setForeground(Color.red);
		topic2.setForeground(Color.yellow);
		topic3.setForeground(Color.blue);
		topic4.setForeground(Color.green);
		topic.add(topic0);
		topic.add(topic1);
		topic.add(topic2);
		topic.add(topic3);
		topic.add(topic4);

		/**
		 * aqui se cre el panel de movimiento que es el que contiene las flechas
		 * que moverán la ficha del jugador
		 */
		movement = new JPanel();
		JPanel movButtons = new JPanel();
		movButtons.setLayout(new GridLayout (3,3));
		this.add(movement, BorderLayout.SOUTH);
		movement.add(movButtons,BorderLayout.CENTER);
		movButtons.setPreferredSize(new Dimension(150,100));
		
		butLeftUp = new JButton();
		butLeftUp.setIcon(this.arrowLeftUp);
		butLeftUp.setRolloverIcon(this.arrowLeftUpR);
		
		butUp = new JButton();
		butUp.setIcon(this.arrowUp);
		butUp.setRolloverIcon(this.arrowUpR);
		
		butRightUp = new JButton();
		butRightUp.setIcon(this.arrowRightUp);
		butRightUp.setRolloverIcon(this.arrowRightUpR);
		
		
		butLeft = new JButton();
		butLeft.setIcon(this.arrowLeft);
		butLeft.setRolloverIcon(this.arrowLeftR);
		
		butRight = new JButton();
		butRight.setIcon(this.arrowRight);
		butRight.setRolloverIcon(this.arrowRightR);
		
		butLeftDown = new JButton();
		butLeftDown.setIcon(this.arrowLeftDn);
		butLeftDown.setRolloverIcon(this.arrowLeftDnR);
		
		butDown = new JButton();
		butDown.setIcon(this.arrowDn);
		butDown.setRolloverIcon(this.arrowDnR);
		
		butRightDown = new JButton();
		butRightDown.setIcon(this.arrowRightDn);
		butRightDown.setRolloverIcon(this.arrowRightDnR);
		
		movButtons.add(butLeftUp);
		movButtons.add(butUp);
		movButtons.add(butRightUp);
		movButtons.add(butLeft);
		movButtons.add(new JLabel(""));
		movButtons.add(butRight);
		movButtons.add(butLeftDown);
		movButtons.add(butDown);
		movButtons.add(butRightDown);
		
		butUp.setActionCommand(UP);
		butUp.addActionListener(this);
		
		butLeftUp.setActionCommand(LEFTUP);
		butLeftUp.addActionListener(this);
		
		butLeftDown.setActionCommand(LEFTDN);
		butLeftDown.addActionListener(this);
		
		butRightUp.setActionCommand(RIGHTUP);
		butRightUp.addActionListener(this);
		
		butRightDown.setActionCommand(RIGHTDN);
		butRightDown.addActionListener(this);

		butLeft.addActionListener(this);
		butLeft.setActionCommand(LEFT);

		butRight.addActionListener(this);
		butRight.setActionCommand(RIGHT);

		butDown.setActionCommand(DOWN);
		butDown.addActionListener(this);
		
		butLeftUp.setEnabled(false);
		butRightUp.setEnabled(false);
		butLeftDown.setEnabled(false);
		butRightDown.setEnabled(false);
		butDown.setEnabled(false);
		butRight.setEnabled(false);
		butLeft.setEnabled(false);
		butUp.setEnabled(false);

		/**
		 * Este Switch determina la forma del panel de información .. lo crea y
		 * lo adiciona...
		 */
		switch (numPlayers) {
		case (2):

			addPlayer1();

			addPlayer2();

			positions.add(topic);
			positions.add(player1);
			positions.add(player2);

			break;
		case (3):

			addPlayer1();

			addPlayer2();

			addPlayer3();

			positions.add(topic);
			positions.add(player1);
			positions.add(player2);
			positions.add(player3);
			break;
		case (4):

			addPlayer1();

			addPlayer2();

			addPlayer3();

			addPlayer4();

			positions.add(topic);
			positions.add(player1);
			positions.add(player2);
			positions.add(player3);
			positions.add(player4);
			break;
		}

		/**
		 * Aqui se carga lo necesario para el panel izquierdo de información y
		 * se crea... luego se adicionan paneles adentro
		 */
		info = new JPanel();
		info.setLayout(new GridLayout(3, 0));
		info.setPreferredSize(new Dimension(300, 0));
		this.add(info, BorderLayout.WEST);

		info.add(turn);
		info.add(dice);
		info.add(positions);
		currentTurn();
		
		
	}

	/**
	 * es el metodo que usa un Random para el numero del dado.
	 * 
	 * @return devuelve un numero al azar entre 1 y 6 que será el resultado de
	 *         la lanzada del dado.
	 */
	public int randomNum() {
		int rand = random.nextInt(6);
		rand += 1;
		return rand;
	}

	/**
	 * actualiza constantemente los puntos de cada jugador
	 * 
	 */
	public void refreshScores() {
		switch (numPlayers) {
		case (2):
			topic1_1.setText("" + nameOf1.getPoints1());
			topic1_2.setText("" + nameOf1.getPoints2());
			topic1_3.setText("" + nameOf1.getPoints3());
			topic1_4.setText("" + nameOf1.getPoints4());

			topic2_1.setText("" + nameOf2.getPoints1());
			topic2_2.setText("" + nameOf2.getPoints2());
			topic2_3.setText("" + nameOf2.getPoints3());
			topic2_4.setText("" + nameOf2.getPoints4());
			break;
		case (3):
			topic1_1.setText("" + nameOf1.getPoints1());
			topic1_2.setText("" + nameOf1.getPoints2());
			topic1_3.setText("" + nameOf1.getPoints3());
			topic1_4.setText("" + nameOf1.getPoints4());

			topic2_1.setText("" + nameOf2.getPoints1());
			topic2_2.setText("" + nameOf2.getPoints2());
			topic2_3.setText("" + nameOf2.getPoints3());
			topic2_4.setText("" + nameOf2.getPoints4());

			topic3_1.setText("" + nameOf3.getPoints1());
			topic3_2.setText("" + nameOf3.getPoints2());
			topic3_3.setText("" + nameOf3.getPoints3());
			topic3_4.setText("" + nameOf3.getPoints4());
			break;
		case (4):
			topic1_1.setText("" + nameOf1.getPoints1());
			topic1_2.setText("" + nameOf1.getPoints2());
			topic1_3.setText("" + nameOf1.getPoints3());
			topic1_4.setText("" + nameOf1.getPoints4());

			topic2_1.setText("" + nameOf2.getPoints1());
			topic2_2.setText("" + nameOf2.getPoints2());
			topic2_3.setText("" + nameOf2.getPoints3());
			topic2_4.setText("" + nameOf2.getPoints4());

			topic3_1.setText("" + nameOf3.getPoints1());
			topic3_2.setText("" + nameOf3.getPoints2());
			topic3_3.setText("" + nameOf3.getPoints3());
			topic3_4.setText("" + nameOf3.getPoints4());

			topic4_1.setText("" + nameOf4.getPoints1());
			topic4_2.setText("" + nameOf4.getPoints2());
			topic4_3.setText("" + nameOf4.getPoints3());
			topic4_4.setText("" + nameOf4.getPoints4());

			break;

		}
	}

	/**
	 * este metodo crea un panel que tiene la informacion del jugador uno en el
	 * juego
	 * 
	 */
	public void addPlayer1() {
		player1 = new JPanel();
		nameOf1 = (Player) names.get(0);
		player1.setLayout(new GridLayout(0, 5));
		name1 = new JLabel(nameOf1.getName());
		topic1_1 = new JLabel("0");
		topic1_2 = new JLabel("0");
		topic1_3 = new JLabel("0");
		topic1_4 = new JLabel("0");
		player1.add(name1);
		player1.add(topic1_1);
		player1.add(topic1_2);
		player1.add(topic1_3);
		player1.add(topic1_4);
	}

	/**
	 * este metodo crea un panel que tiene la informacion del jugador dos en el
	 * juego
	 * 
	 */
	public void addPlayer2() {

		player2 = new JPanel();
		nameOf2 = (Player) names.get(1);
		player2.setLayout(new GridLayout(0, 5));
		name2 = new JLabel(nameOf2.getName());
		topic2_1 = new JLabel("0");
		topic2_2 = new JLabel("0");
		topic2_3 = new JLabel("0");
		topic2_4 = new JLabel("0");
		player2.add(name2);
		player2.add(topic2_1);
		player2.add(topic2_2);
		player2.add(topic2_3);
		player2.add(topic2_4);

	}

	/**
	 * este metodo crea un panel que tiene la informacion del jugador tres en el
	 * juego
	 * 
	 */
	public void addPlayer3() {
		player3 = new JPanel();
		nameOf3 = (Player) names.get(2);
		player3.setLayout(new GridLayout(0, 5));
		name3 = new JLabel(nameOf3.getName());
		topic3_1 = new JLabel("0");
		topic3_2 = new JLabel("0");
		topic3_3 = new JLabel("0");
		topic3_4 = new JLabel("0");
		player3.add(name3);
		player3.add(topic3_1);
		player3.add(topic3_2);
		player3.add(topic3_3);
		player3.add(topic3_4);
	}

	/**
	 * este metodo crea un panel que tiene la informacion del jugador cuatro en
	 * el juego
	 * 
	 */
	public void addPlayer4() {
		player4 = new JPanel();
		nameOf4 = (Player) names.get(3);
		player4.setLayout(new GridLayout(0, 5));
		name4 = new JLabel(nameOf4.getName());
		topic4_1 = new JLabel("0");
		topic4_2 = new JLabel("0");
		topic4_3 = new JLabel("0");
		topic4_4 = new JLabel("0");
		player4.add(name4);
		player4.add(topic4_1);
		player4.add(topic4_2);
		player4.add(topic4_3);
		player4.add(topic4_4);
	}

	/**
	 * Este metodo se encarga de refrescar las posiciones 
	 *
	 */
	public void refreshRank(){
		switch(numPlayers){
		case(2):
		int total1 = nameOf1.getPoints1()+nameOf1.getPoints2()+nameOf1.getPoints3()+nameOf1.getPoints4();
		int total2 = nameOf2.getPoints1()+nameOf2.getPoints2()+nameOf2.getPoints3()+nameOf2.getPoints4();
		if(total1>total2){
			positions.removeAll();
			positions.add(topic);
			positions.add(player1);
			player1.setBackground(Color.LIGHT_GRAY);
			positions.add(player2);
			player2.setBackground(null);
						
		}else if(total1<total2){
			positions.removeAll();
			positions.add(topic);
			positions.add(player2);
			player2.setBackground(Color.LIGHT_GRAY);
			positions.add(player1);
			player1.setBackground(null);
		}else{

		}
		break;
		case(3):
		int total1_3 = nameOf1.getPoints1()+nameOf1.getPoints2()+nameOf1.getPoints3()+nameOf1.getPoints4();
		int total2_3 = nameOf2.getPoints1()+nameOf2.getPoints2()+nameOf2.getPoints3()+nameOf2.getPoints4();
		int total3_3 = nameOf3.getPoints1()+nameOf3.getPoints2()+nameOf3.getPoints3()+nameOf3.getPoints4();
		
		if( total1_3 > total2_3 ){		//if para saber si el jugador uno es el primero y lo pone de primero
			if( total1_3 > total3_3){
				positions.removeAll();
				positions.add(topic);
				positions.add(player1);
				player1.setBackground(Color.LIGHT_GRAY);
				player2.setBackground(null);
				player3.setBackground(null);
				if( total2_3 > total3_3 ){
					positions.add(player2);
					positions.add(player3);
					
				}else{
					positions.add(player3);
					positions.add(player2);					
				}				
			}			
		}else if( total2_3 > total1_3 ){		//if para saber si el jugador dos es el primero y lo pone de primero
			if( total2_3 > total3_3){
				positions.removeAll();
				positions.add(topic);
				positions.add(player2);
				player2.setBackground(Color.LIGHT_GRAY);
				player1.setBackground(null);
				player3.setBackground(null);
				if( total1_3 > total3_3 ){
					positions.add(player1);
					positions.add(player3);
					
				}else{
					positions.add(player3);
					positions.add(player1);					
				}				
			}			
		}else if( total3_3 > total1_3 ){		//if para saber si el jugador tres es el primero y lo pone de primero
			if( total3_3 > total2_3){
				positions.removeAll();
				positions.add(topic);
				positions.add(player3);
				player3.setBackground(Color.LIGHT_GRAY);
				player1.setBackground(null);
				player2.setBackground(null);
				if( total1_3 > total2_3 ){
					positions.add(player1);
					positions.add(player2);
				}else{
					positions.add(player2);
					positions.add(player1);					
				}				
			}			
		}
		
		break;

		case(4):
		int total1_4 = nameOf1.getPoints1()+nameOf1.getPoints2()+nameOf1.getPoints3()+nameOf1.getPoints4();
		int total2_4 = nameOf2.getPoints1()+nameOf2.getPoints2()+nameOf2.getPoints3()+nameOf2.getPoints4();
		int total3_4 = nameOf3.getPoints1()+nameOf3.getPoints2()+nameOf3.getPoints3()+nameOf3.getPoints4();
		int total4_4 = nameOf4.getPoints1()+nameOf4.getPoints2()+nameOf4.getPoints3()+nameOf4.getPoints4();
		
			if(total1_4>total2_4){
				if(total1_4>total3_4){
					if(total1_4>total4_4){
						positions.removeAll();
						positions.add(topic);
						positions.add(player1);
						player1.setBackground(Color.LIGHT_GRAY);
						player2.setBackground(null);
						player3.setBackground(null);
						player4.setBackground(null);
							positions.add(player2);
							positions.add(player3);
							positions.add(player4);
					}
				}
			}else if(total2_4>total1_4){
				if(total2_4>total3_4){
					if(total2_4>total4_4){
						positions.removeAll();
						positions.add(topic);
						positions.add(player2);
						player2.setBackground(Color.LIGHT_GRAY);
						player1.setBackground(null);
						player3.setBackground(null);
						player4.setBackground(null);
							positions.add(player1);
							positions.add(player3);
							positions.add(player4);
					}
				}
			}if(total3_4>total1_4){
				if(total3_4>total2_4){
					if(total3_4>total4_4){
						positions.removeAll();
						positions.add(topic);
						positions.add(player3);
						player3.setBackground(Color.LIGHT_GRAY);
						player2.setBackground(null);
						player1.setBackground(null);
						player4.setBackground(null);
							positions.add(player1);
							positions.add(player2);
							positions.add(player4);
					}
				}
			}if(total4_4>total1_4){
				if(total4_4>total2_4){
					if(total4_4>total3_4){
						positions.removeAll();
						positions.add(topic);
						positions.add(player4);
						player4.setBackground(Color.LIGHT_GRAY);
						player2.setBackground(null);
						player3.setBackground(null);
						player1.setBackground(null);
							positions.add(player1);
							positions.add(player2);
							positions.add(player3);
					}
				}
			}
			
			break;
		}
		
		
	}
	
	/**
	 * Vuelve a poner el dado con los dibujos iniciales para antes de un nuevo
	 * turno.
	 * 
	 */
	public void refreshDice() {
		butDice.setIcon(dicePic);
		butDice.setActionCommand(DICE);
		butDown.setEnabled(false);
		butRight.setEnabled(false);
		butLeft.setEnabled(false);
		butUp.setEnabled(false);
		butLeftUp.setEnabled(false);
		butRightUp.setEnabled(false);
		butLeftDown.setEnabled(false);
		butRightDown.setEnabled(false);
		
	}

	/**
	 * este metodo toma los datos de la pregunta guardados en el arreglo de cada
	 * tema y muestra la pregunta en un frame.
	 */
	public void giveQuestion(int topic) {

		switch (topic) {
		case (1):
			Random ram = new Random();
			int rm = ram.nextInt(questions1.size());
			Question theQuestion1 = (Question) questions1.get(rm);
			FrameQuestion fq1 = new FrameQuestion(1,
					theQuestion1.getQuestion(), theQuestion1.getCorrect(),
					theQuestion1.getAnswer1(), theQuestion1.getAnswer2(),
					theQuestion1.getAnswer3(), this);
			fq1.setVisible(true);
			
			break;
		case (2):
			Random ram2 = new Random();
			int rm2 = ram2.nextInt(questions2.size());
			Question theQuestion2 = (Question) questions2.get(rm2);
			FrameQuestion fq2 = new FrameQuestion(2,
					theQuestion2.getQuestion(), theQuestion2.getCorrect(),
					theQuestion2.getAnswer1(), theQuestion2.getAnswer2(),
					theQuestion2.getAnswer3(), this);
			fq2.setVisible(true);
			
			break;
		case (3):
			Random ram3 = new Random();
			int rm3 = ram3.nextInt(questions3.size());

			Question theQuestion3 = (Question) questions3.get(rm3);
			FrameQuestion fq3 = new FrameQuestion(3,
					theQuestion3.getQuestion(), theQuestion3.getCorrect(),
					theQuestion3.getAnswer1(), theQuestion3.getAnswer2(),
					theQuestion3.getAnswer3(), this);
			fq3.setVisible(true);
			
			break;
		case (4):
			Random ram4 = new Random();
			int rm4 = ram4.nextInt(questions4.size());

			Question theQuestion4 = (Question) questions4.get(rm4);
			FrameQuestion fq4 = new FrameQuestion(4,
					theQuestion4.getQuestion(), theQuestion4.getCorrect(),
					theQuestion4.getAnswer1(), theQuestion4.getAnswer2(),
					theQuestion4.getAnswer3(), this);
			fq4.setVisible(true);
			
			break;
		}

	}
	
	/**
	 * Metodo encargado de llevar el jugador que tiene el turno
	 */
	public void currentTurn() {
		currentPlaying = (Player) players.get(currentPlayer);
		currentName.setText(currentPlaying.getName());
		currentNum.setText("Jugador #"+currentPlaying.getNum());
		currentNum.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		current1.setText("" + currentPlaying.getPoints1());
		current2.setText("" + currentPlaying.getPoints2());
		current3.setText("" + currentPlaying.getPoints3());
		current4.setText("" + currentPlaying.getPoints4());


	}

	/**
	 * este metodo suma las respuestas correctas a los marcadores de los
	 * jugadores.
	 * 
	 * @param topic
	 *            indica el tema de la pregunta que se acaba de responder.
	 * @param correct
	 *            indica si la pregunta que se acaba de responder fue correcta o
	 *            no.
	 */
	public void putScore(int topic, boolean correct) {
		this.setEnabled(true);
		if (correct) {
			switch (topic) {
			case (1):
				currentPlaying.points1++;

				break;
			case (2):
				currentPlaying.points2++;

				break;
			case (3):
				currentPlaying.points3++;
				break;
			case (4):
				currentPlaying.points4++;
				break;
			}

		}

		refreshScores();
		refreshRank();
		currentPlayer++;
		if (currentPlayer == numPlayers) {
			currentPlayer = 0;
		}
		if(currentPlaying.points1>=numToWin && currentPlaying.points2>=numToWin && currentPlaying.points3>=numToWin && currentPlaying.points4>=numToWin){

			JOptionPane finalOptionPane = new JOptionPane('\n'+currentPlaying.getName()+" es el GANADOR!!!!"+'\n'+'\n'+"FELICITACIONES!!!!"+'\n'+'\n'+"Quiere volver a jugar?");
			Object options[] = new String[]{"SI","NO, AHORA MAS TARDE"};
			finalOptionPane.setOptions(options);
			JDialog window = finalOptionPane.createDialog(new JFrame(),"Hay un Ganador del Sabelotodo!!!");
			window.setVisible(true);
			Object selection = finalOptionPane.getValue();
			
			
	    if(selection.equals(options[0])){
	    	try {
	    		this.dispose();
				FramePpal newGame = new FramePpal();
				newGame.setVisible(true);
			} catch (IOException e) {
			} catch (ClassNotFoundException e) {
			} catch (InstantiationException e) {
			} catch (IllegalAccessException e) {
			} catch (UnsupportedLookAndFeelException e) {

				
			}
			
	    }else{
	    	System.exit(0);
	    }

			
		}
		currentTurn();
	}

	/**
	 * cambia la imagen del dado cada vez que se le da click para mostrar el
	 * numero sacado. en el momento que se hace click en el boton, este deja de
	 * funcionar hasta que se le haga el refresco esto con el fin de evitar que
	 * el jugador lo use cuantas veces quiera hasta tener un numero deseado.
	 * 
	 * despues en los movimientos, lo que se hace es verificar que la casilla no
	 * sea fin de matriz o nula, y si no es ninguna de las dos , se cambia la
	 * posicion del jugador a esta nueva casilla.
	 */
	public void actionPerformed(ActionEvent event) {
		String events = event.getActionCommand();
		if (events.equals("dice")) {
			int num = randomNum();
			movsLeft = num;
			switch (num) {
			case (1):
				butDice.setIcon(dice1);
				break;
			case (2):
				butDice.setIcon(dice2);
				break;
			case (3):
				butDice.setIcon(dice3);
				break;
			case (4):
				butDice.setIcon(dice4);
				break;
			case (5):
				butDice.setIcon(dice5);
				break;
			case (6):
				butDice.setIcon(dice6);
				break;
			}
			butDice.setActionCommand("nothing");
			butDown.setEnabled(true);
			butRight.setEnabled(true);
			butLeft.setEnabled(true);
			butUp.setEnabled(true);
			butLeftUp.setEnabled(true);
			butRightUp.setEnabled(true);
			butLeftDown.setEnabled(true);
			butRightDown.setEnabled(true);

		} else if (events.equals("up")) {

			Space current = currentPlaying.getCurrentPos();
			int row = current.getMyRow();
			int column = current.getMyColumn();

			try {
				if (matrix[row - 1][column] != null) {
					if (matrix[row - 1][column].getIcon() == null) {
						current.setIcon(null);
						Space newPos = matrix[row - 1][column];
						currentPlaying.newPos(newPos);
						movsLeft--;
						if (movsLeft == 0) {
							giveQuestion(newPos.getTheTopic());
							refreshDice();
							this.setEnabled(false);
						}
					}
				}
			} catch (Exception error) {

			}

		} else if (events.equals("down")) {

			Space current = currentPlaying.getCurrentPos();
			int row = current.getMyRow();
			int column = current.getMyColumn();

			try {
				if (matrix[row + 1][column] != null) {
					if (matrix[row + 1][column].getIcon()  == null) {
						current.setIcon(null);
						Space newPos = matrix[row + 1][column];
						currentPlaying.newPos(newPos);
						movsLeft--;
						if (movsLeft == 0) {
							giveQuestion(newPos.getTheTopic());
							refreshDice();
							this.setEnabled(false);
						}
					}
				}
			} catch (Exception error) {

			}
		} else if (events.equals("left")) {

			Space current = currentPlaying.getCurrentPos();
			int row = current.getMyRow();
			int column = current.getMyColumn();

			try {
				if (matrix[row][column - 1] != null) {
					if (matrix[row][column - 1].getIcon()  == null) {
						current.setIcon(null);
						Space newPos = matrix[row][column - 1];
						currentPlaying.newPos(newPos);
						movsLeft--;
						if (movsLeft == 0) {
							giveQuestion(newPos.getTheTopic());
							refreshDice();
							this.setEnabled(false);
						}
					}
				}
			} catch (Exception error) {

			}
		} else if (events.equals("right")) {

			Space current = currentPlaying.getCurrentPos();
			int row = current.getMyRow();
			int column = current.getMyColumn();

			try {
				if (matrix[row][column + 1] != null) {
					if (matrix[row][column + 1].getIcon()  == null) {
						current.setIcon(null);
						Space newPos = matrix[row][column + 1];
						currentPlaying.newPos(newPos);
						movsLeft--;
						if (movsLeft == 0) {
							giveQuestion(newPos.getTheTopic());
							refreshDice();
							this.setEnabled(false);
						}
					}
				}
			} catch (Exception error) {

			}
		} else if (events.equals("rightU")) {

			Space current = currentPlaying.getCurrentPos();
			int row = current.getMyRow();
			int column = current.getMyColumn();

			try {
				if (matrix[row - 1][column+1] != null) {
					if (matrix[row - 1][column+1].getIcon()  == null) {
						current.setIcon(null);
						Space newPos = matrix[row - 1][column+1];
						currentPlaying.newPos(newPos);
						movsLeft--;
						if (movsLeft == 0) {
							giveQuestion(newPos.getTheTopic());
							refreshDice();
							this.setEnabled(false);
						}
					}
				}
			} catch (Exception error) {

			}
		} else if (events.equals("rightD")) {

			Space current = currentPlaying.getCurrentPos();
			int row = current.getMyRow();
			int column = current.getMyColumn();

			try {
				if (matrix[row + 1][column+ 1] != null) {
					if (matrix[row + 1][column+ 1].getIcon()  == null) {
						current.setIcon(null);
						Space newPos = matrix[row + 1][column+ 1];
						currentPlaying.newPos(newPos);
						movsLeft--;
						if (movsLeft == 0) {
							giveQuestion(newPos.getTheTopic());
							refreshDice();
							this.setEnabled(false);
						}
					}
				}
			} catch (Exception error) {

			}
		} else if (events.equals("leftD")) {

			Space current = currentPlaying.getCurrentPos();
			int row = current.getMyRow();
			int column = current.getMyColumn();

			try {
				if (matrix[row + 1][column- 1] != null) {
					if (matrix[row + 1][column- 1].getIcon()  == null) {
						current.setIcon(null);
						Space newPos = matrix[row + 1][column- 1];
						currentPlaying.newPos(newPos);
						movsLeft--;
						if (movsLeft == 0) {
							giveQuestion(newPos.getTheTopic());
							refreshDice();
							this.setEnabled(false);
						}
					}
				}
			} catch (Exception error) {

			}
		} else if (events.equals("leftU")) {

			Space current = currentPlaying.getCurrentPos();
			int row = current.getMyRow();
			int column = current.getMyColumn();

			try {
				if (matrix[row - 1][column- 1] != null) {
					if (matrix[row -1][column- 1].getIcon()  == null) {
						current.setIcon(null);
						Space newPos = matrix[row - 1][column- 1];
						currentPlaying.newPos(newPos);
						movsLeft--;
						if (movsLeft == 0) {
							giveQuestion(newPos.getTheTopic());
							refreshDice();
							this.setEnabled(false);
						}
					}
				}
			} catch (Exception error) {

			}

		}
	}
	
}
