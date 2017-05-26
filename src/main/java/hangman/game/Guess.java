package hangman.game;

/**
 * Created by mehyil on 5/26/2017.
 */
public class Guess {

    private Character guessCharacter;

    private Word word;

    public Guess(Character guessCharacter, Word word) {
        this.guessCharacter = guessCharacter;
        this.word = word;
    }

    public void make() {
        result(word.makeAGuess(guessCharacter));
    }

    private void result(boolean result) {
        if (result) {
            System.out.print("Hit!\n");
        } else {
            System.out.printf("Missed, mistake #%d out of %d\n", word.getMistakes(), word.getMaxMistake());
        }
        word.print();
    }
}
