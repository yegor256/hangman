package hangman;

import word.WordFromLetters;
import word.LettersOnAction;
import event.UncaughtEvent;
import game.IncrementedFailures;
import game.MaxInteger;
import view.View;
import game.Failures;
import event.Capture;
import event.Event;
import game.IsNewAttempt;

/**
 * It is the responsible for reacting. 
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class OnNewAttempt implements Capture {
        private final View viewDelegate;
        private final LettersOnAction lettersOnAction;
        private final MaxInteger maxFailures;
        private final Failures failures;    
        private final Capture source;

        public OnNewAttempt(final View viewDelegate, final LettersOnAction lettersOnAction, 
                final MaxInteger maxFailures, final Failures failures, 
                final Capture source) {
                this.viewDelegate = viewDelegate;
                this.lettersOnAction = lettersOnAction;
                this.maxFailures = maxFailures;
                this.failures = failures;                                
                this.source = source;
        }

        @Override
        public Event bubbled() {        
                Event sourceEvent = source.bubbled();
                if (new IsNewAttempt(sourceEvent).matched()) {                        
                        new Attempt(viewDelegate, 
                                new WordFromLetters(lettersOnAction.lettersOn()), maxFailures, 
                                new IncrementedFailures(failures)
                                ).done();    
                        // Temporary. It should return new Atempt(...).bubbled(). But first,
                        // I had to check it in order to avoid an infinite recursion.
                        // Maybe uncaught event must be renamed or the model needs 
                        // a stop propagating or a DoNotDoAnything. All of these thoughts
                        // should not considered if the model is right.
                        return new UncaughtEvent();                                
                }
                return sourceEvent;
        } 
}