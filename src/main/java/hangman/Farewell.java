package hangman;

public class Farewell {
    private Attempts attempts;

    Farewell(Attempts attempts) {
        this.attempts = attempts;
    }

    void start(){
        try {
            attempts.startGuessing();
            System.out.println("You won!");
        } catch (OutOfAttemptsException e) {
            System.out.println("You lost.");
        }
    }
}
