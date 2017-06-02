package game;

import event.Event;
import event.BaseEvent;

/**
 * Won event.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class WonEvent implements Event {
	private final static String EVENT_NAME = "WON";
	private final Event baseEvent;

	public WonEvent() {
		this.baseEvent = new BaseEvent(EVENT_NAME);
	}

	@Override
	public boolean is(String name) {
		return baseEvent.is(name);
	}
}