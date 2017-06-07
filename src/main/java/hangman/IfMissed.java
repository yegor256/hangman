package hangman;

import game.MissedAttemptEvent;
import game.LostEvent;
import game.Incremented;
import game.Failures;
import game.MaxInteger;
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
        private final MaxInteger maxFailures;
        private final Failures failures;            
        private final Dispatching source;

        public IfMissed(final LetterOnCodition letterOnCondition, 
                final MaxInteger maxFailures, final Failures failures,
                final Dispatching source) {
                this.letterOnCondition = letterOnCondition;
                this.maxFailures = maxFailures;
                this.failures = failures;                                                
                this.source = source;
        }

        @Override
        public Event event() {
                Event sourceEvent = source.event();
                return                  
                new IsUncaught(sourceEvent).matched() && ! letterOnCondition.confirmed()
                // ? new LostLife(lives).lives().still() ? new MissedAttemptEvent() : new LostEvent();
                ? maxFailures.reached(new Incremented(failures)) 
                        ? new LostEvent() 
                        : new MissedAttemptEvent()
                : sourceEvent
                ;               
        }
}