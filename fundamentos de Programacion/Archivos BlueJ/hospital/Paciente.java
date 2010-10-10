
public class Paciente
{

    String nombre;
    String ID;
    String codigoDolencia;
    int tipoConsulta;
    
    
    
    public Paciente(String elNombre, String laID, String elCod, int elTipoConsulta)
    {
        nombre = elNombre;
        ID = laID;
        codigoDolencia = elCod;
        tipoConsulta = elTipoConsulta;
    }

    
    
    public String darNombre(){
    return nombre;
    }
    
    //cambiar si es urgencias o normal
    public void cambiaTipo(int nuevoTipo){
    tipoConsulta = nuevoTipo;
    }
    
    //da la ID del paciente
    public String daLaID(){
    return ID;
    }
    
    
    
}//final
