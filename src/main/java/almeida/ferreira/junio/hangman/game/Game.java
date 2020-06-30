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
		usedChars = new HashSet<>();
	}

	public void start(String[] args) {

		UI.printGameTitle();
		
		dictionary = Dictionary.getInstance();
		word = dictionary.getWord();
		
		usedChars.clear();
		
		if(args.length > 0) {
			Config.set("maxErrors", args[0]);
		}
		
		int maxErrors = Integer.parseInt(Config.get("maxErrors"));
		
		attempts = maxErrors;
		
		UI.printNewLine();
		UI.print("-Dicionário utilizado: " + dictionary.getName());
		UI.print("-A palavra possui " + word.size() + " letras.");
		UI.print("-Você pode errar no máximo " + maxErrors + " vez(es)");
		UI.print("======================================");

		char letter;

		while (true) {

			UI.printNewLine();
			UI.print("Você possui " + attempts + " tentativas");
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
				UI.print("ALERTA: A letra '" + letter + "' já foi utilizada.");
				continue;
			}

			if (!word.checkLetter(letter)) {
				attempts--;
			}

			usedChars.add(letter);

			if (word.foundWord() || attempts <= 0) {

				UI.printNewLine();

				if (attempts <= 0) {
					UI.print("Você perdeu o jogo ):");
				} else {
					UI.print("Parabéns, você ganhou o jogo!");
				}

				UI.print("A palavra era => " + word.getOriginalWord());
				UI.printNewLine();

				break;
			}
		}

	}

}