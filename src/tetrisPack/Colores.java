package tetrisPack;

import java.util.ArrayList;

// ========================================================================
public class Colores {

    public int[][] piezas = {
		{255, 204, 0, 227, 182, 2},
		{242, 55, 55, 222, 16, 16},
		{131, 89, 149, 121, 83, 138},
		{204, 204, 204, 187, 187, 187},
		{159, 206, 49, 149, 192, 46},
		{255, 174, 201, 255, 119, 164},
		{74, 191, 240, 52, 182, 237}
	};

	public int[] marcadores = {240, 228, 0, 255, 206, 36, 255, 130, 47};

	public int[] fondo = {143, 127, 9};

	// -----------------------------------------------
	public Colores() {

		this.piezas = piezas;
		this.marcadores = marcadores;
		this.fondo = fondo;
	}
}
