package hangman.guessing;

import java.io.OutputStream;
import java.io.PrintStream;

public class GuessResult implements Guess {
    private final Guess guess;
    private final OutputStream out;

    public GuessResult(Guess guess, OutputStream out) {
        this.guess = guess;
        this.out = out;
    }

    public GuessResult(Guess guess) {
        this(guess, System.out);
    }

    @Override
    public boolean make() {
        var isRight = guess.make();
        if (isRight) {
            new PrintStream(out).print("\nHit!\n");
        } else {
            new PrintStream(out).print("\nMiss!\n");
        }
        return isRight;
    }

    @Override
    public boolean wordIsRevealed() {
        return guess.wordIsRevealed();
    }
}
