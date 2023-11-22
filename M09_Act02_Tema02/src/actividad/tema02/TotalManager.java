package actividad.tema02;

import java.util.Random;

/**
 * La clase TotalManager modela un conjunto de datos que incluye el total, el
 * estado de si hay suficiente para restar, y si el hilo estaba en estado de
 * espera. Permite realizar operaciones de suma y resta con control de hilo para
 * asegurar la integridad de los datos y la sincronización adecuada.
 * 
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 * @since 18/10/2023
 * @version 1.1
 */
public class TotalManager {
	private int total;
	private boolean wasSleeping;

	/**
	 * Constructor de la clase TotalManager que inicializa el valor total.
	 *
	 * @param inicialValue El valor inicial para la variable total.
	 */
	public TotalManager(int inicialValue) {
		this.total = inicialValue;
	}

	/**
	 * Calcula el valor total en función del valor dado y lo imprime junto con el
	 * hilo correspondiente. Si el valor es negativo, comprueba si es suficiente
	 * para restar. Si no es suficiente, el hilo se duerme hasta que pueda restar.
	 * Si el valor es positivo, realiza una suma segura y controlada por hilos. Si
	 * no hay suficiente para restar, el hilo se mantiene en espera y luego realiza
	 * la suma.
	 * 
	 * @param value El valor a calcular.
	 */
	public synchronized void calculate(int value) {
		if (value < 0)
			while (verifyIsNotEnoughToRest(value)) {
				if (!wasSleeping) {
					System.out.println(namedThead() + " - Quiero restar " + value + " hay " + total + " --> Duermo");
				}
				notifyAll();
				waiting();
				wasSleeping = true;
			}
		else {
//			if (new Random().nextBoolean())
			if (getNonRepeatingRandomBoolean())
				waiting();
			wasSleeping = false;
		}
		calculate_PrintMsg_Notfy(value, namedThead());
	}

	private boolean getNonRepeatingRandomBoolean() {
		boolean previousBoolean = false;
		return previousBoolean = (previousBoolean) ? false : new Random().ints(0, 3).findFirst().getAsInt() == 0;
	}

	/**
	 * Verifica si hay suficiente para restar y controla el estado correspondiente
	 * del cálculo.
	 * 
	 * @param value valor a verificar
	 * @return booleano {@code isNotEnough}
	 */
	private boolean verifyIsNotEnoughToRest(int value) {
		return (total + value < 0);
	}

	/**
	 * Retorna el nombre del hilo con un formato específico.
	 * 
	 * @return String del nombre del hilo actual formatado con 9 espacios
	 */
	private String namedThead() {
		return String.format("%-9s", Thread.currentThread().getName());
	}

	/**
	 * La función {@code waiting} pausa la ejecución del hilo actual y espera a que
	 * otro hilo lo notifique para que pueda continuar. Si se produce una
	 * interrupción durante el proceso de espera, la función captura la excepción
	 * {@code InterruptedException} y la imprime en la consola.
	 */
	private void waiting() {
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException capturada");
		}
	}

	/**
	 * la suma del valor dado al total actual, luego imprime un mensaje indicando si
	 * el hilo ha despertado o no. A continuación, imprime el valor que se ha sumado
	 * y el total actual. Finalmente, notifica a todos los hilos que estén en espera
	 * para que puedan reanudar su ejecución.
	 * 
	 * @param value valor a calucular junto al {@code total}
	 * @param hilo  nombre del hilo que está corriendo
	 */
	private void calculate_PrintMsg_Notfy(int value, final String hilo) {
		total += value;
		String message = (wasSleeping) ? " - Despierto --> Valor " : " - Valor ";
		System.out.println(hilo + message + value + " Total ->: " + total);
		notifyAll();
	}

}
