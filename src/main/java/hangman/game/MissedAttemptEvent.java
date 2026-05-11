package game;

import event.BaseEvent;
import event.Event;

/**
 * New attempt event.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class MissedAttemptEvent implements Event {
        private final static String EVENT_NAME = "NEW_ATTEMPT_FROM_MISSED";
        private final Event baseEvent;

        public MissedAttemptEvent() {
                this.baseEvent = new BaseEvent(EVENT_NAME);
        }

        @Override
        public boolean is(final String name) {
                return baseEvent.is(name);
        }         
}