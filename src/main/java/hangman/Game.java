package hangman;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public final class Game implements AbstractGame {

    private final AbstractWord word;
    private final Integer mistakes;
    private final Scanner input;
    private final PrintStream output;
    private final List<AbstractGuess> guesses;

    public Game(final AbstractWord word, final Integer mistakes, final InputStream input, final OutputStream output) {
        this(word, mistakes, input, new PrintStream(output), new LinkedList<AbstractGuess>());
    }

    public Game(final AbstractWord word, final Integer mistakes, final InputStream input, final OutputStream output, final List<AbstractGuess> guesses) {
        this(word, mistakes, new Scanner(input), new PrintStream(output), guesses);
    }

    public Game(final AbstractWord word, final Integer mistakes, final Scanner input, final PrintStream output, final List<AbstractGuess> guesses) {
        this.word = word;
        this.mistakes = mistakes;
        this.input = input;
        this.output = output;
        this.guesses = guesses;
    }

    public AbstractWord word() {
        return this.word;
    }

    public Integer mistakes() {
        return this.mistakes;
    }

    public Scanner input() {
        return this.input;
    }

    public PrintStream output() {
        return this.output;
    }

    public List<AbstractGuess> guesses() {
        return this.guesses;
    }

    public void run() throws Exception {
        while (this.guesses.size() < this.mistakes && !this.word.guessed()) {
            this.output.print("AbstractGuess a letter: ");
            final AbstractGuess guess = new Guess(this.word, this.input.next().charAt(0));
            if (guess.guessed()) {
                this.word.open(guess.character());
                this.output.println("Hit!");
            } else {
                this.guesses.add(guess);
                this.output.printf("Missed, mistake #%d out of %d\n", this.guesses.size(), this.mistakes);
            }
            this.output.println(this.word.word());
        }
        if (this.word.guessed()) {
            this.output.println("You won!");
        } else {
            this.output.println("You lost.");
        }
        this.output.append("The word: " + this.word.original());
    }
}
