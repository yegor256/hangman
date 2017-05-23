package hangman;

import org.junit.Assert;
import org.junit.Test;

public class HagmanTest {
	@Test
	public void hangmanRounds() {
		final Hangman hangman = new Hangman(new StubVocabulary("hangman",2));
		final GuessRound gr1 = hangman.discover('e');
		final GuessRound gr2 = hangman.discover('h');
		final GuessRound gr3 = hangman.discover('n');
		final GuessRound gr4 = hangman.discover('a');
		Assert.assertEquals(4,gr4.round);
		Assert.assertEquals("han\0\0an",gr4.partialSolution);
		Assert.assertEquals(Hangman.Stage.PLAYING, hangman.gameStage());
		final GuessRound gr5 = hangman.discover('w');
		Assert.assertEquals(Hangman.Stage.YOULOSE, hangman.gameStage());
	}
}
