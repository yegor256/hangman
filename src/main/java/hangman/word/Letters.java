package hangman.word;

import java.io.CharArrayWriter;
import java.util.List;

public class Letters {

    private final List<Letter> letters;

    public Letters(String word) {
        letters = word.chars().mapToObj(c -> new Letter((char) c)).toList();
    }

    public boolean reveal(char c) {
        boolean result = false;
        for (Letter letter : letters) {
            if (letter.tryToReveal(c)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        var writer = new CharArrayWriter();

        writer.append(letters.get(0).character());
        for (int i = 1; i < letters.size(); i++) {
            writer.append(' ').append(letters.get(i).character());
        }
        return writer.toString();
    }

    public boolean allVisible() {
        for (Letter letter : letters) {
            if (!letter.isVisible()) {
                return false;
            }
        }
        return true;
    }
}
