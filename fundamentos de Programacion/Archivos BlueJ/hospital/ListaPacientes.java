import java.util.ArrayList;
public class ListaPacientes
{
    private ArrayList<Paciente> urgencias;
    private ArrayList<Paciente> normal;
    public ListaPacientes(){
        urgencias = new ArrayList();
        normal = new ArrayList();
    }

    //agregar un paciente a urgencias o a normal
    public void agregarPaciente(Paciente paciente){
    if (paciente.tipoConsulta == 1){
        urgencias.add(paciente);
    }else{
        normal.add(paciente);
    
    }

    }
    
    
    //quitar un paciente de urgencias
    public void sacarDeUrgencias(Paciente paciente){
    int i;
    boolean encontradaPos = false;
        for ( i =0; i<urgencias.size() && !encontradaPos;i++){
            if (urgencias.get(i).equals(paciente)){
                encontradaPos=true;
                
            }
        }
        
        urgencias.remove(i);
    }
    
    
    
    //dar de alta un paciente
    public void darDeAlta(Paciente paciente){
        sacarDeUrgencias(paciente);
        paciente.cambiaTipo(2);
        agregarPaciente(paciente);
           
    }
    
    //ver si está registrado
    public boolean registrado(String identificacion){
    boolean encontrado = false;
        for (int i=0; !encontrado && i<urgencias.size();i++){
            for (int j=0; !encontrado && j<normal.size();j++){
                if(normal.get(j).daLaID().equals(identificacion)){
                    encontrado= true;
                }
            }            
            if(urgencias.get(i).daLaID().equals(identificacion)){
            encontrado= true;
            }
         }
    
    return encontrado;
    }
    
    
    
    
}
