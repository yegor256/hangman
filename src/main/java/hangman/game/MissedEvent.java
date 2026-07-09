package game;

import event.BaseEvent;
import event.Event;

/**
 * Missed event.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class MissedEvent implements Event {
	private final static String EVENT_NAME = "MISSED";
	private final Event baseEvent;

	public MissedEvent() {
		this.baseEvent = new BaseEvent(EVENT_NAME);
	}

        @Override
        public boolean is(final String name) {
                return baseEvent.is(name);
        }         
}