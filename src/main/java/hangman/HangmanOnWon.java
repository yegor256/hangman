package hangman;

import game.IsWon;
import event.Capture;
import event.Event;
import game.View;

/**
 * Capturing the "won" event. Thus, it is the responsible for reacting.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class HangmanOnWon implements Capture {
	private final View view;
	private final Capture source;

	public HangmanOnWon(final View view, final Capture source) {
		this.view = view;
		this.source = source;
	}

	@Override
	public Event bubbled() {	
		Event sourceEvent = source.bubbled();
		if (new IsWon(sourceEvent).matched()) {
			view.show();
		}
		return sourceEvent;
	}
}