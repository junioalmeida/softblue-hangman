package almeida.ferreira.junio.hangman.core;

@SuppressWarnings("serial")
public class InvalidCharacterException extends Exception {

	public InvalidCharacterException(String message) {
		super(message);
	}
}
