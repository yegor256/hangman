package game;

import event.IsMatched;
import event.Matched;
import event.Event;

/**
 * Predicate for checking if the message is "new attempt" event.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class IsNewAttempt implements Matched {
        private final Matched meta;

        public IsNewAttempt(final Event event) {
                this.meta = new IsMatched("NEW_ATTEMPT", event);
        }       

        @Override
        public boolean matched() {
                return meta.matched();
        }
}