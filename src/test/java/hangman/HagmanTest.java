package hangman;

import org.junit.Assert;
import org.junit.Test;

public class HagmanTest {
	@Test
	public void hangmanRounds() {
		final Hangman hangman = new Hangman(new StubVocabulary("hangman"));
		final GuessRound gr1 = hangman.discover('e');
		final GuessRound gr2 = hangman.discover('h');
		final GuessRound gr3 = hangman.discover('n');
		final GuessRound gr4 = hangman.discover('a');
		Assert.assertEquals(4,gr4.round);
		Assert.assertEquals("han\0\0an",gr4.partialSolution);
	}
}
