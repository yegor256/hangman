package hangman;

public final class SecretPhrase {
	public static final String secret = ""+'\0';
	private final String phrase;

	public SecretPhrase( String phrase ) {
		this.phrase = phrase;
	}

	public final String discover(char character) {
		return phrase.replaceAll("[^"+character+"]", secret);
	}

	public final boolean resolve(String solution) {
		return phrase.equals(solution);
	}
}
