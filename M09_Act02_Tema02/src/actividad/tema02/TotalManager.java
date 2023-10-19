package actividad.tema02;

public class TotalManager {
	private int total = 0;

	public synchronized void increaseTotal(int value) {
		total += value;
		System.out.println("Incrementando " + value + " Total ->: " + total);
		notifyAll();
	}

	public synchronized void decreaseTotal(int value) {
		while (total - value < 0) {
			try {
				System.out.println("Quiero restar " + value + " hay " + total + " --> Duermo");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		total -= value;
		System.out.println("Decrementando " + value + " Total ->: " + total);
	}

}
