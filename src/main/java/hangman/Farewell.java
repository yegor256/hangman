package hangman;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Farewell {
    private final OutputStream output;
    private final InputStream input;
    private final int max;
    private final Attempts attempts;

    public Farewell(
            final InputStream in,
            final OutputStream out,
            final Attempts attempts,
            final int m
    ) {
        this.input = in;
        this.output = out;
        this.attempts = attempts;
        this.max = m;
    }

    public void say() {
        int mistakes = 0;
        try (final PrintStream out = new PrintStream(this.output)) {
            boolean done = true;
            while (mistakes < this.max) {
                done = this.attempts.isDone();
                if (done) {
                    break;
                }

                mistakes += this.attempts.makeAttempt(input, out, mistakes, max);
            }

            if (done) {
                out.print("You won!\n");
            } else {
                out.print("You lost.\n");
            }
        }
    }
}
