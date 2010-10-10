public class Rigo {
	int posFila,posCol;

	//1:arriba	2:derecha	3:abajo		4:izquierda
	int direccion;

	public int tesoros;

	Rigo(int fila,int columna, int direccion) {
		this.tesoros = 0;
		this.posFila=fila;
		this.posCol= columna;
		this.direccion = direccion;

	}

	/**
	 * @return the direccion
	 */
	public int getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}



	/**
	 * @return the posCol
	 */
	public int getPosCol() {
		return posCol;
	}

	/**
	 * @param posCol the posCol to set
	 */
	public void setPosCol(int posCol) {
		this.posCol = posCol;
	}

	/**
	 * @return the posFila
	 */
	public int getPosFila() {
		return posFila;
	}

	/**
	 * @param posFila the posFila to set
	 */
	public void setPosFila(int posFila) {
		this.posFila = posFila;
	}

	/**
	 * @return the tesoros
	 */
	public int getTesoros() {
		return tesoros;
	}

	/**
	 * @param tesoros the tesoros to set
	 */
	public void sumaTesoros() {
		this.tesoros = tesoros + 1;
	}
	
	
	
	/**
	 * @param tesoros the tesoros to set
	 */
	public void quitaTesoros() {
		this.tesoros = tesoros - 1;
	}
	
	
	
	
	
	

}
