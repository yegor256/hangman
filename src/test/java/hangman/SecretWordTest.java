package hangman;

import org.junit.Assert;
import org.junit.Test;

import hangman.core.Guess;
import hangman.core.SecretPhrase;

public class SecretWordTest {
	@Test
	public void discoverLetters() {
		final SecretPhrase secret = new SecretPhrase( "elegant objects", 8 );
		final Guess partialSolution = secret.discover('e');
		Assert.assertEquals("e\0e\0\0\0\0\0\0\0\0e\0\0\0", partialSolution.knownText);
	}
}
