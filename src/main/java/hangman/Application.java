package hangman;

import java.io.InputStream;
import java.io.OutputStream;

public final class Application {

    private final InputStream input;
    private final OutputStream output;
    private final String[] args;
    private final int mistakes;

    public Application(final InputStream input, final OutputStream output, final int mistakes) {
        this(input, output, mistakes, new String[0]);
    }

    public Application(final InputStream input, final OutputStream output, final int mistakes, final String... args) {
        this.input = input;
        this.output = output;
        this.args = args;
        this.mistakes = mistakes;
    }

    public static void main(final String... args) {
        try {
            new Application(System.in, System.out, 5, args).exec();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exec() throws Exception {
        new Game(
                new String[] {
                        "simplicity", "equality", "grandmother",
                        "neighborhood", "relationship", "mathematics",
                        "university", "explanation"
                },
                this.mistakes,
                this.input,
                this.output
        ).play();
    }
}
