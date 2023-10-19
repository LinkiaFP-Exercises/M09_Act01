package actividad.tema02;

import java.util.Random;

interface ArrayWithZeroSum {
	static int[] generateWithLength(int length) {
		Random random = new Random();
		int[] array = new int[length];

		for (int i = 0; i < length; i++) {
			if (i % 2 != 0) {
				array[i] = random.nextInt(100) + 1; // Número positivo
			} else {
				array[i] = -random.nextInt(100) - 1; // Número negativo
			}
		}

		// ajustamos el último elemento para que la suma total sea 0
		int sum = 0;
		for (int i = 0; i < array.length - 1; i++) {
			sum += array[i];
		}
		array[length - 1] = -sum;

		return array;
	}

	static int[] generateWithLength(int length, int initialValue) {
		Random random = new Random();
		int[] array = new int[length];

		for (int i = 0; i < length; i++) {
			if (i % 2 != 0) {
				array[i] = random.nextInt(100) + 1; // Número positivo
			} else {
				array[i] = -random.nextInt(100) - 1; // Número negativo
			}
		}

		// ajustamos el último elemento para que la suma total sea 0
		int sum = 0;
		for (int i = 0; i < array.length - 1; i++) {
			sum += array[i];
		}
		array[length - 1] = -sum - initialValue;

		return array;
	}

}
