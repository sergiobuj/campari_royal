import java.io.*;
import java.util.*;

class Main {
	char[] charA;
	int elContador;
	
	
	
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
	
	int cuentaDigitos(int numero){
		int contador =1;
		while(numero>=10){
			contador++;
			numero = numero /10;
		}
		return contador;
	}
	
	
	
	public static void main(String args[]) // entry point from OS
	{
		Main myWork = new Main(); // create a dinamic instance
		myWork.Begin(); // the true entry point
	}
	
	
	
	
	String posiblididades(String linea, int productos){
		String nuevoString = "";
		linea.toCharArray();
		int  longi = linea.length();
		
		
		
		
		
		
		
		
		
		
		
		return nuevoString;
	}
	
	
	
	
	
	
	
	
	
	String separaProductos(String linea) {
		String separada = "";
		elContador=1;
		charA = linea.toCharArray();
		int charAl = charA.length;
		for (int i = 0; i <= (charAl - 2); i += 2) {
			
			char a = linea.charAt(i);
			if (a == 80 || a == 112) {
				char b = linea.charAt(i + 1);
				String uno = new String(a + "");
				String dos = new String(b + "");
				separada = separada + uno + dos + " ";
				elContador++;
			} else {
				char c = linea.charAt(i + 1);
				String tres = new String(a + "");
				String cuatro = new String(c + "");
				separada = separada + tres + cuatro;
				
			}
		}
		return separada;
	}

	
	
	
	
	String totales(String lineaTotales) {
		char a = lineaTotales.charAt(0);
		char b = lineaTotales.charAt(1);
		String uno = new String(a + "");
		String dos = new String(b + "");
		String nueva = uno + dos;
		String s = new String(lineaTotales.replaceFirst(nueva, (nueva + " ")));
		return s;
	}

	
	
	
	
	
	
	
	
	
	String vendedores(String linea) {
		String lineaNueva = "";
		String numeros = "";
		char[] arreglo = linea.toCharArray();
		for (int i = 0; i <= (arreglo.length - 2); i++) {
			if (arreglo[i] >= 65) {
				char a = arreglo[i];
				lineaNueva = lineaNueva + (new String(a + ""));
			} else {
				char n = arreglo[i];
				numeros = numeros + (new String(n + ""));
			}
		}
		String lineaNueva2 = lineaNueva + " " + numeros;
		return lineaNueva2;
	}

	
	
	
	
	
	
	
	
	
	void Begin() {
		String input;

		while ((input = Main.ReadLn(255)) != null) {
			if (input.startsWith("p1") || input.startsWith("P1")) {
				String linea = separaProductos(input);
				System.out.println(linea);

			} else if (input.startsWith("tp") || input.startsWith("TP")) {
				String linea = totales(input);
				System.out.println(linea);

			} else {
				String linea = vendedores(input);
				System.out.println(linea);
			}

		}
	}
}