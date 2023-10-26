package actividad.tema02;

public class Datos {
	private int total;
	private boolean isNotEnough;
	private boolean wasSleeping;

	public Datos(int inicialValue) {
		this.total = inicialValue;
	}

	public synchronized void rest(int value) {

		while (verifyIfIsEnoughToRest(value)) {
			if (!wasSleeping)
				System.out.println(namedThead() + " - Quiero restar " + value + " hay " + total + " --> Duermo");
			waiting();
			wasSleeping = true;
		}

		calculate_PrintMsg_Notfy(value, namedThead());
	}

	public synchronized void sum(int value) {
		if (!isNotEnough)
			waiting();
		wasSleeping = false;
		calculate_PrintMsg_Notfy(value, namedThead());
	}

	private boolean verifyIfIsEnoughToRest(int value) {
		isNotEnough = (total + value >= 0) ? false : true;
		return isNotEnough;
	}

	private String namedThead() {
		return String.format("%-9s", Thread.currentThread().getName());
	}

	private void waiting() {
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException capturada");
		}
	}

	private void calculate_PrintMsg_Notfy(int value, final String hilo) {
		total += value;
		String message = (wasSleeping) ? " - Despierto --> Valor " : " - Valor ";
		System.out.println(hilo + message + value + " Total ->: " + total);
		notifyAll();
	}

}
