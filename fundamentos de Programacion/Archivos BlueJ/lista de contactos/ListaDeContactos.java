import java.util.ArrayList;
public class ListaDeContactos{

    private ArrayList<Contacto> lista;



    public ListaDeContactos(){
       lista = new ArrayList();
       
    }

    
    
    //agregar un contacto
    public void agregarContacto(Contacto contacto){
    lista.add(contacto);
    }
    
    
    
    //eliminar un contacto
    
    //contar el numero de contactos con el mismo nombre dado
    public int totalContactosConNombre(String nombre){
       int numero=0;
       for(int i = 0; i<lista.size();i++){
            if(lista.get(i).darNombre().equalsIgnoreCase(nombre)){
            
            }    
        
       } 
        
        return 0;
    }
    
    
    //decir si hay una direccion de correo repetida
    public boolean correoRepetido(){
        boolean correoRep = false;
        for (int i = 0; i<lista.size()&&!correoRep; i++){
            String correo1 = lista.get(i).darCorreo();
            
            for(int j=1; j<lista.size()&&!correoRep; j++){
                if (correo1 == lista.get(j).darCorreo()){
                       correoRep=true;
                }
            
            }
        }
    
        return correoRep;
    }    
    
    
    //dice cual es el contacto con mas palabras clave
    public Contacto contactoConMasPalabras(){
        int contacto=0; 
        int masPalabras = lista.get(0).darNumPalabras();
        for(int i=0; i<lista.size();i++){
                if(lista.get(i).darNumPalabras()>masPalabras){
                    masPalabras=lista.get(i).darNumPalabras();
                    contacto = i;
                }
            
        
        }
        
     return lista.get(contacto);
    }
    
    

}