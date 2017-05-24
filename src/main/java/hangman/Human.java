package hangman;

import java.util.Scanner;

class Human {
    private final Scanner scanner;

    Human() {
        scanner = new Scanner(System.in);
    }

    char say() {
        return scanner.next().charAt(0);
    }
}
