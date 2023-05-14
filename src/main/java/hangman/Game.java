package hangman;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

public class Game {

    private final Condition condition;
    private final InputStream in;
    private final OutputStream out;
    private int misses = 0;
    private String word;

    public Game(String word, int maxMisses, InputStream in, OutputStream out) {
        this.condition = new Condition(word, maxMisses);
        this.word = word.replaceAll(".", "?");
        this.in = in;
        this.out = out;
    }

    String getWord() {
        return word;
    }

    void setWord(String word) {
        this.word = word;
    }

    String getWinWord() {
        return condition.getWord();
    }

    public void play() {
        final PrintStream out = new PrintStream(this.out);
        final Iterator<String> scanner = new Scanner(this.in);
        while (canContinue()) {
            out.print("Guess a letter: ");
            char inputLetter = scanner.next().charAt(0);
            Round round = new Round(this, inputLetter);
            if (round.haveHit()) {
                this.word = round.getWordAfterRound();
                out.print("Hit!\n");
            } else {
                this.misses++;
                out.printf(
                        "Missed, mistake #%d out of %d\n",
                        this.misses, condition.getMaxMisses()
                );
            }
            out.print("The word: " + word + "\n");
        }
        if (condition.correctWord(word)) {
            out.print("You won!\n");
        } else {
            out.print("You lost.\n");
        }
    }

    private boolean canContinue() {
        return (condition.alive(misses) && (!condition.correctWord(word)));
    }

}
