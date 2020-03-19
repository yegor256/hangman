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
        WordExamples wordExamples = new WordExamples();
        new Word(wordExamples.chooseRandomWord());
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

    void showWord() {
        System.out.append("The word: ");
        for (int i = 0; i < letters.length; i++) {
            if ((letters[i].isVisible())) {
                letters[i].printValue();
            } else {
                System.out.print("?");
            }
        }
        System.out.append("\n\n");
    }
}
