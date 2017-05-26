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

    private final GameState gameState;

    public Game(GameState gameState) {
        this.gameState = gameState;
    }

    public void playGame(OutputStream outputStream, InputStream inputStream) {
        try (final PrintStream out = new PrintStream(outputStream)) {
            final Iterator<String> scanner = new Scanner(inputStream);
            while (!gameState.isMaxMistakeReached()) {
                if (gameState.isDone()) {
                    break;
                }
                out.print("Guess a letter: ");
                Round round = new Round(new Guess(scanner.next().charAt(0)));
                round.playRound(gameState);
                gameState.print();
            }
            gameState.finalizeGame();
        }
    }


}
