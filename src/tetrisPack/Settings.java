package tetrisPack;

// ========================================================================
public class Settings {

	// ----------------------------------------------------
	// Constantes
	// ----------------------------------------------------
    public final int FPS = 60;

    public final int tileX = 30;
	public final int tileY = 30;
	public final int columnas = 14;
	public final int filas = 20;

	public final int resX = (columnas * tileX) * 2;
    public final int resY = 620;

    public final int xInicial = 7;
	public final int yInicial = 2;
	public final int xNext = 19;
	public final int yNext = 16;
	public final String piezas = "zsljoit";

	public final int tiempo_infoLineas = 2000;

	// ----------------------------------------------------
	// Variables
	// ----------------------------------------------------
	private int[] gravedad = {
		45, 30, 25, 23, 20, 18, 16, 15, 12, 10,
		10, 8, 7, 5, 5, 3, 3, 3, 2, 2, 1
	};

	private int[][] goal_lines = {
		{0, 3}, {0, 7}, {0, 12},
		{0, 15}, {0, 20}, {0, 24},
		{0, 32}, {0, 35}, {0, 40},
		{0, 44}, {0, 47}, {0, 50},
		{0, 55}, {0, 60}, {0, 70},
		{0, 75}, {0, 80}, {0, 85},
		{0, 90}, {0, 95}, {0, 100}

	};

	private int incremento_dificultad;
	private Boolean checkeando_matriz;
	private int next_pieza;
	private Boolean otraPieza = true;

	private int lineas;
	private int nivel;
	private int hiScore;

	private int pausa_rejugar;

	public Fondo[][] tileFondo = new Fondo[filas][columnas];

	public Controles controles;
	public Estado estado;

	// -------------------------------------------
    public Settings() {

    	this.gravedad = gravedad;
    	this.goal_lines = goal_lines;
    	this.incremento_dificultad = 0;
    	this.checkeando_matriz = false;
    	this.otraPieza = true;
    	this.next_pieza = 6;
    	this.lineas = 0;
    	this.nivel = 1;
    	this.hiScore = 27;
    	this.pausa_rejugar = 99;
    	this.controles = new Controles();
    	this.estado = new Estado();
    }

    // Getters & Setters -------------------------
    public int[] getGravedad() {
		return this.gravedad;
	}

	public void setGravedad(int[] gravedad) {
		this.gravedad = gravedad;
	}

	public int[][] getGoal_lines() {
		return this.goal_lines;
	}

	public void setGoal_lines(int[][] goal_lines) {
		this.goal_lines = goal_lines;
	}

	public int getIncremento_dificultad() {
		return this.incremento_dificultad;
	}

	public void setIncremento_dificultad(int incremento_dificultad) {
		this.incremento_dificultad = incremento_dificultad;
	}

	public Boolean isCheckeando_matriz() {
		return this.checkeando_matriz;
	}

	public void setCheckeando_matriz(Boolean checkeando_matriz) {
		this.checkeando_matriz = checkeando_matriz;
	}

	public Boolean isOtraPieza() {
		return this.otraPieza;
	}

	public void setOtraPieza(Boolean otraPieza) {
		this.otraPieza = otraPieza;
	}

	public int getNext_pieza() {
		return this.next_pieza;
	}

	public void setNext_pieza(int next_pieza) {
		this.next_pieza = next_pieza;
	}

	public int getLineas() {
		return this.lineas;
	}

	public void setLineas(int lineas) {
		this.lineas = lineas;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getHiScore() {
		return this.hiScore;
	}

	public void setHiScore(int hiScore) {
		this.hiScore = hiScore;
	}

	public int getPausa_rejugar() {
		return this.pausa_rejugar;
	}

	public void setPausa_rejugar(int pausa_rejugar) {
		this.pausa_rejugar = pausa_rejugar;
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

    // ========================================================
    public class Estado {

    	private Boolean menuPrincipal, enJuego, entreNiveles, gameOver;

    	public Estado() {
    		this.menuPrincipal = false;
    		this.enJuego = true;
    		this.entreNiveles = false;
    		this.gameOver = false;
    	}

    	// Getters & Setters ---------------------------------
		public boolean isMenuPrincipal() {
			return this.menuPrincipal;
		}

		public void setMenuPrincipal(boolean menuPrincipal) {
			this.menuPrincipal = menuPrincipal;
		}

		public boolean isEnJuego() {
			return this.enJuego;
		}

		public void setEnJuego(boolean enJuego) {
			this.enJuego = enJuego;
		}

		public boolean isEntreNiveles() {
			return this.entreNiveles;
		}

		public void setEntreNiveles(boolean entreNiveles) {
			this.entreNiveles = entreNiveles;
		}

		public boolean isGameOver() {
			return this.gameOver;
		}

		public void setGameOver(boolean gameOver) {
			this.gameOver = gameOver;
		}
	}
}
