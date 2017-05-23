package hangman;

public final class SecretPhrase {
	public static final String secret = ""+'\0';
	public final int allowedMistakes;
	private final String phrase; 

	// It seems reasonable for that the SecretPhrase
	// determines the difficulty and number of allowed mistakes
	public SecretPhrase( String phrase, int allowedMistakes ) {
		this.phrase = phrase;
		this.allowedMistakes = allowedMistakes;
	}

	public final String discover(char character) {
		return phrase.replaceAll("[^"+character+"]", secret);
	}

	public final boolean resolve(String solution) {
		return phrase.equals(solution);
	}
}
