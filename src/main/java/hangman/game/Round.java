package hangman.game;

/**
 * Created by mehyil on 5/26/2017.
 */
public class Round {

    private final Word word;

    public Round(Word word) {
        this.word = word;
    }

    public boolean playRound(Guess guess) {
        return word.makeAGuess(guess);
    }
}
