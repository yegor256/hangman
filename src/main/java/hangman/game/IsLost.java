package game;

import event.IsMatched;
import event.Matched;
import event.Event;

/**
 * Predicate for checking if the message is "lost".
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class IsLost implements Matched {
        private final Matched meta;

        public IsLost(final Event event) {
                this.meta = new IsMatched("LOST", event);
        }       

        @Override
        public boolean matched() {
                return meta.matched();
        }
}