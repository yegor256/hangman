package hangman.Words;

public class CachedWords implements WordsInterface {
    private final WordsInterface original;
    private String word = "";

    public CachedWords(WordsInterface original) {
        this.original = original;
    }

    @Override
    public String get() {
        if (word.isEmpty()) {
            word = original.get();
        }
        return word;
    }
}
