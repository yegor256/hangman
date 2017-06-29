package hangman;

import java.util.Random;

public final class Words {

    private final Word[] words;

    public Words(final String[] words) {
        this(new StringsAsWords(words).words());
    }

    public Words(final Word[] words) {
        this.words = words;
    }

    public Word random() {
        return this.words[new Random().nextInt(this.words.length)];
    }
}
