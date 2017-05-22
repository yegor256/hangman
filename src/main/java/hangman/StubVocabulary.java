package hangman;

public final class StubVocabulary implements SecretProvider {
	private final String secretPhrase;

	public StubVocabulary( String secretPhrase ) {
		this.secretPhrase = secretPhrase;
	}

	@Override
	public final SecretPhrase provideSecret() {
		return new SecretPhrase(secretPhrase);
	}
}
