package game;

import event.IsMatched;
import event.Matched;
import event.Event;

/**
 * Predicate for checking if the message is a new attempt from a guessed event.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class IsGuessedAttempt implements Matched {
        private final Matched meta;

        public IsGuessedAttempt(final Event event) {
                this.meta = new IsMatched("NEW_ATTEMPT_FROM_GUESSED", event);
        }       

        @Override
        public boolean matched() {
                return meta.matched();
        }
}