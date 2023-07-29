package hangman;

public class Attempt {
    private final Secret secret;
    private final UserInput guess;

    public Attempt(UserInput guess, Secret secret) {
        this.guess = guess;
        this.secret = secret;
    }

    boolean check() {
        char chr = this.guess.letter();
        String word = this.secret.word();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == chr && this.secret.isClosed(i)) {
                this.secret.open(i);
                return true;
            }
        }
        return false;
    }
}
