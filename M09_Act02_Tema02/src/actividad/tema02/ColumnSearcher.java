package actividad.tema02;

public class ColumnSearcher implements Runnable {
	private int[][] matriz;
	private int columna;
	private int numeroBusqueda;

	public ColumnSearcher(int[][] matriz, int columna, int numeroBusqueda) {
		this.matriz = matriz;
		this.columna = columna;
		this.numeroBusqueda = numeroBusqueda;
	}

	@Override
	public void run() {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][columna] == numeroBusqueda) {
            	String hilo = Thread.currentThread().getName();
            	System.out.printf("Hilo: %s Posición: [%02d][%02d]%n", hilo.charAt(hilo.length()-1), i, columna);
            }
        }
	}
}
