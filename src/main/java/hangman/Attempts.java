package hangman;

import java.io.OutputStream;
import java.io.PrintStream;

public class Attempts {
    private InputCheck inputCheck;
    private int mistakes;
    private final int maxNumberOfAttempts;
    private PrintStream printStream;

    public Attempts(InputCheck inputCheck, int maxNumberOfAttempts, OutputStream outputStream) {
        this.inputCheck = inputCheck;
        this.maxNumberOfAttempts = maxNumberOfAttempts;
        this.mistakes = 0;
        this.printStream = new PrintStream(outputStream);
    }

    public void startGuessing() throws OutOfAttemptsException {
        while (mistakes < maxNumberOfAttempts) {
            try {
                if ((inputCheck.isAttemptSuccessful())) {
                    printStream.println("Hit!");
                } else {
                    printStream.printf(
                            "Missed, mistake #%d out of %d\n",
                            mistakes + 1, this.maxNumberOfAttempts
                    );
                    ++mistakes;
                }
                for (int i = 0; i < inputCheck.showWord().length; i++){
                    printStream.append("The word: ");
                    printStream.print(inputCheck.showWord()[i]);
                    printStream.append("\n\n");
                }
            } catch (AllLettersGuessedException e) {
                return;
            }
        }
        throw new OutOfAttemptsException();
    }
}
