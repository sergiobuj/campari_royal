import java.util.StringTokenizer;
import java.util.Vector;

public class Sintaxis {

	private String bloque;
	private Vector <Vector<String>>lineas;
	private String mensaje;
	private int cont;

	public Sintaxis(String todo){
		this.bloque=todo;
		cont=0;
		lineas = new Vector (0,1);
		descomponerBloque();
	}
	public void descomponerBloque()
	{
		StringTokenizer st =new StringTokenizer(this.bloque,"\n");
		while(st.hasMoreTokens())
		{
			Vector linea=new Vector (0,1);
			linea.add((st.nextToken().trim()));
			lineas.add((descomponerLinea(linea)));	            
		}
	}

	public Vector<String> descomponerLinea(Vector<String> linea)
	{
		Vector descomp=new Vector(0,1);
		String linea2 = linea.toString();
		StringTokenizer st =new StringTokenizer(linea2," ,()[]\n");
		while(st.hasMoreTokens())
		{
			descomp.add(st.nextToken());
		}
		return descomp;
	}
	public boolean esPrograma()
    {
        if(lineas.size()!=0){
            if(lineas.get(cont).get(0).toString().equals("InicioPrograma")){
            	cont++;
               if(esBloque()){
                	if (lineas.get(lineas.size()-1).get(0).equals("FinPrograma")){
                		return true;                		
            		}/*else{
            			mensaje="El programa debe finalizar con la palabra: FinPrograma";
                     }*/
            	}
        	}else{
        		cont++;
        		if(lineas.get(cont-1).get(0).toString().equals("//")&&esPrograma()){
        			return true;
        		}
        		//mensaje="El programa debe iniciar con la palabra: InicioPrograma";
        	 }
        
        }else
            mensaje="No se encontro ningun programa";        
        return false;
    }
	
	public boolean esBloque(){
		if(esSentencia() || (esSentencia() && esBloque())){
			return true;
		}
		return false;
	}
	
	public boolean esSentencia(){
		if(esEstructuraControl() || esPrimitiva(lineas.get(cont).get(0).toString())){
			return true;
		}
		return false;
	}
	
	public boolean esEstructuraControl(){
		if(esSiCondicional() || esCiclo()){
			return true;
		}
		return false;
	}
	
	public boolean esSiCondicional(){
		if(lineas.get(cont).get(0).toString().equals("Si")){
			if(esCondicion(lineas.get(cont).get(1).toString())){
				cont++;
				if(esBloque()){
					if(lineas.get(cont).get(lineas.get(cont).size()-1).toString().equals("FinSi")){
						cont++;
						return true;
					}
				}
			}
			
		}
		return false;
	}
	
	public boolean esCondicion(String condicion){
		if(esBooleano(condicion)||esNoBooleano(condicion)){
			return true;
		}
		return false;
	}
	
	public boolean esBooleano(String condicion){
		if(condicion.equalsIgnoreCase("HayPared") || condicion.equalsIgnoreCase("HayAbismo") || condicion.equalsIgnoreCase("HayTesoro") ||
			condicion.equalsIgnoreCase("TieneTesoro") || condicion.equalsIgnoreCase("MiraNorte") || condicion.equalsIgnoreCase("MiraSur") ||
			condicion.equalsIgnoreCase("MiraEste") || condicion.equalsIgnoreCase("MiraOeste") ) return true;
		return false;
	}
	
	public boolean esNoBooleano(String condicion){
		if(condicion.equalsIgnoreCase("NoHayPared") || condicion.equalsIgnoreCase("NoHayAbismo") || condicion.equalsIgnoreCase("NoHayTesoro") ||
			condicion.equalsIgnoreCase("NoTieneTesoro") || condicion.equalsIgnoreCase("NoMiraNorte") || condicion.equalsIgnoreCase("NoMiraSur") ||
			condicion.equalsIgnoreCase("NoMiraEste") || condicion.equalsIgnoreCase("NoMiraOeste") ) return true;
		return false;
	}
	
	public boolean esCiclo(){
		if(lineas.get(cont).get(0).toString().equals("Mientras")){
			if(esCondicion(lineas.get(cont).get(1).toString())){
				cont++;
				if(esBloque()){
					if(lineas.get(cont).get(lineas.get(cont).size()-1).toString().equals("FinMientras")){
						cont++;
						return true;
					}
				}
			}
			
		}
		return false;
	}
	
	public boolean esPrimitiva(String primitiva){
		if(primitiva.equalsIgnoreCase("Avance") || primitiva.equalsIgnoreCase("Gire") || primitiva.equalsIgnoreCase("TomeTesoro") ||
			primitiva.equalsIgnoreCase("DejeTesoro") || primitiva.equalsIgnoreCase("Termine")){
			cont++;
			return true;
		}
		return false;
	}
	/**
	 * @param args
	 */
	public String supercompi(String ab) {
		String respuesta="";
		//String todo = "InicioPrograma"+"\n"+"Mientras (NoHayAbismo)"+"\n"+"Mientras (HayTesoro)"+"\n"+"TomeTesoro"+"\n"+"FinMientras"+"\n"+"Avance"
		//+"\n"+"FinMientras"+"\n"+"Mientras (TieneTesoro)"+"\n"+"DejeTesoro"+"\n"+"FinMientras"+"\n"+"FinPrograma";
		Sintaxis paco = new Sintaxis(ab);
		boolean es = paco.esPrograma();
		if(es == true){
			respuesta="El código se puede ejecutar.";
		
		}else{
			respuesta="El código tiene errores.";
	}

	return respuesta;
}

}
