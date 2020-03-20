package hangman;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

public class Guess {
    char letter(InputStream input, PrintStream out) {
        final Iterator<String> scanner = new Scanner(input);
        out.print("Guess a letter: ");
        char chr = scanner.next().charAt(0);
        return chr;
    }
}
