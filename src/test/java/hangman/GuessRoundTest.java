package hangman;

import org.junit.Assert;
import org.junit.Test;

public final class GuessRoundTest {
	@Test
	public final void guessRoundProgression() {
		final SecretPhrase secret = new SecretPhrase( "elegant objects");
		final GuessRound gr1 = new GuessRound(secret.discover('a'));
		Assert.assertEquals(1,gr1.round);
		Assert.assertEquals("\0\0\0\0a\0\0\0\0\0\0\0\0\0\0", gr1.partialSolution);
		final GuessRound gr2 = gr1.nextRound(secret.discover('o'));
		Assert.assertEquals(2,gr2.round);
		Assert.assertEquals("\0\0\0\0a\0\0\0o\0\0\0\0\0\0", gr2.partialSolution);
	}
}
