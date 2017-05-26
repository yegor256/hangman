package hangman.game;

/**
 * Created by mehyil on 5/26/2017.
 */
public class GameState {

    private Word word;

    private int mistakes;

    private int maxMistakes;

    public GameState(Word word, int maxMistakes) {
        this.word = word;
        this.maxMistakes = maxMistakes;
    }

    public boolean makeAGuess(Guess guess){
        return word.makeAGuess(guess);
    }

    public void incrementMistake() {
        ++mistakes;
    }

    public int getMistakes() {
        return mistakes;
    }

    public int getMaxMistakes() {
        return maxMistakes;
    }

    public boolean isMaxMistakeReached() {
        if (mistakes == maxMistakes) {
            return true;
        }
        return false;
    }

}
