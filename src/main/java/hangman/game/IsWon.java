package game;

import event.Event;
import event.Matched;

/**
 * Predicate for checking if the message is "won".
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class IsWon implements Matched {
	private static final String EVENT_NAME = "WON";	
	private final Event event;

	public IsWon(final Event event) {
		this.event = event;
	}	

	public boolean matched() {
		return event.is(EVENT_NAME);
	}
}