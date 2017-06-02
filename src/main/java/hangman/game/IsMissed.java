package game;

import event.IsMatched;
import event.Matched;
import event.Event;

/**
 * Predicate for checking if the message is "missed".
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class IsMissed implements Matched {
	private final Matched meta;

	public IsMissed(final Event event) {
		this.meta = new IsMatched("MISSED", event);
	}	

	@Override
	public boolean matched() {
		return meta.matched();
	}
}