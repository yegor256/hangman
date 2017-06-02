package hangman;

import game.IsMissed;
import view.View;
import event.Capture;
import event.Event;

/**
 * Capturing the "won" event. Thus, it is the responsible for reacting.
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
                        assignedView.with(sourceEvent.payload().get("media")).show();
                        return NewAttemptEvent(sourceEvent.payload().get("failures"));
                }
                return sourceEvent;
        }
}