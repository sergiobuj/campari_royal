
public class divisores extends divisor 
{
    private int cont;
    private int n;
    private String espar;
    public divisores()
    {
        cont=1;
        n = 0;
    }
    public void sampleMethod(int n)
    {
        while (cont < n){
           espar= divisible(n,cont);
                if ( espar == "true"){
                    System.out.println ( cont );
                }
            cont = cont +1;    
        }
      System.out.println ( n );
    }
}