package hangman.guessing;

import hangman.word.Word;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * This class is meant to take an InputStream which goes inside a Scanner.
 * Testing is done by injecting an inputstream into it with some predefined
 * values separated by \n. If the input is empty, then the scanner will throw
 * an exception. The users of this class should be aware of this.
 */
public class UserGuess implements Guess {
    private final Word word;
    private final PrintStream printStream;
    private final Scanner scanner;

    public UserGuess(Word word, InputStream in, OutputStream out) {
        this.word = word;
        printStream = new PrintStream(out);
        scanner = new Scanner(in);
    }

    public UserGuess(Word word) {
        this(word, System.in, System.out);
    }

    /**
     * Takes user input and says whether it was a hit or miss.
     *
     * @return true if word has letter (first character of inStream), else
     * false
     */
    @Override
    public boolean make() {
        printStream.print(word + "\nGuess a letter: ");
        char c = scanner.next().charAt(0);
        return word.guess(c);
    }

    @Override
    public boolean wordIsRevealed() {
        return word.revealed();
    }

}
