package hangman;

import java.io.InputStream;
import java.util.Scanner;

public class Guess {
    private final InputStream stream;

    public Guess(InputStream stream) {
        this.stream = stream;
    }

    public Guess() {
        this.stream = System.in;
    }

    char letter() {
        System.out.print("Guess a letter: ");
        return new Scanner(this.stream).next().charAt(0);
    }
}
