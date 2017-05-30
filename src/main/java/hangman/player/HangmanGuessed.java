package player;

import event.Event;
import event.BaseEvent;

/**
 * Won event.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class HangmanGuessed implements Event {
	private final static String EVENT_NAME = "GUESSED";
	private final Event baseEvent;

	public HangmanGuessed() {
		this.baseEvent = new BaseEvent(EVENT_NAME);
	}

	public boolean is(String name) {
		return baseEvent.is(name);
	}
}