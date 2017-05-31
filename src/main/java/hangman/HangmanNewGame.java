package hangman;

import game.Failures;
import game.NewGame;
import word.NextWord;
import word.RandomWords;
import word.NextWord;
import word.RandomWords;

/**
 * Initialization and starting a new game.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class HangmanNewGame implements NewGame {
	private static final int DEFAULT_FAILURES = 5;
	private final NextWord words;
	private final Failures failures;

	public HangmanNewGame() {
		this(DEFAULT_FAILURES);		
	}

	public HangmanNewGame(final int failures) {
		this(new HangmanFailures(failures));		
	}	

	public HangmanNewGame(final Failures failures) {
		this(new RandomWords(), failures);		
	}		

	public HangmanNewGame(final NextWord words, final Failures failures) {
		this.words = words;
		this.failures = failures;
	}

	public void start() {
		new HangmanAttempt(words.next(), failures).attempt();		
	}
}