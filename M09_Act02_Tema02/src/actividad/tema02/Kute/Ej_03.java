package actividad.tema02.Kute;

import java.util.Arrays;
import java.util.Random;

public class Ej_03 {

	public static void main(String[] args) {

		Calculador calculador = new Calculador();

		int[] array = { -29, 91, -67, 31, -21, 31, -81, 55, -51, 25, -20, 20, -78, 35, -7, 92, -15, 57, -77, 9 };

		Arrays.stream(array).boxed().sorted((a, b) -> Math.random() > 0.5 ? -1 : 1).mapToInt(Integer::intValue)
				.forEach(x -> new Thread(new GestionHilos(x, calculador)).start());

	}

}

class GestionHilos implements Runnable {
	private int n;
	private Calculador calculador;

	public GestionHilos(int n, Calculador calculador) {
		this.n = n;
		this.calculador = calculador;
	}

	@Override
	public void run() {
		if (n > 0)
			calculador.sum(n);
		else
			calculador.rest(n);

	}

}

class Calculador {
	private boolean dormido = false;
	private int suma = 0;

	public synchronized void rest(int n) {
		while (suma + n < 0) {
			if (!dormido) {
				System.out.println(
						Thread.currentThread().getName() + " - Quiero restar " + n + " hay " + suma + " --> Duermo");
				notifyAll();
			}

			try {
				wait();
				dormido = true;
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}

		suma += n;

		String msg;
		if (dormido)
			msg = " - Despierto --> Valor ";
		else
			msg = " - Valor ";

		System.out.println(Thread.currentThread().getName() + msg + n + " Total ->: " + suma);

		notifyAll();
	}

	public synchronized void sum(int n) {
		if (new Random().nextBoolean())
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e);
			}

		suma += n;

		System.out.println(Thread.currentThread().getName() + " - Valor " + n + " Total ->: " + suma);

		notify();

	}

}