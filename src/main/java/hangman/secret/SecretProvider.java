package hangman.secret;

import hangman.core.SecretPhrase;

public interface SecretProvider {
	public SecretPhrase provideSecret();
}
