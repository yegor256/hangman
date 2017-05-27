package hangman.word;

import java.util.Random;

public class RandomWord implements Word {
    private final Word word;

    public RandomWord(final Word... words) {
        this.word = words[new Random().nextInt(words.length)];
    }

    @Override
    public String representation() {
        return word.representation();
    }
}
