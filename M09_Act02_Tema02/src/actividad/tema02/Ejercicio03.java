package actividad.tema02;

import java.util.Arrays;

/**
 * La clase Ejercicio03 ejecuta el programa principal que maneja la generación
 * de hilos y la gestión del cálculo total.
 * 
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 * @since 18/10/2023
 * @version 1.1
 */
public class Ejercicio03 {

	/**
	 * Método principal que inicia la ejecución del programa.
	 *
	 * @param args Argumentos de línea de comandos (no se utilizan en esta
	 *             aplicación).
	 */
	public static void main(String[] args) {

		System.out.println("Valor Inicial : " + initialValue);

		Arrays.stream(ArrayWithZeroSum.generateWithLength(numberOfExerciseThreads, initialValue))
				.forEach(x -> new NumberThread(x, totalManager).start());

	}

	// Variables estáticas
	private static final int initialValue = 2;
	private static final int numberOfExerciseThreads = 20;
	private static final TotalManager totalManager = new TotalManager(initialValue);

}
