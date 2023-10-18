package actividad.tema02;

/**
 * La clase Ejercicio01 es la clase principal que ejecuta el programa. Esta
 * clase crea una matriz, la llena con valores aleatorios y luego imprime la
 * matriz resultante.
 * 
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 * @since 12/10/2023
 * @version 1.1
 */
public class Ejercicio01 {

	/**
	 * El método main es el punto de entrada del programa. Crea una matriz, la llena
	 * con valores aleatorios y luego imprime la matriz resultante.
	 *
	 * @param args Argumentos pasados al programa.
	 */
	public static void main(String[] args) {
		final int filas = 25;
		final int columnas = 10;
		final MatrizFiller matrizEjercicio01 = new MatrizFiller(filas, columnas);
		matrizEjercicio01.setMatriz();
		matrizEjercicio01.printMatriz();

	}
}
