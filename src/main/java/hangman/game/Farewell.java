package hangman.game;

import hangman.guessing.Guesses;

import java.io.OutputStream;
import java.io.PrintStream;

public class Farewell {
    private final Guesses guesses;
    private final PrintStream out;

    public Farewell(Guesses guesses, OutputStream out) {
        this.guesses = guesses;
        this.out = new PrintStream(out);
    }

    public Farewell(Guesses guesses) {
        this(guesses, System.out);
    }

    public void say() {
        if (guesses.make()) {
            out.print("\nYou won! Thanks for playing.");
        } else {
            out.print("\nYou lost! Better luck next time.\n");
        }
    }
}
