package hangman;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

public class Guess {
    private final InputStream input;

    Guess(InputStream in) {
        this.input = in;
    }

    char letter(PrintStream out) {
        final Iterator<String> scanner = new Scanner(input);
        out.print("Guess a letter: ");
        char chr = scanner.next().charAt(0);
        return chr;
    }
}
