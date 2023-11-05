package tetrisPack;

import java.awt.Color;
import java.awt.Graphics;

// ======================================================================
public class Nextpieza {

	private int[] colorAreaNextPieza = {115, 103, 9, 220, 200, 15};

	private int x;
	private int y;
	private int[][] idPieza;
	private int[] colorPieza;

	// ------------------------------------------------------------
	public Nextpieza(int x, int y, int[][] idPieza, int[] colorPieza) {

		this.x = x;
		this.y = y;
		this.idPieza = idPieza;
		this.colorPieza = colorPieza;
	}

	public void dibuja(Graphics g, int ancho, int alto) {

		area_nextPieza(g, ancho, alto);

		int[] rgb = this.colorPieza;

		int rotacion_idPieza = 0;
		int fin = rotacion_idPieza + 4;

		for (int i = rotacion_idPieza; i < fin; i ++) {

			int x = (this.x + this.idPieza[i][0]) * ancho;
			int y = (this.y + this.idPieza[i][1]) * alto;

			//g.setColor(new Color(rgb[3], rgb[4], rgb[5]));
			//g.fillRect(x, y, ancho, alto);

			g.setColor(new Color(rgb[0], rgb[1], rgb[2]));
            int[] polX = {x, x + 30, x + 30, x};
            int[] polY = {y, y, y + 30, y};
            g.fillPolygon(polX, polY, 3);

            g.setColor(new Color(rgb[3], rgb[4], rgb[5]));
            //g.fillRect(x, y, ancho, alto);
            int[] polX2 = {x, x, x + 30, x};
            int[] polY2 = {y, y + 30, y + 30, y};
            g.fillPolygon(polX2, polY2, 3);
		}
	}

	public void area_nextPieza(Graphics g, int ancho, int alto) {

		int x = (this.x - 2) * ancho;
		int y = (this.y - 3) * alto;
		int areaAncho = ancho * 6;
		int areaAlto = alto * 7;

		int[] rgb = colorAreaNextPieza;

		g.setColor(new Color(rgb[0], rgb[1], rgb[2]));
		g.fillRoundRect(x, y, areaAncho, areaAlto, 16, 16);
		g.setColor(new Color(rgb[3], rgb[4], rgb[5]));
		g.drawRoundRect(x, y, areaAncho, areaAlto, 16, 16);
	}
}
