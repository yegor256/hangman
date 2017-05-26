package hangman.game;

/**
 * Created by mehyil on 5/26/2017.
 */
public class Round {

    private final Word word;

    private final GameState gameState;

    public Round(Word word, GameState gameState) {
        this.gameState = gameState;
        this.word = word;
    }

    public void playRound(Guess guess) {
        boolean result = word.makeAGuess(guess);
        incrementMistake(result);
        printRoundResult(result);
    }

    private void incrementMistake(boolean result) {
        if (!result) {
            gameState.incrementMistake();
        }
    }

    private void printRoundResult(boolean result) {
        if (result) {
            System.out.print("Hit!\n");
        } else {
            System.out.printf("Missed, mistake #%d out of %d\n", gameState.getMistakes(), gameState.getMaxMistakes());
        }
    }
}
