package actividad.tema02;

public class NumberThread extends Thread {

	private int value;
	private TotalManager totalManager;

	public NumberThread(int value, TotalManager totalManager) {
		this.value = value;
		this.totalManager = totalManager;
	}

	@Override
	public void run() {
		totalManager.calculate(value);
	}

}
