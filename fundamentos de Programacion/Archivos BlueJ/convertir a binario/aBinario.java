public class aBinario
{   private long x;
    private long p;
    private long r;
    private long b;
    private long f;
   
    public aBinario()
    {
    p=1;
    r=0;
    b=0;
    }
    public void sacarBinario(long x)
    {
        f=x;
        while (x>0){
            r=x%2;
            x=x/2;
            r=r*p;
            p=p*10;
            b=b+r;
        
        }
        System.out.println (f+" es "+b+" en binario");    

    }

}