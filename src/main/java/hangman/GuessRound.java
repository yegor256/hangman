package hangman;

public final class GuessRound {
	public final int round;
	public final int mistakes;
	public final boolean missed;
	public final String partialSolution;

	public GuessRound( String partialSolution ) {
		this.round = 1;
		this.partialSolution = partialSolution;
		if(partialSolution.matches("^\0+$")) {
			this.mistakes = 1;
			this.missed = true;
		} else {
			this.mistakes = 0;
			this.missed = false;
		}
	}

	private GuessRound( String combinedSolution, int newRound, int mistakes, boolean missed ) {
		this.missed = missed;
		this.round = newRound;
		this.mistakes = mistakes;
		this.partialSolution = combinedSolution;
	}

	public final GuessRound nextRound( String newPartialSolution ) {
		final String combinedSolution = combineSolutions( partialSolution, newPartialSolution );
		if(partialSolution.equals(combinedSolution)) // ZERO discovered letters // Missed
			return new GuessRound(combinedSolution, round+1, mistakes+1, true);
		else
			return new GuessRound(combinedSolution, round+1, mistakes, false);
	}

	private final String combineSolutions( String partial1, String partial2 ) {
		String combinedSolution = "";
		for( int i=0 ; i < partial1.length() ; i++ ) {
			final char c = (char) (partial1.charAt(i)|partial2.charAt(i));
			combinedSolution += c;
		}
		return combinedSolution;
	}
}
