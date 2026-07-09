package hangman;

import game.Lifespan;
import game.LifeTaken;
import game.MissedAttemptEvent;
import game.LostEvent;
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
        private final Lifespan lifespan;
        private final Dispatching source;

        public IfMissed(final LetterOnCodition letterOnCondition, 
                final Lifespan lifespan, final Dispatching source) {
                this.letterOnCondition = letterOnCondition;
                this.lifespan = lifespan;
                this.source = source;
        }

        @Override
        public Event event() {
                Event sourceEvent = source.event();
                return                  
                new IsUncaught(sourceEvent).matched() && ! letterOnCondition.confirmed()
                ? new LifeTaken(lifespan).left() == 0
                        ? new LostEvent()
                        : new MissedAttemptEvent() 
                : sourceEvent
                ;               
        }
}