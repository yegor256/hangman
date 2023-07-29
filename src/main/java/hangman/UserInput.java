package hangman;

import java.io.InputStream;
import java.util.Scanner;

public class UserInput {
    private final InputStream stream;

    public UserInput(InputStream stream) {
        this.stream = stream;
    }

    public UserInput() {
        this.stream = System.in;
    }

    char letter() {
        System.out.print("Print a letter: ");
        return new Scanner(this.stream).next().charAt(0);
    }
}
