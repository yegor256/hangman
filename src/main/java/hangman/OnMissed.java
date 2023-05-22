package hangman;

import game.LifeTaken;
import game.IsMissedAttempt;
import game.InputCharView;
import game.Output;
import word.WordLetters;
import event.UncaughtEvent;
import game.Lifespan;
import view.View;
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
        private final Lifespan lifespan;
        private final InputCharView input;   
        private final Output output;
        private final Capture source;

        public OnMissed(final View view, final WordLetters word, 
                final Lifespan lifespan, final InputCharView input, 
                final Output output, final Capture source) {
                this.view = view;
                this.word = word;
                this.lifespan = lifespan;
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
                        new Attempt(
                                word, new LifeTaken(lifespan), input, output
                        ).promised();    
                        return new UncaughtEvent();                                
                }
                return sourceEvent;
        } 
}