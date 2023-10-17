package actividad.tema02;

import java.util.Scanner;

public class MatrizSearcher {
    private final int[][] matriz;
    private int numeroBusqueda;

    public MatrizSearcher(MatrizFiller matrizEjercicio02) {
        matriz = matrizEjercicio02.getMatriz();
    }
    public MatrizSearcher(int[][] matriz) {
    	this.matriz = matriz;
    }

    public void buscarNumeroEnMatriz() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEscribe el número a buscar (0-99): ");
        numeroBusqueda = scanner.nextInt();
        scanner.close();
        System.out.print("\n");

        for (int i = 0; i < matriz[0].length; i++) {
            Thread t = new Thread(new ColumnSearcher(matriz, i, numeroBusqueda));
            t.start();
        }
    }
}
