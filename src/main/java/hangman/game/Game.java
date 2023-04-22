package hangman.game;

public abstract class Game {

	private static final int DEFAULT_MAX_GUESS = 5;

	private final GameTask task;

	public Game() {
		this(DEFAULT_MAX_GUESS);
	}

	public Game(int maxGuess) {
		task = new GameTask(maxGuess);
	}

	protected abstract char getNextChar();

	protected abstract void printCurrentHit(boolean success, int mistakes, int maxGuess);

	protected abstract void printNextTask(String taskWord);

	protected abstract void finishGame();

	public void startGame() {
		try {
			while (task.gameContinued()) {
				if (checkWin()) {
					break;
				}

				processNextStep();
			}

			finishGame();
		} finally {
			destroyGame();
		}
	}

	private void processNextStep() {
		char nextChar = getNextChar();
		boolean hit = task.checkHit(nextChar);

		printCurrentHit(hit, task.getMistakes(), task.getMaxGuess());
		printNextTask(task.getCurrentResult());
	}

	protected boolean checkWin() {
		return task.checkWin();
	}

	protected void destroyGame() {
		// No operations by default
	}
}
