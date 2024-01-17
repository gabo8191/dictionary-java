package co.edu.uptc.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WordPanel extends JPanel {
	private JLabel wordLabel;
	private JTextArea wordInput;
	private JButton toEnglish;
	private JTextArea englishWord;
	private JButton toFrench;
	private JTextArea frenchWord;

	public WordPanel(ActionListener listener) {
		initComponents(listener);
	}

	public void initComponents(ActionListener listener) {
		this.setLayout(new GridLayout(3, 2, 5, 5));

		wordLabel = new JLabel("Palabra: ");
		add(wordLabel);

		wordInput = new JTextArea();
		add(wordInput);

		toEnglish = new JButton("Traducir al inglés");
		toEnglish.addActionListener(listener);
		toEnglish.setActionCommand("translateToEnglish");
		add(toEnglish);

		englishWord = new JTextArea();
		add(englishWord);

		toFrench = new JButton("Traducir al francés");
		toFrench.addActionListener(listener);
		toFrench.setActionCommand("TranslateToFrench");
		add(toFrench);

		frenchWord = new JTextArea();
		add(frenchWord);
	}

	public JLabel getWordLabel() {
		return wordLabel;
	}

	public void setWordLabel(JLabel wordLabel) {
		this.wordLabel = wordLabel;
	}

	public JTextArea getWordInput() {
		return wordInput;
	}

	public void setWordInput(JTextArea wordInput) {
		this.wordInput = wordInput;
	}

	public JButton getToEnglish() {
		return toEnglish;
	}

	public void setToEnglish(JButton toEnglish) {
		this.toEnglish = toEnglish;
	}

	public JTextArea getEnglishWord() {
		return englishWord;
	}

	public void setEnglishWord(JTextArea englishWord) {
		this.englishWord = englishWord;
	}

	public JButton getToFrench() {
		return toFrench;
	}

	public void setToFrench(JButton toFrench) {
		this.toFrench = toFrench;
	}

	public JTextArea getFrenchWord() {
		return frenchWord;
	}

	public void setFrenchWord(JTextArea frenchWord) {
		this.frenchWord = frenchWord;
	}

}
