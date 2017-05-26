package hangman.game;

/**
 * Created by mehyil on 5/26/2017.
 */
public class Round {

    private final Guess guess;

    private final Word word;

    public Round(Word word, Guess guess) {
        this.word = word;
        this.guess = guess;
    }

    public void play() {
        boolean result = word.makeAGuess(guess);
        printResult(result);
        word.print();
    }

    private void printResult(boolean result) {
        if (result) {
            System.out.print("Hit!\n");
        } else {
            System.out.printf("Missed, mistake #%d out of %d\n", word.getMistakes(), word.getMaxMistake());
        }
    }
}
