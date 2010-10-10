/*import java.io.*;              //3392 de la acm
import java.util.*;

class Main {
	static String ReadLn(int maxLg) // utility function to read from stdin
	{
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		String line = "";
		try {
			while (lg < maxLg) {
				car = System.in.read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}
		if ((car < 0) && (lg == 0))
			return (null); // eof
		return (new String(lin, 0, lg));
	}

	public static void main(String args[]) // entry point from OS
	{
		Main myWork = new Main(); // create a dinamic instance
		myWork.Begin(); // the true entry point
	}

	void Begin() {
		String input, numCasos;
		StringTokenizer idata, casos;
		int caso = 0;
		int n;
		numCasos = Main.ReadLn(255);
		casos = new StringTokenizer(numCasos);
		int meDaCasos = Integer.parseInt(casos.nextToken());
		boolean fin = false;
		
			while ((input = Main.ReadLn(255)) != null) {
				if (!fin) {
				caso = caso + 1;
				if(caso == meDaCasos){
					fin = true;
				}
				idata = new StringTokenizer(input);
				n = Integer.parseInt(idata.nextToken());
				double resp = (((n * (n + 1)) / 2) * ((n * (n + 1)) / 2)
						+ ((n * (n + 1) * (2 * n + 1)) / 2) + (n * (n + 1))) * 0.5;
				System.out.println(caso + " " + n + " " + (int) resp);
				resp = 0;
			}
		}
	}
}
*/