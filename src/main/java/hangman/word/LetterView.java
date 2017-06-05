package word;

import java.lang.Character;

/**
 * Representation of a character shown or hidden.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class LetterView implements ShowableLetter {
    private final LetterState letter;

    public LetterView(final LetterState letter) {
        this.letter = letter;
    }

    @Override
    public Character symbol() {
        return letter.isOn() ? letter.symbol() : '?' ;
    }    
}