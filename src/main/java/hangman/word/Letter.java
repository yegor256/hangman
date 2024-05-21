package hangman.word;

public class Letter {

    private final char character;
    private boolean visible;

    public Letter(char c) {
        this.character = c;
    }

    public boolean tryToReveal(char c) {
        if (character == c) {
            visible = true;
            return true;
        } else {
            return false;
        }
    }

    public char character() {
        if (visible) {
            return character;
        } else {
            return '_';
        }
    }

    public boolean isVisible() {
        return visible;
    }
}
