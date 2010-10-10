public class divisor   
{
    private int x;
    private int y;
    private int w;
    private int z;

    public divisor()
    {
        w = 0;
        x = 0;
        y = 0;
        z = 0;        
    }
    public String divisible(int x,int y)
    {
         w=x/y;
         z=x-w*y;
                if (z==0){
                    return "true";
                }else{
                    return "false";
                }
                    
        }}
        
        
