package actividad.tema02;

/**
 * La clase NumberThread representa un hilo que se encarga de manejar un valor
 * específico para el cálculo total.
 * 
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 * @since 18/10/2023
 * @version 1.1
 */
public class NumberThread extends Thread {

	// Variables de instancia
	private int value;
	private TotalManager totalManager;

	/**
	 * Constructor que inicializa los valores del hilo.
	 *
	 * @param value        El valor a sumar o restar al total.
	 * @param totalManager El administrador total que controla el cálculo total.
	 */
	public NumberThread(int value, TotalManager totalManager) {
		this.value = value;
		this.totalManager = totalManager;
	}

	/**
	 * Implementación del método run que ejecuta el cálculo en el administrador
	 * total.
	 */
	@Override
	public void run() {
		totalManager.calculate(value);
	}

}
