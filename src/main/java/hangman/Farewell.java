package hangman;

import java.io.OutputStream;
import java.io.PrintStream;

public class Farewell {
    private final OutputStream output;
    private final int max;
    private Schema schema;
    private Guess guess;

    public Farewell(
            final OutputStream out,
            Schema schema,
            Guess guess,
            final int m
    ) {
        this.output = out;
        this.schema = schema;
        this.guess = guess;
        this.max = m;
    }

    public void say() {
        int mistakes = 0;
        try (final PrintStream out = new PrintStream(this.output)) {
            boolean done = true;
            while (mistakes < this.max) {
                done = this.schema.isDone();
                if (done) {
                    break;
                }
                char chr = this.guess.letter(out);
                boolean hit = this.schema.isHit(chr);
                if (hit) {
                    out.print("Hit!\n");
                } else {
                    out.printf(
                            "Missed, mistake #%d out of %d\n",
                            mistakes + 1, this.max
                    );
                }
                this.schema.printWord(out);
            }

            if (done) {
                out.print("You won!\n");
            } else {
                out.print("You lost.\n");
            }
        }
    }
}
