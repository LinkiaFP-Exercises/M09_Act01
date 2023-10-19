package actividad.tema02;

import java.util.Arrays;

public class Ejercicio03 {

	public static void main(String[] args) {

		System.out.println("Valor Inicial : " + initialValue);

		Arrays.stream(ArrayWithZeroSum.generateWithLength(numberOfExerciseThreads, initialValue))
				.forEach(x -> new NumberThread(x, totalManager).start());

	}

	private static final int initialValue = 2;
	private static final int numberOfExerciseThreads = 20;
	private static final TotalManager totalManager = new TotalManager(initialValue);

}
