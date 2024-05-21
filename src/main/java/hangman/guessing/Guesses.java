package hangman.guessing;

import java.io.OutputStream;
import java.io.PrintStream;

public class Guesses {
    private final Guess guess;
    private final PrintStream out;
    private final int max = 5;

    public Guesses(Guess guess) {
        this(guess, System.out);
    }

    public Guesses(Guess guess, OutputStream out) {
        this.guess = guess;
        this.out = new PrintStream(out);
    }

    public boolean make() {
        int incorrectGuesses = 0;

        while (incorrectGuesses != max) {
            boolean correct = guess.make();

            if (!correct) {
                incorrectGuesses++;
                out.print("\nMistake " + incorrectGuesses + " out of " + max +
                        ".\n");
            } else if (guess.wordIsRevealed()) {
                return true;
            }
        }
        return false;
    }

}
