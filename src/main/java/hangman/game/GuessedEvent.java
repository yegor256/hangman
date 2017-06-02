package game;

import event.BaseEvent;
import event.Event;

/**
 * Won event.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class GuessedEvent implements Event {
	private final static String EVENT_NAME = "GUESSED";
	private final Event baseEvent;

	public GuessedEvent() {
		this.baseEvent = new BaseEvent(EVENT_NAME);
	}

	@Override
	public boolean is(String name) {
		return baseEvent.is(name);
	}

        @Override
        public Map<String, T> payload() {
                return baseEvent.payload();
        }        
}