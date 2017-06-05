package hangman;

import game.CharInput;
import game.Output;
import view.View;
import event.OnBase;
import event.IfBase;
import game.Failures;
import game.MaxInteger;
import game.PlayerFailures;
import word.IsWordOn;
import word.LettersOn;
import word.WasLetterOn;
import word.WordLetters;
import word.WhereSymbol;
import word.LetterOnCodition;

/**
 * The player can attempt as many times he can until the number
 * of failures are reached or the success criterion has been
 * achived.
 *
 * @author Ix Manuel (ixmanuel@yahoo.com)
 */
public final class Attempt implements game.Attempt {
        private final CharInput guessChar;
        private final WordLetters pastWord;
        private final MaxInteger maxFailures;
        private final Failures pastFailures;
        private final Output output;

        public Attempt (final WordLetters pastWord, final MaxInteger maxFailures, 
            final Output output, final CharInput guessChar) {
            this(new GuessLetterInput(guessChar, output), pastWord, maxFailures, output);
        }

        public Attempt(final CharInput inputView, final WordLetters pastWord, 
            final MaxInteger maxFailures, final Output output) {
                this(inputView, pastWord, maxFailures, new PlayerFailures(), output);
        }

        public Attempt(final CharInput inputView, final WordLetters pastWord, 
            final MaxInteger maxFailures, Failures pastFailures, 
            final Output output) {
                this.guessChar = inputView;
                this.pastWord = pastWord;
                this.maxFailures = maxFailures;
                this.pastFailures = pastFailures;
                this.output = output;                
        }

        @Override
        public void promised() {                   
                // It requires another level of abstraction:
                //      new Action(new Evaluation(new Result()))   
                final WordLetters presentWord = new LettersOn(pastWord, new WhereSymbol(guessChar.next()));
                final LetterOnCodition wasLetterOn = new WasLetterOn(presentWord, pastWord);
                final View missedView = new MissedView(output, new FailuresMessage(maxFailures, pastFailures));

                new OnWon(new WonView(output),
                        new OnLost(new LostView(output, missedView),
                            new OnGuessedAttempt(new NewAttemptView(output, presentWord), 
                                                    presentWord, maxFailures, pastFailures, output, guessChar, 
                                new OnMissedAttempt(new NewAttemptView(output, presentWord, missedView), 
                                                    presentWord, maxFailures, pastFailures, output, guessChar,                                       
                                        new OnGuessed(new GuessedView(output),
                                                new OnMissed(maxFailures, pastFailures, 
                                                        new OnBase(
                                                                new IfWon(new IsWordOn(presentWord), 
                                                                        new IfGuessed(wasLetterOn,
                                                                                new IfMissed(wasLetterOn,
                                                                                        new IfBase()))))))))))
                .bubbled();                        
        }
}