package hangman;

import hangman.word.SimpleWord;
import hangman.word.Word;

public class Hangman {
    private final Computer computer;
    private final Human human;

    public Hangman(Computer computer, Human human) {
        this.computer = computer;
        this.human = human;
    }

    public static void main(String[] args) {
        new Hangman(
                new Computer(new SimpleWord("equality"), new SimpleWord("grandmother")),
                new Human()
        ).start();
    }

    private void start() {
        int mistakes = 0;
        while (mistakes < 5) {
            System.out.println("Suggest a letter:");
            final char said = human.say();

            final Word before = computer.hiddenWord();
            computer.suggest(said);
            final Word after = computer.hiddenWord();

            if (before.toString().equals(after.toString())) {
                mistakes++;
                System.out.println("Mistake! Mistakes: " + mistakes);
            } else if (after.toString().contains("?")) {
                System.out.println("Hidden word: " + after);
            } else {
                break;
            }
        }

        if (mistakes == 5) {
            System.out.println("You lost!");
        } else {
            System.out.println("You won!");
        }
    }
}
