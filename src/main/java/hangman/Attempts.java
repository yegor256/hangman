package hangman;

public class Attempts {
    private InputCheck inputCheck;
    private int mistakes;
    private final int maxNumberOfAttempts;

    public Attempts(InputCheck inputCheck, int maxNumberOfAttempts) {
        this.inputCheck = inputCheck;
        this.maxNumberOfAttempts = maxNumberOfAttempts;
        this.mistakes = 0;
    }

    public void startGuessing() throws OutOfAttemptsException {
        while (mistakes < maxNumberOfAttempts) {
            try {
                if ((inputCheck.isAttemptSuccessful())) {
                    System.out.println("Hit!");
                } else {
                    System.out.printf(
                            "Missed, mistake #%d out of %d\n",
                            mistakes + 1, this.maxNumberOfAttempts
                    );
                    ++mistakes;
                }
            } catch (AllLettersGuessedException e) {
                return;
            }
        }
        throw new OutOfAttemptsException();
    }
}
