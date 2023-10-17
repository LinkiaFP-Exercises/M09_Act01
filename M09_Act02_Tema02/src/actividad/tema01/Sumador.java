package actividad.tema01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Este programa Sumador permite calcular la suma de todos los números en un
 * rango entre dos números ingresados por el usuario.
 * 
 * El programa sigue los siguientes pasos: 1. Lee dos números ingresados por el
 * usuario. 2. Calcula la suma de todos los números en el rango entre los dos
 * números ingresados. 3. Imprime el resultado de la suma.
 * 
 * El programa maneja tanto rangos ascendentes como descendentes, y muestra la
 * suma total.
 *
 * @author <a href="https://about.me/prof.guazina">Fauno Guazina</a>
 * @since 05/10/2023
 * @version 1.1
 */
public class Sumador {

	public static void main(String[] args) {

		catch2NumbersOfUser_ConvertInIntArray();
		doTheSumOfRangeBetweenBothNumbers();
		printResultMessage();

	}

	/**
	 * La función catch2NumbersOfUser_ConvertInIntArray es responsable de leer dos
	 * números ingresados por el usuario y luego convertirlos en un arreglo de
	 * enteros (Integer[]). Aquí está la explicación detallada de lo que hace esta
	 * función:
	 * 
	 * Dentro de la función catch2NumbersOfUser_ConvertInIntArray, se utiliza un
	 * bloque try-catch para manejar posibles excepciones de tipo IOException. Esto
	 * es importante porque la función interactúa con la entrada del usuario y puede
	 * generar errores de lectura.
	 * 
	 * Dentro del bloque try, se utiliza la clase Arrays junto con las operaciones
	 * stream y map para realizar la conversión de los números ingresados por el
	 * usuario en una cadena de texto en un arreglo de enteros. Veamos cómo funciona
	 * este proceso paso a paso:
	 * 
	 * read2NumbersOfUser(): Esta función se llama para leer la entrada del usuario.
	 * La entrada se espera que esté en el formato de dos números separados por una
	 * coma (por ejemplo, "5,10").
	 * 
	 * .split(","): Se divide la cadena de entrada en dos partes utilizando la coma
	 * como separador. Esto crea un arreglo de cadenas de texto, donde cada elemento
	 * del arreglo contiene uno de los números ingresados.
	 * 
	 * .map(Integer::parseInt): Se aplica la función parseInt de la clase Integer a
	 * cada elemento del arreglo de cadenas de texto. Esto convierte cada cadena de
	 * número en una representación entera.
	 * 
	 * .toArray(Integer[]::new): Finalmente, se convierte el flujo de enteros en un
	 * arreglo de enteros (Integer[]) utilizando el método toArray. El resultado es
	 * un arreglo que contiene los dos números ingresados por el usuario.
	 * 
	 * Si ocurre una excepción IOException, se manejará dentro del bloque catch,
	 * donde se imprime el rastreo de la pila de la excepción utilizando
	 * e.printStackTrace().
	 * 
	 * En resumen, la función catch2NumbersOfUser_ConvertInIntArray lee dos números
	 * ingresados por el usuario como una cadena de texto, los divide en dos partes,
	 * los convierte en enteros y los almacena en un arreglo. Esto prepara los
	 * números para ser utilizados en el cálculo de la suma posteriormente en el
	 * programa.
	 */
	private static void catch2NumbersOfUser_ConvertInIntArray() {

		try {

			array = Arrays.stream(read2NumbersOfUser().split(","))
							.map(Integer::parseInt)
								.toArray(Integer[]::new);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * La función read2NumbersOfUser tiene la responsabilidad de leer la entrada del
	 * usuario, que se espera que contenga dos números separados por una coma. Aquí
	 * tienes una explicación detallada de lo que hace esta función:
	 * 
	 * Se declara una variable llamada inputData del tipo BufferedReader. Esta
	 * variable se utiliza para leer datos desde la entrada estándar (teclado).
	 * 
	 * Se crea una instancia de BufferedReader utilizando new BufferedReader(new
	 * InputStreamReader(System.in)). Esto permite leer datos desde la entrada
	 * estándar (teclado) mediante la clase BufferedReader.
	 * 
	 * Se declara una variable llamada textData del tipo String. Esta variable se
	 * utilizará para almacenar la cadena de texto ingresada por el usuario.
	 * 
	 * Se llama al método readLine() de inputData. Este método espera a que el
	 * usuario ingrese una línea de texto y presione la tecla "Enter". Luego, lee la
	 * línea de texto completa y la almacena en la variable textData.
	 * 
	 * Se utiliza el método replaceAll("[^0-9,-]+", "") para eliminar cualquier
	 * caracter que no sea numeros (negativos o positivos) y comas de la cadena de
	 * texto ingresada por el programa principal. Esto es útil para asegurarse de
	 * que la entrada esté en el formato esperado y no contenga caracteres no
	 * deseados.
	 * 
	 * Finalmente, se cierra el objeto inputData utilizando el método close() para
	 * liberar los recursos asociados a la lectura de la entrada estándar.
	 * 
	 * En resumen, la función read2NumbersOfUser lee una línea de texto ingresada
	 * por el usuario desde la entrada estándar (teclado), elimina espacios en
	 * blanco y corchetes, y devuelve la cadena de texto resultante. Esta cadena de
	 * texto se espera que contenga dos números separados por una coma, como por
	 * ejemplo "5,10". Esta entrada luego se procesa para convertirla en un arreglo
	 * de enteros que se utilizará en el cálculo de la suma.
	 * 
	 * @returnUna cadena de texto que contiene los números ingresados por el
	 *            usuario, separados por coma y sin espacio.
	 * @throws IOException
	 */
	private static String read2NumbersOfUser() throws IOException {

		BufferedReader inputData = new BufferedReader(new InputStreamReader(System.in));
		String textData = inputData.readLine().replaceAll("[^0-9,-]+", "");
		inputData.close();

		return textData;
	}

	/**
	 * La función doTheSumOfRangeBetweenBothNumbers realiza la suma de todos los
	 * números en el rango entre los dos números almacenados en el arreglo array.
	 * Aquí está la explicación paso a paso:
	 * 
	 * Se determina el número más pequeño entre array[0] y array[1] utilizando
	 * Math.min(array[0], array[1]) y se almacena en la variable start.
	 * 
	 * Se determina el número más grande entre array[0] y array[1] utilizando
	 * Math.max(array[0], array[1]) y se almacena en la variable end.
	 * 
	 * Se inicializa una variable i con el valor de start. Esta será la variable de
	 * control del bucle for.
	 * 
	 * Se inicia un bucle for que comienza con i igual a start y continúa mientras i
	 * sea menor o igual a end.
	 * 
	 * En cada iteración del bucle, se suma el valor actual de i a la variable suma.
	 * Esto acumula la suma de todos los números en el rango.
	 * 
	 * El bucle continúa hasta que i sea mayor que end, momento en el que la suma
	 * habrá acumulado el resultado de sumar todos los números en el rango entre
	 * start y end.
	 * 
	 * En resumen, esta función calcula la suma de todos los números en el rango
	 * entre los dos números almacenados en array[0] y array[1], sin importar cuál
	 * de los dos números sea mayor o menor.
	 */
	private static void doTheSumOfRangeBetweenBothNumbers() {

		int start = Math.min(array[0], array[1]);
		int end = Math.max(array[0], array[1]);

		for (int i = start; i <= end; i++) {
			suma += i;
		}
	}

	/**
	 * La función printResultMessage es responsable de imprimir un mensaje en la
	 * consola que muestra el resultado de la suma de los números contenidos en el
	 * arreglo array. Aquí tienes una explicación detallada de cómo funciona esta
	 * función:
	 * 
	 * La función comienza declarando una variable de tipo String llamada
	 * resultMessage. Esta variable se utilizará para construir el mensaje que se
	 * mostrará en la consola.
	 * 
	 * Dentro de resultMessage, se concatena la cadena "La suma de los números
	 * entre" con el valor de array[0], seguido de la cadena "y" y luego el valor de
	 * array[1]. Esto crea una cadena que describe el rango de números cuya suma se
	 * está mostrando.
	 * 
	 * Luego, se agrega la cadena " es: " a resultMessage. Esto prepara el mensaje
	 * para mostrar la suma que se calculará a continuación.
	 * 
	 * La función agrega el valor de la variable suma a resultMessage. Esto completa
	 * el mensaje con la suma calculada.
	 * 
	 * Finalmente, la función utiliza System.out.println(resultMessage) para
	 * imprimir el mensaje completo en la consola. El mensaje mostrará el rango de
	 * números y la suma de esos números.
	 * 
	 * En resumen, la función printResultMessage crea un mensaje descriptivo que
	 * muestra el rango de números y la suma de esos números, y luego imprime ese
	 * mensaje en la consola. Esto permite al usuario ver el resultado de la
	 * operación de suma.
	 */
	private static void printResultMessage() {

		String resultMessage = "La suma de los numeros entre " 
									+ array[0] + " y " + array[1] 
										+ " es: " + suma;

		System.out.println(resultMessage);
	}

	// VARIABLES GLOBALES Y PRIVADAS DEL PROGRAMA
	private static Integer[] array;
	private static int suma = 0;
}
