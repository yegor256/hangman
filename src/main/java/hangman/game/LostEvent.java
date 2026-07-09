package game;

import event.BaseEvent;
import event.Event;

/**
 * Lost event.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class LostEvent implements Event {
        private final static String EVENT_NAME = "LOST";
        private final Event baseEvent;

        public LostEvent() {
                this.baseEvent = new BaseEvent(EVENT_NAME);
        }

        @Override
        public boolean is(final String name) {
                return baseEvent.is(name);
        }         
}