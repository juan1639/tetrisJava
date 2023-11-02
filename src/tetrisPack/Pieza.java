package tetrisPack;

import java.awt.Color;
import java.awt.Graphics;

// ===============================================================
public class Pieza {

	private int x;
	private int y;
	private int[][] idPieza;
	private int columnas;
	private int filas;
	private int rotacion;

	// ---------------------------------------------
	public Pieza(int x, int y, int[][] idPieza, int col, int filas) {

		this.x = x;
		this.y = y;
		this.idPieza = idPieza;
		this.columnas = col;
		this.filas = filas;
		this.rotacion = 0;
	}

	public void dibuja(Graphics g, int ancho, int alto) {

		int rotacion_idPieza = this.rotacion * 4;
		int fin = rotacion_idPieza + 4;

		for (int i = rotacion_idPieza; i < fin; i ++) {

			int x = (this.x + this.idPieza[i][0]) * ancho;
			int y = (this.y + this.idPieza[i][1]) * alto;

			g.setColor(Color.white);
            g.drawRect(x, y, ancho, alto);
		}
	}

	public void actualiza(Settings sett) {

		if (!sett.estado.isEnJuego()) {
			return;
		}

		if (sett.controles.isIzquierda()) {

			this.x --;
			if (check_colision()) {
				this.x ++;
			}

			sett.controles.setIzquierda(false);

		// -------------------------------------------------
		} else if (sett.controles.isDerecha()) {

			this.x ++;
			if (check_colision()) {
				this.x --;
			}

			sett.controles.setDerecha(false);

		// -------------------------------------------------
		} else if (sett.controles.isAbajo()) {

			this.y ++;
			if (check_colision()) {
				this.y --;
			}

			sett.controles.setAbajo(false);

		// -------------------------------------------------
		} else if (sett.controles.isRotar()) {

			int bck_rotacion = this.rotacion;
			this.rotacion ++;

			if (this.rotacion >= 4) {
				this.rotacion = 0;
			}

			if (check_colision()) {
				this.rotacion = bck_rotacion;
			}

			//System.out.println("Rot:" + this.rotacion);
			sett.controles.setRotar(false);
		}
	}

	public Boolean check_colision() {

		int rotacion_idPieza = this.rotacion * 4;
		int fin = rotacion_idPieza + 4;

		for (int i = rotacion_idPieza; i < fin; i ++) {

			int colX = this.x + this.idPieza[i][0];
			int colY = this.y + this.idPieza[i][1];

			if (colX > this.columnas - 1 || colX < 0) {
				return true;
			}

			if (colY > this.filas - 1 || colY < 0) {
				return true;
			}
		}

		return false;
	}

	// Getters & Setters ----------------------
	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int[][] getIdPieza() {
		return this.idPieza;
	}

	public void setIdPieza(int[][] idPieza) {
		this.idPieza = idPieza;
	}

	public int getRotacion() {
		return this.rotacion;
	}

	public void setRotacion(int rotacion) {
		this.rotacion = rotacion;
	}
}