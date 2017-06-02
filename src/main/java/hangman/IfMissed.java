package hangman;

import event.Dispatching;
import event.Event;
import event.IsUncaught;
import game.MaxInteger;
import game.Failures;
import game.IncrementedFailures;
import game.MissedEvent;
import word.WereLettersOn;

/**
 * Guessed dispatching events.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class IfMissed implements Dispatching {
        private final WereLettersOn wereLetters;
        private final MaxInteger maxFailures;
        private final Failures failures;
        private final Dispatching source;

        public IfMissed(final WereLettersOn wereLetters, final MaxInteger maxFailures, 
                        final Failures failures, final Dispatching source) {
                this.wereLetters = wereLetters;
                this.maxFailures = maxFailures;
                this.failures = failures;
                this.source = source;
        }

        @Override
        public Event event() {
                Event sourceEvent = source.event();
                Failures incremented;     
                return                  
                new IsUncaught(sourceEvent).matched() 
                && !(wereLetters.on() || wereLetters.allOn())
                ? new MissedEvent(new FailuresMessage(maxFailures, incremented = new IncrementedFailures(failures)), incremented)
                : sourceEvent;               
        }
}