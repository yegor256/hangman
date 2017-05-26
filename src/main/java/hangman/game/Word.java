package hangman.game;

/**
 * Created by mehyil on 5/26/2017.
 */
public class Word {

    private final String word;

    private final boolean[] visible;

    private final int maxMistake;

    private int mistakes;

    public Word(String word, int maxMistake) {
        this.word = word;
        this.visible = new boolean[word.length()];
        this.maxMistake = maxMistake;
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

    public boolean makeAGuess(Character guessCharacter) {
        boolean hit = false;
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) == guessCharacter && !visible[i]) {
                visible[i] = true;
                hit = true;
            }
        }
        if(!hit){
            incrementMistake();
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

    public boolean maxMistakeReached() {
        if (mistakes == maxMistake) {
            return true;
        }
        return false;
    }

    public int getMaxMistake() {
        return maxMistake;
    }

    public int getMistakes() {
        return mistakes;
    }

    private void incrementMistake() {
        ++mistakes;
    }

}
