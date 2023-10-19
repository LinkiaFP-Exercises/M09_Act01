package actividad.tema02;

public class Ejercicio03 {
	public static void main(String[] args) {
		final int amountOfExercise = 20;
		final int initialValue = 2;
		final TotalManager totalManager = new TotalManager(initialValue);
		final int[] array = ArrayWithZeroSum.generateWithLength(amountOfExercise, initialValue);
		final Thread[] threads = new Thread[amountOfExercise];

		for (int i = 0; i < amountOfExercise; i++) {
			threads[i] = new Thread(new NumberThread(array[i], totalManager));
			threads[i].start();
		}

	}

}
