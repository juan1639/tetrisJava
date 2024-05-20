package tetrisPack;

import java.util.ArrayList;

public class Plantilla {

	private int[][] z = {
		{0, 0}, {0, -1}, {-1, -1}, {1, 0},
		{0, 0}, {0, -1}, {-1, 0}, {-1, 1},
		{0, 0}, {0, -1}, {-1, -1}, {1, 0},
		{0, 0}, {0, -1}, {-1, 0}, {-1, 1}
	};

	private int[][] s = {
		{0, 0}, {0, -1}, {1, -1}, {-1, 0},
		{0, 0}, {0, 1}, {-1, -1}, {-1, 0},
		{0, 0}, {0, -1}, {1, -1}, {-1, 0},
		{0, 0}, {0, 1}, {-1, -1}, {-1, 0}
	};

	private int[][] l = {
		{0, 0}, {0, -1}, {0, -2}, {1, 0},
		{0, 0}, {-1, 0}, {1, 0}, {1, -1},
		{0, 0}, {0, -1}, {0, -2}, {-1, -2},
		{0, 0}, {0, -1}, {1, -1}, {2, -1}
	};

	private int[][] j = {
		{0, 0}, {1, 0}, {1, -1}, {1, -2},
		{0, 0}, {0, -1}, {-1, -1}, {-2, -1},
		{0, 0}, {0, -1}, {0, -2}, {1, -2},
		{0, 0}, {0, -1}, {1, 0}, {2, 0}
	};

	private int[][] o = {
		{0, 0}, {0, -1}, {1, -1}, {1, 0},
		{0, 0}, {0, -1}, {1, -1}, {1, 0},
		{0, 0}, {0, -1}, {1, -1}, {1, 0},
		{0, 0}, {0, -1}, {1, -1}, {1, 0}
	};

	private int[][] i = {
		{0, 0}, {-1, 0}, {1, 0}, {2, 0},
		{0, 0}, {0, -1}, {0, -2}, {0, -3},
		{0, 0}, {-1, 0}, {1, 0}, {2, 0},
		{0, 0}, {0, -1}, {0, -2}, {0, -3}
	};

	private int[][] t = {
		{0, 0}, {0, -1}, {-1, 0}, {1, 0},
		{0, 0}, {0, -1}, {0, -2}, {-1, -1},
		{0, 0}, {-1, 0}, {1, 0}, {0, 1},
		{0, 0}, {0, -1}, {0, -2}, {1, -1}
	};
	
	private ArrayList<int[][]> pieza = new ArrayList<>();

	public Plantilla() {

		this.z = z;
		this.s = s;
		this.l = l;
		this.j = j;
		this.o = o;
		this.i = i;
		this.t = t;

		this.pieza = pieza;
		this.pieza.add(this.z);
		this.pieza.add(this.s);
		this.pieza.add(this.l);
		this.pieza.add(this.j);
		this.pieza.add(this.o);
		this.pieza.add(this.i);
		this.pieza.add(this.t);
	}

	// Getters & Setters
    public ArrayList<int[][]> getPieza() {
		return this.pieza;
	}
}
