package actividad.tema02.Kute;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomBoolean {

	private static boolean previousBoolean = false;
	private static Random random = new Random();

	public static boolean getNonRepeatingRandomBoolean() {
		return previousBoolean = (previousBoolean) ? false : random.ints(0, 3).findFirst().getAsInt() == 0;
	}

	public static void main(String[] args) {
		IntStream.range(0, 10).forEach(i -> System.out.println(getNonRepeatingRandomBoolean()));
	}
}
