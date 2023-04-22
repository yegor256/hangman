package hangman;

import org.junit.Assert;
import org.junit.Test;

import hangman.core.Hangman;
import hangman.core.Round;
import hangman.secret.StubVocabulary;

public class HagmanTest {
	@Test
	public void hangmanRounds() {
		final Hangman hangman = new Hangman(new StubVocabulary("hangman",2));
		final Round gr1 = hangman.disclose('e');
		final Round gr2 = hangman.discloseAlso(gr1,'h');
		final Round gr3 = hangman.discloseAlso(gr2,'n');
		final Round gr4 = hangman.discloseAlso(gr3,'a');
		Assert.assertEquals(4,gr4.round);
		Assert.assertEquals("han\0\0an",gr4.currentGuess.knownText);
		Assert.assertEquals(Hangman.Stage.PLAYING, hangman.gameStage(gr4));
		final Round gr5 = hangman.discloseAlso(gr4,'w');
		Assert.assertEquals(Hangman.Stage.YOULOSE, hangman.gameStage(gr5));
	}
}
