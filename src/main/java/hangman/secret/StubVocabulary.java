package hangman.secret;

import hangman.core.SecretPhrase;

public final class StubVocabulary implements SecretProvider {
	private final String secretPhrase;
	private final int allowedMistakes;

	public StubVocabulary(String secretPhrase, int allowedMistakes) {
		this.secretPhrase = secretPhrase;
		this.allowedMistakes = allowedMistakes;
	}

	@Override
	public final SecretPhrase provideSecret() {
		return new SecretPhrase(secretPhrase, allowedMistakes);
	}
}
