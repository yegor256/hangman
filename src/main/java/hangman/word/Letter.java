package word;

import java.lang.Character;

/**
 * Keeping the state of a letter.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Letter implements LetterState {
    private final Character character;
    private final boolean on;

    public Letter(final Character character) {
        this(character, false);
    }

    public Letter(final Character character, final boolean on) {
        this.character = character;
        this.on = on;
    }  

    @Override
    public LetterState on() {
        return new Letter(character, true);
    }      

    @Override
    public Character symbol() {
        return this.character;
    }

    @Override
    public boolean isOn() {
        return this.on;
    }         
}