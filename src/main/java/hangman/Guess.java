package hangman;

public final class Guess implements AbstractGuess {

    private final AbstractWord word;
    private final Character character;

    public Guess(final AbstractWord word, final Character character) {
        this.word = word;
        this.character = character;
    }

    public AbstractWord word() {
        return this.word;
    }

    public Character character() {
        return this.character;
    }

    public boolean guessed() throws Exception {
        return this.word.contains(this.character) && !this.word.opened(this.character());
    }
}
