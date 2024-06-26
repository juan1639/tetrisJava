package tetrisPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Gameover {

	private Sonidos sonido;
	
	private int[] argsInt;
	private String[] argsTxt;
	private Color color;
	
	public Gameover(int[] argsInt, String[] argsTxt) {

		this.argsInt = argsInt;
		this.argsTxt = argsTxt;
		
		sonido = new Sonidos();
	}
	
	public void sonido_gameover() {
		
		sonido.cargar_audio("src/gameover.wav");
		sonido.play_sonido();
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

		if (idTxt == "gameover" || idTxt == "tetris") {
			resX /= 2;
		}

		if (idTxt == "tetris") {
			resY /= 1.5;
		}

		g.drawString(msg, (resX - metr.stringWidth(msg)) / 2, resY / 2);
	}

	public static int[] argsInt_instanciaGameOver(Settings sett) {

		int[] argsInt = new int[6];

        argsInt[0] = (int) (sett.resY / 9);
        argsInt[1] = sett.resX;
        argsInt[2] = sett.resY;
        argsInt[3] = Colores.gameover[0];
        argsInt[4] = Colores.gameover[1];
        argsInt[5] = Colores.gameover[2];

        return argsInt;
	}

	public static String[] argsString_instanciaGameOver() {

		String[] argsTxt = new String[2];

		argsTxt[0] = "Game Over";
        argsTxt[1] = "gameover";

        return argsTxt;
	}

	public static int[] argsInt_instanciaTitulo(Settings sett) {

		int[] argsInt = new int[6];

        argsInt[0] = (int) (sett.resY / 6);
        argsInt[1] = sett.resX;
        argsInt[2] = sett.resY;
        argsInt[3] = Colores.titulo[0];
        argsInt[4] = Colores.titulo[1];
        argsInt[5] = Colores.titulo[2];

        return argsInt;
	}

	public static String[] argsString_instanciaTitulo() {

		String[] argsTxt = new String[2];

		argsTxt[0] = "TETR1S";
        argsTxt[1] = "tetris";

        return argsTxt;
	}
}
