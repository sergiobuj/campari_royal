/**
 * 
 */

/**
 * @author
 *
 */
public class Pregunta {
	
	String pregunta;
	String correcta;
	String incorrecta1;
	String incorrecta2;
	String incorrecta3;
	
	int tema;
	
public Pregunta(String pregunta, int tema, String correcta, String incorrecta1, String incorrecta2, String incorrecta3){
	
	this.pregunta = pregunta;
	this.tema = tema;
	this.correcta = correcta;
	this.incorrecta1 = incorrecta1;
	this.incorrecta2 = incorrecta2;
	this.incorrecta3 = incorrecta3;
	
		
}

/**
 * @return the correcta
 */
public String getCorrecta() {
	return correcta;
}

/**
 * @return the incorrecta1
 */
public String getIncorrecta1() {
	return incorrecta1;
}

/**
 * @return the incorrecta2
 */
public String getIncorrecta2() {
	return incorrecta2;
}

/**
 * @return the incorrecta3
 */
public String getIncorrecta3() {
	return incorrecta3;
}

/**
 * @return the pregunta
 */
public String getPregunta() {
	return pregunta;
}

/**
 * @return the tema
 */
public int getTema() {
	return tema;
}


}
