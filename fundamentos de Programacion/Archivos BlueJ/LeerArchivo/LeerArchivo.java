import java.io.*;

public class LeerArchivo {

  BufferedReader in = null;
  
  public boolean abrirArchivo() {
    boolean exito = true;
    try {
      in = new BufferedReader(new FileReader("laberinto.txt"));
    } catch (FileNotFoundException e) {
      System.out.println("No esta el archivo");
      exito = false;
    }
    return exito;
  }
  
  public String leerLinea() {
    String s = null;
    try {
      s = in.readLine();
    } catch (IOException e) {
      System.out.println("Problema al leer el archivo: " + e);    
    }
    return s;
  }

  public static void main(String [] args) {
    LeerArchivo miLector = new LeerArchivo();
    String linea = null;
    if (miLector.abrirArchivo() == true) {
      linea = miLector.leerLinea();
      while (linea != null) {
        System.out.println(linea);
        linea = miLector.leerLinea();
    }
    }
  }

}