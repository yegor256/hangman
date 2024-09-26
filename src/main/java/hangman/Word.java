package hangman;

public class Word {
    private Letter[] letters;

    Word(String letters) {
        this.letters = new Letter[letters.length()];
        for (int i = 0; i < letters.length(); i++) {
            this.letters[i] = new Letter(letters.charAt(i));
        }
    }

    Word() {
        this(WordExamples.chooseRandomWord());
        for (int i = 0; i < letters.length; i++){
        }
    }

    void check(char letter) {
        for (Letter letterInWord : letters) {
            if (letterInWord.hasEqualValue(letter)) {
                letterInWord.open();
            }
        }
    }

    int getNumberOfClosedLetters() {
        int counter = 0;
        for (Letter letter : letters) {
            if (!letter.isVisible()) {
                counter++;
            }
        }
        return counter;
    }

    char[] showWord() {
        char[] hiddenWord = new char[letters.length];
        for (int i = 0; i < letters.length; i++) {
            if ((letters[i].isVisible())) {
                hiddenWord[i] = letters[i].getValue();
            } else {
                hiddenWord[i] = '?';
            }
        }
        return hiddenWord;
    }
}
