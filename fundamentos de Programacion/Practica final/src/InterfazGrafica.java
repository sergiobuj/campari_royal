import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;



import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class InterfazGrafica extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList preguntasUno = new ArrayList();
	ArrayList preguntasDos = new ArrayList();
	ArrayList preguntasTres = new ArrayList();
	ArrayList preguntasCuatro = new ArrayList();

	Jugador turnoActual;

//	imagen del titulo del panel     
	private JLabel imagen2;

	//imagenes de jugadores del panel jugadores   
	private JLabel jugador1;

	private JLabel jugador2;

	private JLabel jugador3;

	private JLabel jugador4;

	//imagen del titulo del panel     
	private JLabel imagen1_j;

	int enTurno=0;

	//imagenes de jugadores del panel jugadores   
	private JLabel jugador1_j;

	private JLabel jugador2_j;

	private JLabel jugador3_j;

	private JLabel jugador4_j;

	private JTextField jugadorA_j;

	private JTextField jugadorB_j;

	private JTextField jugadorC_j;

	private JTextField jugadorD_j;

	//labels para las areas tematicas
	private JLabel color1;

	private JLabel color2;

	private JLabel color3;

	private JLabel color4;

	//cajas de texto para el player 1
	private JTextField txtPlayer1a;

	private JTextField txtPlayer1b;

	private JTextField txtPlayer1c;

	private JTextField txtPlayer1d;

	//cajas de texto para el player 2
	private JTextField txtPlayer2a;

	private JTextField txtPlayer2b;

	private JTextField txtPlayer2c;

	private JTextField txtPlayer2d;

	//cajas de texto para el player 3
	private JTextField txtPlayer3a;

	private JTextField txtPlayer3b;

	private JTextField txtPlayer3c;

	private JTextField txtPlayer3d;

	//cajas de texto para el player 4
	private JTextField txtPlayer4a;

	private JTextField txtPlayer4b;

	private JTextField txtPlayer4c;

	private JTextField txtPlayer4d;

	private JPanel panelJugador;

	private JPanel panelPuntaje;

	private JPanel panelDado;

	private JPanel panelImagen;

	private JPanel panelBotones;

	private JLabel imaDado;

	private JLabel turnoAc;

	private JTextField turno;

	private JButton lanzarDado;

	JPanel panelTablero;

	private JPanel panelControl;

	Casilla[][] laMatriz2;

	int filasGrid, columnasGrid;

	private JLabel titulo;

	private JPanel panelTitulo;

	private JPanel panelCentro;

	private JPanel panelInferior;

	private JLabel imaIzquierda;

	private JLabel imaDerecha;

	private JPanel panelMovimiento;

	private JButton arriba;

	private JButton abajo;

	private JButton izquierda;

	private JButton derecha;

	LeeArchivo leerTablero;

	LeeArchivo leerPreguntas;

	int filas, mov;

	int columnas;

	int filas2;

	int columnas2;

	int tema;

	Casilla laMatriz[][];

	ArrayList jugadoresActivos;

	/**
	 * 
	 * @param jugadoresActivos
	 * @throws FileNotFoundException
	 */
	public InterfazGrafica(ArrayList jugadoresActivos) throws FileNotFoundException {
		this.jugadoresActivos = jugadoresActivos;
		setTitle("::SABELOTDO:: By Felo Games v2.0");
		setSize(800, 600);
		this.setMinimumSize(new Dimension(800, 600));

		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.BLUE);

		setLayout(new BorderLayout());

		panelTitulo = new JPanel();
		panelTitulo.setPreferredSize(new Dimension(780, 130));
		TitledBorder border3 = BorderFactory.createTitledBorder("");
		border3.setTitleColor(Color.BLUE);
		panelTitulo.setBorder(border3);

		titulo = new JLabel();
		titulo.setIcon(new ImageIcon("files/bannerppal.jpg"));
		panelTitulo.add(titulo);

		panelInferior = new JPanel();
		panelInferior.setLayout(new BorderLayout());

		imaIzquierda = new JLabel();
		imaIzquierda.setIcon(new ImageIcon(getClass().getResource(
		"files/izquierda.gif")));

		imaDerecha = new JLabel();
		imaDerecha.setIcon(new ImageIcon(getClass().getResource(
		"files/derecha.gif")));

		setLayout(new BorderLayout());
		panelMovimiento = new JPanel();
		panelMovimiento.setLayout(new GridLayout(2, 3));
		arriba = new JButton();
		arriba.setIcon(new ImageIcon(getClass()
				.getResource("files/flecha1.gif")));
		arriba.addActionListener(this);
		arriba.setActionCommand("arriba");
		abajo = new JButton();
		abajo
		.setIcon(new ImageIcon(getClass().getResource(
				"files/flecha2.gif")));
		abajo.addActionListener(this);
		abajo.setActionCommand("abajo");
		izquierda = new JButton();
		izquierda.setIcon(new ImageIcon(getClass().getResource(
		"files/flecha3.gif")));
		izquierda.addActionListener(this);
		izquierda.setActionCommand("izquierda");
		derecha = new JButton();
		derecha.setIcon(new ImageIcon(getClass().getResource(
		"files/flecha4.gif")));
		derecha.addActionListener(this);
		derecha.setActionCommand("derecha");
		panelMovimiento.add(new JLabel(""));
		panelMovimiento.add(arriba);
		panelMovimiento.add(new JLabel(""));
		panelMovimiento.add(izquierda);
		panelMovimiento.add(abajo);
		panelMovimiento.add(derecha);

		panelInferior.add(imaIzquierda, BorderLayout.WEST);
		panelInferior.add(imaDerecha, BorderLayout.EAST);
		panelInferior.add(panelMovimiento, BorderLayout.CENTER);
		TitledBorder border = BorderFactory.createTitledBorder("");
		panelInferior.setBorder(border);

		add(panelInferior, BorderLayout.SOUTH);
		add(panelTitulo, BorderLayout.NORTH);

		leerTablero = new LeeArchivo("tablero.txt");
		this.pack();
		leerTamanio();
		leerCasilla();
		crearPc();
		llenarTablero();
		darPosicion();

	}

	/**
	 * 
	 *
	 */
	public void leerTamanio() {
		String linea;
		try {
			linea = leerTablero.leeLinea();
			Scanner scan = new Scanner(linea);
			filas = scan.nextInt();
			columnas = scan.nextInt();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El tablero no se pudo cargar",
					"error", JOptionPane.WARNING_MESSAGE);
		}
		laMatriz = new Casilla[filas][columnas];

	}

	/**
	 * 
	 *
	 */
	public void crearPc() {
		panelCentro = new JPanel();
		panelTablero = new JPanel();
		panelCentro.setMaximumSize(new Dimension(100, 200));
		laMatriz2 = laMatriz;
		TitledBorder border6 = BorderFactory.createTitledBorder("");
		panelCentro.setBorder(border6);
		panelCentro.setLayout(new BorderLayout());

		filasGrid = filas;
		columnasGrid = columnas;

		panelTablero.setLayout(new GridLayout(filas, columnas));

		panelCentro.add(panelTablero, BorderLayout.CENTER);

		panelControl = new JPanel();

		TitledBorder border5 = BorderFactory.createTitledBorder("");
		panelControl.setBorder(border5);

		panelControl.setPreferredSize(new Dimension(210, 0));
		panelControl.setLayout(new BorderLayout());
		panelJugador = new JPanel();

		panelJugador.setPreferredSize(new Dimension(300, 470));
		TitledBorder border4 = BorderFactory.createTitledBorder("");
		panelJugador.setBorder(border4);
		panelJugador.setPreferredSize(new Dimension(0, 150));
		panelJugador.setLayout(new GridLayout(5, 2));

		imagen1_j = new JLabel();
		imagen1_j.setIcon(new ImageIcon(getClass().getResource(
		"files/titulo1.gif")));

		jugador1_j = new JLabel();
		jugador1_j.setIcon(new ImageIcon(getClass().getResource(
		"files/jugador1.gif")));
		jugador2_j = new JLabel();
		jugador2_j.setIcon(new ImageIcon(getClass().getResource(
		"files/jugador2.gif")));
		jugador3_j = new JLabel();
		jugador3_j.setIcon(new ImageIcon(getClass().getResource(
		"files/jugador3.gif")));
		jugador4_j = new JLabel();
		jugador4_j.setIcon(new ImageIcon(getClass().getResource(
		"files/jugador4.gif")));

		jugadorA_j = new JTextField();
		jugadorA_j.setBackground(Color.white);
		jugadorA_j.setForeground(Color.black);
		jugadorA_j.setEditable(false);

		jugadorB_j = new JTextField();
		jugadorB_j.setBackground(Color.white);
		jugadorB_j.setForeground(Color.black);
		jugadorB_j.setEditable(false);

		jugadorC_j = new JTextField();
		jugadorC_j.setBackground(Color.white);
		jugadorC_j.setForeground(Color.black);
		jugadorC_j.setEditable(false);

		jugadorD_j = new JTextField();
		jugadorD_j.setBackground(Color.white);
		jugadorD_j.setForeground(Color.black);
		jugadorD_j.setEditable(false);

		panelJugador.add(imagen1_j);
		panelJugador.add(new JLabel(""));

		panelJugador.add(jugador1_j);
		panelJugador.add(jugadorA_j);

		panelJugador.add(jugador2_j);
		panelJugador.add(jugadorB_j);

		panelJugador.add(jugador3_j);
		panelJugador.add(jugadorC_j);

		panelJugador.add(jugador4_j);
		panelJugador.add(jugadorD_j);

		panelControl.add(panelJugador, BorderLayout.NORTH);

		panelPuntaje = new JPanel();

		panelPuntaje.setPreferredSize(new Dimension(300, 470));
		TitledBorder border2 = BorderFactory.createTitledBorder("");
		panelPuntaje.setBorder(border2);

		panelPuntaje.setLayout(new GridLayout(5, 5));
		panelPuntaje.setPreferredSize(new Dimension(350, 0));

		imagen2 = new JLabel();
		imagen2.setIcon(new ImageIcon(getClass().getResource(
		"files/titulo2.gif")));

		jugador1 = new JLabel();
		jugador1.setIcon(new ImageIcon(getClass().getResource(
		"files/jugador1.gif")));
		jugador2 = new JLabel();
		jugador2.setIcon(new ImageIcon(getClass().getResource(
		"files/jugador2.gif")));
		jugador3 = new JLabel();
		jugador3.setIcon(new ImageIcon(getClass().getResource(
		"files/jugador3.gif")));
		jugador4 = new JLabel();
		jugador4.setIcon(new ImageIcon(getClass().getResource(
		"files/jugador4.gif")));

		color1 = new JLabel();
		color1
		.setIcon(new ImageIcon(getClass().getResource(
				"files/color1.gif")));
		color2 = new JLabel();
		color2
		.setIcon(new ImageIcon(getClass().getResource(
				"files/color2.gif")));
		color3 = new JLabel();
		color3
		.setIcon(new ImageIcon(getClass().getResource(
				"files/color3.gif")));
		color4 = new JLabel();
		color4
		.setIcon(new ImageIcon(getClass().getResource(
				"files/color4.gif")));

		txtPlayer1a = new JTextField();
		txtPlayer1b = new JTextField();
		txtPlayer1c = new JTextField();
		txtPlayer1d = new JTextField();

		txtPlayer2a = new JTextField();
		txtPlayer2b = new JTextField();
		txtPlayer2c = new JTextField();
		txtPlayer2d = new JTextField();

		txtPlayer3a = new JTextField();
		txtPlayer3b = new JTextField();
		txtPlayer3c = new JTextField();
		txtPlayer3d = new JTextField();

		txtPlayer4a = new JTextField();
		txtPlayer4b = new JTextField();
		txtPlayer4c = new JTextField();
		txtPlayer4d = new JTextField();

		panelPuntaje.add(new JLabel(""));
		panelPuntaje.add(color1);
		panelPuntaje.add(color2);
		panelPuntaje.add(color3);
		panelPuntaje.add(color4);
		panelPuntaje.add(jugador1);
		panelPuntaje.add(txtPlayer1a);
		panelPuntaje.add(txtPlayer1b);
		panelPuntaje.add(txtPlayer1c);
		panelPuntaje.add(txtPlayer1d);
		panelPuntaje.add(jugador2);
		panelPuntaje.add(txtPlayer2a);
		panelPuntaje.add(txtPlayer2b);
		panelPuntaje.add(txtPlayer2c);
		panelPuntaje.add(txtPlayer2d);
		panelPuntaje.add(jugador3);
		panelPuntaje.add(txtPlayer3a);
		panelPuntaje.add(txtPlayer3b);
		panelPuntaje.add(txtPlayer3c);
		panelPuntaje.add(txtPlayer3d);
		panelPuntaje.add(jugador4);
		panelPuntaje.add(txtPlayer4a);
		panelPuntaje.add(txtPlayer4b);
		panelPuntaje.add(txtPlayer4c);
		panelPuntaje.add(txtPlayer4d);
		panelControl.add(panelPuntaje, BorderLayout.CENTER);
		panelDado = new JPanel();
		panelControl.add(panelDado, BorderLayout.SOUTH);
		panelDado.setLayout(new BorderLayout());

		panelImagen = new JPanel();
		TitledBorder border1 = BorderFactory.createTitledBorder("");
		panelImagen.setBorder(border1);

		panelImagen.setLayout(new BorderLayout());
		imaDado = new JLabel();

		imaDado.setIcon(new ImageIcon(getClass().getResource(
		"files/dadofinal.gif")));
		panelImagen.add(imaDado, BorderLayout.CENTER);

		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(3, 1));
		turnoAc = new JLabel("TURNO ACTUAL");
		turnoAc.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
		turno = new JTextField("");
		lanzarDado = new JButton("Lanzar Dado");
		lanzarDado.addActionListener(this);
		lanzarDado.setActionCommand("tirarDado");

		panelBotones.add(turnoAc);
		panelBotones.add(turno);
		panelBotones.add(lanzarDado);

		panelDado.add(panelImagen, BorderLayout.WEST);
		panelDado.add(panelBotones, BorderLayout.CENTER);

		panelCentro.add(panelControl, BorderLayout.EAST);
		add(panelCentro, BorderLayout.CENTER);

		refrescaPuntos();
		


		cargarPregunta();
		turnoActual();

	}

	/**
	 * 
	 *
	 */
	public void leerCasilla() {
		boolean termino = false;
		while (!termino) {
			try {
				String lineaCasilla = leerTablero.leeLinea();
				Scanner scan2 = new Scanner(lineaCasilla);
				try {
					filas2 = scan2.nextInt();
					columnas2 = scan2.nextInt();
					tema = scan2.nextInt();
					Casilla laCasilla = new Casilla(filas2, columnas2, tema);
					laMatriz[filas2 - 1][columnas2 - 1] = laCasilla;

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"archivo mal configurado", "error",
							JOptionPane.WARNING_MESSAGE);
				}

			} catch (Exception err) {
				termino = true;

			}

		}

	}

	/**
	 * 
	 *
	 */
	public void llenarTablero() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				Casilla cActual = laMatriz[i][j];
				if (cActual == null) {
					panelTablero.add(new JLabel("oe"));
				} else {
					panelTablero.add(cActual);
				}

			}
		}
	}

	public void darPosicion() {
		int pos=0;
		boolean termino = false;
		for (int i = 0; i < filas && !termino; i+=filas-1) {
			for (int j = 0; j < columnas && !termino; j+=columnas-1) {
				Casilla actual = laMatriz2[i][j];
				if (actual != null) {
					Jugador jugador = (Jugador) jugadoresActivos.get(pos);
					jugador.setPosicion(actual);
					pos++;
					if (pos == jugadoresActivos.size()) {
						termino = true;
					}
				}
			}
		}
	}

	public int randomDado(){
		Random miRandom = new Random();

		int dado = miRandom.nextInt(6);
		dado += 1;
		return dado;

	}

	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();

		if (accion.equals("arriba")){
			Casilla actual = turnoActual.getPosicion();
			int fila = actual.getFila();
			int columna = actual.getColumna();

			try {
				if (laMatriz2[fila - 1][columna] != null) {
					if (laMatriz2[fila - 1][columna].getText() == null) {
						actual.setText(null);
						Casilla nuevaPos = laMatriz2[fila - 1][columna];
						turnoActual.setPosicion(nuevaPos);
						mov--;
						if (mov== 0) {
							darPregunta(nuevaPos.getTema());
							this.setEnabled(false);
						}
					}
				}
			} catch (Exception error) {

			}

		}else if(accion.equals("abajo")){
			
			Casilla actual = turnoActual.getPosicion();
			int fila = actual.getFila();
			int columna = actual.getColumna();

			try {
				if (laMatriz2[fila + 1][columna] != null) {
					if (laMatriz2[fila + 1][columna].getText() == null) {
						actual.setText(null);
						Casilla nuevaPos = laMatriz2[fila + 1][columna];
						turnoActual.setPosicion(nuevaPos);
						mov--;
						if (mov== 0) {
							darPregunta(nuevaPos.getTema());
							this.setEnabled(false);
						}
					}
				}
			} catch (Exception error) {

			}
			
			

		}else if(accion.equals("izquierda")){
			
			Casilla actual = turnoActual.getPosicion();
			int fila = actual.getFila();
			int columna = actual.getColumna();

			try {
				if (laMatriz2[fila][columna- 1] != null) {
					if (laMatriz2[fila ][columna- 1].getText() == null) {
						actual.setText(null);
						Casilla nuevaPos = laMatriz2[fila][columna- 1];
						turnoActual.setPosicion(nuevaPos);
						mov--;
						if (mov== 0) {
							darPregunta(nuevaPos.getTema());
							this.setEnabled(false);
						}
					}
				}
			} catch (Exception error) {

			}
			

		}else if(accion.equals("derecha")){

			Casilla actual = turnoActual.getPosicion();
			int fila = actual.getFila();
			int columna = actual.getColumna();

			try {
				if (laMatriz2[fila][columna+1] != null) {
					if (laMatriz2[fila][columna+1].getText() == null) {
						actual.setText(null);
						Casilla nuevaPos = laMatriz2[fila][columna+1];
						turnoActual.setPosicion(nuevaPos);
						mov--;
						if (mov== 0) {
							darPregunta(nuevaPos.getTema());
							this.setEnabled(false);
						}
					}
				}
			} catch (Exception error) {

			}
			
			
		}else if(accion.equals("tirarDado")){
			mov = randomDado();
			turno.setText(mov +"");




		}


	}

	public void cargarPregunta(){
		String pregunta = null, incorrecta1 = null, incorrecta2 = null, incorrecta3 = null, correcta = null, tipo;
		int tema = 0;

		try {
			LeeArchivo txtPreguntas = new LeeArchivo("preguntasYRespuestas.txt");

			boolean fin = false;
			while (!fin) {
				try {
					String linea = txtPreguntas.leeLinea();
					Scanner scan1 = new Scanner(linea);
					tipo = scan1.next();
					if (tipo.equals("p")) {
						tema = scan1.nextInt();
						pregunta = scan1.nextLine();
					} else if (tipo.equals("c")) {
						correcta = scan1.nextLine();
					} else if (tipo.equals("r")) {
						if (incorrecta1 == null) {
							incorrecta1 = scan1.nextLine();
						} else if (incorrecta2 == null) {
							incorrecta2 = scan1.nextLine();
						} else if (incorrecta3 == null) {
							incorrecta3 = scan1.nextLine();

						}
					}

					if (pregunta != null && incorrecta1 != null && incorrecta2 != null
							&& incorrecta3 != null && correcta != null) {
						switch (tema) {
						case (1):
							preguntasUno.add(new Pregunta(pregunta,1, correcta,
									incorrecta1,incorrecta2, incorrecta3));
						pregunta = null;
						incorrecta1 = null;
						incorrecta2 = null;
						incorrecta3 = null;
						correcta = null;
						tipo = null;
						break;
						case (2):
							preguntasDos.add(new Pregunta(pregunta,2, correcta,
									incorrecta1,incorrecta2, incorrecta3));
						pregunta = null;
						incorrecta1 = null;
						incorrecta2 = null;
						incorrecta3 = null;
						correcta = null;
						tipo = null;
						break;
						case (3):
							preguntasTres.add(new Pregunta(pregunta, 3, correcta,
									incorrecta1,incorrecta2, incorrecta3));
						pregunta = null;
						incorrecta1 = null;
						incorrecta2 = null;
						incorrecta3 = null;
						correcta = null;
						tipo = null;
						break;
						case (4):
							preguntasCuatro.add(new Pregunta( pregunta,4, correcta,
									incorrecta1,incorrecta2, incorrecta3));
						pregunta = null;
						incorrecta1 = null;
						incorrecta2 = null;
						incorrecta3 = null;
						correcta = null;
						tipo = null;
						break;
						}
					}

				} catch (Exception error) {
					fin = true;
				}
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"El archivo no se cargo","Error",
					JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}

	}

	public void turnoActual(){
		turnoActual = (Jugador)jugadoresActivos.get(enTurno);

	}

	public void darPregunta(int tema){

		switch(tema){
		case(1):
			Random ram = new Random();
		int rm = ram.nextInt(preguntasUno.size());
		Pregunta laPregunta = (Pregunta) preguntasUno.get(rm);
		FramePregunta cuadroDePregunta = new FramePregunta(
				laPregunta.getPregunta(),1, laPregunta.getCorrecta(),
				laPregunta.getIncorrecta1(), laPregunta.getIncorrecta2(),
				laPregunta.getIncorrecta3(), this);
		cuadroDePregunta.setVisible(true);

		break;
		case(2):
			Random ram2 = new Random();
		int rm2 = ram2.nextInt(preguntasUno.size());
		Pregunta laPregunta2 = (Pregunta) preguntasUno.get(rm2);
		FramePregunta cuadroDePregunta2 = new FramePregunta(
				laPregunta2.getPregunta(),2, laPregunta2.getCorrecta(),
				laPregunta2.getIncorrecta1(), laPregunta2.getIncorrecta2(),
				laPregunta2.getIncorrecta3(), this);
		cuadroDePregunta2.setVisible(true);
			break;
		case(3):
			Random ram3 = new Random();
		int rm3 = ram3.nextInt(preguntasUno.size());
		Pregunta laPregunta3 = (Pregunta) preguntasUno.get(rm3);
		FramePregunta cuadroDePregunta3 = new FramePregunta(
				laPregunta3.getPregunta(),3, laPregunta3.getCorrecta(),
				laPregunta3.getIncorrecta1(), laPregunta3.getIncorrecta2(),
				laPregunta3.getIncorrecta3(), this);
		cuadroDePregunta3.setVisible(true);
			break;
		case(4):
			Random ram4 = new Random();
		int rm4 = ram4.nextInt(preguntasUno.size());
		Pregunta laPregunta4 = (Pregunta) preguntasUno.get(rm4);
		FramePregunta cuadroDePregunta4 = new FramePregunta(
				laPregunta4.getPregunta(),4, laPregunta4.getCorrecta(),
				laPregunta4.getIncorrecta1(), laPregunta4.getIncorrecta2(),
				laPregunta4.getIncorrecta3(), this);
		cuadroDePregunta4.setVisible(true);
			break;


		}

	}

	public void darPunto(int esteTema, String siONo) {
		if(siONo.equals("si")){
			switch (esteTema) {
			case (1):
				turnoActual.sumarPunto1();
				break;
			case (2):
				turnoActual.sumarPunto2();

				break;
			case (3):
				turnoActual.sumarPunto3();
				break;
			case (4):
				turnoActual.sumarPunto4();
				break;
			}
			
		}
		enTurno++;
		refrescaPuntos();
		if(enTurno==jugadoresActivos.size()){
			enTurno=0;
			
		}
		if(turnoActual.puntos1>=2 && turnoActual.puntos2>=2 && turnoActual.puntos3>=2 && turnoActual.puntos4>=2){

			JOptionPane.showMessageDialog(null, "ganador: "+turnoActual.getNombre(),"ganador.. chao", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		
		turnoActual();
	}
	
	
	public void refrescaPuntos(){
		switch(jugadoresActivos.size()){
		case(2):
		Jugador jugador1a = (Jugador)jugadoresActivos.get(0);
		Jugador jugador2a = (Jugador)jugadoresActivos.get(1);	
		jugadorA_j.setText(jugador1a.getNombre());
		jugadorB_j.setText(jugador2a.getNombre());

		txtPlayer1a.setText(jugador1a.getPuntos1()+"");
		txtPlayer2a.setText(jugador2a.getPuntos1()+"");
		txtPlayer1b.setText(jugador1a.getPuntos2()+"");
		txtPlayer2b.setText(jugador2a.getPuntos2()+"");
		txtPlayer1c.setText(jugador1a.getPuntos3()+"");
		txtPlayer2c.setText(jugador2a.getPuntos3()+"");
		txtPlayer1d.setText(jugador1a.getPuntos4()+"");
		txtPlayer2d.setText(jugador2a.getPuntos4()+"");

		jugadorC_j.setVisible(false);
		jugador3_j.setVisible(false);
		jugadorD_j.setVisible(false);
		jugador4_j.setVisible(false);
		jugador3.setVisible(false);
		jugador4.setVisible(false);
		txtPlayer3a.setVisible(false);
		txtPlayer3b.setVisible(false);
		txtPlayer3c.setVisible(false);
		txtPlayer3d.setVisible(false);
		txtPlayer4a.setVisible(false);
		txtPlayer4b.setVisible(false);
		txtPlayer4c.setVisible(false);
		txtPlayer4d.setVisible(false);

		break;

		case(3):
		Jugador jugador1b = (Jugador)jugadoresActivos.get(0);
		Jugador jugador2b = (Jugador)jugadoresActivos.get(1);
		Jugador jugador3b = (Jugador)jugadoresActivos.get(2);
		jugadorA_j.setText(jugador1b.getNombre());
		jugadorB_j.setText(jugador2b.getNombre());
		jugadorC_j.setText(jugador3b.getNombre());

		txtPlayer1a.setText(jugador1b.getPuntos1()+"");
		txtPlayer2a.setText(jugador2b.getPuntos1()+"");
		txtPlayer3a.setText(jugador3b.getPuntos1()+"");
		txtPlayer1b.setText(jugador1b.getPuntos2()+"");
		txtPlayer2b.setText(jugador2b.getPuntos2()+"");
		txtPlayer3b.setText(jugador3b.getPuntos2()+"");
		txtPlayer1c.setText(jugador1b.getPuntos3()+"");
		txtPlayer2c.setText(jugador2b.getPuntos3()+"");
		txtPlayer3c.setText(jugador3b.getPuntos3()+"");
		txtPlayer1d.setText(jugador1b.getPuntos4()+"");
		txtPlayer2d.setText(jugador2b.getPuntos4()+"");
		txtPlayer3d.setText(jugador3b.getPuntos4()+"");

		jugadorD_j.setVisible(false);
		jugador4_j.setVisible(false);
		jugador4.setVisible(false);
		txtPlayer4a.setVisible(false);
		txtPlayer4b.setVisible(false);
		txtPlayer4c.setVisible(false);
		txtPlayer4d.setVisible(false);

		break;

		case(4):
		Jugador jugador1c = (Jugador)jugadoresActivos.get(0);
		Jugador jugador2c = (Jugador)jugadoresActivos.get(1);
		Jugador jugador3c = (Jugador)jugadoresActivos.get(2);
		Jugador jugador4c = (Jugador)jugadoresActivos.get(3);
		jugadorA_j.setText(jugador1c.getNombre());
		jugadorB_j.setText(jugador2c.getNombre());
		jugadorC_j.setText(jugador3c.getNombre());
		jugadorD_j.setText(jugador4c.getNombre());

		txtPlayer1a.setText(jugador1c.getPuntos1()+"");
		txtPlayer2a.setText(jugador2c.getPuntos1()+"");
		txtPlayer3a.setText(jugador3c.getPuntos1()+"");
		txtPlayer4a.setText(jugador4c.getPuntos1()+"");
		txtPlayer1b.setText(jugador1c.getPuntos2()+"");
		txtPlayer2b.setText(jugador2c.getPuntos2()+"");
		txtPlayer3b.setText(jugador3c.getPuntos2()+"");
		txtPlayer4b.setText(jugador4c.getPuntos2()+"");
		txtPlayer1c.setText(jugador1c.getPuntos3()+"");
		txtPlayer2c.setText(jugador2c.getPuntos3()+"");
		txtPlayer3c.setText(jugador3c.getPuntos3()+"");
		txtPlayer4c.setText(jugador4c.getPuntos3()+"");
		txtPlayer1d.setText(jugador1c.getPuntos4()+"");
		txtPlayer2d.setText(jugador2c.getPuntos4()+"");
		txtPlayer3d.setText(jugador3c.getPuntos4()+"");
		txtPlayer4d.setText(jugador4c.getPuntos4()+"");
		break;
		
		}}
	}


