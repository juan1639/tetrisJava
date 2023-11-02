package tetrisPack;

import java.awt.Color;
import java.awt.Graphics;

// ====================================================================
public class Fondo {

	private int columna;
	private int fila;
	private int ancho;
	private int alto;
	private Boolean valor;

	// --------------------------------------------------------
	public Fondo(int columna, int fila, int ancho, int alto) {

		this.columna = columna;
		this.fila = fila;
		this.ancho = ancho;
		this.alto = alto;
		this.valor = false;
	}

	public void dibuja(Graphics g) {

		Color fondoNada = new Color(70, 62, 4);
		Color fondoRastroPieza = new Color(128, 128, 128);

		int x = this.columna * this.ancho;
		int y = this.fila * this.alto;

		if (this.valor) {

			g.setColor(fondoRastroPieza);
            g.fillRect(x, y, this.ancho, this.alto);

		} else {

			g.setColor(fondoNada);
            g.fillRect(x, y, this.ancho, this.alto);
		}
	}

	// Getters & Setters ----------------------
	public int getColumna() {
		return this.columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getFila() {
		return this.fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public Boolean isValor() {
		return this.valor;
	}

	public void setValor(Boolean valor) {
		this.valor = valor;
	}
}
