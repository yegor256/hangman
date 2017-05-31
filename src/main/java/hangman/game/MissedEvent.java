package game;

import event.BaseEvent;
import event.Event;

/**
 * Won event.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class MissedEvent implements Event {
	private final static String EVENT_NAME = "MISSED";
	private final Event baseEvent;

	public MissedEvent() {
		this.baseEvent = new BaseEvent(EVENT_NAME);
	}

	public boolean is(String name) {
		return baseEvent.is(name);
	}
}