package actividad.tema02;

import java.util.Random;

public class ColumnFiller implements Runnable {
	private int[][] matriz;
	private int columna;
	private Random rand;

	public ColumnFiller(int[][] matriz, int columna) {
		this.matriz = matriz;
		this.columna = columna;
		this.rand = new Random();
	}

	@Override
	public void run() {
		for (int i = 0; i < matriz.length; i++) {
			matriz[i][columna] = rand.nextInt(100);
		}
	}
}
