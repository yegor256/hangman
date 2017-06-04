package hangman;

import game.Failures;
import game.NewAttemptEvent;
import game.IsMissed;
import event.Capture;
import event.Event;

/**
 * Capturing the "missed" event. Thus, it is the responsible for reacting.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class OnMissed implements Capture {
        private final AssignedMissedView assignedView;
        private final Capture source;

        public OnMissed(final AssignedMissedView assignedView, final Capture source) {
                this.assignedView = assignedView;
                this.source = source;
        }

        @Override
        public Event bubbled() {        
                Event sourceEvent = source.bubbled();
                if (new IsMissed(sourceEvent).matched()) {                         
                        // assignedView.with(payload.media()).show();
                        return new NewAttemptEvent();
                }
                return sourceEvent;
        }
}