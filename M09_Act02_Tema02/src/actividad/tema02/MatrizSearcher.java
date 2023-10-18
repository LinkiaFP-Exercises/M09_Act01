package actividad.tema02;

import java.util.Scanner;

/**
 * La clase MatrizSearcher se encarga de buscar un número específico en una
 * matriz dada. Utiliza múltiples hilos para buscar en cada columna de la
 * matriz.
 * 
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 * @since 13/10/2023
 * @version 1.1
 */
public class MatrizSearcher {
	private final int[][] matriz;
	private int numeroBusqueda;

	/**
	 * Construye un objeto MatrizSearcher a partir de una MatrizFiller dada.
	 *
	 * @param matrizEjercicio02 La MatrizFiller que se utilizará para la búsqueda.
	 */
	public MatrizSearcher(MatrizFiller matrizEjercicio02) {
		matriz = matrizEjercicio02.getMatriz();
	}

	/**
	 * Construye un objeto MatrizSearcher a partir de una matriz dada.
	 *
	 * @param matriz La matriz en la que se realizará la búsqueda.
	 */
	public MatrizSearcher(int[][] matriz) {
		this.matriz = matriz;
	}

	/**
	 * Realiza la búsqueda de un número específico en la matriz. Utiliza múltiples
	 * hilos para buscar en cada columna de la matriz.
	 */
	public void buscarNumeroEnMatriz() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEscribe el número a buscar (0-99): ");
		numeroBusqueda = scanner.nextInt();
		scanner.close();
		System.out.print("\n");

		for (int i = 0; i < matriz[0].length; i++) {
			Thread t = new Thread(new ColumnSearcher(matriz, i, numeroBusqueda));
			t.start();
		}
	}
	
}
