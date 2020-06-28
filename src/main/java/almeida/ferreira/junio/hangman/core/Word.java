package almeida.ferreira.junio.hangman.core;

public class Word {

	private static final char SECRET_CHAR = '_';
	private String originalWord;
	private char[] foundLetters;

	public Word(String oringinalWord) {
		this.originalWord = oringinalWord.toUpperCase();

		foundLetters = new char[oringinalWord.length()];

		for (int i = 0; i < foundLetters.length; i++) {
			foundLetters[i] = SECRET_CHAR;
		}
	}

	public boolean checkLetter(char letter) {

		letter = Character.toUpperCase(letter);

		int index = originalWord.indexOf(letter);

		if (index == -1) {
			return false;
		} else {

			while (index != -1) {

				foundLetters[index] = letter;
				index = originalWord.indexOf(letter, index + 1);
			}

			return true;
		}
	}

	public boolean foundWord() {
		for (int i = 0; i < foundLetters.length; i++) {
			if (foundLetters[i] == SECRET_CHAR) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String toString() {
		StringBuilder wordBuilder = new StringBuilder();

		for (int i = 0; i < foundLetters.length; i++) {

			wordBuilder.append(foundLetters[i]);
			wordBuilder.append(' ');
		}

		wordBuilder.deleteCharAt(wordBuilder.length() - 1);

		return wordBuilder.toString();
	}

	public String getOriginalWord() {
		return originalWord;
	}

	public int size() {
		return originalWord.length();
	}

}
