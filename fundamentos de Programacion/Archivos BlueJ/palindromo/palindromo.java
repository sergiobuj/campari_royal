import java.util.ArrayList;
public class palindromo{

    public palindromo(){
    }

    public boolean palind(String palabra){

        StringBuffer palabraInversa =  new StringBuffer(palabra);
            if(palabra.equals(palabraInversa.reverse().toString())){
               return true;
            }else{
               return false;
            }
    }
}
/*     NO ME DA LA RESPUESTA DE LA FORMA QUE NOS SUGIRIERON... Y NO SE QUE PASA...  
    public boolean palind(String palabra){
        boolean es=false;
        boolean noEs=false;
        char[] arregloP = palabra.toCharArray();
        for(int i=0, j=palabra.length()-1; (i==j || j<i) && !noEs; i++,j--){
            
            if(!(arregloP[i].equals(arregloP[j]))){
                noEs=true;
                es=false;
            }
        }
        return es;
        
*/