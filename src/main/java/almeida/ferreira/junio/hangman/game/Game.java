package almeida.ferreira.junio.hangman.game;

import java.util.HashSet;
import java.util.Set;

import almeida.ferreira.junio.hangman.core.Config;
import almeida.ferreira.junio.hangman.core.Dictionary;
import almeida.ferreira.junio.hangman.core.InvalidCharacterException;
import almeida.ferreira.junio.hangman.core.Word;
import almeida.ferreira.junio.hangman.ui.UI;

public class Game {

	private Dictionary dictionary;
	private Word word;
	private int attempts;

	private Set<Character> usedChars;

	public Game() {
		dictionary = Dictionary.getInstance();
		usedChars = new HashSet<>();
	}

	public void start() {

		UI.printGameTitle();

		word = dictionary.getRandomWord();
		int maxErrors = Integer.parseInt(Config.get("maxErrors"));
		
		attempts = maxErrors;
		
		UI.printNewLine();
		UI.print("A palavra possui " + word.size() + " letras.");
		UI.print("Voc� pode errar no m�ximo " + maxErrors + " vez(es)");

		char letter;

		while (true) {

			UI.printNewLine();
			UI.print("Voc� possui " + attempts + " tentativas");
			UI.printTextWithoutNewLine("Palavra => ");
			UI.print(word);
			UI.printNewLine();

			try {
				letter = Character.toUpperCase(UI.readChar("Letra: "));
			} catch (InvalidCharacterException e) {
				UI.printTextWithoutNewLine("Erro: ");
				UI.print(e.getMessage());
				continue;
			}

			if (usedChars.contains(letter)) {
				UI.printNewLine();
				UI.print("ALERTA: A letra '" + letter + "' j� foi utilizada.");
				continue;
			}

			if (!word.checkLetter(letter)) {
				attempts--;
			}

			usedChars.add(letter);

			if (word.foundWord() || attempts <= 0) {

				UI.printNewLine();

				if (attempts <= 0) {
					UI.print("Voc� perdeu o jogo ):");
				} else {
					UI.print("Parab�ns, voc� ganhou o jogo!");
				}

				UI.print("A palavra era => " + word.getOriginalWord());
				UI.printNewLine();

				break;
			}
		}

	}

}