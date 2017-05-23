package hangman;

public final class Hangman {
	public static enum Stage {
		PLAYING, YOUWON, YOULOSE
	}

	private final SecretPhrase secretPhrase;
	public final int allowedMistakes;

	public Hangman(SecretProvider secretProvider) {
		this.secretPhrase = secretProvider.provideSecret();
		this.allowedMistakes = secretPhrase.allowedMistakes;
	}

	public final GuessRound discover(char c) {
		return new GuessRound(secretPhrase.discover(c));
	}

	public final GuessRound discover(GuessRound prevRound, char c) {
		return prevRound.nextRound(secretPhrase.discover(c));
	}

	public final Stage gameStage(GuessRound round) {
		if (round.mistakes >= secretPhrase.allowedMistakes) {
			return Stage.YOULOSE;
		} else if (secretPhrase.resolve(round.partialSolution)) {
			return Stage.YOUWON;
		} else {
			return Stage.PLAYING;
		}
	}
}
