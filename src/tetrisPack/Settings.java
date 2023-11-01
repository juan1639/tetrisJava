package tetrisPack;

// ========================================================================
public class Settings {

	public Controles controles;

	// ------------------------------------------
    public Settings() {

    	this.controles = new Controles();

    }

    // ========================================================
    public class Controles {

    	private Boolean izquierda, derecha, abajo, rotar;

    	public Controles() {
    		this.izquierda = false;
    		this.derecha = false;
    		this.abajo = false;
    		this.rotar = false;
    	}

    	// Getters & Setters ---------------------------------
		public boolean isIzquierda() {
			return this.izquierda;
		}

		public void setIzquierda(boolean izquierda) {
			this.izquierda = izquierda;
		}

		public boolean isDerecha() {
			return this.derecha;
		}

		public void setDerecha(boolean derecha) {
			this.derecha = derecha;
		}

		public boolean isAbajo() {
			return this.abajo;
		}

		public void setAbajo(boolean abajo) {
			this.abajo = abajo;
		}

		public boolean isRotar() {
			return this.rotar;
		}

		public void setRotar(boolean rotar) {
			this.rotar = rotar;
		}
    }
}
