package hangman.game;

/**
 * Created by mehyil on 5/26/2017.
 */
public class Guess {

    private Character guessCharacter;

    public Guess(Character guessCharacter) {
        this.guessCharacter = guessCharacter;
    }

    public Character getGuessCharacter() {
        return guessCharacter;
    }


}
