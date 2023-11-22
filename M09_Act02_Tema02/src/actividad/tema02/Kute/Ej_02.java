package actividad.tema02.Kute;

import java.util.Scanner;

// La clase Ej_02 se encarga de buscar un número específico en una matriz generada previamente.
public class Ej_02 {

	// variable de la clase
	private static Scanner in;

	public static void main(String[] args) {
		// variables de dimensión del array
		int lineas = 20;
		int columnas = 10;

		// utilizando el ejercício anterior para rellenar la matriz
		int[][] array = Ej_01.ejecutar(lineas, columnas);

		// ejecución del ejercicio02, buscar un número específico en la matriz.
		Ej_02.ejecutar(array, columnas);
	}

	// Este método solicita al usuario un número y busca ese número en una matriz
	// específica.
	public static void ejecutar(int[][] array, int columnas) {
		System.out.println(); // salto de línea
		System.out.print("Escribe el número a buscar (0-99): "); // print para que ecriba delante de la pregunta
		in = new Scanner(System.in); // inicializa scanner
		int valor = in.nextInt(); // lectura de numero del teclado que se vá buscar
		System.out.println(); // salto de línea

		// FOR con índice para que cada hilo busque en una columna
		for (int i = 0; i < columnas; i++) {
			new Thread(new BuscadorMatrices(valor, i, array)).start();

		}
	}

}

// La clase BuscadorMatrices se encarga de buscar un número específico en cada columna de la matriz.
class BuscadorMatrices implements Runnable {
	int encontrar;
	int columna;
	int[][] matriz;

	// constructor con numero a buscar, la columna a buscar y la matriz
	public BuscadorMatrices(int encontrar, int columna, int[][] matriz) {
		this.encontrar = encontrar;
		this.columna = columna;
		this.matriz = matriz;
	}

	// Método que formatea un número para que tenga dos dígitos.
	public String dosDigits(int n) {
		String numero;

		if (n < 10)
			numero = "0" + n;
		else
			numero = "" + n;

		return numero;
	}

	// Método de Runnable que ejecuta el proceso de búsqueda de un número específico
	// en una columna especifica dentro de la matriz.
	@Override
	public void run() {
		for (int i = 0; i < matriz.length; i++) {
			if (encontrar == matriz[i][columna]) {
				System.out.println(
						"Thread-" + columna + " Posición: [" + dosDigits(i) + "]" + "[" + dosDigits(columna) + "]");
			}
		}
	}

}
