package game;

import word.NextWord;
import word.RandomWords;

/**
 * Initialization and starting a new game.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class NewHangman implements NewGame {
	private static final int DEFAULT_FAILURES = 5;
	private final NextWord words;
	private final Failures failures;

	public NewHangman() {
		this(DEFAULT_FAILURES);		
	}

	public NewHangman(final int failures) {
		this(new HangmanFailures(failures));		
	}	

	public NewHangman(final Failures failures) {
		this(new RandomWords(), failures);		
	}		

	public NewHangman(final NextWord words, final Failures failures) {
		this.words = words;
		this.failures = failures;
	}

	public void start() {
		new HangmanAttempt(words.next(), failures).attempt();		
	}
}