package hangman.game;

/**
 * Created by mehyil on 5/26/2017.
 */
public class HangmanWord {

    private String word;

    private boolean[] visible;

    public HangmanWord(String word) {
        this.word = word;
        this.visible = new boolean[word.length()];
    }

    public void print() {
        System.out.append("The word: ");
        for (int i = 0; i < word.length(); ++i) {
            if (visible[i]) {
                System.out.print(word.charAt(i));
            } else {
                System.out.print("?");
            }
        }
        System.out.append("\n\n");
    }

    public boolean makeAGuess(Guess guess) {
        boolean hit = false;
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) == guess.getGuessCharacter() && !visible[i]) {
                visible[i] = true;
                hit = true;
            }
        }
        return hit;
    }

    public boolean isAllCharVisible() {
        for (int i = 0; i < word.length(); ++i) {
            if (!visible[i]) {
                return false;
            }
        }
        return true;
    }
}
