package hangman.game;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by mehyil on 5/26/2017.
 */
public class Game {

    private final Word word;

    private final int maxMistakes;

    private int mistakes;

    public Game(Word word, int maxMistakes) {
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
                Round round = new Round(word);
                boolean roundResult = round.playRound(new Guess(scanner.next().charAt(0)));
                printGameStatus(roundResult);
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

    private boolean isDone() {
        return word.isAllCharVisible();
    }

}