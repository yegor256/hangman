package hangman.game;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by mehyil on 5/26/2017.
 */
public class HangmanGame {

    private final HangmanWord word;

    private final int maxMistakes;

    private int mistakes;

    public HangmanGame(HangmanWord word, int maxMistakes) {
        this.maxMistakes = maxMistakes;
        this.word = word;
    }

    public void playGame(OutputStream outputStream, InputStream inputStream) {
        try (final PrintStream out = new PrintStream(outputStream)) {
            final Iterator<String> scanner = new Scanner(inputStream);
            while (!isMaxMistakeReached()) {
                if (isDone()) {
                    break;
                }
                out.print("Guess a letter: ");
                char chr = scanner.next().charAt(0);
                printGameStatus(makeAGuess(new Guess(chr)));
            }
            finalizeGame();
        }
    }

    private void finalizeGame() {
        if (isDone()) {
            System.out.print("You won!\n");
        } else {
            System.out.print("You lost.\n");
        }
    }

    private boolean isMaxMistakeReached() {
        if (mistakes == maxMistakes) {
            return true;
        }
        return false;
    }

    private void printGameStatus(boolean hit) {
        if (hit) {
            System.out.print("Hit!\n");
        } else {
            System.out.printf("Missed, mistake #%d out of %d\n", mistakes + 1, this.maxMistakes);
            ++mistakes;
        }
        word.print();
    }

    private boolean makeAGuess(Guess guess) {
        return word.makeAGuess(guess);
    }

    private boolean isDone() {
        return word.isAllCharVisible();
    }

}
