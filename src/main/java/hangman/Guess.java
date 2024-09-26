package hangman;

import java.io.InputStream;
import java.util.Scanner;

class Guess {
    private final Scanner scanner;

    public Guess(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    char letter() {
        System.out.print("Guess a letter: ");
        return scanner.next().charAt(0);
    }
}
