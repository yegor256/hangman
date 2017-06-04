package hangman;

import game.MissedEvent;
import event.Dispatching;
import event.Event;
import event.IsUncaught;
import game.MaxInteger;
import game.Failures;
import game.IncrementedFailures;
import word.WereLettersOn;

/**
 * Dispatching events.
 * Note: Maybe max failures and failures can be part of a blackboard.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class IfMissed implements Dispatching {
        private final WereLettersOn wereLetters;
        private final MaxInteger maxFailures;
        private final Failures failures;
        private final Dispatching source;

        public IfMissed(final WereLettersOn wereLetters, 
                final MaxInteger maxFailures, final Failures failures, 
                final Dispatching source) {
                this.wereLetters = wereLetters;
                this.maxFailures = maxFailures;
                this.failures = failures;
                this.source = source;
        }

        @Override
        public Event event() {
                Event sourceEvent = source.event();
                return                  
                new IsUncaught(sourceEvent).matched() && ! wereLetters.on()
                // ? new MissedEvent(new MissedPayload(maxFailures, 
                //         new IncrementedFailures(failures)))
                ? new MissedEvent()                
                : sourceEvent
                ;               
        }
}