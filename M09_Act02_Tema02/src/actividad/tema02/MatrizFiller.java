package actividad.tema02;

/**
 * La clase MatrizFiller se utiliza para crear y llenar una matriz con valores
 * aleatorios.
 * 
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 * @since 12/10/2023
 * @version 1.1
 */
class MatrizFiller {
	private final int[][] matriz;
	private final int columnas;
	private final int filas;

	/**
	 * El constructor de la clase MatrizFiller crea una matriz con la cantidad de
	 * filas y columnas especificadas.
	 *
	 * @param filas    Número de filas de la matriz.
	 * @param columnas Número de columnas de la matriz.
	 */
	public MatrizFiller(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		this.matriz = new int[filas][columnas];
	}

	/**
	 * Obtiene el número de columnas de la matriz.
	 *
	 * @return El número de columnas de la matriz.
	 */
	public int getColumnas() {
		return columnas;
	}

	/**
	 * Obtiene el número de filas de la matriz.
	 *
	 * @return El número de filas de la matriz.
	 */
	public int getFilas() {
		return filas;
	}

	/**
	 * Obtiene la matriz creada y llena con valores aleatorios.
	 *
	 * @return La matriz creada y llena.
	 */
	public int[][] getMatriz() {
		return matriz;
	}

	/**
	 * Llena la matriz con valores aleatorios en cada columna mediante el uso de
	 * hilos.
	 */
	public void setMatriz() {
		try {
			for (int i = 0; i < columnas; i++) {
				Thread t = new Thread(new ColumnFiller(matriz, i));
				t.start();
				t.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Imprime la matriz en la consola, mostrando sus elementos en formato de dos
	 * dígitos entre corchetes.
	 */
	public void printMatriz() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.printf("[%02d] ", matriz[i][j]);
			}
			System.out.println();
		}
	}

}
