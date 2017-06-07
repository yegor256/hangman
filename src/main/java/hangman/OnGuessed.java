package hangman;

import game.IsGuessedAttempt;
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
public final class OnGuessed implements Capture {
        private final View view;
        private final WordLetters presentWord;
        private final Lifespan lifespan;
        private final InputCharView input;   
        private final Output output;
        private final Capture source;

        public OnGuessed(final View view, final WordLetters presentWord, 
                final Lifespan lifespan, final InputCharView input, 
                final Output output, final Capture source) {
                this.view = view;
                this.presentWord = presentWord;
                this.lifespan = lifespan;
                this.input = input;                             
                this.output = output;
                this.source = source;
        }

        @Override
        public Event bubbled() {        
                Event sourceEvent = source.bubbled();
                if (new IsGuessedAttempt(sourceEvent).matched()) {                        
                        // @todo input receives view.show() as decorator.
                        view.show();
                        new Attempt(presentWord, lifespan, input, output)
                        .promised();    
                        return new UncaughtEvent();                                
                }
                return sourceEvent;
        } 
}