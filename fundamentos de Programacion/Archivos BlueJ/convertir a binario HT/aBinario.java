public class ABinario
{   private  int num;
    private  int pos;
    private  int residuo;
    private  int bin;
    private  int f;
   
    public ABinario()
    {
    	pos=1;
    	residuo=0;
    	bin=0;
    }
    
    public void sacarBinario(int num)
    {
        f=num;
        while (num>1){
            residuo=num%2;
            num=num/2;
            residuo=residuo*pos;
            pos=pos*10;
            bin=bin+residuo;
        }
        bin = bin + pos;
        System.out.println (f+" es "+bin+" en binario");
    }
    
    public static void main(String [] args) {
    	ABinario aBinario = new ABinario();
    	aBinario.sacarBinario(100);
    }

}