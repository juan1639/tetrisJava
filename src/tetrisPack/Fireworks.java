package tetrisPack;

import java.awt.Color;
import java.awt.Graphics;

// ======================================================================
public class Fireworks {

	private double x;
	private double y;
	private double velX;
	private double velY;

	// ------------------------------------------------------------
	public Fireworks(double x, double y, double velX, double velY) {

		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
	}

	public void dibuja(Graphics g) {

		int rgb = (int) (Math.random() * 200);
		rgb += 55;

		this.x += this.velX;
		this.y += this.velY;

		g.setColor(new Color(255, rgb, 0));
		g.fillRect((int) (this.x), (int) (this.y), 2, 2);
	}
}
