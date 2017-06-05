package game;

import event.IsMatched;
import event.Matched;
import event.Event;

/**
 * Predicate for checking if the message is a new attempt from a missed event.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class IsMissedAttempt implements Matched {
        private final Matched meta;

        public IsMissedAttempt(final Event event) {
                this.meta = new IsMatched("NEW_ATTEMPT_FROM_MISSED", event);
        }       

        @Override
        public boolean matched() {
                return meta.matched();
        }
}