package hangman;

class InputCheck {
    private Word word;
    private final Guess guess;

    InputCheck(Word word, Guess guess) {
        this.word = word;
        this.guess = guess;
    }

    boolean isAttemptSuccessful() throws AllLettersGuessedException {
        char letterToCheck = guess.letter();
        int numberOfClosedLettersBeforeCheck = word.getNumberOfClosedLetters();
        word.check(letterToCheck);
        if (word.getNumberOfClosedLetters() == 0) {
            throw new AllLettersGuessedException();
        } else {
            return word.getNumberOfClosedLetters() != numberOfClosedLettersBeforeCheck;
        }
    }

    char[] showWord() {
        return word.showWord();
    }
}
