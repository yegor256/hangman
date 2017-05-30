package word;

import java.util.List;

/**
 * Keeping the state of a word.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public interface WordState {
	public List<LetterState> letters();
}
