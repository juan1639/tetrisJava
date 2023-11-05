package tetrisPack;

// ========================================================================
public class Pausaniveles {

	public static void pausar_entreNiveles(Settings sett) {

		int lineas = sett.getLineas();
	    int[][] superado = sett.getGoal_lines();
	    int nivel = sett.getNivel();

	    if (lineas >= superado[nivel][1] && lineas < superado[nivel][1] + 4 && superado[nivel][0] == 0) {

	        sett.estado.setEnJuego(false);
	        sett.estado.setEntreNiveles(true);

	        superado[nivel][0] = 9;
	        sett.setGoal_lines(superado);

	        nivel ++;
	        sett.setNivel(nivel);
	        System.out.println("superado:" + nivel + sett.getNivel());
	    }
	}
}
