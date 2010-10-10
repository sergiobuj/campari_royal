public class Fibonacci {
    int fibo1 = 1;
    int fibo2 = 1;
    int fibo3 = 3;
    int fibo = 0;
    public Fibonacci() {
    }
    public void sacaFibo(int numeroFibo){
    if(numeroFibo>=2){
        System.out.print(fibo1+", ");
        System.out.print(fibo2);
        for(fibo3= 3;fibo3<=numeroFibo;fibo3++){
            fibo = fibo1+fibo2;
            System.out.print(", "+fibo);
            fibo1=fibo2;
            fibo2=fibo;   
        }
    fibo1 = 1;
    fibo2 = 1;
    fibo3 = 3;
    fibo = 0;
    }
    }
}
