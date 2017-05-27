package hangman;

import hangman.word.Word;

import java.io.PrintWriter;

public class Hangman {
    private final PrintWriter writer;
    private final Computer computer;
    private final Human human;
    private final int maxMistakes;

    public Hangman(final PrintWriter writer, final Computer computer, final Human human, int maxMistakes) {
        this.writer = writer;
        this.computer = computer;
        this.human = human;
        this.maxMistakes = maxMistakes;
    }

    public void start() {
        int mistakes = 0;
        while (mistakes < maxMistakes) {
            writer.println("Suggest a letter:");
            final char said = human.say();

            final Word before = computer.hiddenWord();
            computer.suggest(said);
            final Word after = computer.hiddenWord();

            if (before.representation().equals(after.representation())) {
                mistakes++;
                writer.println("Mistake! Mistakes: " + mistakes);
            } else if (after.representation().contains("?")) {
                writer.println("Hidden word: " + after);
            } else {
                break;
            }
        }

        if (mistakes == maxMistakes) {
            writer.println("You lost!");
        } else {
            writer.println("You won!");
        }
    }
}
