package hangman;

import game.WonEvent;
import event.Dispatching;
import event.Event;
import event.IsUncaught;
import word.WordOnCondition;

/**
 * Dispatching events.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class IfWon implements Dispatching {
        private final WordOnCondition wordOnCondition;
        private final Dispatching source;

        public IfWon(final WordOnCondition wordOnCondition, final Dispatching source) {
                this.wordOnCondition = wordOnCondition;
                this.source = source;
        }

        @Override
        public Event event() {
                Event sourceEvent = source.event();     
                return                  
                new IsUncaught(sourceEvent).matched() && wordOnCondition.confirmed()
                ? new WonEvent()
                : sourceEvent
                ;
        }
}