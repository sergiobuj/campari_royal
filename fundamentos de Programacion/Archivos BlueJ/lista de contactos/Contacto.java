
import java.util.ArrayList;
public class Contacto{

    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;
    
    private ArrayList<String> telefonos;
    private ArrayList<String> palClaves;
    
    public Contacto(String elNombre, String elApellido, String laDireccion, String elCorreo){
        nombre= elNombre;
        apellido=elApellido;
        direccion=laDireccion;
        correo=elCorreo;
        telefonos= new ArrayList();
        palClaves= new ArrayList();
    }
    
    //para dar el correo
    public String darCorreo(){
    return correo;
    }
    
    //para dar el numero de palabras claves
    public int darNumPalabras(){
    return palClaves.size();
    }
    
    
    //para saber el nombre del contacto
    public String darNombre(){
    return nombre;
    }
    
    
    //agrega telefonos
    public void agregaTel(String telefono){
    telefonos.add(telefono);
    }
    
    //agrega palabras claves
    public void agregaPalClaves(String palabraClave){
    telefonos.add(palabraClave);
    }
    //contar el numero de palabras claves que empiezan por la letra dada
    public int totalPalabrasInicianCon(String letra){
        int encontradas=0;
        for (int i=0; i<palClaves.size();i++){
            String palabraBuscada = palClaves.get(i);
            if(palabraBuscada.startsWith(letra)){
            encontradas++;
            }
        }
        
        return encontradas;
    }
    
    
    //dice si el contacto tiene un telefono que empieza por el numero dado
    public boolean existeTelefonoIniciaCon(String prefijo){
        boolean existe = false;
        for (int i = 0; i<telefonos.size() && !existe; i++){
             if (telefonos.get(i).startsWith(prefijo)){
                existe = true;
                }
        }
        
        return existe;
    }
    
    
    //da la primera palabra que tiene la terminacion dada
    public String darPalabraTerminaCon(String cadena){
        boolean encontrada=false;
        String pal = null;
        for (int i = 0; i<palClaves.size() && !encontrada;i++){
            if (palClaves.get(i).endsWith(cadena)){
                encontrada = true;
                pal = palClaves.get(i);
            }
           
        }
        
        return pal;
    }
    
    
    //cuenta el nuemro de palabras clave que son prefijo de otras palabras clave
    public int totalPalabrasPrefijo(){
        int numero= 0;
        for (int i = 0; i<palClaves.size();i++){
                for (int j =1; j<palClaves.size();j++){
                    if(palClaves.get(j).startsWith(palClaves.get(i))){
                    numero++;
                    }
                
                }
        
        }
        
        return numero;
    }
    
    
    
    
}
