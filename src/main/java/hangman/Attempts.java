package hangman;

import java.io.PrintStream;
import java.io.InputStream;

public class Attempts {
    private Schema schema;
    private Guess guess;


    Attempts(Schema schema, Guess guess) {
        this.schema = schema;
        this.guess = guess;
    }

    boolean isDone() {
        return this.schema.isDone();
    }

    int makeAttempt(InputStream input, PrintStream out, int mistakes, int max) {
        char chr = this.guess.letter(input, out);
        boolean hit = this.schema.isHit(chr);
        this.printResult(out, hit, mistakes, max);
        this.schema.printWord(out);
        return hit ? 0 : 1;
    }

    private void printResult(PrintStream out, boolean hit, int mistakes, int max) {
        if (hit) {
            out.print("Hit!\n");
        } else {
            out.printf(
                    "Missed, mistake #%d out of %d\n",
                    mistakes + 1, max
            );
        }
    }
}
