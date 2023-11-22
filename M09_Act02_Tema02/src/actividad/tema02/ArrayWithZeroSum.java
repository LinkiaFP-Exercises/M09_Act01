package actividad.tema02;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

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
	 * Genera un array de enteros con una longitud determinada. Llena el array con
	 * números aleatorios positivos y negativos. Asegura que la suma de todos los
	 * elementos en el array es cero, incluso después de tener en cuenta un valor
	 * inicial. Si no hay un valor inicial la variable {@code initialValue} debe ser
	 * zero.
	 *
	 * @param length       La longitud del arreglo.
	 * @param initialValue El valor inicial para el cálculo total.
	 * @return Un arreglo de enteros con la suma total igual a cero.
	 */
	static int[] generateWithLength(int length, int initialValue) {
		Random random = new Random();

		/**
		 * Se crea un rango de números enteros desde 0 hasta (length-1) utilizando
		 * IntStream. Cada número en el rango se mapea a un número aleatorio en función
		 * de si es par o impar, siendo aleatorio en el rango positivo o negativo de 1 a
		 * 100. Posteriormente, se convierte el IntStream en un Stream<Integer>
		 * utilizando el método boxed(). Luego se realiza una clasificación
		 * semi-aleatoria utilizando la función sorted() con un comparador que devuelve
		 * -1 o 1 de forma aleatoria utilizando el método Math.random(). Por último, se
		 * mapea de nuevo a un IntStream y luego se convierte a un array de enteros.
		 */
		int[] array = IntStream.range(0, length)
				.map(i -> (i % 2 == 0) ? random.nextInt(100) + 1 : -random.nextInt(100) - 1)
				.boxed().sorted((a, b) -> Math.random() > 0.5 ? -1 : 1).mapToInt(Integer::intValue)
				.toArray();
		/**
		 * Se utiliza el método Arrays.stream() para crear un flujo de los elementos del
		 * array. Luego se limita la cantidad de elementos del flujo a 'length - 1' para
		 * excluir el último elemento. Finalmente, se aplica la función de suma para
		 * sumar todos los elementos del flujo. Luego se asigna al último elemento del
		 * array el resultado de la resta entre la suma total y el valor inicial, con el
		 * signo cambiado.
		 */
		array[length - 1] = -Arrays.stream(array).limit(length - 1).sum() - initialValue;

		return array;
	}

}
