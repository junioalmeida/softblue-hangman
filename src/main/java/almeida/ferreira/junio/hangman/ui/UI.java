package almeida.ferreira.junio.hangman.ui;

import java.util.Scanner;

import almeida.ferreira.junio.hangman.core.InvalidCharacterException;

public class UI {

	public static void print(Object obj) {
		System.out.println(obj);
	}

	public static void printTextWithoutNewLine(Object obj) {
		System.out.print(obj);
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static void printGameTitle() {
		print("=================");
		print("| JOGO DA FORCA |");
		print("=================");
		printNewLine();
	}

	
	public static char readChar(String text) throws InvalidCharacterException {
		System.out.print(text + " ");

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);

		String str = keyboard.nextLine();

		if (str.trim().isEmpty()) {
			throw new InvalidCharacterException("Nenhuma letra foi digitada.");
		}
		
		if(str.length() >  1) {
			throw new InvalidCharacterException("Apenas uma letra deve ser digitada.");
		}
		
		char c = str.charAt(0);
		
		if(!Character.isLetter(c)) {
			throw new InvalidCharacterException("Apenas letras devem ser digitadas.");
		}
		
		return c;

	}

}
