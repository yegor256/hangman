package hangman.word;

public class SimpleWord implements Word {

    private final char[] characters;

    public SimpleWord(final String word) {
        this.characters = word.toCharArray();
    }

    @Override
    public String toString() {
        return new String(characters);
    }
}
