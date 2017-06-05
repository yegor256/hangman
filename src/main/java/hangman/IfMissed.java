package hangman;

import game.MissedEvent;
import event.Dispatching;
import event.Event;
import event.IsUncaught;
import word.LetterOnCodition;

/**
 * Dispatching events.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class IfMissed implements Dispatching {
        private final LetterOnCodition letterOnCondition;
        private final Dispatching source;

        public IfMissed(final LetterOnCodition letterOnCondition, 
                final Dispatching source) {
                this.letterOnCondition = letterOnCondition;
                this.source = source;
        }

        @Override
        public Event event() {
                Event sourceEvent = source.event();
                return                  
                new IsUncaught(sourceEvent).matched() && ! letterOnCondition.confirmed()
                ? new MissedEvent()                
                : sourceEvent
                ;               
        }
}