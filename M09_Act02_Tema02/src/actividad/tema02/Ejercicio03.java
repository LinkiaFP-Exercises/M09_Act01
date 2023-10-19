package actividad.tema02;

public class Ejercicio03 {
	public static void main(String[] args) {
		TotalManager totalManager = new TotalManager();
		Thread[] threads = new Thread[20];

		// Inicializar los 20 hilos
		for (int i = 0; i < 20; i++) {
			threads[i] = new Thread(new NumberThread(totalManager));
			threads[i].start();
		}
	}

}
