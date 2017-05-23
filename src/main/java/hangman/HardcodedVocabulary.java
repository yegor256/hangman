package hangman;

import java.util.Random;

public final class HardcodedVocabulary implements SecretProvider {
	private static final String[] WORDS = {
			"simplicity", "equality", "grandmother",
			"neighborhood", "relationship",
			"mathematics", "university", "explanation" };

	@Override
	public final SecretPhrase provideSecret() {
		return new SecretPhrase(WORDS[new Random().nextInt(WORDS.length)], 5);
	}
}
