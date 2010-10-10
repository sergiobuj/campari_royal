
public class Traduccion
{
    // instance variables - replace the example below with your own
    String laPalabra;
    String laTraduccion;
    
    
    public Traduccion(String palabra, String traduccion)
    {
        // initialise instance variables
        laPalabra = palabra;
        laTraduccion=traduccion;
    }

    //retorna la palabra en español de una pareja
    public  String darPalabra(){
    
    return laPalabra;
    }
    
    //da la traduccion a una palabra
    public String darTraduccion(){
    
    return laTraduccion;
    }
    
    //cambia traduccion a una palabra
    public void cambiarTraduccion(String nuevaPalabra){
        laTraduccion=nuevaPalabra;

    }
    
}
