package hangman;

import hangman.exceptions.HangmanAlreadyWinnerException;
import hangman.exceptions.HangmanIsDeadException;
import hangman.exceptions.HitNotAllowedException;
import hangman.exceptions.WordAlreadyOpenException;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by teSGreat on 24.05.2017.
 */
public class SuperHangman implements IHangman {

    private final IWordKeeper wordKeeper;
    private final Iterator<String> input;
    private final PrintStream output;
    private final int maxErrors;
    private int errors;

    public SuperHangman(IWordKeeper wordKeeper, int maxErrors, InputStream input, OutputStream output) {

        this.wordKeeper = wordKeeper;
        this.maxErrors = maxErrors;
        this.input = new Scanner(input);
        this.output = new PrintStream(output);
    }

    public SuperHangman(IWordKeeper wordKeeper, int maxErrors, InputStream input) {
        this(wordKeeper, maxErrors, input, System.out);
    }

    public SuperHangman(IWordKeeper wordKeeper, int maxErrors) {
        this(wordKeeper, maxErrors, System.in, System.out);
    }

    public SuperHangman(IWordKeeper wordKeeper) {
        this(wordKeeper, 0);
    }

    @Override
    public void trySurvive() {

        do {
            output.print("Guess a letter: ");
            if (!input.hasNext()) {
                break;
            }
            char letter = input.next().charAt(0);
            try {
                hitMe(letter);
            } catch (HitNotAllowedException ex) {
                output.print(ex.getMessage());
                break;
            }
            output.println(this);
            if (!isAlive()) {
                output.println("You lost.");
                break;
            } else if (winner()) {
                output.println("You won!");
                break;
            }
        } while (true);
    }

    @Override
    public void hitMe(char letter) throws HitNotAllowedException {

        if (!isAlive()) {
            throw new HangmanIsDeadException();
        }
        try {
            if (wordKeeper.findLetter(letter)) {
                output.println("Hit!");
            } else {
                errors++;
                output.println("Missed, mistake #" + errors + " out of " + maxErrors);
            }
        } catch (WordAlreadyOpenException e) {
            throw new HangmanAlreadyWinnerException();
        }

    }

    @Override
    public boolean isAlive() {
        return errors < maxErrors || (errors == 0 && maxErrors == 0);
    }

    @Override
    public boolean winner() {
        return wordKeeper.isOpen();
    }

    @Override
    public int attemptsRemained() {
        return maxErrors - errors;
    }

    @Override
    public String toString() {
        return wordKeeper.toString();
    }
}

