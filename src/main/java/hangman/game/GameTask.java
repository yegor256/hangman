package hangman.game;

class GameTask {

	private static final char SECRET_CHAR = '?';

	private final String secretWord;

	boolean[] visibleChars;

	private final int maxGuess;

	private int mistakes = 0;

	public GameTask(int maxGuess) {
		this.maxGuess = maxGuess;

		SecretWordsGenerator generator = new SecretWordsGenerator();
		this.secretWord = generator.getSecretWord();
		this.visibleChars = new boolean[secretWord.length()];
	}

	String getCurrentResult() {
		StringBuilder builder = new StringBuilder();

        for (int i = 0; i < secretWord.length(); ++i) {
            if (visibleChars[i]) {
            	builder.append(secretWord.charAt(i));
            } else {
            	builder.append(SECRET_CHAR);
            }
        }

        return builder.toString();
	}

	boolean checkHit(char chr) {
		boolean hit = false;

        for (int i = 0; i < secretWord.length(); ++i) {
            if (secretWord.charAt(i) == chr && !visibleChars[i]) {
                visibleChars[i] = true;
                hit = true;
            }
        }

        if (!hit) {
        	mistakes += 1;
        }

        return hit;
	}

	boolean checkWin() {
        for (int i = 0; i < secretWord.length(); ++i) {
            if (!visibleChars[i]) {
                return false;
            }
        }

        return true;
	}

	boolean gameContinued() {
		return (mistakes < maxGuess);
	}

	public int getMaxGuess() {
		return maxGuess;
	}

	public int getMistakes() {
		return mistakes;
	}
}
