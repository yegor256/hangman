package hangman;

import game.MissedAttemptEvent;
import game.LostEvent;
import game.IncrementedFailures;
import game.MaxInteger;
import game.Failures;
import game.IsMissed;
import event.Capture;
import event.Event;

/**
 * It is the responsible for reacting. 
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class OnMissed implements Capture {
        private final MaxInteger maxFailures;
        private final Failures failures;    
        private final Capture source;

        public OnMissed(final MaxInteger maxFailures, final Failures failures, 
                final Capture source) {
                this.maxFailures = maxFailures;
                this.failures = failures;                                
                this.source = source;
        }

        @Override
        public Event bubbled() {        
                Event sourceEvent = source.bubbled();
                if (new IsMissed(sourceEvent).matched()) {                         
                        return 
                        maxFailures.reached(new IncrementedFailures(failures)) 
                        ? new LostEvent()                        
                        : new MissedAttemptEvent()
                        ;
                }
                return sourceEvent;
        } 
}