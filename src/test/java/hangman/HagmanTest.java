package hangman;

import org.junit.Assert;
import org.junit.Test;

public class HagmanTest {
	@Test
	public void hangmanRounds() {
		final Hangman hangman = new Hangman(new StubVocabulary("hangman",2));
		final GuessRound gr1 = hangman.discover('e');
		final GuessRound gr2 = hangman.discover(gr1,'h');
		final GuessRound gr3 = hangman.discover(gr2,'n');
		final GuessRound gr4 = hangman.discover(gr3,'a');
		Assert.assertEquals(4,gr4.round);
		Assert.assertEquals("han\0\0an",gr4.partialSolution);
		Assert.assertEquals(Hangman.Stage.PLAYING, hangman.gameStage(gr4));
		final GuessRound gr5 = hangman.discover(gr4,'w');
		Assert.assertEquals(Hangman.Stage.YOULOSE, hangman.gameStage(gr5));
	}
}
