package hangman;

import java.util.Stack;

public final class Hangman {
	public static enum Stage {
		PLAYING, YOUWON, YOULOSE
	}

	private final SecretPhrase secretPhrase;
	private final Stack<GuessRound> guesses;
	public final int allowedMistakes;

	public Hangman(SecretProvider secretProvider) {
		this.secretPhrase = secretProvider.provideSecret();
		this.allowedMistakes = secretPhrase.allowedMistakes;
		this.guesses = new Stack<>();
	}

	public final GuessRound discover(char c) {
		return nextRound(secretPhrase.discover(c));
	}

	public final GuessRound resolve(String solution) {
		if (secretPhrase.resolve(solution)) { // You won!
			return nextRound(solution);
		} else {
			return nextRound(secretPhrase.discover('\0'));
		}
	}

	private final GuessRound nextRound(String partialSolution) {
		final GuessRound nextRound;
		if (guesses.size() == 0) {
			nextRound = new GuessRound(partialSolution);
		} else {
			nextRound = guesses.lastElement().nextRound(partialSolution);
		}
		guesses.add(nextRound);
		return nextRound;
	}

	public final Stage gameStage() {
		if (guesses.size() == 0) {
			return Stage.PLAYING;
		}

		final GuessRound lastRound = guesses.lastElement();

		if (lastRound.mistakes >= secretPhrase.allowedMistakes) {
			return Stage.YOULOSE;
		} else if (secretPhrase.resolve(lastRound.partialSolution)) {
			return Stage.YOUWON;
		} else {
			return Stage.PLAYING;
		}
	}
}
