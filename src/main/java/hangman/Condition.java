package hangman;

public class Condition {

    private final String word;
    private final int maxMisses;

    Condition(String word, int maxMisses) {
        this.word = word;
        this.maxMisses = maxMisses;
    }

    String getWord() {
        return word;
    }

    int getMaxMisses() {
        return maxMisses;
    }

    boolean alive(int misses) {
        return misses < maxMisses;
    }

    boolean correctWord(String userWord) {
        return word.equals(userWord);
    }

}
