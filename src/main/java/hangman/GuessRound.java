package hangman;

public final class GuessRound {
	public final int round;
	public final String partialSolution;

	public GuessRound( String partialSolution ) {
		this.round = 1;
		this.partialSolution = partialSolution;
	}

	private GuessRound( String combinedSolution, int newRound ) {
		this.round = newRound;
		this.partialSolution = combinedSolution;
	}

	public final GuessRound nextRound( String newPartialSolution ) {
		final String combinedSolution = combineSolutions( partialSolution, newPartialSolution );
		return new GuessRound(combinedSolution,round+1);
	}

	private final String combineSolutions( String partial1, String partial2 ) {
		String combinedSolution = "";
		for( int i=0 ; i < partial1.length() ; i++ ) {
			final char c = (char) (partial1.charAt(i)^partial2.charAt(i));
			combinedSolution += c;
		}
		return combinedSolution;
	}
}
