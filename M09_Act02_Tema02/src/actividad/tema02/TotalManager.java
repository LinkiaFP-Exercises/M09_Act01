package actividad.tema02;

public class TotalManager {
	private int total = 0;

	public synchronized void add(int value) {
		total += value;
		System.out.println("Valor " + value + " Total ->: " + total);
		notifyAll();
	}

	public synchronized void subtract(int value) {
		while (total + value < 0) {
			System.out.println("Quiero restar " + value + " hay " + total + " -->Duermo");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		total += value;
		System.out.println("Despierto--> Valor " + value + " Total ->: " + total);
		notifyAll();
	}

}
