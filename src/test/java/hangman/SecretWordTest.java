package hangman;

import org.junit.Assert;
import org.junit.Test;

public class SecretWordTest {
	@Test
	public void discoverLetters() {
		final SecretPhrase secret = new SecretPhrase( "elegant objects");
		final String partialSolution = secret.discover('e');
		Assert.assertEquals("e\0e\0\0\0\0\0\0\0\0e\0\0\0", partialSolution);
	}
}
