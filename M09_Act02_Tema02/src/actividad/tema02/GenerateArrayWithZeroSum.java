package actividad.tema02;

import java.util.Random;

/**
 * La interfaz ArrayWithZeroSum proporciona un método para generar un arreglo de
 * números aleatorios con una suma total de cero.
 * 
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 * @since 18/10/2023
 * @version 1.1
 */
interface ArrayWithZeroSum {

	/**
	 * Genera un arreglo de longitud dada con valores aleatorios cuya suma total es
	 * cero. Si no hay un valor inicial la variable {@code initialValue} debe ser
	 * zero.
	 *
	 * @param length       La longitud del arreglo.
	 * @param initialValue El valor inicial para el cálculo total.
	 * @return Un arreglo de enteros con la suma total igual a cero.
	 */
	static int[] generateWithLength(int length, int initialValue) {
		Random random = new Random();
		int[] array = new int[length];
		int sum = 0;

		for (int i = 0; i < length; i++) {

			if (i % 2 != 0) {
				array[i] = random.nextInt(100) + 1; // Número positivo
			} else {
				array[i] = -random.nextInt(100) - 1; // Número negativo
			}

			if (i < array.length - 1)
				sum += array[i];
		}

		array[length - 1] = -sum - initialValue;

		return array;
	}

}
