package hangman.word;

public class SimpleWord implements Word {

    private final String representation;

    public SimpleWord(final String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return representation;
    }
}
