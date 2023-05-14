package OOP_hangman;

import java.util.Scanner;

class Guess {
    char letter() {
        System.out.print("Guess a letter: ");
        return new Scanner(System.in).next().charAt(0);
    }
}

