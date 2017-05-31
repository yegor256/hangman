package hangman;

import game.IsMissed;
import game.View;
import event.Capture;
import event.Event;

/**
 * Capturing the "won" event. Thus, it is the responsible for reacting.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class HangmanOnMissed implements Capture {
	private final View view;
	private final Capture source;

	public HangmanOnMissed(final View view, final Capture source) {
		this.view = view;
		this.source = source;
	}

	@Override
	public Event bubbled() {	
		Event sourceEvent = source.bubbled();
		if (new IsMissed(sourceEvent).matched()) {
			view.show();
		}
		return sourceEvent;
	}
}