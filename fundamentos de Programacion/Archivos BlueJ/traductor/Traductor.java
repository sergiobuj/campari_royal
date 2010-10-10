import java.util.ArrayList;

public class Traductor
{

    public final static int INGLES = 1;
    public final static int FRANCES = 2;

    public ArrayList diccioIngles;
    public ArrayList diccioFrances;
    
    public Traductor()
    {
        diccioIngles= new ArrayList();
        diccioFrances= new ArrayList();

    }
    
    //agrega una palabra a un diccionario
    public void agregarTraduccion(String pal, String trad, int idioma){
        if(idioma==1){
            Traduccion traducida = buscarTraduccionDe(pal, idioma);
                if(traducida == null){
                    diccioIngles.add( new Traduccion (pal,trad));
                }else{
                    traducida.cambiarTraduccion(trad);
                }
        }else if(idioma==2){
            Traduccion traducida = buscarTraduccionDe(pal, idioma);
                if(traducida == null){
                    diccioFrances.add( new Traduccion (pal,trad));
                }else{
                    traducida.cambiarTraduccion(trad);
                }        
        }else{
            return;
        }
    }
    
    //da la traduccion de una palabra
    public Traduccion buscarTraduccionDe(String pal, int idioma){
        Traduccion pareja=null;
        boolean encontrada= false;
        if(idioma==1){
            for(int i = 0;i<diccioIngles.size() && !encontrada; i++){
                pareja = (Traduccion)diccioIngles.get(i);
                if(pareja.darPalabra().equals(pal)){
                    encontrada=true;
                }
            }
        }else if(idioma==2){
            for(int i = 0;i<diccioFrances.size() && !encontrada; i++){
                pareja = (Traduccion)diccioFrances.get(i);
                if(pareja.darPalabra().equals(pal)){
                    encontrada=true;
                }
            }    
        }else{
            return null;
        }
        if(encontrada==true){
            return pareja;
        }else{
            return null;
        }
    }
    
    //da el numero de palabras de un diccionario
    public int darTamanioDiccionario(int idioma){
        if(idioma==1){
            return diccioIngles.size();
        }else if(idioma==2){
            return diccioFrances.size();
        }else{
            return 0;
        }
    }

}
