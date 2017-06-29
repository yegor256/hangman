package hangman;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public final class Game {

    private final Word word;
    private final int mistakes;
    private final InputStream input;
    private final OutputStream output;

    public Game(final String[] words, final int mistakes) throws Exception {
        this(new Words(words).random(), mistakes, System.in, System.out);
    }

    public Game(final Word[] words, final int mistakes) throws Exception {
        this(new Words(words).random(), mistakes, System.in, System.out);
    }

    public Game(final String[] words, final int mistakes, final InputStream input, final OutputStream output) throws Exception {
        this(new Words(words).random(), mistakes, input, output);
    }

    public Game(final Word[] words, final int mistakes, final InputStream input, final OutputStream output) throws Exception {
        this(new Words(words).random(), mistakes, input, output);
    }

    public Game(final Word word, final int mistakes, final InputStream input, final OutputStream output) throws Exception {
        this.word = word;
        this.mistakes = mistakes;
        this.input = input;
        this.output = output;
    }

    public void play() throws Exception {
        final Scanner scanner = new Scanner(this.input);
        int counter = 0;
        try (final PrintStream out = new PrintStream(this.output)) {
            while (counter < this.mistakes || this.word.opened()) {
                out.print("Guess a letter: ");
                char chr = scanner.next().charAt(0);
                if (!this.word.contains(chr) || this.word.visible(chr)) {
                    counter += 1;
                    out.printf("Missed, mistake #%d out of %d\n",
                            counter, this.mistakes);
                } else {
                    out.println("Hit!\n");
                }
                this.word.unhide(chr);
                out.println(this.word.maskedValue());
            }
            if (this.word.opened()) {
                out.println("You won!");
            } else {
                out.println("You lost.");
            }
            out.append("The word: " + this.word.unmaskedValue());
        }
    }
}
