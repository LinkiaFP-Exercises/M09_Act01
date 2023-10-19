package actividad.tema02;

public class TotalManager {
	private int total = 0;
	private int vueltas = 0;

	public TotalManager(int initialValue) {
		this.total = initialValue;
	}

	public synchronized void calculate(int value) {
		if (vueltas == 0) {
			System.out.println("Valor Inicial : " + total);
		}
		vueltas++;

		final String hilo = Thread.currentThread().getName();

		if (total + value < 0) {

			while (total + value < 0) {
				System.out.println(hilo + " - Quiero restar " + value + " hay " + total + " -->Duermo");
				try {
					wait();
					notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			total += value;
			System.out.println(hilo + " - Despierto--> Valor " + value + " Total ->: " + total);

		} else {
			total += value;
			System.out.println(hilo + " - Valor " + value + " Total ->: " + total);
			notifyAll();
		}

	}

}
