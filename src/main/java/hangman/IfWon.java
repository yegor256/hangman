package hangman;

import game.WonEvent;
import event.Dispatching;
import event.Event;
import event.IsUncaught;
import word.WordCondition;

/**
 * Dispatching events.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class IfWon implements Dispatching {
        private final WordCondition wereLeters;
        private final Dispatching source;

        public IfWon(final WordCondition wereLeters, final Dispatching source) {
                this.wereLeters = wereLeters;
                this.source = source;
        }

        @Override
        public Event event() {
                Event sourceEvent = source.event();     
                return                  
                new IsUncaught(sourceEvent).matched() && wereLeters.allOn()
                ? new WonEvent()
                : sourceEvent
                ;
        }
}