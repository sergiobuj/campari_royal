import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ensayo {
	private BufferedReader tableroTxt = null;

	public void Ensayo() throws FileNotFoundException {
		tableroTxt = new BufferedReader(new FileReader("alpham.in"));
	}
	public String readLine() throws IOException {
		return tableroTxt.readLine();
	}
}