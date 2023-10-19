package actividad.tema02;

/**
 * La clase TotalManager administra el cálculo del total y controla la lógica de
 * sincronización para la gestión de los hilos.
 * 
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 * @since 18/10/2023
 * @version 1.1
 */
public class TotalManager {

	// Variable de instancia para el total
	private int total;

	/**
	 * Constructor que inicializa el valor total.
	 *
	 * @param initialValue El valor inicial para el cálculo total.
	 */
	public TotalManager(int initialValue) {
		this.total = initialValue;
	}

	/**
	 * Calcula el valor total e imprime información sobre el proceso de cálculo.
	 *
	 * @param value El valor a sumar o restar al total.
	 */
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
