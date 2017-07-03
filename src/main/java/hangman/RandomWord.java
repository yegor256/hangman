package hangman;

import java.util.Random;

public final class RandomWord implements AbstractRandomWord {

    private final AbstractWord[] words;

    public RandomWord(final String... words) {
        this.words = new StringsAsWords(words).toWords();
    }

    public RandomWord(final AbstractWord... words) {
        this.words = words;
    }

    public AbstractWord[] words() {
        return this.words;
    }

    public AbstractWord random() throws Exception {
        return this.words[new Random().nextInt(this.words.length)];
    }
}
