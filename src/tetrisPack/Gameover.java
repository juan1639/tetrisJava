package tetrisPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

// ====================================================================
public class Gameover {

	private int[] argsInt;
	private String[] argsTxt;
	private Color color;

	// -------------------------------------------------------------
	public Gameover(int[] argsInt, String[] argsTxt) {

		this.argsInt = argsInt;
		this.argsTxt = argsTxt;
	}

	public void dibuja(Graphics g, JPanel panel) {

		int size = this.argsInt[0];
		int resX = this.argsInt[1];
		int resY = this.argsInt[2];

		int[] rgb = {this.argsInt[3], this.argsInt[4], this.argsInt[5]};

		String msg = this.argsTxt[0];
		String idTxt = this.argsTxt[1];

		Font fuente = new Font("Helvetica", Font.BOLD, size);
		FontMetrics metr = panel.getFontMetrics(fuente);

		g.setFont(fuente);
		g.setColor(new Color(rgb[0], rgb[1], rgb[2]));

		if (idTxt == "gameover") {
			resX /= 2;
		}

		g.drawString(msg, (resX - metr.stringWidth(msg)) / 2, resY / 2);
	}
}
