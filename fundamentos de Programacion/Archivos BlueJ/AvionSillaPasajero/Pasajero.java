
/**
 * Información de un Pasajero.
 * 
 * @author Helmuth Trefftz 
 * @version 0.1
 */
public class Pasajero 
{
    private int cedula;
    private String nombre;

    /**
     * Constructor for objects of class Pasajero
     */
    public Pasajero(int miCedula, String nombre)
    {
        cedula = miCedula;
        this.nombre = nombre;
    }


    public int getCedula(){
        return cedula;
       }
       
    public String getNombre(){
        return nombre;
    }
    
    
}









