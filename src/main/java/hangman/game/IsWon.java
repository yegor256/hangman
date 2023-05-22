package game;

import event.IsMatched;
import event.Event;
import event.Matched;

/**
 * Predicate for checking if the message is "won".
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class IsWon implements Matched {
	private final Matched meta;

	public IsWon(final Event event) {
		this.meta = new IsMatched("WON", event);
	}	

	@Override
	public boolean matched() {
		return meta.matched();
	}
}