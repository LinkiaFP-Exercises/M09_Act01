package actividad.tema02;

public class Ejercicio03 {
	public static void main(String[] args) {
		TotalManager totalManager = new TotalManager();
		int[] array = ArrayWithZeroSum.generateWithLength(20);
		Thread[] threads = new Thread[20];

		// Inicializar los 20 hilos
		for (int i = 0; i < 20; i++) {
			threads[i] = new Thread(new NumberThread(array[i], totalManager));
			threads[i].start();
		}

	}

}
