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
	 * Calcula el valor total e imprime información sobre el proceso de cálculo. La
	 * función calculate en la clase TotalManager es responsable de actualizar la
	 * variable total de forma sincronizada, utilizando el valor proporcionado como
	 * parámetro. Si la suma resultante de total y el valor es negativa, el hilo se
	 * duerme hasta que se produzca un resultado no negativo. Posteriormente, el
	 * hilo actualiza el valor de total y notifica a todos los hilos en espera. La
	 * función imprime mensajes informativos que indican si el hilo se ha quedado
	 * dormido y si ha despertado para realizar la operación.
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
