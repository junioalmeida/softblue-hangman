package almeida.ferreira.junio.hangman.core;

import java.util.List;

public class StaticDictionary extends Dictionary {

	private List<String> words = List.of("casa", "carro", "administracao", "sistema", "computador");
	private int currentIndex = -1;
	
	@Override
	public Word getWord() {
		currentIndex = (currentIndex + 1) % words.size();
		return new Word(words.get(currentIndex));
	}

	@Override
	public String getName() {
		return "Estático";
	}

}
