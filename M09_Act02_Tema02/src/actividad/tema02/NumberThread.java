package actividad.tema02;

import java.util.Random;

public class NumberThread implements Runnable {

	private TotalManager totalManager;
	private Random random = new Random();

	public NumberThread(TotalManager totalManager) {
		this.totalManager = totalManager;
	}

	@Override
	public void run() {
		int value = random.nextInt(10) - 6; // Números aleatorios entre -5 y 4
		if (value >= 0) {
			totalManager.increaseTotal(value);
		} else {
			totalManager.decreaseTotal(Math.abs(value));
		}
	}

}
