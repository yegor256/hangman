package hangman;

import org.junit.Assert;
import org.junit.Test;

import hangman.core.Round;
import hangman.core.SecretPhrase;

public final class GuessRoundTest {
	@Test
	public final void guessRoundProgression() {
		final SecretPhrase secret = new SecretPhrase( "elegant objects", 8);

		final Round gr1 = new Round(secret.discover('a'));
		Assert.assertEquals(1,gr1.round);
		Assert.assertEquals(false,gr1.missed);
		Assert.assertEquals(0,gr1.mistakes);
		Assert.assertEquals("\0\0\0\0a\0\0\0\0\0\0\0\0\0\0", gr1.currentGuess.knownText);

		final Round gr2 = gr1.nextRound(secret.discover('o'));
		Assert.assertEquals(2,gr2.round);
		Assert.assertEquals(0,gr2.mistakes);
		Assert.assertEquals(false,gr2.missed);
		Assert.assertEquals("\0\0\0\0a\0\0\0o\0\0\0\0\0\0", gr2.currentGuess.knownText);

		final Round gr3 = gr2.nextRound(secret.discover('v'));
		Assert.assertEquals(3,gr3.round);
		Assert.assertEquals(1,gr3.mistakes);
		Assert.assertEquals(true,gr3.missed);
	}
}
