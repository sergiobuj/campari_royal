import java.util.Scanner;

public class Analiza {

	Analiza() {

	}

	// decide si la linea de entrada es una primitiva
	boolean primitiva(String line) {
		boolean esPrimitiva = false;

		String escrita = line;
		if (escrita.equals("Avance") || escrita.equals("Gire")
				|| escrita.equals("TomeTesoro") || escrita.equals("DejeTesoro")
				|| escrita.equals("Termine")) {
			esPrimitiva = true;
			System.out.println("está bien");

		}

		return esPrimitiva;

	}

	// decide si la linea de entrada es una booleana
	boolean booleana(String line) {
		boolean esBooleana = false;
		String booleana = line;
		if (booleana.equals("HayObstaculo") || booleana.equals("HayAbismo")
				|| booleana.equals("HayTesoro")
				|| booleana.equals("TieneTesoro")
				|| booleana.equals("MiraNorte") || booleana.equals("MiraSur")
				|| booleana.equals("MiraEste") || booleana.equals("MiraOeste")) {
			esBooleana = true;
			System.out.println("está bien");
		}
		return esBooleana;
	}

	// decide si la linea de entrada es un comentario
	boolean comentario(String line) {
		boolean esComentario = false;
		Scanner scan = new Scanner(line);
		if (scan.next().startsWith("//")) {
			esComentario = true;
			System.out.println("está bien");
		}
		scan.close();
		return esComentario;
	}

	// mira si es una condicion
	boolean condicion(String line) {
		boolean esCondicion = false;
		if (line.startsWith("no ")) {
			line = line.replaceFirst("no ", "");
			if (booleana(line)) {
				esCondicion = true;
			}
		} else if (booleana(line)) {
			esCondicion = true;
		}

		return esCondicion;
	}

	boolean ciclo(String line) {
		boolean esCiclo = false;
		Scanner scan = new Scanner(line);
		String lineaCodigo = scan.nextLine();
		if (lineaCodigo.startsWith("Mientras")) {
			lineaCodigo = lineaCodigo.replaceFirst("Mientras", "");
			if (lineaCodigo.endsWith("FinMientras")) {
				lineaCodigo = volteaBorraFin(lineaCodigo, "sartneiMniF");
				Scanner scan1 = new Scanner(lineaCodigo);
				
				String posible= scan1.next();
				if(booleana(posible)){
					bloque(scan1.nextLine());
				}else{
					String posible2 = posible+" "+scan1.next();
					if(booleana(posible2)){
						bloque(scan1.nextLine());
						
					}
				}
				
				
				
				
				
				
				
				
			}

		}

		scan.close();
		return esCiclo;
	}

	boolean sentencia(String line) {
		boolean esSentencia = false;
		Scanner scan = new Scanner(line);
		String linea = scan.nextLine();

		if (estructuraControl(linea) || primitiva(linea)) {
			esSentencia = true;
		}

		scan.close();
		return esSentencia;
	}

	boolean estructuraControl(String line) {
		boolean esEstructuraC = false;
		Scanner scan = new Scanner(line);
		String linea = scan.nextLine();
		if (siCondicional(linea) || ciclo(linea)) {
			esEstructuraC = true;
		}
		scan.close();
		return esEstructuraC;
	}

	private boolean siCondicional(String linea) {
		String posi1 = null;
		String posi2 = null;
		String posibleCond2;
		String posibleCond1;
		boolean esCondicional = false;
		if (linea.startsWith("Si")) {
			linea = linea.replaceFirst("Si", "");
			if (linea.endsWith("FinSi")) {
				linea = volteaBorraFin(linea, "iSniF");
				Scanner scan = new Scanner(linea);
				posibleCond1 = scan.next();

				if (scan.hasNext()) {
					posibleCond2 = posibleCond1.concat(" " + scan.next());
				} else {
					posibleCond2 = "";
				}

				if (condicion(posibleCond1) || condicion(posibleCond2)) {

					if (scan.hasNext()) {
						posi1 = scan.next();
						if (scan.hasNext()) {
							posi2 = posi1.concat(" " + scan.next());
						} else {
							posi2 = "";
						}
					}
					if (bloque(posi1) || bloque(posi2)) {
						System.out.println("esta bien condicional");
						esCondicional = true;

					}

				}
				scan.close();
			}

		}

		return esCondicional;
	}

	private boolean bloque(String linea) {
		boolean esBloque = false;
		String posible;
		String posible2 = null;

		if (linea != null || linea != " ") {

			Scanner scan = new Scanner(linea);
			if (scan.hasNext()) {
				posible = scan.next();
				if (scan.hasNext()) {
					posible2 = scan.nextLine();
				}else{posible2="no more elements";
				}
				if ((sentencia(posible) && bloque(posible2))
						|| sentencia(posible)) {
					System.out.println("esta bien");
					esBloque = true;
				}
			}

			scan.close();
		}
		return esBloque;
	}

	public String volteaBorraFin(String linea1, String quitar) {
		StringBuffer elBuffer = new StringBuffer(linea1);
		elBuffer.reverse();
		String linea = elBuffer.toString();
		linea = linea.replaceFirst(quitar, "");
		StringBuffer otro = new StringBuffer(linea);
		otro.reverse();
		return otro.toString();
	}

	public static void main(String[] args) {

		Analiza codigo = new Analiza();
		

		codigo.ciclo("Mientras no HayTesoro " +
						"Avance " +
					"FinMientras");

	}

}
