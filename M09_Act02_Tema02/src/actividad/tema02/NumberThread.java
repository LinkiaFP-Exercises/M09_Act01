package actividad.tema02;

public class NumberThread implements Runnable {

	private int value;
    private TotalManager totalManager;

    public NumberThread(int value, TotalManager totalManager) {
        this.value = value;
        this.totalManager = totalManager;
    }

    @Override
    public void run() {
        if (value >= 0) {
            totalManager.add(value);
        } else {
            totalManager.subtract(value);
        }
    }

}
