package actividad.tema02;

class MatrizFiller {
	private final int[][] matriz;
	private final int columnas;
	private final int filas;

	public MatrizFiller(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		this.matriz = new int[filas][columnas];
	}

	public int getColumnas() {
		return columnas;
	}

	public int getFilas() {
		return filas;
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public void setMatriz() {
		try {
			for (int i = 0; i < columnas; i++) {
				Thread t = new Thread(new ColumnFiller(matriz, i));
				t.start();
				t.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void printMatriz() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.printf("[%02d] ", matriz[i][j]);
			}
			System.out.println();
		}
	}

}