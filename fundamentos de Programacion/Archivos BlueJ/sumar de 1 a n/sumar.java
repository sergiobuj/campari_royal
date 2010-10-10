
public class sumar
{
    private int n;
    private int acum;
    private int cont;

    public sumar()
    {
        cont=0;
        acum=0;
    }
    public void sumatoriaSerie(int n)
    { 
        while (cont<n){
            cont=cont+1;
            acum=acum+cont;
        }
        System.out.println("El resultado de esta suma es "+acum);
    }
}