package hangman;

public final class StringsAsWords implements AbstractStringsAsWords {

    private final String[] strings;

    public StringsAsWords(final String... strings) {
        this.strings = strings;
    }

    @Override
    public String[] strings() {
        return this.strings;
    }

    @Override
    public AbstractWord[] toWords() {
        final AbstractWord[] words = new AbstractWord[this.strings.length];
        for (int i = 0; i < this.strings.length; i++) {
            words[i] = new Word(strings[i]);
        }
        return words;
    }
}
