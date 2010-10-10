import java.io.*;

/**
 * Archivo
 * Ejemplo sencillo de leer de un archivo tipo txt
 */
public class Archivo {
	private BufferedReader archivo = null;
	

	/**
	 * Constructor
	 * Trata de abrir el archivo que se va a leer
	 */
    public Archivo(String nombre) throws FileNotFoundException {
        archivo = new BufferedReader(new FileReader(nombre)); 
    }
    
    /**
     * leerUnaLinea
     * Trata de leer una linea del archivo y la devuelve
     */
    public String leerUnaLinea() throws IOException {
    	return archivo.readLine();
    }

}