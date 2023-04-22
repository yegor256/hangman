package hangman.core;

public final class Guess {
	public static final char unknownChar = '\0';
	public final String knownText;

	public Guess( String knownText ) {
		this.knownText = knownText;
	}

	public final boolean missed() {
		return this.knownText.replace(""+unknownChar,"").length()==0;
	}

	public final Guess combine( Guess otherGuess ) {
		String combinedSolution = "";
		for( int i=0 ; i < knownText.length() ; i++ ) {
			final char c = (char) (knownText.charAt(i)|otherGuess.knownText.charAt(i));
			combinedSolution += c;
		}
		return new Guess(combinedSolution);
	}

	public final String toString() {
		// Replace non-printable NULL characters with CLI friendly alternative
		return knownText.replace(unknownChar, '_');
	}
}
