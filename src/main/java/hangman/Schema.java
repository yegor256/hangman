package hangman;

import java.io.PrintStream;

public class Schema {
    private final String word;
    private boolean[] visible;

    Schema(String word) {
        this.word = word;
        this.visible = new boolean[word.length()];
    }

    boolean isDone() {
        boolean done = true;
        for (int i = 0; i < visible.length; ++i) {
            if (!visible[i]) {
                done = false;
            }
        }
        return done;
    }

    boolean isHit(char chr) {
        boolean hit = false;
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) == chr && !this.visible[i]) {
                this.visible[i] = true;
                hit = true;
            }
        }
        return hit;
    }

    void printWord(PrintStream out) {
        out.append("The word: ");
        for (int i = 0; i < this.word.length(); ++i) {
            if (this.visible[i]) {
                out.print(word.charAt(i));
            } else {
                out.print("?");
            }
        }
        out.append("\n\n");
    }
}
