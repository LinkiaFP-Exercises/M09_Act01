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
	public static void main(String[] args) throws InterruptedException {

		System.out.println("Valor Inicial : " + initialValue);

		/**
		 * Esta línea de código crea un flujo de datos a partir de un array generado por
		 * el método generateWithLength de la interfaz ArrayWithZeroSum. Posteriormente,
		 * itera sobre cada elemento del flujo utilizando el método forEach. En cada
		 * iteración, se crea una nueva instancia de NumberThread con el valor actual
		 * del flujo y se inicia el hilo utilizando el método start(). De esta forma, la
		 * línea de código genera y administra múltiples hilos, cada uno de los cuales
		 * maneja un valor específico y se comunica con el totalManager para realizar
		 * operaciones de suma y resta.
		 */

		Arrays.stream(ArrayWithZeroSum.generateWithLength(numberOfExerciseThreads, initialValue))
				.forEach(x -> new NumberThread(x, totalManager).start());

	}

	// Variables estáticas
	private static final int initialValue = 0;
	private static final int numberOfExerciseThreads = 20;
	private static final TotalManager totalManager = new TotalManager(initialValue);
}
