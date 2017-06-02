package game;

import event.BaseEvent;
import event.Event;

/**
 * Won event.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class NewAttemptEvent implements Event, IncrementedFailures {
        private final static String EVENT_NAME = "NEW_ATTEMPT";
        private final Event baseEvent;
        private final FailuresState failuresState;

        public NewAttemptEvent(final FailuresState failuresState) {
                this.baseEvent = new BaseEvent(EVENT_NAME);
                this.failuresState = failuresState;
        }

        @Override
        public FailuresState state() {
                return this.failuresState;
        }

        @Override
        public boolean is(String name) {
                return baseEvent.is(name);
        }
}