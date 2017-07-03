package hangman;

import java.io.InputStream;
import java.io.OutputStream;

public final class Application {

    private final InputStream input;
    private final OutputStream output;
    private final Integer mistakes;

    public Application(final InputStream input, final OutputStream output, final Integer mistakes) {
        this.input = input;
        this.output = output;
        this.mistakes = mistakes;
    }

    public static void main(final String[] args) throws Exception {
        new Application(System.in, System.out, 5).execute();
    }

    public void execute() throws Exception {
        new Game(
                new RandomWord(
                        "simplicity", "equality", "grandmother",
                        "neighborhood", "relationship", "mathematics",
                        "university", "explanation"
                ).random(),
                this.mistakes,
                this.input,
                this.output
        ).run();
    }
}
