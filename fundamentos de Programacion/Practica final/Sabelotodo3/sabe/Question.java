/**
 * Paquete que contiene todo el Sabelotodo desarrollado por Sergio Botero Uribe 200710001010
 */
package sabe;


import java.util.Random;


/**
 * @author Sergio Botero 200710001010
 *
 * 
 * 
 */

/**
 * Clase que contiene la información de cada pregunta
 */
public class Question {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Random random;
	
	String  question, correct, answer1, answer2, answer3;
	int topic;

	public Question(int theTopic, String theQuestion, String theCorrect,
			String theAnswer1, String theAnswer2, String theAnswer3) {
		this.question = theQuestion;
		this.correct = theCorrect;
		this.answer1 = theAnswer1;
		this.answer2 = theAnswer2;
		this.answer3 = theAnswer3;
		this.topic = theTopic;


	}

	/**Entrega una posible respuesta a la pregunta
	 * @return the answer1
	 */
	public String getAnswer1() {
		return answer1;
	}

	/**Entrega una posible respuesta a la pregunta
	 * @return the answer2
	 */
	public String getAnswer2() {
		return answer2;
	}

	/**Entrega una posible respuesta a la pregunta
	 * @return the answer3
	 */
	public String getAnswer3() {
		return answer3;
	}

	/**Entrega la respuesta correcta a la pregunta
	 * @return the correct
	 */
	public String getCorrect() {
		return correct;
	}

	/**Entrega la Pregunta
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**devuelve el numero del tema de la tema (de 1 a 4)
	 * @return the topic
	 */
	public int getTopic() {
		return topic;
	}

	
}
