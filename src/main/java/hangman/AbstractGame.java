package hangman;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

/**
 * Hangman game.
 */
public interface AbstractGame {
    /**
     * The hidden word.
     *
     * @return The hidden word
     */
    AbstractWord word();

    /**
     * Maximum number of mistakes.
     *
     * @return Maximum number of mistakes
     */
    Integer mistakes();

    /**
     * Input stream scanner.
     *
     * @return Input stream scanner
     */
    Scanner input();

    /**
     * Output stream.
     *
     * @return Output stream
     */
    PrintStream output();

    /**
     * Attempts to guess the word.
     *
     * @return List of guesses
     */
    List<AbstractGuess> guesses();

    /**
     * Run game.
     *
     * @throws Exception When something is wrong
     */
    void run() throws Exception;
}
