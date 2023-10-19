package actividad.tema02;

public class Ejercicio03 {
	public static void main(String[] args) {
		TotalManager totalManager = new TotalManager();

		new Thread(new NumberThread(5, totalManager)).start();
		new Thread(new NumberThread(-5, totalManager)).start();
		new Thread(new NumberThread(7, totalManager)).start();
		new Thread(new NumberThread(-7, totalManager)).start();
	}

}
