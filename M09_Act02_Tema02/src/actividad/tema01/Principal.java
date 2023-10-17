package actividad.tema01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * En resumen, este programa Java interactúa con un proceso externo llamado
 * "Sumador" que realiza operaciones con los números ingresados por el usuario.
 * Solicita dos números enteros, los envía al "Sumador", recibe el resultado y
 * lo muestra en la consola. El programa se ejecuta en un bucle hasta que ambos
 * números ingresados por el usuario sean cero, momento en el cual se cierra el
 * proceso "Sumador" y finaliza el programa.
 * 
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 * @since 05/10/2023
 * @version 1.1
 */
public class Principal {

	public static void main(String[] args) {

		try {

			printTitulo();

			do {
				startProcessSumador();
				request2NumbersOfUserAndFillArray();
				sendArrayInStringFormatToSumador();
				receivingAndPrintingResult();
			} while (bothNumbersAreNotZero());

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			closeProcessSumador();
		}

	}


	/**
	 * La función startProcessSumador() es responsable de iniciar un proceso externo
	 * llamado "Sumador" desde el programa Java. Aquí está una explicación detallada
	 * de lo que hace esta función:
	 * 
	 * ProcessBuilder: Se utiliza la clase ProcessBuilder para crear un nuevo
	 * proceso. ProcessBuilder es una clase en Java que se utiliza para iniciar
	 * procesos externos desde una aplicación Java.
	 * 
	 * Comando y Argumentos: Dentro de ProcessBuilder, se especifica el comando y
	 * los argumentos necesarios para ejecutar el proceso externo "Sumador". En este
	 * caso, los elementos específicos son:
	 * 
	 * "java": El comando que se ejecutará, que en este caso es la máquina virtual
	 * de Java.
	 * 
	 * "-jar": Un argumento que indica que se ejecutará un archivo JAR.
	 * 
	 * RUTA_SUMADOR: Una constante que representa la ruta al archivo JAR del proceso
	 * "Sumador". Esta ruta se utiliza como argumento para el comando.
	 * 
	 * Inicio del Proceso: Después de configurar el ProcessBuilder, se llama al
	 * método start() para iniciar el proceso externo. Esto inicia la ejecución del
	 * programa "Sumador" desde el archivo JAR especificado en la ruta.
	 * 
	 * En resumen, la función startProcessSumador() se encarga de iniciar el proceso
	 * externo "Sumador" desde el programa Java utilizando ProcessBuilder. Esto
	 * permite que el programa interactúe con el proceso "Sumador" y utilice sus
	 * funcionalidades para realizar operaciones con números ingresados por el
	 * usuario.
	 * 
	 * @throws IOException
	 */
	private static void startProcessSumador() throws IOException {

		Sumador = new ProcessBuilder("java", "-jar", RUTA_SUMADOR).start();

	}

	/**
	 * La función request2NumbersOfUserAndFillArray() tiene dos responsabilidades
	 * principales: solicitar al usuario que ingrese dos números enteros y almacenar
	 * estos números en un array. Aquí está una explicación detallada de lo que hace
	 * esta función:
	 * 
	 * Solicitud de Números al Usuario: La función muestra mensajes al usuario para
	 * solicitar dos números enteros. Para ello, utiliza la función
	 * pideEntero(String statement) para cada número. La variable statement es una
	 * cadena que contiene la pregunta que se muestra al usuario para solicitar la
	 * entrada.
	 * 
	 * Lectura y Validación de la Entrada del Usuario: La función pideEntero(String
	 * statement) se utiliza para leer la entrada del usuario.
	 * 
	 * Almacenamiento en el Array: Después de obtener dos números enteros válidos
	 * del usuario, la función los almacena en un array llamado array2NumbersOfUser.
	 * El primer número ingresado se almacena en array2NumbersOfUser[0] y el segundo
	 * en array2NumbersOfUser[1].
	 * 
	 * En resumen, la función request2NumbersOfUserAndFillArray() interactúa con el
	 * usuario para solicitar dos números enteros, garantizando que los números
	 * ingresados sean válidos según la expresión regular definida. Luego, almacena
	 * estos números en un array para su posterior uso en el programa.
	 * 
	 * @see pideEntero
	 */
	private static void request2NumbersOfUserAndFillArray() {
		array2NumbersOfUser[0] = pideEntero("Escribe el 1ª numero: ");
		array2NumbersOfUser[1] = pideEntero("Escribe el 2ª numero: ");
	}

	/**
	 * Solicita al usuario que ingrese un valor de tipo entero y lo valida mediante
	 * una expresión regular. La función seguirá hasta que se proporcione unn valor
	 * que cumpla con el patrón especificado.
	 * 
	 * @param statement pregunta una pregunta que se muestra al usuario para
	 *                  solicitar la entrada.
	 * @return el valor de entrada validado del usuario en formato int.
	 */
	private static int pideEntero(String statement) {

		final String REGEX_ENTERO = "^-?\\d+$";
		int attemptSelection = 0;
		String userEntryValue = "";

		do {

			if (attemptSelection > 0)
				System.out.println("¡¡¡VALOR INVALIDO!!!");

			System.out.print(statement);

			userEntryValue = scanner.nextLine().replace(",", ".");

			attemptSelection++;

		} while (!userEntryValue.matches(REGEX_ENTERO));

		return Integer.valueOf(userEntryValue);
		
	}

	/**
	 * La función sendArrayInStringFormatToSumador() tiene la responsabilidad de
	 * enviar un array de números (almacenado en formato de cadena) al proceso
	 * externo llamado "Sumador". Aquí está una explicación detallada de lo que hace
	 * esta función:
	 * 
	 * Creación de un Flujo de Salida: La función crea un flujo de salida llamado
	 * sendingDataToSumador utilizando la clase PrintStream. Este flujo de salida se
	 * utiliza para enviar datos al proceso externo.
	 * 
	 * Formateo del Array a una Cadena: La función convierte el array de dos
	 * números, array2NumbersOfUser, en una cadena de texto en formato de matriz
	 * utilizando el método Arrays.toString(array2NumbersOfUser). Esto crea una
	 * cadena que representa los números en el array, con comas y espacios entre
	 * ellos, por ejemplo, "[num1, num2]".
	 * 
	 * Envío de la Cadena al Proceso Externo: Utilizando el flujo de salida
	 * sendingDataToSumador, la función envía la cadena formateada al proceso
	 * externo llamado "Sumador". Esto se hace mediante la llamada a
	 * sendingDataToSumador.println(array2NumbersStrFormat), donde
	 * array2NumbersStrFormat es la cadena generada en el paso anterior.
	 * 
	 * En resumen, la función sendArrayInStringFormatToSumador() toma un array de
	 * números, lo convierte en una cadena en formato de matriz y la envía al
	 * proceso externo llamado "Sumador" a través de un flujo de salida. Esta
	 * función permite al programa principal comunicarse con el proceso externo y
	 * proporcionarle los datos necesarios para su funcionamiento.
	 */
	private static void sendArrayInStringFormatToSumador() {

		sendingDataToSumador = new PrintStream(Sumador.getOutputStream(), true);

		final String array2NumbersStrFormat = Arrays.toString(array2NumbersOfUser);

		sendingDataToSumador.println(array2NumbersStrFormat);
	}

	/**
	 * La función receivingAndPrintingResult() tiene la responsabilidad de recibir y
	 * imprimir el resultado enviado por el proceso externo llamado "Sumador". A
	 * continuación, te proporciono una explicación detallada de lo que hace esta
	 * función:
	 * 
	 * Creación de un Lector de Entrada: La función crea un lector de entrada
	 * llamado receiverDataFromSumador utilizando la clase BufferedReader. Este
	 * lector se utiliza para leer los datos que el proceso externo envía de vuelta
	 * al programa principal.
	 * 
	 * Inicialización de la Variable Resultado: La variable resultFromSumador se
	 * inicializa como null. Esta variable se utilizará para almacenar el resultado
	 * que se reciba del proceso externo o la mensaje FIN si el usuário ingresa dos
	 * zeros.
	 * 
	 * Lectura del Resultado del Proceso Externo: El operador ternario, denotado por
	 * ? :, es una forma abreviada de escribir una instrucción condicional en Java.
	 * Se utiliza para asignar un valor a una variable basado en una condición. Aquí
	 * se explica cómo funciona en esta línea específica:
	 * 
	 * La condición evaluada es bothNumbersAreNotZero(). Esta es una llamada a un
	 * método que verifica si ambos números ingresados por el usuario son diferentes
	 * de cero.
	 * 
	 * Si la condición es verdadera (es decir, si bothNumbersAreNotZero() devuelve
	 * true), se ejecuta la primera parte del operador ternario, que es
	 * receiverDataFromSumador.readLine(). Esto significa que se leerá una línea de
	 * texto del lector de entrada receiverDataFromSumador y se asignará a la
	 * variable resultFromSumador. En otras palabras, se captura el resultado
	 * enviado por el proceso externo.
	 * 
	 * Si la condición es falsa (es decir, si bothNumbersAreNotZero() devuelve
	 * false), se ejecuta la segunda parte del operador ternario, que es "FIN". Esto
	 * significa que se asignará la cadena de texto "FIN" a la variable
	 * resultFromSumador. En este caso, el proceso ha finalizado y se indica que no
	 * hay más resultados para mostrar.
	 * 
	 * @throws IOException
	 */
	private static void receivingAndPrintingResult() throws IOException {

		receiverDataFromSumador = new BufferedReader(new InputStreamReader(Sumador.getInputStream()));

		String resultFromSumador = null;

		resultFromSumador = bothNumbersAreNotZero() ? receiverDataFromSumador.readLine() : "\nFIN";

		System.out.println(resultFromSumador);
	}

	/**
	 * En esta función, se evalúa la condición lógica utilizando el operador lógico
	 * &&, que representa la conjunción lógica "Y". La función retorna true si ambas
	 * de las siguientes condiciones son verdaderas:
	 * 
	 * (1) array2NumbersOfUser[0] != 0: Esto verifica si el primer número almacenado
	 * en el índice 0 del array array2NumbersOfUser es diferente de cero.
	 * 
	 * (2) array2NumbersOfUser[1] != 0: Esto verifica si el segundo número
	 * almacenado en el índice 1 del array array2NumbersOfUser es diferente de cero.
	 * 
	 * Si ambas condiciones son verdaderas (es decir, si ambos números no son cero),
	 * la función bothNumbersAreNotZero() devuelve true. En otras palabras, esta
	 * función comprueba si ambos números ingresados por el usuario son diferentes
	 * de cero, lo que indica que el proceso debe continuar. Si al menos uno de los
	 * números es cero, la función devuelve false, lo que indica que el proceso debe
	 * finalizar.
	 * 
	 * @return TRUE Si ambas condiciones son verdaderas
	 */
	private static boolean bothNumbersAreNotZero() {

		return array2NumbersOfUser[0] != 0 && array2NumbersOfUser[0] != 0;
	}

	/**
	 * La función closeProcessSumador se encarga de realizar las operaciones
	 * necesarias para cerrar y limpiar adecuadamente los recursos relacionados con
	 * el proceso denominado "Sumador" que se inicia en el programa. Esta función se
	 * llama al final del programa Principal en el bloque finally para asegurarse de
	 * que se ejecuta incluso si ocurren excepciones.
	 * 
	 * Aquí está una explicación de las operaciones realizadas por
	 * closeProcessSumador:
	 * 
	 * scanner.close(): Cierra el objeto Scanner llamado scanner que se utiliza para
	 * leer la entrada del usuario. Esto asegura que el recurso de entrada se libere
	 * adecuadamente.
	 * 
	 * sendingDataToSumador.close(): Cierra el flujo de salida sendingDataToSumador
	 * que se utiliza para enviar datos al proceso "Sumador". Esto garantiza que el
	 * flujo de salida se cierre adecuadamente y que los datos se envíen por
	 * completo.
	 * 
	 * try...catch: Aquí se intenta cerrar el flujo de entrada
	 * receiverDataFromSumador, que se utiliza para recibir datos del proceso
	 * "Sumador". En caso de que ocurra una excepción de E/S (por ejemplo, si no se
	 * puede cerrar el flujo de entrada), se captura la excepción y se imprime la
	 * traza de la excepción. Esto asegura que cualquier recurso pendiente se cierre
	 * o maneje adecuadamente, incluso si se produce un error al hacerlo.
	 * 
	 * Sumador.destroy(): Esta línea de código llama al método destroy() en el
	 * objeto Sumador, que representa el proceso iniciado en el programa. La llamada
	 * a destroy() destruirá el proceso "Sumador" y liberará todos los recursos
	 * asociados a él. Esto es importante para asegurarse de que el proceso se
	 * cierre de manera ordenada y que no queden recursos en uso después de que el
	 * programa haya terminado de ejecutarse.
	 */
	private static void closeProcessSumador() {

		scanner.close();
		sendingDataToSumador.close();
		try {
			receiverDataFromSumador.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sumador.destroy();
	}
	
	/**
	 * Imprime el título del programa en la consola.
	 */
	private static void printTitulo() {
		System.out.println(TITULO);
	}

	// VARIABLES GLOBALES Y PRIVADAS DEL PROGRAMA
	private static final String TITULO = """
										SUMA DEL RANGO ENTRE 2 NÚMEROS
										      (ambos incluidos)
										            0 y 0
										            salir
										""";
	private static Process Sumador;
	private static final String RUTA_SUMADOR = "c:\\tempjava\\Sumador.jar";
	private static final int[] array2NumbersOfUser = new int[2];
	private static Scanner scanner = new Scanner(System.in);
	private static PrintStream sendingDataToSumador;
	private static BufferedReader receiverDataFromSumador;
}

