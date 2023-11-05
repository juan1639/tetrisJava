package tetrisPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

// ====================================================================
public class Marcadores {

	private static int[] colorAreaMarcadores = {115, 103, 9, 180, 150, 15}; 

	private int[] argsInt;
	private String[] argsTxt;
	private Color color;

	// --------------------------------------------------------------
	public Marcadores(int[] argsInt, String[] argsTxt, Color color) {

		this.argsInt = argsInt;
		this.argsTxt = argsTxt;
		this.color = color;
	}

	public void dibuja(Graphics g, int valor, JPanel panel) {

		int size = this.argsInt[0];
		int resX = this.argsInt[1];
		int resY = this.argsInt[2];

		String msg = this.argsTxt[0] + valor;
		String idTxt = this.argsTxt[1];

		Font fuente = new Font("Helvetica", Font.BOLD, size);
		FontMetrics metr = panel.getFontMetrics(fuente);

		g.setFont(fuente);
		g.setColor(this.color);
		g.drawString(msg, resX, resY);
	}

	public static void area_marcadores(Graphics g, int[] argsCoord) {

		int margenAreaX = (int) (argsCoord[2] / 70);
		int margenAreaY = (int) (argsCoord[3] / 40);

		int x = argsCoord[0] + margenAreaX;
		int y = argsCoord[1] + margenAreaY;
		int ancho = (int) (argsCoord[2] / 2 - margenAreaX * 2);
		int alto = (int) (argsCoord[3] / 1.9);

		int[] rgb = colorAreaMarcadores;

		g.setColor(new Color(rgb[0], rgb[1], rgb[2]));
		g.fillRoundRect(x, y, ancho, alto, 16, 16);
		g.setColor(new Color(rgb[3], rgb[4], rgb[5]));
		g.drawRoundRect(x, y, ancho, alto, 16, 16);
	}
}
