package actividad.tema02.Kute;

import java.util.Random;

// La clase Ej_01 es responsable de generar una matriz y llenarla con valores aleatorios utilizando múltiples hilos.
// También imprime la matriz generada en la consola.
public class Ej_01 {

	public static void main(String[] args) {
		// Variables
		int lineas = 25;
		int columnas = 10;

		// Ejecuta el proceso de generación y visualización de la matriz
		Ej_01.ejecutar(lineas, columnas);
	}

	public static int[][] ejecutar(int lineas, int columnas) {
		// Crea una matriz vacía con las dimensiones dadas
		int[][] matriz = new int[lineas][columnas];

		// Rellena la matriz utilizando múltiples hilos
		// FOR normal por necesidad del indice para cada hilo
		for (int i = 0; i < columnas; i++) {
			Thread t = new Thread(new LlenadorMatrices(matriz, i));
			t.start();
		}

		// Imprime la matriz después rellenada
		// FOREACH porque no hace falta el indice
		for (int[] linea : matriz) {
			for (int columna : linea) {
				// IF Formatea el número para imprimirlo con dos dígitos
				String numero;
				if (columna < 10)
					numero = "0" + columna;
				else
					numero = "" + columna;

				// Imprime el número en formato de matriz
				System.out.print("[" + numero + "] ");
			}
			// salto de linea
			System.out.println();
		}

		// Devuelve la matriz generada, uso para el ejercício02
		return matriz;
	}
}

// La clase GeneradorMatrices se encarga de generar valores aleatorios y
// rellenar la matriz en una columna específica.
class LlenadorMatrices extends Thread {
	private Random r = new Random();
	private int col;
	private int[][] array;

	// constructor
	public LlenadorMatrices(int[][] array, int col) {
		this.col = col;
		this.array = array;
	}

	// método de la clase thread que rellena una columna específica de la matriz
	@Override
	public void run() {
		for (int j = 0; j < array.length; j++) {
			array[j][col] = r.nextInt(100);
		}
	}
}
