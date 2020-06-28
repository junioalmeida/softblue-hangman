package almeida.ferreira.junio.hangman.utils;

import java.util.Random;

public class RandomUtils {
	
	private static Random random = new Random();
	
	public static int newRandomInt(int min, int max) {
		return random.nextInt(max - min) + min;
	}
}
