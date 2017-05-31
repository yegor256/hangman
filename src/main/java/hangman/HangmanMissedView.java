package hangman;

import game.View;

public final class HangmanMissedView implements View {
	private final int failNumber;
	private final int maxFailures;

	public HangmanMissedView(final int failNumber, final int maxFailures) {
		this.failNumber = failNumber;
		this.maxFailures = maxFailures;
	}

	@Override
	public void show() {		
		System.out.println(String.format("Missed, mistake #%d out of %d\n", failNumber, maxFailures));
	}
}