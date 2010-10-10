
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Helmuth
 * @version 2.0
 *
 */
public class LeeArchivo {
	private BufferedReader tableroTxt = null;

	public LeeArchivo(String tablero) throws FileNotFoundException {
		tableroTxt = new BufferedReader(new FileReader(tablero));
	}

	public String leeLinea() throws IOException {
		return tableroTxt.readLine();
	}
}
