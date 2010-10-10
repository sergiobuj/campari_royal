/**
 * Paquete que contiene todo el Sabelotodo desarrollado por Sergio Botero Uribe 200710001010
 */
package sabe;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * @author Sergio Botero 200710001010
 * 
 *
 */

/** 
*Esta clase tiene toda la informacion del jugador, su nombre y puntaje.
*/
public class Player {
	
	/**
	 * Nombre del jugador
	 */
	String name;
	/**
	 * punto del jugador
	 */
	int points1;
	/**
	 * punto del jugador
	 */
	int points2;
	/**
	 * punto del jugador
	 */
	int points3;
	/**
	 * punto del jugador
	 */
	int points4;
	/**
	 * toma la imagen de la ficha que debe tener el jugador
	 */
	Icon figure;
	/**
	 * numero que identifica el jugador
	 */
	int num;
	/**
	 * posicion en el tablero donde se encuentra el jugador
	 */
	Space pos;
	
	/**
	 * Imagen de la ficha del jugador 1
	 */
	ImageIcon figure1 = new ImageIcon("Images/ficha1.png");
	/**
	 * Imagen de la ficha del jugador 2
	 */
	ImageIcon figure2 = new ImageIcon("Images/ficha2.png");
	/**
	 * Imagen de la ficha del jugador 3
	 */
	ImageIcon figure3 = new ImageIcon("Images/ficha3.png");
	/**
	 * Imagen de la ficha del jugador 4
	 */
	ImageIcon figure4 = new ImageIcon("Images/ficha4.png");
	/**
	 * Imagen de la cara del creador del Juego
	 */
	ImageIcon cara = new ImageIcon("Images/cara2.png");

	
	
	public Player(String theName, int num){
		this.name = theName;
		this.points1 = 0;
		this.points2 = 0;
		this.points4 = 0;
		this.points3 = 0;
		this.num=num;

		switch(num){
		case(1):
			this.figure=figure1;
			break;
		case(2):
			this.figure=figure2;
			break;
		case(3):
			this.figure=figure3;
			break;
		case(4):
			this.figure=figure4;
			break;
		}
		
		if(name.equalsIgnoreCase("sergiobuj")){
			this.figure=cara;
			this.name = "+El Creador+";
		}
		
	}

	/**
	 * entrega el numero total de respuestas correctas
	 * @return la suma de todas las respuestas correctas de todas las areas.
	 */
	public int getTotal(){
		int total = points1+points2+points3+points4;
		return total;
	}
	/**
	 * agrega una respuesta correcta al numero acumulado.
	 * en la categoria 1
	 *
	 */
	public void sumIn1(){
		points1+=1;
	}
	/**
	 * agrega una respuesta correcta al numero acumulado.
	 * en la categoria 2
	 *
	 */
	public void sumIn2(){
		points2+=1;
	}
	/**
	 * agrega una respuesta correcta al numero acumulado.
	 * en la categoria 3
	 *
	 */
	public void sumIn3(){
		points3+=1;
	}
	/**
	 * agrega una respuesta correcta al numero acumulado.
	 * en la categoria 4
	 *
	 */
	public void sumIn4(){
		points4+=1;
	}
	/**
	 *entrega los puntos acumulados en el area numero 1. 
	 * @return un numero de respuestas correctas.
	 */
	public int getPoints1(){
		return points1;
	}
	/**
	 *entrega los puntos acumulados en el area numero 2. 
	 * @return un numero de respuestas correctas.
	 */
	public int getPoints2(){
		return points2;
	}
	/**
	 *entrega los puntos acumulados en el area numero 3. 
	 * @return un numero de respuestas correctas.
	 */
	public int getPoints3(){
		return points3;
	}
	/**
	 *entrega los puntos acumulados en el area numero 4. 
	 * @return un numero de respuestas correctas.
	 */
	public int getPoints4(){
		return points4;
	}
	/**
	 * Entrega el nombre del jugador.
	 * @return nombre del jugador
	 */
	public String getName(){
		return name;
	}
	/**  Da una nueva posicion al jugador, posicion que está determinada por una casilla de tipo Space
	 * @param newPos es la nueva posicion en el tablero del jugador.
	 *esta newPos tiene que ser de tipo Space.
	 */
	public void newPos(Space newPos){
		this.pos = newPos;
		pos.setIcon(figure);
	}
	
	/**
	 * este metodo muestra la posicion del jugador en el tablero
	 */
	public Space getCurrentPos(){
		return pos;
	}

	/**Este metodo entrega el numero del jugador como fue especificado en la ventana principal (valores de 1 a 4).
	 * @return the num es entre 1 y 4
	 */
	public int getNum() {
		return num;
	}
}
