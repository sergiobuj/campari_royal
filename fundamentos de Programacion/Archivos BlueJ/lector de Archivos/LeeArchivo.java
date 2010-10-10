import java.io.*;
import java.util.Scanner;


public class LeeArchivo{

    private BufferedReader txt = null;
    public int uno;
    public int dos;
    public int tres;
    
    
    public LeeArchivo()throws FileNotFoundException{
        txt = new BufferedReader(new FileReader("prueba.txt"));
    }

    public String daLinea()throws IOException{
        String linea = txt.readLine();
        Scanner escanea = new Scanner(linea);
        return linea;
    }
   
    public int daint()throws IOException{
        String linea = txt.readLine();
        Scanner escanea = new Scanner(linea);
        
        uno = escanea.nextInt();

        return uno;
    }
    
    public void imprime(int j)throws IOException{
        switch(j){
            case(1):
                System.out.println(daLinea());
                break;
            case(2):
                System.out.println(daint());
                break;
            default:
                System.out.println("no sirve");
        
        }
    }
    
    
        public int leeTema()throws IOException{ 
        String lineaTema = txt.readLine();
        Scanner escanea2 = new Scanner(lineaTema);
        int tema = escanea2.nextInt();
        return tema;
    
    }
    
}
