import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Codigo {
	private BufferedReader elCodigo = null;
	public Codigo(String codigo) throws FileNotFoundException {
		elCodigo = new BufferedReader(new FileReader(codigo));
	}
	public String readLine() throws IOException {
		return elCodigo.readLine();
	}
}
