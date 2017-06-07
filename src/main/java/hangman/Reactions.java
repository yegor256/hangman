package hangman;

import event.Event;
import event.Capture;
import event.OnBase;
import event.Dispatching;
import view.View;
import game.Output;
import game.CharInput;
import game.Failures;
import game.MaxInteger;
import word.WordLetters;

/**
 * Reactions.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Reactions implements Capture {
        private final WordLetters word;
        private final MaxInteger max;
        private final Failures failures;
        private final CharInput in;
        private final Output out;        
        private final View missedView;
        private final View guessAttemptView;
        private final View missAttemptView;
        private final Dispatching dispatching;

        public Reactions(final WordLetters updatedWord, 
                final MaxInteger max, final Failures failures,
                final CharInput in, Output out, Dispatching dispatching) {
                this.word = updatedWord;
                this.max = max;
                this.failures = failures;
                this.in = in;
                this.out = out;                
                this.missedView = new MissedView(
                        out, new FailuresMessage(max, failures));
                this.guessAttemptView = new NewAttemptView(out, 
                        word, new GuessedView(out));
                this.missAttemptView = new NewAttemptView(out, word, 
                        missedView);
                this.dispatching = dispatching;
        }

        @Override
        public Event bubbled() {                 
                return
                new OnWon(new WonView(out),
                        new OnLost(new LostView(out, missedView),
                                new OnGuessed(guessAttemptView, word, max, failures, 
                                        in, out,
                                        new OnMissed(missAttemptView, word, max, failures, 
                                                in, out,
                                                new OnBase(dispatching)))))
                .bubbled();
        }
}