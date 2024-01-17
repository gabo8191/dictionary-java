package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.model.Dictionary;
import co.edu.uptc.view.DictionaryFrame;

public class Presenter implements ActionListener {
	private DictionaryFrame view;
	private Dictionary dictionary;

	public Presenter() {
		view = new DictionaryFrame(this);
		dictionary = new Dictionary();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch (command) {
			case "translateToEnglish":
				handleTranslateToEnglish();
				break;

			case "TranslateToFrench":
				handleTranslateToFrench();
				break;

			case "addEnglish":
				handleAddEnglish();
				break;

			case "addFrench":
				handleAddFrench();
				break;

			default:
				break;
		}
	}

	public void handleTranslateToEnglish() {
		String word = view.getWordInput();
		String translate = dictionary.translateToEnglish(word);
		view.setEnglishWord(translate);
		if (translate == null) {
			view.setEnglishWord("No se encontró la palabra");
		}
		int quantityEnglish = dictionary.countEnglishWords();
		view.setQuantityEnglish(quantityEnglish);
	}

	public void handleTranslateToFrench() {
		String word = view.getWordInput();
		String translate = dictionary.translateToFrench(word);
		view.setFrenchWord(translate);
		if (translate == null) {
			view.setFrenchWord("No se encontró la palabra");
		}
		int quantity = dictionary.countFrenchWords();
		view.setQuantityFrench(quantity);
	}

	public void handleAddEnglish() {
		String spanishWord = view.getSpanishWordInput();
		String englishWord = view.getTranslateInput();

		if (spanishWord.equals("")) {
			view.setSpanishWordInput("No se puede agregar una palabra vacía");
		} else if (englishWord.equals("")) {
			view.setTranslateInput("No se puede agregar una palabra vacía");
		} else {
			dictionary.addEnglishWord(spanishWord, englishWord);
			view.setSpanishWordInput("");
			view.setTranslateInput("");
		}
	}

	public void handleAddFrench() {
		String spanishWord = view.getSpanishWordInput();
		String frenchWord = view.getTranslateInput();

		if (spanishWord.equals("")) {
			view.setSpanishWordInput("No se puede agregar una palabra vacía");
		} else if (frenchWord.equals("")) {
			view.setTranslateInput("No se puede agregar una palabra vacía");
		} else {
			dictionary.addFrenchWord(spanishWord, frenchWord);
			view.setSpanishWordInput("");
			view.setTranslateInput("");
		}
	}

	public static void main(String[] args) {
		new Presenter();
	}

}
