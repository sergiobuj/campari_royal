
/**
 * Silla del avion.
 * 
 * @author (Helmuth Trefftz 
 * @version 0.1
 */
public class Silla
{
    public final static int CLASE_EJECUTIVA = 1;
    public final static int CLASE_ECONOMICA = 2;
    public final static int VENTANA = 1;
    public final static int CENTRAL = 2;
    public final static int PASILLO = 3;
    
    private int numero;
    private int clase;
    private int ubicacion;
    private Pasajero pasajero;

    /**
     * Constructor for objects of class Silla
     */
    public Silla(int numero, int clase, int ubicacion)
    {
        this.numero = numero;
        this.clase = clase;
        this.ubicacion = ubicacion;
        pasajero = null;
    }

    /**
     * Asignarle un pasajero a la silla
     * 
     * @param  pasajero referencia al pasajero asignado 
     */
    public void asignarPasajero(Pasajero pasajero)
    {
        this.pasajero = pasajero;
    }
  
                                            //para dar el numero de la silla.
    public int getNumero() {
        return numero;   
    }

    
                                            //para desasignar esta silla.
    public void desasignarSilla(){
        pasajero = null;
    }

                                            // para saber si la silla está asignada.
    public boolean sillaAsignada(){
      if (pasajero != null){
        return true;
      }  
       return false;
    }

                                            //para dar la clase
    public int getClase(){
        return clase;
    }
    
                                            //para entregar la ubicacion de esta silla.
    public int getUbicacion(){
        return ubicacion;
    }
    
    
                                            //para decir quien es el pasajero.
    public Pasajero getPasajero(){
        return pasajero;
    }
    
    
}
