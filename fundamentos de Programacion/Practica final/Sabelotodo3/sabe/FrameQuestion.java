/**
 * Paquete que contiene todo el Sabelotodo desarrollado por Sergio Botero Uribe 200710001010
 */
package sabe;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author Sergio Botero 200710001010
 * 
 * 
 */
/**
 * clase que extiende de JFrame y es la plantilla donde se crea la pregunta para mostrar al usuario
 */
public class FrameQuestion extends JFrame implements ActionListener {
	

	private static final long serialVersionUID = 1L;

	/**
	 * label en donde se muestra la pregunta
	 */
	JLabel theQuestion;
	/**
	 * frame de la ventana donde se desarrolla el juego
	 */
	FrameGame thisFrameGame;

	/**
	 * boton de seleccion de respuesta
	 */
	JButton theAnswer1, theAnswer2, theAnswer3, theCorrect;
	
	/**
	 * tema de la pregunta que debe ser mostrada
	 */
	int thisTopic,rand;
	
	/**
	 * String que se usa para efectos de mostrar un mensaje al usuario
	 */
	String theCorrectA,option;

	/**
	 * Frame donde se muestra cada pregunta que sale.
	 * @param topic es el tema del que se quiere la pregunta.
	 * @param question es un string que trae la pregunta.
	 * @param correct es el string que es la respuesta correcta.
	 * @param answer1 un string que tiene una opcion de respuesta.
	 * @param answer2 un string que tiene una opcion de respuesta.
	 * @param answer3 un string que tiene una opcion de respuesta.
	 * @param frameGame se pasa el FrameGame para poder adicionar el puntaje.
	 */
	public FrameQuestion(int topic, String question, String correct,
			String answer1, String answer2, String answer3,FrameGame frameGame) {
		thisFrameGame = frameGame;
		this.setAlwaysOnTop(true);
		this.setMinimumSize(new Dimension(300, 300));
		this.setLayout(new GridLayout(7, 0));
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		thisTopic = topic;
		theQuestion = new JLabel(question);
		this.add(new JLabel(""));
		this.add(theQuestion);
		this.add(new JLabel(""));
		theCorrectA=correct;
		this.setResizable(false);
		

		switch (thisTopic) {
		case (1):
			this.setTitle("Pregunta de Geografía");
			break;
		case (2):
			this.setTitle("Pregunta de Historia");
			break;
		case (3):
			this.setTitle("Pregunta de Deportes");
			break;
		case (4):
			this.setTitle("Pregunta de Cultura General");
			break;
		}

		Random random = new Random();
		rand = random.nextInt(4);
		rand += 1;
		switch (rand) {
		case (4):
			add(theAnswer1 = new JButton("A. " + answer1));
			add(theAnswer2 = new JButton("B. " + answer2));
			add(theAnswer3 = new JButton("C. " + answer3));
			add(theCorrect = new JButton("D. " + correct));
			option = "D";
			break;
		case (1):

			add(theCorrect = new JButton("A. " + correct));
			add(theAnswer3 = new JButton("B. " + answer3));
			add(theAnswer2 = new JButton("C. " + answer2));
			add(theAnswer1 = new JButton("D. " + answer1));
			option="A";

			break;
		case (2):
			add(theAnswer1 = new JButton("A. " + answer1));
			add(theAnswer2 = new JButton("B. " + answer2));
			add(theCorrect = new JButton("C. " + correct));
			add(theAnswer3 = new JButton("D. " + answer3));
			option="C";

			break;
		case (3):
			add(theAnswer1 = new JButton("A. " + answer1));
			add(theCorrect = new JButton("B. " + correct));
			add(theAnswer2 = new JButton("C. " + answer2));
			add(theAnswer3 = new JButton("D. " + answer3));
			option="B";
			break;

		}
		theAnswer1.setActionCommand("wrong");
		theAnswer2.setActionCommand("wrong");
		theAnswer3.setActionCommand("wrong");
		theCorrect.setActionCommand("right");
		theAnswer1.addActionListener(this);
		theAnswer2.addActionListener(this);
		theAnswer3.addActionListener(this);
		theCorrect.addActionListener(this);
		this.pack();
	}

	/**
	 * ActionPerformed que toma la respuesta del jugador y suma punto si es la correcta.
	 */
	public void actionPerformed(ActionEvent event) {

		String answer = event.getActionCommand();
		if (answer.equals("right")) {
			thisFrameGame.putScore(thisTopic, true);
			JOptionPane
			.showMessageDialog(
					null,
					"correcto"
							+ '\n'
							+ "La respuesta es la:"
							+ '\n'
							+ option+"."+theCorrectA
							+ '\n'
							+ '\n',
					"Juego Sabelotodo -RESPUESTA-",
					JOptionPane.INFORMATION_MESSAGE);
			this.dispose();

		} else {
			this.dispose();
			JOptionPane
			.showMessageDialog(
					null,
					"Incorrecto"
							+ '\n'
							+ "La respuesta correcta era la:"
							+ '\n'
							+ option+"."+theCorrectA
							+ '\n'
							+ '\n',
					"Juego Sabelotodo -RESPUESTA-",
					JOptionPane.INFORMATION_MESSAGE);
			thisFrameGame.putScore(thisTopic, false);
		}
	}

}
