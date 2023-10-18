package actividad.tema02;

/**
 * La clase ColumnSearcher se encarga de buscar un número específico en una
 * columna dada de una matriz. Utiliza hilos para realizar la búsqueda en la
 * columna designada.
 * 
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 * @since 13/10/2023
 * @version 1.1
 */
public class ColumnSearcher implements Runnable {
	private int[][] matriz;
	private int columna;
	private int numeroBusqueda;

	/**
	 * Construye un objeto ColumnSearcher con una matriz, una columna específica y
	 * un número a buscar.
	 *
	 * @param matriz         La matriz en la que se realizará la búsqueda.
	 * @param columna        La columna específica en la que se buscará el número.
	 * @param numeroBusqueda El número que se busca en la columna.
	 */
	public ColumnSearcher(int[][] matriz, int columna, int numeroBusqueda) {
		this.matriz = matriz;
		this.columna = columna;
		this.numeroBusqueda = numeroBusqueda;
	}

	/**
	 * Realiza la búsqueda del número especificado en la columna dada de la matriz.
	 * Imprime la posición del número en la columna si se encuentra.
	 */
	@Override
	public void run() {
		for (int i = 0; i < matriz.length; i++) {
			if (matriz[i][columna] == numeroBusqueda) {
				String hilo = Thread.currentThread().getName();
				System.out.printf("Hilo: %s Posición: [%02d][%02d]%n", hilo.charAt(hilo.length() - 1), i, columna);
			}
		}
	}
}
