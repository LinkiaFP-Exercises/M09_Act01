package actividad.tema02;

import java.util.Random;

interface ArrayWithZeroSum {
	static int[] generateWithLength(int length) {
		Random random = new Random();
		int[] array = new int[length];

		for (int i = 0; i < length; i++) {
			if (i % 2 == 0) {
				array[i] = random.nextInt(100) + 1; // Número positivo
			} else {
				array[i] = -random.nextInt(100) - 1; // Número negativo
			}
		}

		// Si la suma no es 0, ajustamos el último elemento para que la suma total sea 0
		int sum = 0;
		for (int num : array) {
			sum += num;
		}
		array[length - 1] = -sum;

		return array;
	}

}
