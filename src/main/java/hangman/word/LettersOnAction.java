package word;

import java.util.List;

/**
 * Turning on the matched letters.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public interface LettersOnAction {
	public List<LetterState> letters();
	public List<LetterState> lettersOn();    
}
