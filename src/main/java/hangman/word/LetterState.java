package word;

import java.lang.Character;

/**
 * Keeping the state of a letter.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public interface LetterState {
    public LetterState on();
    public Character symbol();
    public boolean isOn();
}
