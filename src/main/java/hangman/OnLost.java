package hangman;

import view.View;
import game.IsLost;
import event.Capture;
import event.Event;

/**
 * It is the responsible for reacting.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class OnLost implements Capture {
        private final View view;   
        private final Capture source;

        public OnLost(final View view, final Capture source) {
                this.view = view;
                this.source = source;
        }

        @Override
        public Event bubbled() {        
                Event sourceEvent = source.bubbled();
                if (new IsLost(sourceEvent).matched()) {                         
                        view.show();
                }
                return sourceEvent;
        } 
}