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

    public Game(Word word) {
        this.word = word;
    }

    public void playGame(OutputStream outputStream, InputStream inputStream) {
        try (final PrintStream out = new PrintStream(outputStream)) {
            final Iterator<String> scanner = new Scanner(inputStream);
            while (!word.maxMistakeReached()) {
                if (word.isAllCharVisible()) {
                    break;
                }
                out.print("Guess a letter: ");
                Round round = new Round(new Guess(scanner.next().charAt(0), word));
                round.play();
            }
            finalizeGame();
        }
    }

    private void finalizeGame() {
        if (word.isAllCharVisible()) {
            System.out.print("You won!\n");
        } else {
            System.out.print("You lost.\n");
        }
    }

}
