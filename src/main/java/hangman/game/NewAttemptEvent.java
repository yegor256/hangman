package game;

import event.BaseEvent;
import event.Event;

/**
 * New attempt event.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class NewAttemptEvent implements Event {
        private final static String EVENT_NAME = "NEW_ATTEMPT";
        private final Event baseEvent;

        public NewAttemptEvent() {
                this.baseEvent = new BaseEvent(EVENT_NAME);
        }

        @Override
        public boolean is(final String name) {
                return baseEvent.is(name);
        }       
}