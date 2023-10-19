package actividad.tema02;

public class TotalManager {
	private int total;

	public TotalManager(int initialValue) {
		this.total = initialValue;
	}

	public synchronized void calculate(int value) {

		final String hilo = String.format("%-9s", Thread.currentThread().getName());

		boolean wasSleeping = false;

		if (total + value < 0) {

			System.out.println(hilo + " - Quiero restar " + value + " hay " + total + " --> Duermo");

			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			wasSleeping = true;
		}

		total += value;

		String message = (wasSleeping) ? " - Despierto --> Valor " : " - Valor ";

		System.out.println(hilo + message + value + " Total ->: " + total);

		notifyAll();

	}

}
