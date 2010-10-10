
public class ensayo
{

public String voltearPalabra(String palabra, int indice){
StringBuffer volteada = new StringBuffer(palabra);
return volteada.reverse().toString() + "  " + volteada.charAt(indice) + "  " +volteada.length();

}
    
    
}
