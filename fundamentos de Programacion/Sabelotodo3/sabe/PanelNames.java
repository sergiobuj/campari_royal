/**
 * Paquete que contiene todo el Sabelotodo desarrollado por Sergio Botero Uribe 200710001010
 */
package sabe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * @author Sergio Botero 200710001010
 * @version 3.0
 */

/**
 * clase que extiende de JPanel que es donde se agregan los nombres de los jugadores
 */
public class PanelNames extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	/**
	 * JText donde el usuario escribe nombre de un jugador
	 */
	JTextField texPlayer1, texPlayer2, texPlayer3, texPlayer4;

	/**
	 * boton de adicion de jugador
	 */
	JButton butPlayer1, butPlayer2, butPlayer3, butPlayer4;

	/**
	 * label guia para saber que nombre se debe introducir despues
	 */
	JLabel labPlayer1, labPlayer2, labPlayer3, labPlayer4, empty1, empty2;

	/**
	 * String donde se guarda el nombre del jugador
	 */
	String name1, name2, name3, name4;

	public static final String BUT1 = "1",BUT2 = "2",BUT3 = "3",BUT4 = "4";



	/**
	 * arreglo que se crea con los jugadores ingresados
	 */
	ArrayList players;

	/**
	 * Ventana principal
	 */
	private FramePpal mainWin;

	public PanelNames(FramePpal mainWin) {
		this.mainWin = mainWin;
		players = new ArrayList();
		this.setLayout(new BorderLayout());
		JPanel buttons = new JPanel();
		this.add(buttons, BorderLayout.EAST);
		buttons.setLayout(new GridLayout(9, 2));
		buttons.add(empty1 = new JLabel(""));
		buttons.add(empty1 = new JLabel(""));
		buttons.add(butPlayer1 = new JButton("Jugar"));
		butPlayer1.addActionListener(this);
		butPlayer1.setActionCommand(BUT1);
		buttons.add(empty1 = new JLabel(""));
		buttons.add(empty1 = new JLabel(""));
		buttons.add(empty1 = new JLabel(""));
		buttons.add(butPlayer2 = new JButton("Jugar"));
		butPlayer2.addActionListener(this);
		butPlayer2.setActionCommand(BUT2);
		buttons.add(empty1 = new JLabel(""));
		buttons.add(empty1 = new JLabel(""));
		buttons.add(empty1 = new JLabel(""));
		buttons.add(butPlayer3 = new JButton("Jugar"));
		butPlayer3.addActionListener(this);
		butPlayer3.setActionCommand(BUT3);
		buttons.add(empty1 = new JLabel(""));
		buttons.add(empty1 = new JLabel(""));
		buttons.add(empty1 = new JLabel(""));
		buttons.add(butPlayer4 = new JButton("Jugar"));
		butPlayer4.addActionListener(this);
		butPlayer4.setActionCommand(BUT4);
		buttons.setPreferredSize(new Dimension(160, 0));
		JPanel center = new JPanel();
		this.add(center, BorderLayout.CENTER);
		center.setLayout(new BorderLayout());
		JPanel names = new JPanel();
		center.add(names, BorderLayout.CENTER);
		names.setLayout(new GridLayout(9, 2));
		names.add(labPlayer1 = new JLabel("Jugador 1"));
		names.add(texPlayer1 = new JTextField(""));
		names.add(labPlayer2 = new JLabel("Jugador 2"));
		names.add(texPlayer2 = new JTextField(""));
		names.add(labPlayer3 = new JLabel("Jugador 3"));

		names.add(texPlayer3 = new JTextField(""));
		names.add(labPlayer4 = new JLabel("Jugador 4"));

		names.add(texPlayer4 = new JTextField(""));
		JPanel panEmpty = new JPanel();
		center.add(panEmpty, BorderLayout.EAST);
		panEmpty.setPreferredSize(new Dimension(50, 0));
		labPlayer3.setForeground(Color.gray);
		labPlayer4.setForeground(Color.gray);

		texPlayer2.setEnabled(false);
		butPlayer2.setEnabled(false);
		labPlayer3.setVisible(false);
		labPlayer4.setVisible(false);
		texPlayer3.setVisible(false);
		butPlayer3.setVisible(false);
		texPlayer4.setVisible(false);
		butPlayer4.setVisible(false);
	}

	/**
	 * este action performed juega con las propiedades de los botones y de los campos de texto, haciendolos
	 * visibles y editables cada vez que el jugador va haciendo uso de ellos, esto en parte elimina la posibilidad de 
	 * que el jugador intente jugar solo y además ayuda para la definicion del resto del juego basandose
	 * en el numero de jugadores y sus nombres.
	 */
	public void actionPerformed(ActionEvent event) {
		String events = event.getActionCommand();
		if (events.equals("1")) {
			name1 = texPlayer1.getText();
			if (name1 == null || name1.equals("")) {
				JOptionPane.showMessageDialog(this,
						"Se debe escribir el nombre del jugador numero 1",
						"Juego Sabelotodo -ESCRIBA LOS NOMBRES-",
						JOptionPane.WARNING_MESSAGE);
			} else {
				players.add(new Player(texPlayer1.getText(), 1));
				butPlayer1.setEnabled(false);
				texPlayer1.setEditable(false);
				butPlayer1.setText("LISTO!!");
				texPlayer2.setEnabled(true);
				butPlayer2.setEnabled(true);
			}

		} else if (events.equals("2")) {
			name2 = texPlayer2.getText();
				if (name2 == null || name2.equals("")) {
					JOptionPane.showMessageDialog(this,
							"Se debe escribir el nombre del jugador numero 2",
							"Juego Sabelotodo -ESCRIBA LOS NOMBRES-",
							JOptionPane.WARNING_MESSAGE);
				}else if(name2.equalsIgnoreCase(name1)){
					JOptionPane.showMessageDialog(this,
							"Se debe escribir el nombre del jugador numero 2"+'\n'+"diferente al nombre del jugador 1",
							"Juego Sabelotodo -ESCRIBA LOS NOMBRES-",
							JOptionPane.WARNING_MESSAGE);
				} else {
					players.add(new Player(texPlayer2.getText(),2));
					texPlayer3.setVisible(true);
					butPlayer3.setVisible(true);
					labPlayer3.setForeground(Color.black);
					butPlayer2.setEnabled(false);
					texPlayer2.setEditable(false);
					butPlayer2.setText("LISTO!!");
					labPlayer3.setVisible(true);
					mainWin.play.setEnabled(true);

				}
			
		} else if (events.equals("3")) {
			name3 = texPlayer3.getText();
			
			if (name3 == null || name3.equals("")) {
				JOptionPane.showMessageDialog(this,
						"Se debe escribir el nombre del jugador numero 3",
						"Juego Sabelotodo -ESCRIBA LOS NOMBRES-",
						JOptionPane.WARNING_MESSAGE);
			}else if(name3.equalsIgnoreCase(name1)){
				JOptionPane.showMessageDialog(this,
						"Se debe escribir el nombre del jugador numero 3"+'\n'+"diferente al nombre del jugador 1",
						"Juego Sabelotodo -ESCRIBA LOS NOMBRES-",
						JOptionPane.WARNING_MESSAGE);
			}else if(name3.equalsIgnoreCase(name2)){
				JOptionPane.showMessageDialog(this,
						"Se debe escribir el nombre del jugador numero 3"+'\n'+"diferente al nombre del jugador 2",
						"Juego Sabelotodo -ESCRIBA LOS NOMBRES-",
						JOptionPane.WARNING_MESSAGE);
			
			} else {

				players.add(new Player(texPlayer3.getText(),3));
				texPlayer4.setVisible(true);
				butPlayer4.setVisible(true);
				labPlayer4.setForeground(Color.black);
				butPlayer3.setEnabled(false);
				texPlayer3.setEditable(false);
				butPlayer3.setText("LISTO!!");
				labPlayer4.setVisible(true);
			}
		
		} else if (events.equals("4")) {

			name4 = texPlayer4.getText();
			if (name4 == null || name4.equals("")) {
				JOptionPane.showMessageDialog(this,
						"Se debe escribir el nombre del jugador numero 4",
						"Juego Sabelotodo -ESCRIBA LOS NOMBRES-",
						JOptionPane.WARNING_MESSAGE);
			}else if(name4.equalsIgnoreCase(name1)){
				JOptionPane.showMessageDialog(this,
						"Se debe escribir el nombre del jugador numero 4"+'\n'+"diferente al nombre del jugador 1",
						"Juego Sabelotodo -ESCRIBA LOS NOMBRES-",
						JOptionPane.WARNING_MESSAGE);
			}else if(name4.equalsIgnoreCase(name2)){
				JOptionPane.showMessageDialog(this,
						"Se debe escribir el nombre del jugador numero 4"+'\n'+"diferente al nombre del jugador 2",
						"Juego Sabelotodo -ESCRIBA LOS NOMBRES-",
						JOptionPane.WARNING_MESSAGE);
			}else if(name4.equalsIgnoreCase(name3)){
				JOptionPane.showMessageDialog(this,
						"Se debe escribir el nombre del jugador numero 4"+'\n'+"diferente al nombre del jugador 3",
						"Juego Sabelotodo -ESCRIBA LOS NOMBRES-",
						JOptionPane.WARNING_MESSAGE);
			
			
			} else {
				players.add(new Player(texPlayer4.getText(),4));
				butPlayer4.setEnabled(false);
				texPlayer4.setEditable(false);
				butPlayer4.setText("LISTO!!");
			}
		}
	}

}