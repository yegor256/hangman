package hangman;

import event.Event;
import event.Capture;
import event.OnBase;
import event.Dispatching;
import view.View;
import game.Output;
import game.InputCharView;
import game.Lifespan;
import game.LifeTaken;
import word.WordLetters;

/**
 * Reactions.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Reactions implements Capture {
        private final WordLetters word;
        private final Lifespan lifespan;
        private final InputCharView in;
        private final Output out;        
        private final View missedView;
        private final View guessAttemptView;
        private final View missAttemptView;
        private final Dispatching dispatching;

        public Reactions(final WordLetters updatedWord, final Lifespan lifespan, 
                final InputCharView in, Output out, Dispatching dispatching) {
                this.word = updatedWord;
                this.lifespan = lifespan;
                this.in = in;
                this.out = out;                
                this.missedView = new MissedView(out, 
                        new FailuresMessage(new LifeTaken(lifespan)));
                this.guessAttemptView = new NewAttemptView(out, word, 
                        new GuessedView(out));
                this.missAttemptView = new NewAttemptView(out, word, missedView);
                this.dispatching = dispatching;
        }

        @Override
        public Event bubbled() {                 
                return
                new OnWon(new WonView(out),
                        new OnLost(new LostView(out, missedView),
                                new OnGuessed(guessAttemptView, word, lifespan, in, out,
                                        new OnMissed(missAttemptView, word, lifespan, in, out,
                                                new OnBase(dispatching)))))
                .bubbled();
        }
}