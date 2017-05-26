package hangman.game;

/**
 * Created by mehyil on 5/26/2017.
 */
public class Round {

    private final Guess guess;

    public Round(Guess guess) {
        this.guess = guess;
    }

    public void play() {
        guess.make();
    }

}
