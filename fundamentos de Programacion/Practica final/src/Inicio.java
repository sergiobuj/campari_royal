import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Inicio extends JFrame implements ActionListener {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelInicio;

	private JLabel titulo;

	private JLabel ima1;

	private JLabel ima2;

	private JLabel ima3;

	private JLabel ima4;

	private JTextField juga1;

	private JTextField juga2;

	private JTextField juga3;

	private JTextField juga4;

	private JButton jugadores2;

	private JButton jugadores3;

	private JButton jugadores4;

	private JButton btnJugar;

	int numJugadores;

	private ArrayList jugadoresActivos;

	public Inicio() {
		setLayout(new BorderLayout());
		this.setSize(new Dimension(350, 300));

		titulo = new JLabel();
		titulo.setIcon(new ImageIcon(getClass().getResource(
				"files/izquierda.gif")));

		panelInicio = new JPanel();
		panelInicio.setLayout(new GridLayout(6, 2));
		jugadores2 = new JButton("dos jugadores");
		jugadores2.addActionListener(this);
		jugadores2.setActionCommand("Dos");
		jugadores3 = new JButton("tres jugadores");
		jugadores3.addActionListener(this);
		jugadores3.setActionCommand("Tres");
		jugadores4 = new JButton("cuatro jugadores");
		jugadores4.addActionListener(this);
		jugadores4.setActionCommand("Cuatro");
		ima1 = new JLabel("JUGADOR 1");
		ima1.setVisible(false);
		ima2 = new JLabel("JUGADOR 2");
		ima2.setVisible(false);
		ima3 = new JLabel("JUGADOR 3");
		ima3.setVisible(false);
		ima4 = new JLabel("JUGADOR 4");
		ima4.setVisible(false);
		juga1 = new JTextField("");
		juga1.setVisible(false);
		juga2 = new JTextField("");
		juga2.setVisible(false);
		juga3 = new JTextField("");
		juga3.setVisible(false);
		juga4 = new JTextField("");
		juga4.setVisible(false);

		jugadoresActivos = new ArrayList();

		panelInicio.add(jugadores2);
		panelInicio.add(jugadores3);
		panelInicio.add(jugadores4);
		panelInicio.add(new JLabel(""));
		panelInicio.add(ima1);
		panelInicio.add(juga1);
		panelInicio.add(ima2);
		panelInicio.add(juga2);
		panelInicio.add(ima3);
		panelInicio.add(juga3);
		panelInicio.add(ima4);
		panelInicio.add(juga4);

		btnJugar = new JButton("JUGAR");

		this.add(panelInicio, BorderLayout.CENTER);
		this.add(titulo, BorderLayout.NORTH);
		this.add(btnJugar, BorderLayout.SOUTH);

		btnJugar.addActionListener(this);
		btnJugar.setActionCommand("nJugadore");
	}

	public void mostrarInicio(String evento) {

		if (evento.equals("Dos")) {
			ima1.setVisible(true);
			juga1.setVisible(true);
			ima2.setVisible(true);
			juga2.setVisible(true);
			ima3.setVisible(false);
			juga3.setVisible(false);
			ima4.setVisible(false);
			juga4.setVisible(false);
			numJugadores = 2;
		} else if (evento.equals("Tres")) {

			ima1.setVisible(true);
			juga1.setVisible(true);
			ima2.setVisible(true);
			juga2.setVisible(true);
			ima3.setVisible(true);
			juga3.setVisible(true);
			ima4.setVisible(false);
			juga4.setVisible(false);
			numJugadores = 3;

		} else if (evento.equals("Cuatro")) {

			ima1.setVisible(true);
			juga1.setVisible(true);
			ima2.setVisible(true);
			juga2.setVisible(true);
			ima3.setVisible(true);
			juga3.setVisible(true);
			ima4.setVisible(true);
			juga4.setVisible(true);
			numJugadores = 4;

		}
	}

	/**
	 * 
	 * @throws FileNotFoundException
	 */
	public void iniciaJuego() throws FileNotFoundException {
		
		switch (numJugadores) {
		case (2):
			String nombre1 = juga1.getText();
			jugadoresActivos.add(new Jugador(nombre1));
			String nombre2 = juga2.getText();
			jugadoresActivos.add(new Jugador(nombre2));

			break;
		case (3):
			String nombre12 = juga1.getText();
			jugadoresActivos.add(new Jugador(nombre12));
			String nombre22 = juga2.getText();
			jugadoresActivos.add(new Jugador(nombre22));
			String nombre32 = juga3.getText();
			jugadoresActivos.add(new Jugador(nombre32));

			break;
		case (4):
			String nombre13 = juga1.getText();
			jugadoresActivos.add(new Jugador(nombre13));
			String nombre23 = juga2.getText();
			jugadoresActivos.add(new Jugador(nombre23));
			String nombre33 = juga3.getText();
			jugadoresActivos.add(new Jugador(nombre33));
			String nombre43 = juga4.getText();
			jugadoresActivos.add(new Jugador(nombre43));

			break;

		}
		InterfazGrafica interfazGrafica = new InterfazGrafica(jugadoresActivos);
		interfazGrafica.setVisible(true);
		this.dispose();

	}

	/**
	 * @param args
	 */
	public static void main(String[] miJuego) {
		Inicio Juego = new Inicio();
		Juego.setVisible(true);

	}

	public void actionPerformed(ActionEvent elevento) {
		String evento = elevento.getActionCommand();

		if (evento.equals("nJugadore")) {

			try {
				iniciaJuego();
			} catch (FileNotFoundException e) {

			}
		} else {
			mostrarInicio(evento);
		}

	}

}
