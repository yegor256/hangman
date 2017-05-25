package hangman.word;

import java.util.HashSet;
import java.util.Set;

public class HiddenWord implements Word {

    private final Word origin;
    private final Set<Character> opened;

    public HiddenWord(final Word word, final Set<Character> opened) {
        this.origin = word;
        this.opened = new HashSet<>(opened);
    }

    @Override
    public String toString() {
        final String representation = origin.toString();
        final StringBuilder hidden = new StringBuilder();
        for (char c : representation.toCharArray()) {
            if (opened.contains(c)) {
                hidden.append(c);
            } else {
                hidden.append('?');
            }
        }

        return hidden.toString();
    }
}
