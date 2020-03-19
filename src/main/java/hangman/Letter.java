package hangman;

public class Letter {
    private boolean isVisible;
    private char value;

    Letter(boolean isVisible, char value) {
        this.isVisible = isVisible;
        this.value = value;
    }

    Letter(char value) {
        new Letter(false, value);
    }

    boolean hasEqualValue(char value) {
        return this.value == value;
    }

    boolean isVisible() {
        return isVisible;
    }

    void open() {
        this.isVisible = true;
    }

    char getValue() {
        return value;
    }
}
