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
	        sett.setFireWorks(true);

	        superado[nivel][0] = 9;
	        sett.setGoal_lines(superado);

	        nivel ++;
	        sett.setNivel(nivel);
	        System.out.println("superado:" + nivel + sett.getNivel());
	    }
	}

	public static double[] argsDouble_instanciarFireWorks(Settings sett) {

		int rangoX = (int) (sett.resX / 3) + 20;
        int rangoY = (int) (sett.resY / 2) + 20;

        int rangoVelX = 49;
        int rangoVelY = 49;

        double x = (int) (Math.random() * rangoX);
        double y = (int) (Math.random() * rangoY);

        double velX = (int) (Math.random() * (rangoVelX * 2));
        double velY = (int) (Math.random() * (rangoVelY * 2));

        double[] argsDouble = {x, y, velX - rangoVelX, velY - rangoVelY};

        return argsDouble;
	}
}
