
/**
 * Informacion del avion: sillas ejecutivas y economicas.
 * 
 * @author (villalobos y casallas) 
 * @version 0.1
 */
public class Avion
{
    // Constantes
    public final static int NUM_SILLAS_EJECUTIVAS = 8;
    public final static int NUM_SILLAS_ECONOMICAS = 42;
    
    // Atributos
    private Silla[] sillasEjecutivas;
    private Silla[] sillasEconomicas;
    
    int ocupadasEjec;
    /**
     * Constructor for objects of class Avion
     */
    public Avion()
    {
        ocupadasEjec=0;
        
        sillasEjecutivas = new Silla [NUM_SILLAS_EJECUTIVAS];
        sillasEconomicas = new Silla [NUM_SILLAS_ECONOMICAS];
        
        // creacion de las sillas ejecutivas
        int ubicacionEj;
        for (int numEj=1, indice=0; indice<NUM_SILLAS_EJECUTIVAS;numEj++,indice++){
            if(numEj%4==1 || numEj%4==0)
                ubicacionEj = Silla.VENTANA;
            else
                ubicacionEj = Silla.PASILLO;
                
            sillasEjecutivas[indice] = new Silla(numEj, Silla.CLASE_EJECUTIVA, ubicacionEj);
        }
        // sillas economicas
       int ubicacionEc;
        for (int sillaEc=9, numEc=1 ; numEc<NUM_SILLAS_ECONOMICAS; sillaEc++,numEc++ ){
            if( numEc%6 == 1 || numEc%6 == 0 )
               ubicacionEc = Silla.VENTANA;
            else if( numEc%6 == 2 || numEc%6 == 5 )
                ubicacionEc = Silla.CENTRAL;
            else
                ubicacionEc = Silla.PASILLO;
            sillasEconomicas[numEc-1] = new Silla(sillaEc, Silla.CLASE_ECONOMICA, ubicacionEc );
        }   // modelo de construccion sillas economicas tomado del cd del libro de Villalobos y casallas
       
    }

    public Silla getSillaEjecutiva(int numeroSilla) {
        for (int i = 0; i < sillasEjecutivas.length; i++) {
            if (sillasEjecutivas[i].getNumero() == numeroSilla) {
                return sillasEjecutivas[i];   
            }
        }
        return null;
    }
    
    
                                        //para contar las sillas ejecutivas ocupadas
    public int contarSillasEjecutivasOcupadas(){
        for (int i=0; i <sillasEjecutivas.length; i++){
            if (sillasEjecutivas[i].getPasajero() != null){
                ocupadasEjec ++;
            }
        }
    return ocupadasEjec;
    }  
    
    
                                        //buscar pasajero en clase ejecutiva con la cedula
    public Silla buscarPasajeroEjecutivo(int cedula){
        for (int i = 0; i<sillasEjecutivas.length; i++){
            if(sillasEjecutivas[i].getPasajero().getCedula()==cedula){
                return sillasEjecutivas[i];
            }
        }
    return null;
    }
    
                                   //ver si una silla en clase economica está libre
       boolean encontrada= false;
       Silla silla;
       public Silla buscarSillaEconomicaLibre(int ubicacion){
        for (int i=0; i<NUM_SILLAS_ECONOMICAS && !encontrada; i++){
            if (sillasEconomicas[i].getUbicacion() == ubicacion){
                if (sillasEconomicas[i].sillaAsignada() == false){
                    encontrada = true;
                    silla = sillasEconomicas[i];
                }
            }    
        }
        if (encontrada==true)
            return silla;
        else
            return null;
        
        }

    
                                         //asignar una silla economica a un pasajero
                                         //true para decir que queda asiganada y false para decir que no queda asignada
        public boolean asignarSillaEconomica(int ubicacion, Pasajero pasajero){
        Silla silla=null;    
        silla = buscarSillaEconomicaLibre(ubicacion);
            if(silla.sillaAsignada() == false){
                silla.asignarPasajero(pasajero);
                return true;
            }else{
                return false;
            }
        }


                                    //anular reserva en clase ejecutiva
        public boolean anularReservaEjecutivo(int cedula){
        boolean desasignada=false;
            for(int i=0;i<NUM_SILLAS_EJECUTIVAS && !desasignada; i++){
                if(sillasEjecutivas[i].getPasajero().getCedula() == cedula){
                    sillasEjecutivas[i].desasignarSilla();
                    desasignada = true;
                }
            }
            if (desasignada == true)
                return true;
            else
                return false;
        }
        
                                //cuenta el numero de ventanas economicas desocupadas
        public int contarVentanasEconomicas(){
            int contadas = 0;
            for (int i=0;i<NUM_SILLAS_ECONOMICAS; i++){
             if(sillasEconomicas[i].getUbicacion() == 1 && sillasEconomicas[i].sillaAsignada() == false){
                 contadas++;
             }
            }
            return contadas;
        }
        
        //dice si hay dos personas con el mismo nombre en clase economica
        public Boolean hayDosHomonimosEconomica(){
        String pasajero1=null;
        boolean siHay=false;
            for (int i= 0 ; i<NUM_SILLAS_ECONOMICAS && !siHay; i++){
                pasajero1 = sillasEconomicas[i].getPasajero().getNombre();
                for (int j= 1 ; j<NUM_SILLAS_ECONOMICAS && !siHay; j++){
                    if (sillasEconomicas[j].getPasajero().getNombre().equals(pasajero1))
                        siHay=true;
                }
            
            }
          return true;  
        }



} //final
