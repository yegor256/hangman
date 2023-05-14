package hangman;

public class Hangman {
    private final Mistakes attempts;

    Hangman(Mistakes attempts) {
        this.attempts = attempts;
    }

    void play() {
        if (this.attempts.matches()) {
            System.out.println("You won!\n");
        } else {
            System.out.println("You lost.\n");
        }
    }
}
