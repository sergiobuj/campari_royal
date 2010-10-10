import java.io.*;
import java.util.*;

class Main {
	int filas = 0;

	ArrayList bigThing = new ArrayList();

	ArrayList bigThingWords = new ArrayList();

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
		String input;
		StringTokenizer idata;

		while ((input = Main.ReadLn(255)) != null) {
			idata = new StringTokenizer(input);

			while (idata.hasMoreTokens()) {
				String word = idata.nextToken();
				
				bigThingWords.add(word);
				

				if (word.equalsIgnoreCase("+") || word.equalsIgnoreCase("-")
						|| word.equalsIgnoreCase("=")) {
					filas++;
				} else {
					filas++;
					unicas(word);

				}

			}
			toMatrix();
		}

	}

	public void unicas(String word) {
		char[] arrChar = word.toCharArray();
		ArrayList<Character> alone = new ArrayList<Character>();
		alone.add(arrChar[0]);
		for (int i = 1; i < arrChar.length; i++) {
			char a1 = arrChar[i];
			int num = alone.size();

			for (int j = 0; j < alone.size(); j++) {
				char b1 = alone.get(j);
				if (a1 != b1) {
					num = num - 1;
					if (num == 0) {
						alone.add(arrChar[i]);
					}
				}
			}
		}
		bigThing.add(alone);
	}

	public void toMatrix() {
		int[][] matrix = new int[filas][30];

		for (int i = 0; i < filas; i++) {
			
			
			String tempWord = (String) bigThingWords.get(i);
			ArrayList temp = (ArrayList) bigThing.get(i);			
			
			
			char[] chars = tempWord.toCharArray();
			char[] chars1 = temp.toString().toCharArray();

			for (int j = 0; j < chars.length; j++) {
				char one = chars[j];
				
				for (int k = 0; k < chars1.length; k++) {
					char two = chars1[k];

					if (one == two) {
						matrix[i][j] = k;
					}

				}

			}

		}

		// esto es solo una prueba ..para ver si imprime la matriz...
		for (int ab = 0; ab < filas; ab++) {
			System.out.println("");			
			for (int bc = 0; bc < 30; bc++) {
				int abc = matrix[ab][bc];
				System.out.print(" " + abc);

			}
		}
	}

}
