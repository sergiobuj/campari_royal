/**
 * Paquete que contiene todo el Sabelotodo desarrollado por Sergio Botero Uribe 200710001010
 */
package sabe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Helmuth
 * adaptado por Sergio Botero 200710001010
 * @version 2.0
 */

/**
 * Clase para leer archivo.
 *
 */
public class ReadFile {
	private BufferedReader tableroTxt = null;
	
	/**
	 * Aqui se toma un archivo para ser usado en el programa
	 * @param tablero es una direccion donde está el archivo que se quiere leer
	 * @throws FileNotFoundException si el documento no está en el lugar indicado
	 */
	public ReadFile(String tablero) throws FileNotFoundException {
		tableroTxt = new BufferedReader(new FileReader(tablero));
	}

	/**
	 * Metodo usado para tomar una linea de un archivo
	 * @return un String que contiene toda una fila tomada de un archivo de texto txt.
	 * @throws IOException sin no encuentra mas lineas
	 */
	public String readLine() throws IOException {
		return tableroTxt.readLine();
	}
}
