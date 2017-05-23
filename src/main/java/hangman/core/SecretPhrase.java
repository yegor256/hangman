package hangman.core;

public final class SecretPhrase {
	public final int allowedMistakes;
	private final String phrase;

	// It seems reasonable for that the SecretPhrase
	// determines the difficulty and number of allowed mistakes
	public SecretPhrase(String phrase, int allowedMistakes) {
		this.phrase = phrase;
		this.allowedMistakes = allowedMistakes;
	}

	public final Guess discover(char character) {
		return new Guess(phrase.replaceAll("[^" + character + "]", ""+Guess.unknownChar));
	}

	public final boolean resolve(Guess solution) {
		return phrase.equals(solution.knownText);
	}
}
