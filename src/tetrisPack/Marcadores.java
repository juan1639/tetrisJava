package tetrisPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

// ====================================================================
public class Marcadores {

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
}
