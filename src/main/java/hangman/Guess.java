package hangman;

import java.util.Scanner;

public class Guess {
    private final Scanner scanner = new Scanner(System.in);

    char letter() {
        System.out.print("Guess a letter: ");
        return scanner.next().charAt(0);
    }
}
