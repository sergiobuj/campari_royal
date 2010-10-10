
public class Jugador {
	
	int dinero=0;
	String Nombre;

	
	public Jugador(int dinero,String nombre){
		this.Nombre=nombre;
		this.dinero=dinero;
				
	}


	/**
	 * @return the dinero
	 */
	public int getDinero() {
		return dinero;
	}


	/**
	 * @param dinero the dinero to set
	 */
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}
	
}
