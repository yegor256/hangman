package hangman;

import java.util.NoSuchElementException;
import java.util.Stack;

public final class Hangman {
	private final SecretPhrase secretPhrase;
	private final Stack<GuessRound> guesses;

	public Hangman( SecretProvider secretProvider ) {
		this.secretPhrase = secretProvider.provideSecret();
		this.guesses = new Stack<>();
	}

	public final GuessRound discover( char c ) {
		GuessRound nextGuess;
		try {
			nextGuess = guesses.lastElement().nextRound(secretPhrase.discover(c));
		} catch( NoSuchElementException e ) {
			nextGuess = new GuessRound(secretPhrase.discover(c));
		}
		guesses.add(nextGuess);
		return nextGuess;
	}

	public final GuessRound resolve( String solution ) {
		final GuessRound lastRound = guesses.lastElement();
		if(secretPhrase.resolve(solution))
			return lastRound.nextRound(solution);
		else
			return lastRound.nextRound(lastRound.partialSolution);
	}
}
