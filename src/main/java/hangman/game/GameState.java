package hangman.game;

/**
 * Created by mehyil on 5/26/2017.
 */
public class GameState {

    private int mistakes;

    private int maxMistakes;

    public GameState(int maxMistakes) {
        this.maxMistakes = maxMistakes;
    }

    public GameState() {
        this(0);
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
