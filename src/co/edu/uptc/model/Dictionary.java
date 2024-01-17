package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private List<Word> wordList;

    public Dictionary() {
        wordList = new ArrayList<>();
        loadData();
    }

    public void loadData() {
        Word word = new Word("hola");
        word.addTranslate("hello");
        word.addTranslate("bonjour");
        wordList.add(word);

        word = new Word("casa");
        word.addTranslate("house");
        word.addTranslate("maison");
        wordList.add(word);

        word = new Word("perro");
        word.addTranslate("dog");
        word.addTranslate("chien");
        wordList.add(word);

        word = new Word("gato");
        word.addTranslate("cat");
        wordList.add(word);

    }

    public Word searchWord(String word) {
        Word wordAux = null;
        for (Word wordAux1 : wordList) {
            if (wordAux1.getWord().equalsIgnoreCase(word)) {
                wordAux = wordAux1;
            }
        }
        return wordAux;
    }

    public void addEnglishWord(String spanishWord, String englishWord) {
        Word wordAux = searchWord(spanishWord.toLowerCase());
        if (wordAux == null) {
            wordAux = new Word(spanishWord.toLowerCase());
            wordAux.addTranslate(englishWord.toLowerCase());
            wordList.add(wordAux);
        } else {
            wordAux.addTranslate(englishWord.toLowerCase());
        }
    }

    public void addFrenchWord(String spanishWord, String frenchWord) {
        Word wordAux = searchWord(spanishWord.toLowerCase());
        if (wordAux == null) {
            wordAux = new Word(spanishWord.toLowerCase());
            wordAux.addTranslate(null);
            wordAux.addTranslate(frenchWord.toLowerCase());
            wordList.add(wordAux);
        } else {
            wordAux.addTranslate(frenchWord.toLowerCase());
        }

    }

    public String translateToEnglish(String word) {
        Word wordAux = searchWord(word.toLowerCase());
        if (wordAux != null) {
            return wordAux.getTranslate().get(0);
        }
        return null;
    }

    public String translateToFrench(String word) {
        Word wordAux = searchWord(word.toLowerCase());
        if (wordAux != null) {
            return wordAux.getTranslate().get(1);
        }
        return null;
    }

    public int countEnglishWords() {
        int count = 0;
        for (Word word : wordList) {
            if (word.getTranslate().size() > 0 && word.getTranslate().get(0) != null) {
                count++;
            }
        }

        return count;
    }

    public int countFrenchWords() {
        int count = 0;
        for (Word word : wordList) {
            if (word.getTranslate().size() > 1 && word.getTranslate().get(1) != null) {
                count++;
            }
        }

        return count;
    }

}
