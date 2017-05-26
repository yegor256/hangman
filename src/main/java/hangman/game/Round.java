package hangman.game;

/**
 * Created by mehyil on 5/26/2017.
 */
public class Round {

    private final Guess guess;

    public Round(Guess guess) {
        this.guess = guess;
    }

    public void playRound(GameState gameState) {
        boolean result = gameState.makeAGuess(guess);
        incrementMistake(gameState, result);
        printRoundResult(gameState, result);
    }

    private void incrementMistake(GameState gameState, boolean result) {
        if (!result) {
            gameState.incrementMistake();
        }
    }

    private void printRoundResult(GameState gameState, boolean result) {
        if (result) {
            System.out.print("Hit!\n");
        } else {
            System.out.printf("Missed, mistake #%d out of %d\n", gameState.getMistakes(), gameState.getMaxMistakes());
        }
    }
}
