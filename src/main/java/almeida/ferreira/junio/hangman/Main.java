package almeida.ferreira.junio.hangman;

import almeida.ferreira.junio.hangman.core.InvalidCharacterException;
import almeida.ferreira.junio.hangman.game.Game;
import almeida.ferreira.junio.hangman.ui.UI;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();

		char choice = 'S';
		boolean firstTime = true;

		while (true) {

			if (!firstTime) {
				try {
					choice = UI.readChar("Deseja jogar novamente? (S/N): ");
				} catch (InvalidCharacterException e) {
					UI.printTextWithoutNewLine("Erro: ");
					UI.print(e.getMessage());
					UI.printNewLine();
					continue;
				}
			}

			if (Character.toUpperCase(choice) == 'S') {
				game.start();
			} else if (Character.toUpperCase(choice) == 'N') {
				UI.printNewLine();
				UI.print("Fim do Jogo!");
				break;
			} else {
				UI.printNewLine();
				UI.print("A opção escolhida é inválida.");
			}

			firstTime = false;
		}
	}
}
