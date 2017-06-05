package hangman;

import game.GuessedEvent;
import event.Dispatching;
import event.Event;
import event.IsUncaught;
import word.LetterOnCodition;

/**
 * Dispatching events.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class IfGuessed implements Dispatching {
        private final LetterOnCodition letterOnCondition;
        private final Dispatching source;

        public IfGuessed(final LetterOnCodition letterOnCondition, 
                final Dispatching source) {
                this.letterOnCondition = letterOnCondition;
                this.source = source;
        }

        @Override
        public Event event() {
                Event sourceEvent = source.event();     
                return                  
                new IsUncaught(sourceEvent).matched() && letterOnCondition.confirmed()
                ? new GuessedEvent()    
                : sourceEvent
                ;               
        }
}