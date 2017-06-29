package hangman;

public final class StringsAsWords {

    private final String[] words;

    public StringsAsWords(final String[] words) {
        this.words = words;
    }

    public Word[] words() throws Exception {
        final Word[] result = new Word[this.words.length];
        for (int i = 0; i < this.words.length; i++) {
            result[i] = new Word(this.words[i]);
        }
        return result;
    }
}
