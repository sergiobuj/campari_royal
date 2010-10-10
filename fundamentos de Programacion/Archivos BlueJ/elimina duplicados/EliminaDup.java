import java.util.ArrayList;
public class EliminaDup{

    private ArrayList<Integer> arreglo;

  public EliminaDup(Integer a, Integer b, Integer c, Integer d,Integer e){
    arreglo.add(a);
    arreglo.add(b);
    arreglo.add(c);
    arreglo.add(d);
    arreglo.add(e);
    }
  
  
  public ArrayList eliminaDuplicados(){
      for(int i=0; i<arreglo.size();i++){
        Integer numero1=arreglo.get(i);
        for(int j =1;j<arreglo.size();j++){
            Integer numero2=arreglo.get(j);
            if(numero1==numero2){
                arreglo.remove(j);
            } 
        
        }
    
    
    }
      
      
    return arreglo;
    }
}