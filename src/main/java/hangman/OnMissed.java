package hangman;

import game.IsMissedAttempt;
import game.CharInput;
import game.Output;
import word.WordLetters;
import event.UncaughtEvent;
import game.Incremented;
import game.MaxInteger;
import view.View;
import game.Failures;
import event.Capture;
import event.Event;

/**
 * It is the responsible for reacting. 
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class OnMissed implements Capture {
        private final View view;
        private final WordLetters word;
        private final MaxInteger maxFailures;
        private final Failures failures; 
        private final CharInput input;   
        private final Output output;
        private final Capture source;

        public OnMissed(final View view, final WordLetters word, 
                final MaxInteger maxFailures, final Failures failures, 
                final CharInput input, final Output output, 
                final Capture source) {
                this.view = view;
                this.word = word;
                this.maxFailures = maxFailures;
                this.failures = failures;                   
                this.input = input; 
                this.output = output;                            
                this.source = source;
        }

        @Override
        public Event bubbled() {        
                Event sourceEvent = source.bubbled();
                if (new IsMissedAttempt(sourceEvent).matched()) {                        
                        // @todo input receives view.show() as decorator.
                        view.show();
                        new Attempt(word, maxFailures, 
                                // new LostLife(lives).lives()
                                new Incremented(failures), input, output 
                        ).promised();    
                        // Temporary. It should return new Atempt(...).bubbled(). But first,
                        // I had to check it in order to avoid an infinite recursion.
                        // Maybe uncaught event must be renamed or the model needs 
                        // a stop propagating or a DoNotDoAnything. All of these thoughts
                        // should not be considered if the model is right.
                        return new UncaughtEvent();                                
                }
                return sourceEvent;
        } 
}