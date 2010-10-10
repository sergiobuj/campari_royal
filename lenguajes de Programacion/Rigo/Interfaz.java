import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

public class Interfaz extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel panelTitulo, panelTablero, panelEntrada, p2, p3;

	private JLabel titulo;

	public static final String COMPILAR = "compila", CORRER = "correr",
			LISTO = "listo", TESOROS = "tesoros", RP = "rp";

	private JButton compilar, correr, listo, tesoros, rp;

	private JTextArea entrada;

	int filas, columnas, reType = 1, veces = 0, lineasLeidas = 0;;

	public int clikeadoFila, clikeadoCol, numTesorosActual, numTesoroSig,
			vecesDeja, vecesAvanza, vecesToma, numMientras;

	private PanelEstado panelEstado;

	Sintaxis laSinta;

	public String codigo;

	Buttons matriz[][];

	boolean puedeSeguir, arranque = true, hayAbismo = false, hayPared = false,
			hayTesoro = false, tieneTesoro = false;

	JLabel matrizLab[][];

	Rigo rigo;

	public Interfaz(int filas, int columnas) throws IOException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		{

			// números globales
			this.filas = filas;
			this.columnas = columnas;
			puedeSeguir = true; // para controlar el error y saber cuando se
			// debe terminar la ejecución

			// crear Frame
			this.setTitle("::RIGO::");
			this.setSize(780, 500);
			this.setMinimumSize(new Dimension(780, 500));
			this.setResizable(true);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setBackground(Color.BLUE);
			this.setLayout(new BorderLayout());

			// crear tablero
			matriz = new Buttons[filas][columnas];
			matrizLab = new JLabel[filas][columnas];

			// crear paneles
			panelEstado = new PanelEstado();
			panelTitulo = new JPanel();
			panelEntrada = new JPanel(new BorderLayout());
			p2 = new JPanel(new GridLayout(1, 2));
			p3 = new JPanel(new GridLayout(7, 1));
			panelTablero = new JPanel(new GridLayout(filas, columnas));
			// panelTablero.setLayout(new GridLayout(filas, columnas));

			// crear otros
			titulo = new JLabel();
			titulo.setIcon(new ImageIcon("bannerppal.jpg"));

			// crear botones
			compilar = new JButton("Compilar");
			correr = new JButton("correr");
			tesoros = new JButton("Ajustar Tesoros");
			rp = new JButton("Ajustar Rigo y paredes");
			listo = new JButton("Listo");

			// estado inicial botones
			correr.setEnabled(false);
			compilar.setEnabled(false);
			// el resto... enable

			// acción de botones
			compilar.addActionListener(this);
			compilar.setActionCommand(COMPILAR);
			compilar.setVisible(false);
			correr.addActionListener(this);
			correr.setActionCommand(CORRER);
			correr.setVisible(false);
			listo.addActionListener(this);
			listo.setActionCommand(LISTO);
			rp.addActionListener(this);
			rp.setActionCommand(RP);
			tesoros.addActionListener(this);
			tesoros.setActionCommand(TESOROS);

			// bordes y dimensiones
			TitledBorder border3 = BorderFactory.createTitledBorder("");
			border3.setTitleColor(Color.BLUE);
			panelTitulo.setBorder(border3);
			panelEntrada.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
			panelTitulo.setPreferredSize(new Dimension(780, 100));
			p3.setPreferredSize(new Dimension(245, 0));

			// agregar
			this.add(panelTitulo, BorderLayout.NORTH);
			panelTitulo.add(titulo);
			this.add(panelTablero, BorderLayout.CENTER);
			this.add(panelEntrada, BorderLayout.EAST);
			panelEntrada.add(p3, BorderLayout.CENTER);
			p3.add(new JLabel());
			p3.add(new JLabel());
			p3.add(tesoros);
			p3.add(rp);
			p3.add(listo);
			p3.add(new JLabel());
			p3.add(new JLabel());
			panelEntrada.add(p2, BorderLayout.SOUTH);
			p2.add(compilar);
			p2.add(correr);
			this.add(panelEstado, BorderLayout.SOUTH);

			// métodos
			this.llenado();
		}
	}

	public void daEntrada() {
		panelEntrada.remove(p3);
		entrada = new JTextArea(10, 20);
		entrada.setEditable(true);
		entrada.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
		entrada.setText("InicioPrograma" + '\n' + "FinPrograma");
		JScrollPane pScroll = new JScrollPane(entrada,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelEntrada.add(pScroll, BorderLayout.CENTER);
		tesoros.setEnabled(false);
		rp.setEnabled(false);

	}

	public void llenado() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				Buttons boton = new Buttons(i, j, this);
				matriz[i][j] = boton;
				panelTablero.add(boton);
			}
		}
	}

	public void revisaRigo() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {

				if (i == clikeadoFila && j == clikeadoCol) {
				} else {
					Buttons boton = matriz[i][j];
					if (boton.getType() >= 2) {
						boton.setType(0);
						boton.setText("" + boton.tesoOriginal);
					}
				}
			}
		}
	}

	public void hacerLabels() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				Buttons boton = matriz[i][j];
				JLabel temp = new JLabel(boton.getText());
				temp.setHorizontalAlignment((int) CENTER_ALIGNMENT);
				if (boton.getType() == 1) {
					temp.setForeground(Color.red);
					;
				}
				matrizLab[i][j] = temp;
			}
		}
	}

	public void gire() {
		// 1:arriba 2:derecha 3:abajo 4:izquierda
		int dir = rigo.getDireccion();
		dir = dir + 1;
		if (dir == 5) {
			dir = 1;
		}
		JLabel posTemp = matrizLab[rigo.getPosFila()][rigo.getPosCol()];
		switch (dir) {
		case (1):
			posTemp.setText("^");
			break;
		case (2):
			posTemp.setText(">");
			break;
		case (3):

			posTemp.setText("v");
			break;
		case (4):

			posTemp.setText("<");
			break;

		}
		poneMensaje(10);
		rigo.setDireccion(dir);
	}

	public void avance() {
		// 1:arriba 2:derecha 3:abajo 4:izquierda
		int direcc = rigo.getDireccion();
		int col = rigo.getPosCol();
		int fil = rigo.getPosFila();
		JLabel siguiente;
		JLabel chequea;
		JLabel actual = matrizLab[fil][col];
		String elRiguito = actual.getText();

		switch (direcc) {
		case (1):

			if (fil - 1 < 0) {
				poneMensaje(3);
			} else {

				chequea = matrizLab[fil - 1][col];
				if (chequea.getText().equalsIgnoreCase("X")) {
					poneMensaje(4);
				} else {

					actual.setText("" + numTesorosActual);
					siguiente = matrizLab[fil - 1][col];
					numTesorosActual = Integer.parseInt(siguiente.getText());
					siguiente.setText(elRiguito);
					rigo.setPosFila(fil - 1);

					poneMensaje(5);
					// siguiente.setBackground(Color.ORANGE);

				}

			}

			break;
		case (2):

			if (col + 1 > columnas - 1) {
				poneMensaje(3);
			} else {

				chequea = matrizLab[fil][col + 1];
				if (chequea.getText().equalsIgnoreCase("X")) {
					poneMensaje(4);
				} else {

					actual.setText("" + numTesorosActual);
					siguiente = matrizLab[fil][col + 1];
					numTesorosActual = Integer.parseInt(siguiente.getText());
					siguiente.setText(elRiguito);
					rigo.setPosCol(col + 1);

					poneMensaje(5);
					// siguiente.setBackground(Color.ORANGE);
				}
			}
			break;
		case (3):

			if (fil + 1 > filas - 1) {
				poneMensaje(3);
			} else {

				chequea = matrizLab[fil + 1][col];
				if (chequea.getText().equalsIgnoreCase("X")) {
					poneMensaje(4);
				} else {
					actual.setText("" + numTesorosActual);
					siguiente = matrizLab[fil + 1][col];
					numTesorosActual = Integer.parseInt(siguiente.getText());
					siguiente.setText(elRiguito);
					rigo.setPosFila(fil + 1);
					poneMensaje(5);
					// siguiente.setBackground(Color.ORANGE);
				}

			}
			break;
		case (4):

			if (col - 1 < 0) {
				poneMensaje(3);
			} else {

				chequea = matrizLab[fil][col - 1];
				if (chequea.getText().equalsIgnoreCase("X")) {
					poneMensaje(4);
				} else {

					actual.setText("" + numTesorosActual);
					siguiente = matrizLab[fil][col - 1];
					numTesorosActual = Integer.parseInt(siguiente.getText());
					siguiente.setText(elRiguito);
					rigo.setPosCol(col - 1);
					poneMensaje(5);
					// siguiente.setBackground(Color.ORANGE);
				}
			}
			break;

		}

		// actual.setForeground(Color.BLACK);
		refrescaTesoros();
	}

	public void tomaTesoro() {

		if (numTesorosActual > 0) {
			rigo.sumaTesoros();
			numTesorosActual = numTesorosActual - 1;
			refrescaTesoros();
			poneMensaje(6);
		} else {
			poneMensaje(8);
		}
	}

	public boolean hayTesoro() {
		boolean hay = false;
		if (numTesorosActual > 0) {
			hay = true;
		}
		return hay;
	}

	public boolean tieneTesoro() {
		boolean tiene = false;
		if (rigo.getTesoros() > 0) {
			tiene = true;
		}
		return tiene;
	}

	// 1:arriba 2:derecha 3:abajo 4:izquierda
	public boolean miraDonde(int direcc) {
		boolean direccion = false;
		switch (direcc) {
		case (1):
			if (rigo.getDireccion() == 1) {
				direccion = true;
			}
			break;
		case (2):
			if (rigo.getDireccion() == 2) {
				direccion = true;
			}
			break;
		case (3):
			if (rigo.getDireccion() == 3) {
				direccion = true;
			}
			break;
		case (4):
			if (rigo.getDireccion() == 4) {
				direccion = true;
			}
			break;
		}
		return direccion;

	}

	public void dejaTesoro() {
		if (rigo.getTesoros() == 0) {
			poneMensaje(9);
		} else {
			rigo.quitaTesoros();
			numTesorosActual = numTesorosActual + 1;
			refrescaTesoros();

			poneMensaje(7);
		}
	}

	// 1:arriba 2:derecha 3:abajo 4:izquierda
	// tipo 1 = Pared ; 2 = Abismo
	public boolean hayAdelante(int tipo) {
		boolean hay = false;
		int direcc = rigo.getDireccion();
		int col = rigo.getPosCol();
		int fil = rigo.getPosFila();
		JLabel adelante;
		switch (tipo) {
		case (1):
			switch (direcc) {
			case (1):
				if (fil - 1 > 0) {
					adelante = matrizLab[fil - 1][col];
					if (adelante.getText().equalsIgnoreCase("X")) {
						hay = true;
					}

				}
				break;
			case (2):
				if (col + 1 > columnas - 1) {
				} else {
					adelante = matrizLab[fil][col + 1];
					if (adelante.getText().equalsIgnoreCase("X")) {
						hay = true;
					}
				}
				break;
			case (3):

				if (fil + 1 > filas - 1) {
				} else {
					adelante = matrizLab[fil + 1][col];
					if (adelante.getText().equalsIgnoreCase("X")) {
						hay = true;
					}
				}
				break;
			case (4):

				if (col - 1 > 0) {
					adelante = matrizLab[fil][col - 1];
					if (adelante.getText().equalsIgnoreCase("X")) {
						hay = true;
					}
				}
				break;
			}
			break;
		case (2):
			switch (direcc) {
			case (1):
				if (fil - 1 < 0) {
					hay = true;

				}
				break;
			case (2):
				if (col + 1 > columnas - 1) {
					hay = true;

				}
				break;
			case (3):

				if (fil + 1 > filas - 1) {
					hay = true;

				}
				break;
			case (4):

				if (col - 1 < 0) {

					hay = true;

				}
				break;
			}
			break;
		}
		return hay;
	}



	public void aLabels() {
		hacerLabels();
		panelTablero.removeAll();
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				JLabel temp = matrizLab[i][j];
				panelTablero.add(temp);
			}
		}

	}

	public boolean validaRigo() {
		boolean loHay = false;
		for (int i = 0; i < filas && !loHay; i++) {
			for (int j = 0; j < columnas && !loHay; j++) {
				Buttons boton = matriz[i][j];
				switch (boton.getType()) {
				case (2):
					loHay = true;
					rigo = new Rigo(i, j, 2);
					break;
				case (3):
					loHay = true;
					rigo = new Rigo(i, j, 3);
					break;
				case (4):
					loHay = true;
					rigo = new Rigo(i, j, 4);
					break;
				case (5):
					loHay = true;
					rigo = new Rigo(i, j, 1);
					break;
				}
			}
		}
		return loHay;
	}

	public void actionPerformed(ActionEvent evento) {
		String eventos = evento.getActionCommand();

		if (eventos.equalsIgnoreCase("compila")) {

			laSinta = new Sintaxis("");
			codigo = entrada.getText();

			String analisis = laSinta.supercompi(codigo);
			panelEstado.actualizarBarraDeEstado("     " + analisis);

			if (analisis.equalsIgnoreCase("El código se puede ejecutar.")) {
				correr.setEnabled(true);
				vecesDeja = 0;
				vecesAvanza = 0;
				vecesToma = 0;
				puedeSeguir = true;
				lineasLeidas = 0;
				// hayAbismo = false;
				// hayPared = false;
				// hayTesoro = false;
				// tieneTesoro = false;

			}

		} else if (eventos.equalsIgnoreCase("correr")) {
			panelEstado.actualizarBarraDeEstado("");

			Scanner scany = new Scanner(codigo);
			String elCodigo = "";

			scany.next();
			while (scany.hasNext()) {
				String order = scany.nextLine();
				elCodigo = elCodigo + " " + order;
			}

			String codeFinal = "";
			Scanner scan2 = new Scanner(elCodigo);
			while (scan2.hasNext()) {
				String tmp = scan2.next();
				if (!tmp.equalsIgnoreCase("FinPrograma")) {
					codeFinal = codeFinal + " " + tmp;
				}
			}

			haceBloque(codeFinal);
			correr.setEnabled(false);

		} else if (eventos.equalsIgnoreCase("listo")) {
			if (validaRigo()) {
				Buttons buTeso = matriz[rigo.getPosFila()][rigo.getPosCol()];
				numTesorosActual = buTeso.tesoOriginal;
				aLabels();
				refrescaTesoros();
				listo.setEnabled(false);
				compilar.setEnabled(true);
				compilar.setVisible(true);
				correr.setVisible(true);
				poneMensaje(2);
				daEntrada();

			} else {
				poneMensaje(1);
			}
		} else if (eventos.equalsIgnoreCase("tesoros")) {
			reType = 1;

		} else if (eventos.equalsIgnoreCase("rp")) {
			reType = 2;
		}

	}

	public void poneMensaje(int mensaje) {
		switch (mensaje) {
		case (1):
			panelEstado
					.actualizarBarraDeEstado("   Falta ubicar a RIGO en el tablero!!!");
			break;
		case (2):
			panelEstado
					.actualizarBarraDeEstado("     Se ha creado el tablero.");
			break;
		case (3):
			panelEstado
					.actualizarBarraDeEstado("  RIGO no puede avanzar... Hay Abismo!!!");
			puedeSeguir = false;
			// hayAbismo = true;
			break;
		case (4):
			panelEstado
					.actualizarBarraDeEstado("  RIGO no puede avanzar... Hay Pared!!!");
			puedeSeguir = false;
			// hayPared = true;
			break;
		case (5):
			vecesAvanza++;
			if (vecesAvanza == 1) {
				panelEstado
						.actualizarBarraDeEstado("  RIGO avanzó una casilla");
			} else {
				panelEstado.actualizarBarraDeEstado("  RIGO avanzó "
						+ vecesAvanza + " casillas");
			}
			// hayPared = false;
			// hayAbismo = false;

			break;
		case (6):
			vecesToma++;
			if (vecesToma == 1) {
				panelEstado.actualizarBarraDeEstado("  RIGO tomó un tesoro!!!");
			} else {
				panelEstado.actualizarBarraDeEstado("  RIGO tomó " + vecesToma
						+ " tesoros!!!");
			}
			// tieneTesoro = true;
			break;
		case (7):
			vecesDeja++;
			if (vecesDeja == 1) {
				panelEstado.actualizarBarraDeEstado("  RIGO dejó un tesoro!!!");
			} else {
				panelEstado.actualizarBarraDeEstado("  RIGO dejó " + vecesDeja
						+ " tesoros!!!");
			}
			// hayTesoro = true;

			break;
		case (8):
			panelEstado
					.actualizarBarraDeEstado("  RIGO no puede tomar tesoros... No Hay!!!");
			// hayTesoro = false;
			puedeSeguir = false;
			break;
		case (9):
			panelEstado
					.actualizarBarraDeEstado("  RIGO no puede dejar tesoros... No tiene!!!");
			// tieneTesoro = false;
			puedeSeguir = false;
			break;
		case (10):
			panelEstado.actualizarBarraDeEstado("  RIGO giró!!!");
			break;
		}
	}

	public void refrescaTesoros() {
		panelEstado.actualizaTesorosActuales(numTesorosActual);
		panelEstado.actualizaTesoros(rigo.getTesoros());

	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		Interfaz interfaz = new Interfaz(5, 6);
		interfaz.setVisible(true);
	}

	public void haceBloque(String codigo) {
		Scanner scan = new Scanner(codigo);
		while (scan.hasNext()) {
			String comando = scan.next();

			if (comando.equalsIgnoreCase("avance") && puedeSeguir) {
				avance();
			} else if (comando.equalsIgnoreCase("gire") && puedeSeguir) {
				gire();
			} else if (comando.equalsIgnoreCase("tometesoro") && puedeSeguir) {
				tomaTesoro();
			} else if (comando.equalsIgnoreCase("dejetesoro") && puedeSeguir) {
				dejaTesoro();
			} else if (comando.equalsIgnoreCase("Pare") && puedeSeguir) {
				puedeSeguir = false;
			} else if (comando.equalsIgnoreCase("Mientras")) {// //////////mientras
				int cont = 1;
				String condicion = scan.next();
				String bloque = "";
				String temp = "";
				while (cont > 0) {

					if (scan.hasNext()) {
						temp = scan.next();
					}

					if (temp.equalsIgnoreCase("FinMientras")) {
						cont--;
					} else {
						if (temp.equalsIgnoreCase("Mientras")) {
							cont++;
						}

					}

					bloque = bloque + " " + temp;
				}

				//condiciones mientras
				if (condicion.equalsIgnoreCase("HayAbismo") && puedeSeguir) {// ////1
					if (hayAdelante(2) && puedeSeguir) {
						while (hayAdelante(2) && puedeSeguir) {
							haceBloque(bloque);
						}
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("noHayAbismo") && puedeSeguir) {// //2
					if (!hayAdelante(2) && puedeSeguir) {
						while (!hayAdelante(2) && puedeSeguir) {
							haceBloque(bloque);
						}
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("HayPared") && puedeSeguir) {// ////3
					if (hayAdelante(1) && puedeSeguir) {
						while (hayAdelante(1) && puedeSeguir) {
							haceBloque(bloque);
						}
						////break;
					} else {
						poneMensaje(11);
					}

				} else if (condicion.equalsIgnoreCase("noHayPared") && puedeSeguir) {// ////////////4
					if (!hayAdelante(1) && puedeSeguir) {
						while (!hayAdelante(1) && puedeSeguir) {
							haceBloque(bloque);
						}
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("HayTesoro") && puedeSeguir) {// //////////5
					if (hayTesoro() && puedeSeguir) {
						while (hayTesoro() && puedeSeguir) {
							haceBloque(bloque);
						}
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("noHayTesoro") && puedeSeguir) {// ///////////6
					if (!hayTesoro() && puedeSeguir) {
						while (!hayTesoro() && puedeSeguir) {
							haceBloque(bloque);
						}
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("TieneTesoro") && puedeSeguir) {// //////////7
					if (tieneTesoro() && puedeSeguir) {
						while (tieneTesoro() && puedeSeguir) {
							haceBloque(bloque);
						}
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("noTieneTesoro")
						&& puedeSeguir) {// ////////8
					if (!tieneTesoro() && puedeSeguir) {
						while (!tieneTesoro() && puedeSeguir) {
							haceBloque(bloque);
						}
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("MiraNorte") && puedeSeguir) {// //////9
					if (miraDonde(1) && puedeSeguir) {
						while (miraDonde(1) && puedeSeguir) {
							haceBloque(bloque);
						}
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("noMiraNorte") && puedeSeguir) {// ///10
					if (!miraDonde(1) && puedeSeguir) {
						while (!miraDonde(1) && puedeSeguir) {
							haceBloque(bloque);
						}
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("MiraEste") && puedeSeguir) {// ///////11
					if (miraDonde(2) && puedeSeguir) {
						while (miraDonde(2) && puedeSeguir) {
							haceBloque(bloque);
						}
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("noMiraEste") && puedeSeguir) {// /////12
					if (!miraDonde(2) && puedeSeguir) {
						while (!miraDonde(2) && puedeSeguir) {
							haceBloque(bloque);
						}
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("MiraOeste") && puedeSeguir) {// /////13
					if (miraDonde(4) && puedeSeguir) {
						while (miraDonde(4) && puedeSeguir) {
							haceBloque(bloque);
						}
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("noMiraOeste") && puedeSeguir) {// //////14
					if (!miraDonde(4) && puedeSeguir) {
						while (!miraDonde(4) && puedeSeguir) {
							haceBloque(bloque);
						}
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("MiraSur") && puedeSeguir) {// //////////15
					if (miraDonde(3) && puedeSeguir) {
						while (miraDonde(3) && puedeSeguir) {
							haceBloque(bloque);
						}
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("noMiraSur") && puedeSeguir) {// ////////16
					if (!miraDonde(3) && puedeSeguir) {
						while (!miraDonde(3) && puedeSeguir) {
							haceBloque(bloque);

						}
						////break;
					} else {
						poneMensaje(11);
					}
				}
				

				
			} else if (comando.equalsIgnoreCase("Si")) {// IFFFFFFFFFFFFFFF

				int cont = 1;
				String condicion = scan.next();
				String bloque = "";
				String temp = "";
				while (cont > 0) {

					if (scan.hasNext()) {
						temp = scan.next();
					}

					if (temp.equalsIgnoreCase("FinSi")) {
						cont--;
					} else {
						if (temp.equalsIgnoreCase("Si")) {
							cont++;
						}
						bloque = bloque + " " + temp;
					}
				}

				//condiciones if
				if (condicion.equalsIgnoreCase("HayAbismo") && puedeSeguir) {// ////1
					if (hayAdelante(2) && puedeSeguir) {
						haceBloque(bloque);
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("noHayAbismo") && puedeSeguir) {// //2
					if (!hayAdelante(2) && puedeSeguir) {
						haceBloque(bloque);
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("HayPared") && puedeSeguir) {// ////3
					if (hayAdelante(1) && puedeSeguir) {
						haceBloque(bloque);
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("noHayPared") && puedeSeguir) {// ////////////4
					if (!hayAdelante(1) && puedeSeguir) {
						haceBloque(bloque);
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("HayTesoro") && puedeSeguir) {// //////////5
					if (hayTesoro() && puedeSeguir) {
						haceBloque(bloque);
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("noHayTesoro") && puedeSeguir) {// ///////////6
					if (!hayTesoro() && puedeSeguir) {
						haceBloque(bloque);
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("TieneTesoro") && puedeSeguir) {// //////////7
					if (tieneTesoro() && puedeSeguir) {
						haceBloque(bloque);
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("noTieneTesoro")
						&& puedeSeguir) {// ////////8
					if (!tieneTesoro() && puedeSeguir) {
						haceBloque(bloque);
						////break;
					} else {
						poneMensaje(11);
					}
					// 1:arriba 2:derecha 3:abajo 4:izquierda mira donde
				} else if (condicion.equalsIgnoreCase("MiraNorte") && puedeSeguir) {// //////9
					if (miraDonde(1) && puedeSeguir) {
						haceBloque(bloque);
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("noMiraNorte") && puedeSeguir) {// ///10
					if (!miraDonde(1) && puedeSeguir) {
						haceBloque(bloque);
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("MiraEste") && puedeSeguir) {// ///////11
					if (miraDonde(2) && puedeSeguir) {
						haceBloque(bloque);
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("noMiraEste") && puedeSeguir) {// /////12
					if (!miraDonde(1) && puedeSeguir) {
						haceBloque(bloque);
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("MiraOeste") && puedeSeguir) {// /////13
					if (miraDonde(4) && puedeSeguir) {
						haceBloque(bloque);
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("noMiraOeste") && puedeSeguir) {// //////14
					if (!miraDonde(4) && puedeSeguir) {
						haceBloque(bloque);
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("MiraSur") && puedeSeguir) {// //////////15
					if (miraDonde(3) && puedeSeguir) {
						haceBloque(bloque);
						////break;
					} else {
						poneMensaje(11);
					}
				} else if (condicion.equalsIgnoreCase("noMiraSur") && puedeSeguir) {// ////////16
					if (!miraDonde(3) && puedeSeguir) {
						haceBloque(bloque);
						//break;
					} else {
						poneMensaje(11);
					}
				}
				
				

			}//fin si 
			
		}//fin While
	}//fin metodo bloque
}

/*
 * 
 * InicioPrograma Avance Avance Avance Avance FinPrograma
 * 
 * InicioPrograma Avance TomeTesoro Gire Gire Avance Gire Gire FinPrograma
 * 
 * Avance Si HayTesoro Mientras HayTesoro TomeTesoro FinMientras FinSi
 */

