package tetrisPack;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main extends JFrame {

	public Main() {

		inicializa();
	}

	private void inicializa() {

		add(new Ventana());

		setResizable(false);
		pack();

		setTitle("Tetris Java by Juan Eguia");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame principal = new Main();
				principal.setVisible(true);
			}
		});
	}
}
