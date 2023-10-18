package actividad.tema02;

import java.util.Random;

/**
 * La clase ColumnFiller implementa la interfaz Runnable y se utiliza para
 * llenar una columna específica de una matriz con valores aleatorios.
 * 
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 * @since 12/10/2023
 * @version 1.1
 */
public class ColumnFiller implements Runnable {
	private int[][] matriz;
	private int columna;
	private Random rand;

	/**
	 * El constructor de la clase ColumnFiller inicializa la matriz y la columna
	 * objetivo para rellenar con valores aleatorios.
	 *
	 * @param matriz  La matriz a la que se agregarán los valores aleatorios.
	 * @param columna El índice de la columna en la matriz que se llenará con
	 *                valores aleatorios.
	 */
	public ColumnFiller(int[][] matriz, int columna) {
		this.matriz = matriz;
		this.columna = columna;
		this.rand = new Random();
	}

	/**
	 * Rellena la columna específica de la matriz con valores aleatorios generados
	 * por la instancia de Random.
	 */
	@Override
	public void run() {
		for (int i = 0; i < matriz.length; i++) {
			matriz[i][columna] = rand.nextInt(100);
		}
	}
}
