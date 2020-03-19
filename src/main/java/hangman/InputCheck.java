package hangman;

public class InputCheck {
    private Word word;
    private final Guess guess = new Guess();

    InputCheck(Word word) { ;
        this.word = word;
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
}
