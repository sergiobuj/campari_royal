import java.lang.Math.*;

public class FuncionSin{
 

   public FuncionSin(){
    }
 
    
    public int calcSigno(int n){
        int signo = -1;
        for(int i = 0;i<=n;i++){
            signo*=-1;
        }
        return signo;
    }
 
    
    public int calcFactorial(int n){
        int resultado=1;
        for(int i = n;i>=1;i--){
            resultado *= i;
        }
        return resultado;
    }
 
    
    public double calcPotencia(double base, int n){
        double resultado = base;
        for(int i = 1; i <n; i++){
            resultado *= base;
        }
        return resultado;
    }

    
    public double calcTermino(double x, int n){
    double termino = (calcSigno(n-1))*((calcPotencia(x,(2*n)-1))/(calcFactorial((2*n)-1)));
    return termino;
    }
 
    
    public double calcSen(double x){

        
        
        return 0.0;
    }

    
    public double darSenoJava(double angulo){
    double respuesta = Math.sin(angulo);
    return respuesta;
    }
}