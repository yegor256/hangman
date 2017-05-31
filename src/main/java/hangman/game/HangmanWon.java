package game;

import event.Event;
import event.BaseEvent;

/**
 * Won event.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class HangmanWon implements Event {
	private final static String EVENT_NAME = "WON";
	private final Event baseEvent;

	public HangmanWon() {
		this.baseEvent = new BaseEvent(EVENT_NAME);
	}

	public boolean is(String name) {
		return baseEvent.is(name);
	}
}