/**
 * 
 */

/**
 * @author Felipe
 * 
 */
public class Jugador {

	String nombre;

	Casilla posicion;

	int puntos1;

	int puntos2;

	int puntos3;

	int puntos4;

	public Jugador(String nombre) {

		this.nombre = nombre;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the posicion
	 */
	public Casilla getPosicion() {
		return posicion;
	}

	/**
	 * @return the puntos
	 */
	public int getPuntos1() {
		return puntos1;
	}

	public int getPuntos2() {
		return puntos2;
	}

	public int getPuntos3() {
		return puntos3;
	}

	public int getPuntos4() {
		return puntos4;
	}

	public void sumarPunto1() {
		puntos1 += 1;

	}

	public void sumarPunto2() {
		puntos2 += 1;

	}

	public void sumarPunto3() {
		puntos3 += 1;

	}

	public void sumarPunto4() {
		puntos4 += 1;

	}

	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(Casilla posicion) {
		this.posicion = posicion;
		posicion.setText(nombre);
	}

}
