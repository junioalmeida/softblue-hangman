package almeida.ferreira.junio.hangman.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import almeida.ferreira.junio.hangman.game.GameException;
import almeida.ferreira.junio.hangman.utils.RandomUtils;

public class Dictionary {

	private static final String FILE_NAME = "dictionary.txt";
	
	private static Dictionary instance;
	
	private List<String> dictionary;

	
	private Dictionary() {
		dictionary = new ArrayList<>();
		loadDictionary();
	}
	
	public static Dictionary getInstance() {
		if(instance == null) {
			instance = new Dictionary();
		}
		return instance;
	}

	public Word getRandomWord() {
		
		int index = RandomUtils.newRandomInt(0, dictionary.size());
		
		return new Word(dictionary.get(index));
	}

	private void loadDictionary() {
		try (Scanner scanner = new Scanner(getClass().getResourceAsStream(FILE_NAME))) {
			
			while(scanner.hasNextLine()) {
				dictionary.add(scanner.nextLine());
			}
			
			if(dictionary.size() == 0) {
				throw new GameException("A lista não pode ser vazia.");
			}
		}
	}

}
