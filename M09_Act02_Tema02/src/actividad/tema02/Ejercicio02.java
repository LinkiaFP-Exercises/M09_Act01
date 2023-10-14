package actividad.tema02;

public class Ejercicio02 {

	public static void main(String[] args) {
		int filas = 20;
		int columnas = 10;
		MatrizFiller matrizEjercicio02 = new MatrizFiller(filas, columnas);
		matrizEjercicio02.setMatriz();
		matrizEjercicio02.printMatriz();
		new MatrizSearcher(matrizEjercicio02).buscarNumeroEnMatriz();

	}

}
