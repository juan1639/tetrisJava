package tetrisPack;

import java.awt.Color;
import java.awt.Graphics;

// ===============================================================
public class Pieza {

	private int x;
	private int y;
	private int[][] idPieza;
	private int rotacion;

	// ---------------------------------------------
	public Pieza(int x, int y, int[][] idPieza) {

		this.x = x;
		this.y = y;
		this.idPieza = idPieza;
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

		if (sett.controles.isRotar()) {

			int bck_rotacion = this.rotacion;
			this.rotacion ++;

			if (this.rotacion >= 4) {
				this.rotacion = 0;
			}

			System.out.println("Rot:" + this.rotacion);

			sett.controles.setRotar(false);
		}
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
