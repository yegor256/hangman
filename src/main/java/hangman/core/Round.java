package hangman.core;

public final class Round {
	public final int round;
	public final int mistakes;
	public final boolean missed;
	public final Guess currentGuess;

	public Round( Guess initialGuess ) {
		this.round = 1;
		this.currentGuess = initialGuess;
		if(initialGuess.missed()) {
			this.mistakes = 1;
			this.missed = true;
		} else {
			this.mistakes = 0;
			this.missed = false;
		}
	}

	private Round( Guess guess, int newRound, int mistakes, boolean missed ) {
		this.missed = missed;
		this.round = newRound;
		this.mistakes = mistakes;
		this.currentGuess = guess;
	}

	public final Round nextRound( Guess newGuess ) {
		if(newGuess.missed())
			return new Round(currentGuess.combine(newGuess), round+1, mistakes+1, true);
		else
			return new Round(currentGuess.combine(newGuess), round+1, mistakes, false);
	}
}
