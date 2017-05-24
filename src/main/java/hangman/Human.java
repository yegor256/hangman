package hangman;

import java.util.Scanner;

class Human {
    private final Scanner scanner;

    Human(final Scanner scanner) {
        this.scanner = scanner;
    }

    char say() {
        return scanner.next().charAt(0);
    }
}
