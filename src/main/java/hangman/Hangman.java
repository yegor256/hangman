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

	public final Round disclose(char c) {
		return new Round(secretPhrase.discover(c));
	}

	public final Round discloseAlso(Round prevRound, char c) {
		return prevRound.nextRound(secretPhrase.discover(c));
	}

	public final Stage gameStage(Round round) {
		if (round.mistakes >= secretPhrase.allowedMistakes) {
			return Stage.YOULOSE;
		} else if (secretPhrase.resolve(round.currentGuess)) {
			return Stage.YOUWON;
		} else {
			return Stage.PLAYING;
		}
	}
}
