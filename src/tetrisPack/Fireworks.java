package tetrisPack;

import java.awt.Color;
import java.awt.Graphics;

// ======================================================================
public class Fireworks {

	private double x;
	private double y;
	private double velX;
	private double velY;
	private int duracion;

	// ------------------------------------------------------------
	public Fireworks(double x, double y, double velX, double velY) {

		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
		this.duracion = 30;
	}

	public void dibuja(Graphics g, Settings sett) {

		if (this.duracion > 0) {

			this.duracion --;

			if (this.duracion == 0 && sett.estado.isEntreNiveles()) {
				sett.setFireWorks(true);
			}

			int rgb = (int) (Math.random() * 200);
			rgb += 55;

			this.x += this.velX;
			this.y += this.velY;

			int size = (int) ((46 - this.duracion) / 15);

			g.setColor(new Color(255, rgb, 0));
			g.fillRect((int) (this.x), (int) (this.y), size, size);
		}
	}
}
