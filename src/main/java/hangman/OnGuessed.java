package hangman;

import game.IsGuessed;
import view.View;
import event.Capture;
import event.Event;

/**
 * Capturing the "won" event. Thus, it is the responsible for reacting.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class OnGuessed implements Capture {
        private final View view;
        private final Capture source;

        public OnGuessed(final View view, final Capture source) {
                this.view = view;
                this.source = source;
        }

        @Override
        public Event bubbled() {        
                Event sourceEvent = source.bubbled();
                if (new IsGuessed(sourceEvent).matched()) {
                        view.show();
                }
                return sourceEvent;
        }
}