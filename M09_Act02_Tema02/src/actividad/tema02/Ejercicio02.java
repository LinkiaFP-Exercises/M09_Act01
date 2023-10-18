package actividad.tema02;

/**
 * La clase Ejercicio02 implementa una aplicación que crea una matriz y busca un
 * número específico en ella. Utiliza hilos para el proceso de búsqueda y
 * muestra la posición del número en la matriz si se encuentra.
 * 
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 * @since 13/10/2023
 * @version 1.1
 */
public class Ejercicio02 {

	/**
	 * El método main es el punto de entrada de la aplicación. Crea una matriz y
	 * realiza la búsqueda de un número en ella. Luego muestra la matriz y la
	 * posición del número si se encuentra en la matriz.
	 *
	 * @param args Los argumentos de la línea de comandos. No se utilizan en esta
	 *             aplicación.
	 */
	public static void main(String[] args) {
		int filas = 20;
		int columnas = 10;
		MatrizFiller matrizEjercicio02 = new MatrizFiller(filas, columnas);
		matrizEjercicio02.setMatriz();
		matrizEjercicio02.printMatriz();
		new MatrizSearcher(matrizEjercicio02).buscarNumeroEnMatriz();
	}

}
