package hangman;

import game.IsGuessedAttempt;
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
public final class OnGuessed implements Capture {
        private final View view;
        private final WordLetters presentWord;
        private final MaxInteger maxFailures;
        private final Failures failures; 
        private final CharInput charInput;   
        private final Output output;
        private final Capture source;

        public OnGuessed(final View view, final WordLetters presentWord, 
                final MaxInteger maxFailures, final Failures failures, 
                final CharInput charInput, final Output output, 
                final Capture source) {
                this.view = view;
                this.presentWord = presentWord;
                this.maxFailures = maxFailures;
                this.failures = failures;   
                this.charInput = charInput;                             
                this.output = output;
                this.source = source;
        }

        @Override
        public Event bubbled() {        
                Event sourceEvent = source.bubbled();
                if (new IsGuessedAttempt(sourceEvent).matched()) {                        
                        // @todo charInput receives view.show() as decorator.
                        view.show();
                        new Attempt(presentWord, maxFailures, failures, 
                                charInput, output 
                                ).promised();    
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