package player;

import event.Capture;
import event.Event;
import game.IsWon;

/**
 * Capturing the "won" event. Thus, it is the responsible for reacting.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class HangmanOnWon implements Capture {
	private final WonView wonView;
	private final Capture source;

	public HangmanOnWon(final WonView wonView, final Capture source) {
		this.wonView = wonView;
		this.source = source;
	}

	@Override
	public Event bubbled() {	
		Event sourceEvent = source.bubbled();
		if (new IsWon(sourceEvent).matched()) {
			wonView.show();
		}
		return sourceEvent;
	}
}