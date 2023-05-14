package hangman;

import hangman.exceptions.WordAlreadyOpenException;

/**
 * Created by teSGreat on 24.05.2017.
 */
public class WordKeeper implements IWordKeeper {

    private final char[] word;
    private final boolean[] visible;

    public WordKeeper(String word) {

        this.visible = new boolean[word.length()];
        this.word = word.toCharArray();
    }

    @Override
    public boolean findLetter(char letter) throws WordAlreadyOpenException {

        if (isOpen()) {
            throw new WordAlreadyOpenException();
        }
        boolean find = false;
        for (int i = 0; i < word.length; ++i) {
            if (word[i] == letter && !visible[i]) {
                visible[i] = true;
                find = true;
            }
        }
        return find;
    }

    @Override
    public boolean isOpen() {

        for (boolean chv : visible) {
            if (!chv) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {

        String strWord = "";
        for (int i = 0; i < word.length; i++) {
            strWord += visible[i] ? word[i] : '?';
        }
        return "The word: " + strWord;
    }
}
