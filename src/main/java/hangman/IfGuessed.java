package hangman;

import game.GuessedAttemptEvent;
import game.WonEvent;
import word.WordOnCondition;
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
        private final WordOnCondition wordOnCondition;
        private final Dispatching source;

        public IfGuessed(final LetterOnCodition letterOnCondition, 
                final WordOnCondition wordOnCondition, 
                final Dispatching source) {
                this.letterOnCondition = letterOnCondition;
                this.wordOnCondition = wordOnCondition;
                this.source = source;
        }

        @Override
        public Event event() {
                Event sourceEvent = source.event();     
                return                  
                new IsUncaught(sourceEvent).matched() && letterOnCondition.confirmed()
                ? wordOnCondition.confirmed()
                        ? new WonEvent()
                        : new GuessedAttemptEvent()    
                : sourceEvent
                ;               
        }
}
