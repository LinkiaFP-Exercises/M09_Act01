package actividad.tema02;

import java.util.Random;

interface ArrayWithZeroSum {

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
