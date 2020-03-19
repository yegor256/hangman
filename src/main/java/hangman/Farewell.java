package hangman;

import java.io.OutputStream;
import java.io.PrintStream;

public class Farewell {
    private Attempts attempts;
    private PrintStream printStream;

    Farewell(Attempts attempts, OutputStream out) {
        this.attempts = attempts;
        this.printStream = new PrintStream(out);
    }

    void start(){
        try {
            attempts.startGuessing();
            printStream.println("You won!");
        } catch (OutOfAttemptsException e) {
            printStream.println("You lost.");
        }
    }
}
