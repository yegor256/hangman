package hangman;

import java.util.Random;

public final class Words {

    private final Word[] words;

    public Words(final String[] words) throws Exception {
        this(new StringsAsWords(words).words());
    }

    public Words(final Word[] words) {
        this.words = words;
    }

    public Word random() throws Exception {
        return this.words[new Random().nextInt(this.words.length)];
    }
}
